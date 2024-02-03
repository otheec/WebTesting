package modeljunit;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class CzcModelTest implements FsmModel{
    private CzcStates state;
    private CzcWeb sut = new CzcWeb();

    public CzcStates getState() {
        return state;
    }

    public void reset(boolean testing) {
        state = CzcStates.MAIN_PAGE;
        if (sut != null) {
            sut.getDriver().quit();
            sut = new CzcWeb();
        }
    }

    public boolean returnToMainPageGuard() {
        return  !getState().equals(CzcStates.CART_PREVIEW);
    }

    @Action
    public void returnToMainPage() {
        state = CzcStates.MAIN_PAGE;
        sut.returnToMainPage();

        Assertions.assertNotNull(sut.getDriver().findElement(By.id("homepage-container")));
    }

    public boolean selectCategoryGuard() {
        return getState().equals(CzcStates.MAIN_PAGE);
    }

    @Action
    public void selectCategory() {
        state = CzcStates.CATEGORY_RESULTS;
        sut.selectCategory();

        Assertions.assertNotNull(sut.getDriver().findElement(By.id("title-params-tail")));
    }

    public boolean viewProductGuard() {
        return getState().equals(CzcStates.CATEGORY_RESULTS);
    }

    @Action
    public void viewProduct() {
        state = CzcStates.PRODUCT_PAGE;
        sut.viewProduct();

        Assertions.assertNotNull(sut.getDriver().findElement(By.className("pd-wrap")));
    }

    public boolean buyGuard() {
        return getState().equals(CzcStates.CATEGORY_RESULTS);
    }

    @Action
    public void buy() {
        state = CzcStates.CART_PREVIEW;
        sut.buyFromCategory();

        Assertions.assertNotNull(sut.getDriver().findElement(By.cssSelector("button[title='Přidat zboží do košíku']")));
    }

    public boolean toCartGuard() {
        return getState().equals(CzcStates.CART_PREVIEW);
    }

    @Action
    public void toCart() {
        state = CzcStates.CART;
        sut.toCart();

        Assertions.assertNotNull(sut.getDriver().findElement(By.id("basket-visibility-container")));
    }

    public boolean goToCartGuard() {
        return !(getState().equals(CzcStates.CART_PREVIEW) || getState().equals(CzcStates.CART));
    }

    @Action
    public void goToCart() {
        state = CzcStates.CART;
        sut.goToCart();

        Assertions.assertNotNull(sut.getDriver().findElement(By.id("basket-visibility-container")));
    }


    @Test
    public void OkayModelRunner() {
        final GreedyTester tester = new GreedyTester(new CzcModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(10);
        tester.printCoverage();
    }
}
