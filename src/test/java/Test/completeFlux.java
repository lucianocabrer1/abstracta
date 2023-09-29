package Test;

import DriverManager.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.annotations.Test;

public class completeFlux extends BaseTest {

    @Test
    public void goToMonitors() {
        THREAD_LOCAL_EXTENT_TEST = THREAD_LOCAL_EXTENT_REPORTS.
                createTest("Flujo completo","Se desea buscar un producto, agregarlo al carrito y eliminarlo");

        HomePage homePage = new HomePage(getDriver(), getWait(), getExtentTest());

        homePage.findProduct("iphone");

        homePage.selectProduct("iPhone");

        ProductPage productPage = new ProductPage(getDriver(), getWait(), getExtentTest());

        productPage.addToCart();

        homePage.goToViewCart();

        CartPage cartPage = new CartPage(getDriver(), getWait(), getExtentTest());

        cartPage.checkProduct("iPhone");

        cartPage.deleteProduct();

    }
}
