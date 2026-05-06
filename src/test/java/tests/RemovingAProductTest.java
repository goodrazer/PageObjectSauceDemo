package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovingAProductTest extends BaseTest {

    @Test (testName = "Удаление товара из корзины.",
            description = "Удаление первого добавленного товара из корзины.",
            groups = "Positive")
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