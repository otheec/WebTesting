package modeljunit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CzcWeb {

    WebDriver driver;

    public CzcWeb() {
        this.driver = new ChromeDriver();
        driver.get("https://www.czc.cz/");
        WebElement cookiesButton = driver.findElement(By.className("ccp-controls__all-cookies"));
        cookiesButton.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void returnToMainPage() {
        try {
            Thread.sleep(1000);
            WebElement mainPageLogo = driver.findElement(By.className("header__logo"));
            mainPageLogo.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectCategory() {
        try {
            Thread.sleep(1000);
            WebElement categoryButton = driver.findElement(By.xpath("//div[contains(@class, 'main-menu__dep') " + "and .//div[contains(@class, 'main-menu__title unselectable') " + "and contains(text(), 'Mobily, tablety')]]"));
            categoryButton.click();
            Thread.sleep(1000);
            WebElement cellphonesButton = driver.findElement(By.xpath("//a[contains(@class, 'main-menu__link') and contains(@class, 'main-menu__item') and text()='Mobilní telefony']"));
            cellphonesButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void buyFromCategory() {
        try {
            Thread.sleep(1000);
            WebElement addToCartButton = driver.findElement(By.cssSelector("button[title='Přidat zboží do košíku']"));
            addToCartButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewProduct() {
        try {
            Thread.sleep(1000);
            WebElement productLink = driver.findElement(By.xpath("//h5/a[@href='/apple-iphone-15-128gb-black/383646/produkt' and @title='Apple iPhone 15, 128GB, Black CZC MagSafe držák v hodnotě 599 Kč']"));
            productLink.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void toCart() {
        try {
            Thread.sleep(1000);
            WebElement continueShoppingButton = driver.findElement(By.xpath("//a[.//span[contains(text(), 'objednávce')]]"));
            continueShoppingButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void goToCart() {
        try {
            Thread.sleep(1000);
            WebElement cartLink = driver.findElement(By.xpath("//div[@id='basket-preview']//a[contains(@class, 'header-previews__btn') and contains(@class, 'view-basket')]"));
            cartLink.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
