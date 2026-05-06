package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class FillingOutTheCheckoutFormTest extends BaseTest {
    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' валидными значениями",
            description = "Проверка заполнения формы 'Checkout Your Information' валидными значениями ФИО и почтового индекса",
            priority = 1,
            groups = "Positive")
    public void checkFillingOutTheCheckoutFormValidValue() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","87486734");
        Assert.assertEquals(checkoutOverviewPage.getTextTitleCheckoutOverview(),"Checkout: Overview");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидным именем",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидным именем",
            priority = 3,
            groups = "Negative",
            enabled = false)
    public void checkFillingOutTheCheckoutFormInvalidFirstName() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("","Malevaniy","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: First Name is required");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидной фамилией",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидной фамилией",
            priority = 4,
            groups = "Negative",
            enabled = false)
    public void checkFillingOutTheCheckoutFormInvalidLastName() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Last Name is required");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидным почтовым индексом",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидным почтовым индексом",
            priority = 5,
            groups = "Negative",
            enabled = false)
    public void checkFillingOutTheCheckoutFormInvalidPostalCode() {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm("Anton","Malevaniy","");
        Assert.assertEquals(checkoutYourInformationPage.getTextError(),"Error: Postal Code is required");
    }

    @DataProvider(name = "Тестовые даннны для негативных проверок заполнения полей при оформлении заказа клиентом")
    public Object[][] loginData (){
        return new Object[][] {
                {"","Malevaniy","87486734","Error: First Name is required"},
                {"Anton","","87486734","Error: Last Name is required"},
                {"Anton","Malevaniy","","Error: Postal Code is required"},
        };
    }

    @Test (testName = "Проверка заполнения формы 'Checkout' невалидными значениями.",
            description = "Проверка заполнения формы 'Checkout' невалидными значениями.",
            dataProvider = "Тестовые даннны для негативных проверок заполнения полей при оформлении заказа клиентом",
            priority = 2,
            groups = "Negative")
    public void inputNegativeLogin (String firstName, String lastName, String postalCode,String errorMessage) {
        loginPage.open();
        loginPage.checkingTheLoginPageDisplay();
        loginPage.successfulAuthorization();
        productsPage.checkingTheProductsPageDisplay();
        productsPage.clickToBasket();
        basketPage.checkingTheBasketPageDisplay();
        basketPage.clickButtonCheckout();
        checkoutYourInformationPage.CheckingTheCheckoutYourInfirmationPageDisplay();
        checkoutYourInformationPage.inputCheckoutForm(firstName, lastName, postalCode);
        assertEquals(checkoutYourInformationPage.getTextError(), errorMessage);
    }
}