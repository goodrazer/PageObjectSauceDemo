import org.testng.Assert;
import org.testng.annotations.Test;

public class TransitionToPageCheckoutYourInformationTest extends BaseTest{

    @Test

    public void checkingTheTransitionToTheCheckoutForm () {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        Assert.assertEquals(checkoutYourInformationPage.getTextTitle(),"Checkout: Your Information");
    }

}
