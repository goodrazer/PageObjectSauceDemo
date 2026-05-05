package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;

import java.util.HashMap;

public class BaseTest {

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected BasketPage basketPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @Parameters ({"browser"})
    @BeforeMethod (alwaysRun = true, description = "Настройка браузера")
    @Description ("Настройка браузера")
    public void setUp (@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap <String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-notfications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            WebDriver driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriver driver = new FirefoxDriver();
            DriverManager.setDriver(driver);
            driver.manage().window().maximize();
        }

        loginPage = new LoginPage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
        basketPage = new BasketPage(DriverManager.getDriver());
        checkoutYourInformationPage = new CheckoutYourInformationPage(DriverManager.getDriver());
        checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver());
        checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver());
    }

    @AfterMethod (alwaysRun = true, description = "Закрытие браузера")
    @Description ("Закрытие браузера")
    public void tearDawn () {
        DriverManager.quitDriver();
    }
}