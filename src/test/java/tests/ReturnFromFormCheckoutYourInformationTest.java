package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReturnFromFormCheckoutYourInformationTest extends BaseTest {

    @Test (testName = "Переход к форме 'Checkout Your Information'.",
            description = "Проверка перехода к форме 'Checkout Your Information'.",
            groups = "Positive")
    @Description("Переход к форме 'Checkout Your Information'.")
    @Epic("EPIC05 Удаление товара")
    @Feature("Checkout Your Information Page")
    @Story("Checking Return From Form Checkout Your Information")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void CheckingReturnFromFormCheckoutYourInformation() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.clickButtonCancel();
        Assert.assertEquals(basketPage.getTextTitleBasket(),"Your Cart");
    }

    public static class RetryTransformer implements IAnnotationTransformer {
        @Override
        public void transform(ITestAnnotation annotation, Class testClass,
                              Constructor testConstructor, Method testMethod) {
            annotation.setRetryAnalyzer(TransitionToProductsPageFromCheckoutOverviewTest.Retry.class);
        }
    }
}