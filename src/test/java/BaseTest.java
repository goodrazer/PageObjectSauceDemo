import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasketPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    BasketPage basketPage;

    @BeforeMethod
    public void setUp () {
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
        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDawn () {
        driver.quit();
    }
}


