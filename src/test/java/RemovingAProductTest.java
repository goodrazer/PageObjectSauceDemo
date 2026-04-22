import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovingAProductTest extends BaseTest {

    @Test

    public void checkingIfAnItemHasBeenRemovedFromTheCart () {
        loginPage.open();
        loginPage.successfulAuthorization();
        productsPage.clickButtonAddToCart1();
        productsPage.clickToBasket();
        basketPage.clickButtonRemoveInBasket();
        Assert.assertTrue(basketPage.checkRemovedCartItem(),"Товар не удален из корзины!");
    }
}
