import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class BrowserNavigation {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prr-qa.inframarket.cloud/");
        driver.navigate().to("https://groww.in/login/enter");
        driver.navigate().back();
        ((JavascriptExecutor) driver).executeScript("window.open();");

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            //driver.get("https://www.google.com");
        }

        driver.quit();
    }
}
