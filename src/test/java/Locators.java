import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String args[]){
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("jha@gmail.com");
    driver.findElement(By.name("inputPassword")).sendKeys("random");
    driver.findElement(By.className("submit")).click();
    System.out.println(driver.findElement(By.cssSelector("P.error")).getText());
    driver.findElement(By.linkText("Forgot your password?")).click();
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testing for selenium");
    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@123");//custom  xpath
    driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9991232431");
    driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
    driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("testerrrrr@gmail.com");
    driver.findElement(By.xpath("//form/input[3]")).clear();
    driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234563211");
    driver.findElement(By.className("go-to-login-btn")).click();
    driver.quit();





    }
}
