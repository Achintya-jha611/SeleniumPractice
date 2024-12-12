import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Practice {
    WebDriver driver = new ChromeDriver();
    @BeforeTest public void setup(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
   @Test(testName = "login") public void BasicNavigation() {
       driver.get("https://prr-qa.inframarket.cloud/applications");
       driver.findElement(By.xpath("//input[@id=\"sign-in\"]")).sendKeys("7987619717");
       driver.findElement(By.xpath("//Button[@id=\"send-otp-button\"]")).click();
       driver.findElement(By.xpath("//input[@type=\"text\"][2]")).sendKeys("1");
       driver.findElement(By.xpath("//input[@type=\"text\"][3]")).sendKeys("2");
       driver.findElement(By.xpath("//input[@type=\"text\"][4]")).sendKeys("3");
       driver.findElement(By.xpath("//input[@type=\"text\"][5]")).sendKeys("4");
       driver.findElement(By.xpath("//input[@type=\"text\"][6]")).sendKeys("5");
       driver.findElement(By.xpath("//input[@type=\"text\"][6]")).sendKeys("6");
       driver.findElement(By.xpath("//button[text()='Login']")).click();
       driver.findElement(By.xpath("//div[@role=\"tablist\"]/button[2]")).click();
       //driver.quit();
   }
    @Test(testName = "Filter Approved Application",dependsOnMethods = {"BasicNavigation"}) public void FilterApp() throws InterruptedException {
       driver.findElement(By.xpath("//div[@class=\"MuiBox-root css-n36yp9\"]/button")).click();
       driver.findElement(By.xpath("//div[@class=\"MuiBox-root css-1kitncz\"]/span/input[@id=\"submitted\"]")).click();
        //driver.quit();
        driver.manage().wait(10000);
    }
   @AfterTest
   public void clean(){
        driver.quit();
   }


}
