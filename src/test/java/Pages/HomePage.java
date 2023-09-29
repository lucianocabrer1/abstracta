package Pages;

import DriverManager.Utils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private Utils utils;
    @FindBy(name = "search")
    WebElement searchBar;

    @FindBy(xpath = "//*[text()=\" View Cart\"]")
    WebElement viewCart;

    @FindBy(id = "cart")
    WebElement cart;
    ExtentTest test;
    public HomePage(WebDriver driver, WebDriverWait wait, ExtentTest test){
         this.driver = driver;
         this.wait = wait;
         this.test = test;
         utils = new Utils(this.driver);
         PageFactory.initElements(this.driver, this);
    }

    public void findProduct(String product){
        test.log(Status.INFO,"Se busca el producto " + product);
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("search="+ product));
        test.addScreenCaptureFromPath(utils.TakeScreenshot("findProduct"));
    }

    public void selectProduct(String productName) {
        test.log(Status.INFO,"Se selecciona el producto " + productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\""+ productName +"\")]"))).click();
        wait.until(ExpectedConditions.urlContains("search="+ productName.toLowerCase()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),\""+ productName +"\")]")));
        test.addScreenCaptureFromPath(utils.TakeScreenshot("selectProduct"));
    }

    public void goToViewCart(){
        test.log(Status.INFO, "Se intenta ingresar el carrito para ver el mismo");
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        wait.until(ExpectedConditions.visibilityOf(viewCart)).click();
        wait.until(ExpectedConditions.urlContains("cart"));
        test.addScreenCaptureFromPath(utils.TakeScreenshot("viewCart"));
    }
}
