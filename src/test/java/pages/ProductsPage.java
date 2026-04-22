package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    private final By TITLE = By.xpath("//*[@data-test='title']");
    private final By ADD_TO_CART1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BASKET_CLICK= By.xpath("//a[@data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickButtonAddToCart1() {
         driver.findElement(ADD_TO_CART1).click();
    }

    public String getSauceLabsBackpack() {
        return driver.findElement(SAUCE_LABS_BACKPACK).getText();
    }

    public void clickToBasket() {
        driver.findElement(BASKET_CLICK).click();
    }

}
