package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE = By.xpath("//*[@data-test='title']");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By NAME_PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_BASKET = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By COST_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By DESCRIPTION_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");

    public void checkingTheProductsPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    @Step("Получение заголовка страницы 'Products'")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем 'Product' в корзину по кнопке 'ADD TO CART'")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Получение наименования товара")
    public String getSauceLabsBackpack() {
        return driver.findElement(NAME_PRODUCT_SAUCE_LABS_BACKPACK).getText();
    }

    @Step("Клик по кнопке корзины")
    public void clickToBasket() {
        driver.findElement(BUTTON_BASKET).click();
    }

    @Step("Получение стоимости первого товара на странице 'Products'")
    public String getTextElementCostOfTheFirstItem() {
        return driver.findElement(COST_OF_THE_FIRST_ITEM).getText();
    }

    @Step("Получение описания первого товара на странице 'Products'")
    public String getTextElementDescriptionOfTheFirstItem() {
        return driver.findElement(DESCRIPTION_OF_THE_FIRST_ITEM).getText();
    }
}