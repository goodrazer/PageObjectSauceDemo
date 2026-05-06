package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnsToProductsFromTheCartTest extends BaseTest {

    @Test (testName = "Возврат к странице продуктов.",
            description = "Проверка возврата к форме 'Products' из корзины.",
            groups = "Positive")
    @Description("Проверка возврата к форме 'Products' из корзины.")
    @Epic("EPIC06 Возврат к странице продуктов.")
    @Feature("Return To Product Page")
    @Story("Checking If An Item Has Been Removed From The Cart")
    @Severity(SeverityLevel.NORMAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Owner("Malevaniy Anton")
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