package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasketPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");
    private final By EMPTY_BASKET_ITEM = By.xpath("//*[@class='removed_cart_item']");
    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By BUTTON_CHECKOUT = By.id("checkout");
    private final By TITLE_BASKET = By.xpath("//*[@data-test='title']");
    private final By COST_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By DESCRIPTION_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");


    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkingTheBasketPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CHECKOUT));
    }

    public String getTextTitleBasket() {
        return driver.findElement(TITLE_BASKET).getText();
    }

    public String getSauceLabsBackpackInBasket() {
        return driver.findElement(PRODUCT_SAUCE_LABS_BACKPACK).getText();
    }

    public void clickButtonRemoveInBasket () {
        driver.findElement(BUTTON_REMOVE).click();
    }

    public boolean checkRemovedCartItem () {
        return driver.findElements(EMPTY_BASKET_ITEM).size() > 0;
    }

    public void clickButtonContinueShopping () {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
    }

    public void clickButtonCheckout () {
        driver.findElement(BUTTON_CHECKOUT).click();
    }

    public String getTextElementCostOfTheFirstItem() {
        return driver.findElement(COST_OF_THE_FIRST_ITEM).getText();
    }

    public String getTextElementDescriptionOfTheFirstItem() {
        return driver.findElement(DESCRIPTION_OF_THE_FIRST_ITEM).getText();
    }
}
