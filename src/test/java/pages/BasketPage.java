package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    WebDriver driver;

    private final By PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");
    private final By EMPTY_BASKET_ITEM = By.xpath("//*[@class='removed_cart_item']");
    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By BUTTON_CHECKOUT = By.id("checkout");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
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
}
