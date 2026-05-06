package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void checkingTheLoginPageDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Авторизация покупателя на форме 'Login' c заполнением параметров {user} и {password}")
    public void login(String user, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Авторизация покупателя с вводом валидных парметров {user} и {password}")
    public void successfulAuthorization() {
        driver.findElement(USERNAME_FIELD).sendKeys("standard_user");
        driver.findElement(PASSWORD_FIELD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получение ошибки при вводе невалидных данных покупателя на форме 'Login'")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}