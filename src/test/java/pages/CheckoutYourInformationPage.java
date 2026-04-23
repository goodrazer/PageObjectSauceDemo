package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutYourInformationPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE_CHECKOUT_YOUR_INFORMATION = By.xpath("//span[@data-test='title']");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By BUTTON_CONTINUE = By.id("continue");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By ERROR = By.xpath("//h3[@data-test='error']");



    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void CheckingTheCheckoutYourInfirmationPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CHECKOUT_YOUR_INFORMATION));
    }

    public String getTextTitle() {
        return driver.findElement(TITLE_CHECKOUT_YOUR_INFORMATION).getText();
    }

    public void inputCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(BUTTON_CONTINUE).click();
    }

    public void clickButtonCancel() {
         driver.findElement(BUTTON_CANCEL).click();
    }

    public String getTextError() {
        return driver.findElement(ERROR).getText();
    }

}
