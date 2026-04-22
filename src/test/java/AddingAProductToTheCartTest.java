import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingAProductToTheCartTest extends BaseTest {


   @Test
   public void AddingAProductToTheCart () {
       loginPage.open();
       loginPage.successfulAuthorization();
       productsPage.getSauceLabsBackpack();
       productsPage.clickButtonAddToCart1();
       productsPage.clickToBasket();
       basketPage.getSauceLabsBackpackInBasket();
       String expectedName = productsPage.getSauceLabsBackpack();
       String actualName = basketPage.getSauceLabsBackpackInBasket();
       Assert.assertEquals(actualName, expectedName, "Название товара в корзине не совпадает с выбранным!");
   }
}
