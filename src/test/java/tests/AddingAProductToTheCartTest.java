package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.AllureUtils;

public class AddingAProductToTheCartTest extends BaseTest {
   @Test (testName = "Добавление товара в корзину",
           description = "Добавление первого товара в корзину",
           groups = "Positive")
   @Description ("Добавление первого товара в корзину")
   @Epic("EPIC01 Добавление товара в корзину")
   @Feature("Basket Page")
   @Story("Positive adding a product to the cart")
   @Severity(SeverityLevel.BLOCKER)
   @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
   @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
   @Issue("LinkBUG")
   @Flaky
   @Owner("Malevaniy Anton")
   public void addingAProductToTheCart() {
       SoftAssert softAssert = new SoftAssert();
       loginPage.open();
       loginPage.checkingTheLoginPageDisplay();
       loginPage.successfulAuthorization();
       productsPage.checkingTheProductsPageDisplay();
       productsPage.addToCart("Sauce Labs Backpack");
       String expectedName = productsPage.getSauceLabsBackpack();
       String expectedPrice = productsPage.getTextElementCostOfTheFirstItem();
       String expectedDescription = productsPage.getTextElementDescriptionOfTheFirstItem();
       productsPage.clickToBasket();
       basketPage.checkingTheBasketPageDisplay();
       basketPage.getSauceLabsBackpackInBasket();
       String actualName = basketPage.getSauceLabsBackpackInBasket();
       softAssert.assertEquals(actualName, expectedName, "Название товара в корзине не совпадает с выбранным!");
       String actualPrice = basketPage.getTextElementCostOfTheFirstItem();
       softAssert.assertEquals(actualPrice, expectedPrice,
       "Валюта или стоимость в корзине не совпадает с валютой или стоимостью товара на странице продукты!");
       String actualDescription = basketPage.getTextElementDescriptionOfTheFirstItem();
       softAssert.assertEquals(actualDescription, expectedDescription,
       "Описание товара в корзине не совпадает с описанием товара на странице продукты!");
       softAssert.assertAll();
   }
}