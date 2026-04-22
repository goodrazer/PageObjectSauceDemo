import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCheckoutFormFromCartTest extends BaseTest{

    @Test

    public void checkingTheTransitionToTheCheckoutForm () {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonCheckout();
        Assert.assertEquals(checkoutYourInformationPage.getTextTitle(),"Checkout: Your Information");
    }

}
