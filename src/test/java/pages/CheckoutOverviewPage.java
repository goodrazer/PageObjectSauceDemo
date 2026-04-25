package pages;

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

    public String getTextProductName() {
        return driver.findElement(NAME_PRODUCT1).getText();
    }

    public String getTextProductDescription() {
        return driver.findElement(DESCRIPTION_PRODUCT1).getText();
    }

    public String getTextProductCost() {
        return driver.findElement(COST_PRODUCT1).getText();
    }

    public String getTextTitleCheckoutOverview() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }

    public String getTextElementPaymentInformation() {
        return driver.findElement(ELEMENT_PAYMENT_INFORMATION).getText();
    }

    public String getTextElementSauceCard() {
        return driver.findElement(ELEMENT_SAUCE_CARD).getText();
    }

    public String getTextElementQyt() {
        return driver.findElement(ELEMENT_QTY).getText();
    }

    public String getTextElementDescription() {
        return driver.findElement(ELEMENT_DESCRIPTION).getText();
    }

    public boolean checkIsDisplayedBlockWithPurchasedGoods() {
        driver.findElement(BLOCK_WITH_PURCHASED_GOODS).isDisplayed();
        return false;
    }

    public String getTextElementShippingInformation() {
        return driver.findElement(ELEMENT_SHIPPING_INFORMATION).getText();
    }

    public String getTextElementDeliveryOption() {
        return driver.findElement(ELEMENT_DELIVERY_OPTION).getText();
    }

    public String getTextElementPriceTotal() {
        return driver.findElement(ELEMENT_PRICE_TOTAL).getText();
    }

    public boolean checkIsDisplayedElementItemTotal() {
        driver.findElement(ELEMENT_ITEM_TOTAL).isDisplayed();
        return false;
    }

    public boolean checkIsDisplayedElementTax() {
        driver.findElement(ELEMENT_TAX).isDisplayed();
        return false;
    }

    public String getTextElementTax() {
        return driver.findElement(ELEMENT_TAX).getText();
    }

    public boolean checkIsDisplayedElementTotal() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    public String getTextElementTotal() {
        return driver.findElement(ELEMENT_TOTAL).getText();
    }

    public boolean checkIsDisplayedButtonCancel() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    public boolean checkIsDisplayedButtonFinish() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }

    public void clickButtonFinish() {
        driver.findElement(BUTTON_FINISH).click();
    }
}