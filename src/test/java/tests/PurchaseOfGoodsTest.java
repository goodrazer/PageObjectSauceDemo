package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseOfGoodsTest extends BaseTest {

    @Test (testName = "Покупка товара",
            description = "Проверка покупки первого товара",
            priority = 2,
            timeOut = 20000,
            groups = "Positive")
    public void purchaseOfGoods() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickButtonAddToCart1();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        checkoutOverviewPage.checkingTheCheckoutOverviewPageDisplay();
        checkoutOverviewPage.clickButtonFinish();
        String actualTitle = checkoutCompletePage.getTextTitleCheckoutCompletePage();
        String expectedTitle = "Checkout: Complete!";
        Assert.assertEquals(actualTitle,expectedTitle, "Покупка не произведена!");
    }

    @Test (testName = "Проверка данных приобретаемого товара на форме 'Checkout Overview'.",
            description = "Проверка имени, описания и стоимости товара на форме 'Checkout Overview'.",
            priority = 1,
            groups = "Positive")
    public void checkProductNameAndCostAndDescription() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickButtonAddToCart1();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        checkoutOverviewPage.checkingTheCheckoutOverviewPageDisplay();
        String expectedName = basketPage.getSauceLabsBackpackInBasket();
        String expectedPrice = basketPage.getTextElementCostOfTheFirstItem();
        String expectedDescription = basketPage.getTextElementDescriptionOfTheFirstItem();
        String actualName = checkoutOverviewPage.getTextProductName();
        softAssert.assertEquals(actualName, expectedName, "Название товара на форме оформления заказа " +
                "не совпадает с выбранным в корзине!");
        String actualPrice = checkoutOverviewPage.getTextProductCost();
        softAssert.assertEquals(actualPrice, expectedPrice,
                "Валюта или стоимость товара на форме оформления заказа не " +
                        "совпадает с валютой или стоимостью товара в корзине!");
        String actualDescription = checkoutOverviewPage.getTextProductDescription();
        softAssert.assertEquals(actualDescription, expectedDescription,
                "Описание товара на форме оформления заказа не совпадает с описанием товара в корзине!");
        String actualTextElementItemTotal = checkoutOverviewPage.getTextProductCost();
        String expectedCleanedTotal = actualTextElementItemTotal.replace("Item total: ", "").trim();
        softAssert.assertEquals(expectedCleanedTotal, "$29.99", "Валюта или стоимость не совпадают");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementTax(),
                "Tax: $2.40");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementTotal(),
                "Total: $32.39");
        softAssert.assertAll();
    }
}