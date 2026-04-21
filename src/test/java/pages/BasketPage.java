package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    WebDriver driver;

    private final By SAUCE_LABS_BACKPACK_IN_BASKET= By.xpath("//*[@data-test='inventory-item-name']");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSauceLabsBackpackInBasket() {
        return driver.findElement(SAUCE_LABS_BACKPACK_IN_BASKET).getText();
    }

}
