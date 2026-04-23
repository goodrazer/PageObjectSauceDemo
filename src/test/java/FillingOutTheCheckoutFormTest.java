import org.testng.Assert;
import org.testng.annotations.Test;

public class FillingOutTheCheckoutFormTest extends BaseTest{

    @Test

    public void checkFillingOutTheCheckoutFormValidValue() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        Assert.assertEquals(checkoutOverviewPage.getTextTitleCheckoutOverview(),"Checkout: Overview");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidFirstName() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("","Malevaniy","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: First Name is required");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidLastName() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Last Name is required");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidPostalCode() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Postal Code is required");
    }
}
