package Pages;

import DriverManager.ExecutionContext;
import DriverManager.Utils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class CartPage extends ExecutionContext {

    private WebDriver driver;
    private WebDriverWait wait;

    ExtentTest test;
    private Utils utils;
    @FindBy(xpath = "//form/div/table/tbody/tr/td/div/span/button[2]")
    WebElement delete;

    @FindBy(xpath = "//*[@id=\"content\"]/p[text()=\"Your shopping cart is empty!\"]")
    WebElement cartEmpty;

    public CartPage(WebDriver driver, WebDriverWait wait, ExtentTest test){
        this.driver = driver;
        this.wait = wait;
        this.test = test;

        utils = new Utils(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void checkProduct(String product) {
        test.log(Status.INFO, "Se busca que se encuentre el producto " + product + "en el carrito");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//form/div/table/tbody/tr/td/a[text()=\""+ product +"\"]"))).getText(), product);
        test.addScreenCaptureFromPath(utils.TakeScreenshot("checkProduct"));
    }

    public void deleteProduct(){
        test.log(Status.INFO, "Se elimina el producto en el carrito");
        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
        wait.until(ExpectedConditions.visibilityOf(cartEmpty));
        //test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + utils.TakeScreenshot("cartEmpty"));
        test.addScreenCaptureFromPath( utils.TakeScreenshot("cartEmpty"));
    }

}
