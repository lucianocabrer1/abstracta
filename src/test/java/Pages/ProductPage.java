package Pages;

import DriverManager.Utils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private Utils utils;
    @FindBy(id = "button-cart")
    WebElement addToCart;

    ExtentTest test;
    public ProductPage(WebDriver driver, WebDriverWait wait, ExtentTest test){
        this.driver = driver;
        this.wait = wait;
        this.test = test;
        utils = new Utils(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addToCart(){
        test.log(Status.INFO,"Se agrega el producto al carrito ");
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Success: You have added \"]")));
        test.addScreenCaptureFromPath(utils.TakeScreenshot("addToCart"));
    }
}
