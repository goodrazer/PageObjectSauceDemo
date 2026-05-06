package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE_CHECKOUT_COMPLETE = By.xpath("//span[@data-test='title']");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTextTitleCheckoutCompletePage() {
        return driver.findElement(TITLE_CHECKOUT_COMPLETE).getText();
    }
}