package DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }
    public Utils(){

    }

    public String getDate(){
        LocalDateTime localTime = LocalDateTime.now();
        String temp = localTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd___HH-mm-SS"));

        return temp;
    }

    public String TakeScreenshot(String fileName){
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String file = fileName + '_'+ getDate() +".PNG";
        String name = "src\\test\\resources\\reportes\\" + fileName + '_'+ getDate() +".PNG";
        // Save the screenshot to a file
        try {
            FileUtils.copyFile(screenshotFile, new File(name));
            System.out.println("Screenshot saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to save the screenshot: " + e.getMessage());
        }

        return file;
    }

}
