package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

    public static WebDriver setUp(String tpoNavegador){
        WebDriver driver = null;

        switch (tpoNavegador){
            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");              // Maximize the browser window
                options.addArguments("--disable-infobars");             // Disable the "Chrome is being controlled by automated test software" infobar
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-cache");// Disable browser extensions
                options.addArguments("--headless");

                driver = new ChromeDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();

                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();

                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver();

                break;
        }

        return driver;
    }
}
