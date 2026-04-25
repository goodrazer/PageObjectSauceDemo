package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnFromFormCheckoutYourInformationTest extends BaseTest {

    @Test
    public void CheckingReturnFromFormCheckoutYourInformation() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickButtonAddToCart1();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.clickButtonCancel();
        Assert.assertEquals(basketPage.getTextTitleBasket(),"Your Cart");
    }
}