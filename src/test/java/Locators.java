import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class Locators {
    public static void main(String args[]) throws InterruptedException {
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    /*driver.findElement(By.id("inputUsername")).sendKeys("jha@gmail.com");
    driver.findElement(By.name("inputPassword")).sendKeys("random");
    driver.findElement(By.className("submit")).click();*/
    //System.out.println(driver.findElement(By.cssSelector("P.error")).getText());
        String password=getPassword(driver);
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testing for selenium");
    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@123");//custom  xpath
    driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9991232431");
    driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
    driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("testerrrrr@gmail.com");
    driver.findElement(By.xpath("//form/input[3]")).clear();
    driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234563211");
    driver.findElement(By.className("go-to-login-btn")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("input[type*='text']")).sendKeys("rahul");
        driver.findElement(By.xpath("//div/form[@class='form']/input[2]")).sendKeys(password);//xpath using parent to child traversal
        driver.findElement(By.xpath("//div[@class='checkbox-container']/span/input[@id='chkboxOne']")).click();
        driver.findElement(By.cssSelector("Button.submit")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("P")).getText(),"You are successfully logged in.");
        driver.findElement(By.xpath("//Button[text()='Log Out']")).click();
    driver.quit();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//Button[text()='Reset Login']")).click();
        String displayText=driver.findElement(By.xpath("//form[@action='#']/p")).getText();
        String[] arrSplit=displayText.split("'");
        String pass=arrSplit[1].split("'")[0];
        return pass;

    }
}
