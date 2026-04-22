package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    WebDriver driver;

    private final By TITLE_CHECKOUT_OVERVIEW = By.xpath("//span[@data-test='title']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextTitleCheckoutOverview() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }





}
