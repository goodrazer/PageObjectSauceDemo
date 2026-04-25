package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE = By.xpath("//*[@data-test='title']");
    private final By BUTTON_ADD_TO_CART1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By NAME_PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_BASKET = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By COST_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By DESCRIPTION_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkingTheProductsPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickButtonAddToCart1() {
        driver.findElement(BUTTON_ADD_TO_CART1).click();
    }

    public String getSauceLabsBackpack() {
        return driver.findElement(NAME_PRODUCT_SAUCE_LABS_BACKPACK).getText();
    }

    public void clickToBasket() {
        driver.findElement(BUTTON_BASKET).click();
    }

    public String getTextElementCostOfTheFirstItem() {
        return driver.findElement(COST_OF_THE_FIRST_ITEM).getText();
    }

    public String getTextElementDescriptionOfTheFirstItem() {
        return driver.findElement(DESCRIPTION_OF_THE_FIRST_ITEM).getText();
    }
}