package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasketPage {

    WebDriver driver;

    private final By SAUCE_LABS_BACKPACK_IN_BASKET= By.xpath("//*[@data-test='inventory-item-name']");
    private final By REMOVE_PRODUCT_IN_BASKET= By.id("remove-sauce-labs-backpack");
    private final By EMPTY_BASKET_ITEM = By.xpath("//*[@class='removed_cart_item']");



    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSauceLabsBackpackInBasket() {
        return driver.findElement(SAUCE_LABS_BACKPACK_IN_BASKET).getTagName();
    }

    public void clickButtonRemoveInBasket () {
        driver.findElement(REMOVE_PRODUCT_IN_BASKET).click();
    }

    public boolean checkRemovedCartItem () {
        return driver.findElements(EMPTY_BASKET_ITEM).size() > 0;
    }
}
