package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidatingElementsInCheckoutOverviewPageTest extends BaseTest {

    @Test (testName = "Отображение элементов формы 'CheckoutOverview'.",
            description = "Проверка отображения элементов на форме 'CheckoutOverview'.",
            groups = "Positive")
    public void checkValidatingElementsInCheckoutOverviewPage() {
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
        softAssert.assertEquals(checkoutOverviewPage.getTextElementQyt(),
                "QTY",
                "Элемент: QTY - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementDescription(),
                "Description",
                "Элемент: Description - не найден на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedBlockWithPurchasedGoods(),
                true,
                "Элемент: Description - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementPaymentInformation(),
                "Payment Information:",
                "Элемент: Payment Information - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementSauceCard(),
                "SauceCard #31337",
                "Элемент: SauceCard - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementShippingInformation(),
                "Shipping Information:",
                "Элемент: Payment Information - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementShippingInformation(),
                "Shipping Information:",
                "Элемент: Payment Information - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementDeliveryOption(),
                "Free Pony Express Delivery!",
                "Элемент: Free Pony Express Delivery! - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementDeliveryOption(),
                "Free Pony Express Delivery!",
                "Элемент: Free Pony Express Delivery! - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementPriceTotal(),
                "Price Total",
                "Элемент: Price Total - не найден на странице!");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementPriceTotal(),
                "Price Total",
                "Элемент: Price Total - не найден на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedElementItemTotal(),
                true,
                "Элемент: ItemTotal - не найден на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedElementTax(),
                true,
                "Элемент: Tax - не найден на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedElementTotal(),
                true,
                "Элемент: Total - не найден на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedButtonCancel(),
                true,
                "Кнопка: Cancel - не найдена на странице!");
        softAssert.assertNotEquals(checkoutOverviewPage.checkIsDisplayedButtonFinish(),
                true,
                "Кнопка: Finish - не найдена на странице!");
        softAssert.assertAll();
    }
}