package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransitionToProductsPageFromCheckoutOverviewTest extends BaseTest {

    @Test (testName = "Переход к форме 'Products' из 'CheckoutOverview'.",
            description = "Проверка перехода к форме 'Products' с формы 'CheckoutOverview' по кнопке 'Cancel'.",
            groups = "Positive")
    @Description("Проверка перехода к форме 'Products' с формы 'CheckoutOverview' по кнопке 'Cancel'.")
    @Epic("EPIC08 Возврат к форме продуктов")
    @Feature("Checkout Overview Page")
    @Story("Execution Transition To Products Page From Checkout Overview")
    @Severity(SeverityLevel.NORMAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Owner("Malevaniy Anton")
    public void executionTransitionToProductsPageFromCheckoutOverview() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        checkoutOverviewPage.checkingTheCheckoutOverviewPageDisplay();
        checkoutOverviewPage.clickButtonCancel();
        Assert.assertEquals(productsPage.getTitle(),"Products");
    }
}