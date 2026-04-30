package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnsToProductsFromTheCartTest extends BaseTest {

    @Test (testName = "Возврат к странице продуктов.",
            description = "Проверка возврата к форме 'Products' из корзины.",
            groups = "Positive",
            retryAnalyzer = Retry.class)
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