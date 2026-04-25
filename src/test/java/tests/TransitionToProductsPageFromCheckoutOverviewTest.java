package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TransitionToProductsPageFromCheckoutOverviewTest extends BaseTest {

    @Test
    public void executionTransitionToProductsPageFromCheckoutOverview() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickButtonAddToCart1();
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