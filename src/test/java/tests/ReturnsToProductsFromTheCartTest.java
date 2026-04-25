package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnsToProductsFromTheCartTest extends BaseTest {

    @Test
    public void checkingIfAnItemHasBeenRemovedFromTheCart () {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonContinueShopping();
        Assert.assertEquals(productsPage.getTitle(),"Products");
    }
}