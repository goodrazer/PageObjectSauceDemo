import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingReturnsToProductsFromTheCartTest extends BaseTest {

    @Test

    public void checkingIfAnItemHasBeenRemovedFromTheCart () {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickToBasket();
        basketPage.clickButtonContinueShopping();
        Assert.assertEquals(productsPage.getTitle(),"Products");
    }
}
