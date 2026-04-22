import org.testng.Assert;
import org.testng.annotations.Test;

public class FillingOutTheCheckoutFormTest extends BaseTest{

    @Test

    public void checkFillingOutTheCheckoutFormValidValue() {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        Assert.assertEquals(checkoutOverviewPage.getTextTitleCheckoutOverview(),"Checkout: Overview");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidFirstName() {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.inputCheckoutForm("","Malevaniy","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: First Name is required");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidLastName() {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.inputCheckoutForm("Anton","","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Last Name is required");
    }

    @Test

    public void checkFillingOutTheCheckoutFormInvalidPostalCode() {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Postal Code is required");
    }
}
