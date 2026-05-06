package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE_CHECKOUT_OVERVIEW = By.xpath("//span[@data-test='title']");
    private final By ELEMENT_QTY = By.xpath("//div[@data-test='cart-quantity-label']");
    private final By ELEMENT_DESCRIPTION = By.xpath("//div[@data-test='cart-desc-label']");
    private final By BLOCK_WITH_PURCHASED_GOODS = By.xpath("//div[@data-test='inventory-item']");
    private final By ELEMENT_PAYMENT_INFORMATION = By.xpath("//div[@data-test='payment-info-label']");
    private final By ELEMENT_SAUCE_CARD = By.xpath("//div[@data-test='payment-info-value']");
    private final By ELEMENT_SHIPPING_INFORMATION = By.xpath("//div[@data-test='shipping-info-label']");
    private final By ELEMENT_DELIVERY_OPTION = By.xpath("//div[@data-test='shipping-info-value']");
    private final By ELEMENT_PRICE_TOTAL = By.xpath("//div[@data-test='total-info-label']");
    private final By ELEMENT_ITEM_TOTAL = By.xpath("//div[@data-test='subtotal-label']");
    private final By ELEMENT_TAX = By.xpath("//div[@data-test='tax-label']");
    private final By ELEMENT_TOTAL = By.xpath("//div[@class='summary_total_label']");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By BUTTON_FINISH = By.id("finish");
    private final By NAME_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-name']");
    private final By DESCRIPTION_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By COST_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-price']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkingTheCheckoutOverviewPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CHECKOUT_OVERVIEW));
    }

    @Step("Проверка наименования продукта при оформлении заказа")
    public String getTextProductName() {
        return driver.findElement(NAME_PRODUCT1).getText();
    }

    @Step("Проверка описания продукта при оформлении заказа")
    public String getTextProductDescription() {
        return driver.findElement(DESCRIPTION_PRODUCT1).getText();
    }

    @Step("Проверка стоимости продукта при оформлении заказа")
    public String getTextProductCost() {
        return driver.findElement(COST_PRODUCT1).getText();
    }

    @Step("Получение наименования страницы 'CHECKOUT OVERVIEW'")
    public String getTextTitleCheckoutOverview() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }
    @Step("Получение информации об оплате")
    public String getTextElementPaymentInformation() {
        return driver.findElement(ELEMENT_PAYMENT_INFORMATION).getText();
    }

    @Step("Получение номера заказа")
    public String getTextElementSauceCard() {
        return driver.findElement(ELEMENT_SAUCE_CARD).getText();
    }

    @Step("Получение элемента 'QTY' на странице оформления заказа")
    public String getTextElementQyt() {
        return driver.findElement(ELEMENT_QTY).getText();
    }

    @Step("Получение элемента 'Description' на странице оформления заказа")
    public String getTextElementDescription() {
        return driver.findElement(ELEMENT_DESCRIPTION).getText();
    }

    @Step("Проверка отображения блока с приобретенными товарами")
    public boolean checkIsDisplayedBlockWithPurchasedGoods() {
        driver.findElement(BLOCK_WITH_PURCHASED_GOODS).isDisplayed();
        return false;
    }

    @Step("Получение элемента 'SHIPPING INFORMATION' на странице оформления заказа")
    public String getTextElementShippingInformation() {
        return driver.findElement(ELEMENT_SHIPPING_INFORMATION).getText();
    }

    @Step("Получение элемента 'DELIVERY OPTION' на странице оформления заказа")
    public String getTextElementDeliveryOption() {
        return driver.findElement(ELEMENT_DELIVERY_OPTION).getText();
    }

    @Step("Получение элемента 'PRICE TOTAL' на странице оформления заказа")
    public String getTextElementPriceTotal() {
        return driver.findElement(ELEMENT_PRICE_TOTAL).getText();
    }

    @Step("Проверка отображения элемента 'Item Total' на странице оформления заказа")
    public boolean checkIsDisplayedElementItemTotal() {
        driver.findElement(ELEMENT_ITEM_TOTAL).isDisplayed();
        return false;
    }

    @Step("Проверка отображения элемента 'Tax' на странице оформления заказа")
    public boolean checkIsDisplayedElementTax() {
        driver.findElement(ELEMENT_TAX).isDisplayed();
        return false;
    }

    @Step("Получение валюты и стоимости надбавки магазина на странице оформления заказа")
    public String getTextElementTax() {
        return driver.findElement(ELEMENT_TAX).getText();
    }

    @Step("Проверка отображения элемента 'Total' на странице оформления заказа")
    public boolean checkIsDisplayedElementTotal() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    @Step("Проверка валюты и общей стоимости приобратаемых товаров на странице оформления заказа")
    public String getTextElementTotal() {
        return driver.findElement(ELEMENT_TOTAL).getText();
    }

    @Step("Проверка отображения кнопки 'Cancel' на странице оформления заказа")
    public boolean checkIsDisplayedButtonCancel() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }
    @Step("Проверка отображения кнопки 'Finish' на странице оформления заказа")
    public boolean checkIsDisplayedButtonFinish() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    @Step("Клик по кнопке 'Cancel' на странице оформления заказа")
    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }

    @Step("Клик по кнопке 'Finish' на странице оформления заказа")
    public void clickButtonFinish() {
        driver.findElement(BUTTON_FINISH).click();
    }
}