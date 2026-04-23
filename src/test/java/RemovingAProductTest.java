import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovingAProductTest extends BaseTest {

    @Test

    public void checkingIfAnItemHasBeenRemovedFromTheCart () {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickButtonAddToCart1();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonRemoveInBasket();
        Assert.assertTrue(basketPage.checkRemovedCartItem(),"Товар не удален из корзины!");
    }
}
