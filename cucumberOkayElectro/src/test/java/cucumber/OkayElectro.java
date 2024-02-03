package cucumber;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OkayElectro {
    WebDriver driver = new ChromeDriver();

    public void quitDriver() {
        driver.quit();
    }

    public void driverGet(String http) {
        driver.get(http);
    }

    public void iClickOnTheCategory(String categoryName) {
        String xpathCategorySelector = "//a/img[@alt='" + categoryName + "']";
        WebElement category = driver.findElement(By.xpath(xpathCategorySelector));
        category.click();
    }

    public void iShouldBeTakenToCategory(String categoryName) {
        WebElement h1Element = driver.findElement(By.cssSelector("h1.boost-pfs-filter-collection-header"));
        String headlineText = h1Element.getText();
        Assert.assertEquals(categoryName, headlineText);
    }

    public void theCategoryShouldShowAtLeastNumberProducts(Integer number) {
        List<WebElement> products = driver.findElements(By.className("product-wrap"));
        int productCount = products.size();
        Assert.assertTrue(productCount > number);
    }

    public void iClickOnTheFirstProductInTheResults() {
        WebElement firstProduct = driver.findElement(By.className("product-thumbnail__title"));
        firstProduct.click();
    }

    public void iShouldBeTakenToTheDetailsPageForThatProduct() {
        String reserveButtonText = "Vyzvednout / doručit do 60min.";
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + reserveButtonText + "')]"));
        Assert.assertEquals(reserveButtonText, button.getText());
    }

    public void iLookUpForAProductUsingTheTerm(String searchedTerm) {
        WebElement searchBox = driver.findElement(By.id("boost-pfs-search-box-0"));

        WebElement buttonElement = driver.findElement(By.className("header__search-button"));
        buttonElement.click();

        searchBox.sendKeys("mobil");
        searchBox.sendKeys(Keys.ENTER);
    }

    public void iShouldSeeTheSearchResults() {
        WebElement h1Element = driver.findElement(By.className("search__content"));
        Assert.assertNotNull(h1Element);
    }

    public void thereShouldBeAtLeastProductsInTheSearchResults(int number) {
        List<WebElement> products = driver.findElements(By.className("product-wrap"));
        int productsCount = products.size();
        Assert.assertTrue(productsCount > number);
    }
}
