package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OkayStepDefs {

    OkayElectro okayElectro;

    @Before
    public void setUp() {
        okayElectro = new OkayElectro();
    }

    @After
    public void tearDown() {
        okayElectro.quitDriver();
    }

    @Given("I am a user of the website")
    public void iAmAUserOfTheWebsite() {
        okayElectro.driverGet("https://www.okay.cz/");
    }

    @When("I visit the news website")
    public void iVisitTheNewsWebsite() {}

    @And("I click on the {string} category")
    public void iClickOnTheCategory(String categoryName) {
        okayElectro.iClickOnTheCategory(categoryName);
    }

    @Then("I should be taken to {string} category")
    public void iShouldBeTakenToCategory(String categoryName) {
        okayElectro.iShouldBeTakenToCategory(categoryName);
    }

    @And("the category should show at least {int} products")
    public void theCategoryShouldShowAtLeastNumberProducts(Integer number) {
        okayElectro.theCategoryShouldShowAtLeastNumberProducts(number);
    }

    @When("I click on the first product in the results")
    public void iClickOnTheFirstProductInTheResults() {
        okayElectro.iClickOnTheFirstProductInTheResults();
    }

    @Then("I should be taken to the details page for that product")
    public void iShouldBeTakenToTheDetailsPageForThatProduct() {
        okayElectro.iShouldBeTakenToTheDetailsPageForThatProduct();
    }

    @When("I look up for a product using the term {string}")
    public void iLookUpForAProductUsingTheTerm(String searchedTerm) {
        okayElectro.iLookUpForAProductUsingTheTerm(searchedTerm);
    }

    @Then("I should see the search results")
    public void iShouldSeeTheSearchResults() {
        okayElectro.iShouldSeeTheSearchResults();
    }

    @And("there should be at least {int} products in the search results")
    public void thereShouldBeAtLeastProductsInTheSearchResults(int number) {
        okayElectro.thereShouldBeAtLeastProductsInTheSearchResults(number);
    }
}
