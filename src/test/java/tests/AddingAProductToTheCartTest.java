package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddingAProductToTheCartTest extends BaseTest {
   @Test (testName = "Добавление товара в корзину",
           description = "Добавление первого товара в корзину",
           groups = "Positive",
           retryAnalyzer = Retry.class)
   public void addingAProductToTheCart() {
       SoftAssert softAssert = new SoftAssert();
       loginPage.open();
       loginPage.checkingTheLoginPageDisplay();
       loginPage.successfulAuthorization();
       productsPage.checkingTheProductsPageDisplay();
       productsPage.clickButtonAddToCart1();
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