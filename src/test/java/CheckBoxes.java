import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBoxes {
    @Test(testName = "handling checkboxes")public void checkbox() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://prr-qa.inframarket.cloud/applications");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button/span[contains(@class,'MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel')]")).click();
        Thread.sleep(2000);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='approved']")).isSelected());
        driver.findElement(By.xpath("//input[@id='approved']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='approved']")).isSelected());
        List<WebElement> l1=driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(l1.size(),5,"number of checkboxes are incorrect");

    }
    @Test()public void checkBoxAssessment(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption2")).click();
        driver.findElement(By.id("checkBoxOption3")).click();
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(checkBoxes.size(),3,"number of checkboxes are incorrect");



    }
}

