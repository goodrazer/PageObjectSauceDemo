import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseOfGoodsTest extends BaseTest{

    @Test

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
}
