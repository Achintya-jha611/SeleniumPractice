import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdowns {

        WebDriver driver=new ChromeDriver();
        @BeforeTest public void setup()
        {driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        }


        @Test(testName = "static") public void staticDropdown()
        {
        WebElement wb= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown=new Select(wb);
        dropDown.selectByIndex(3);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("USD");
        driver.quit();
        }

        @Test(testName = "static with more actions") public void staticVariation() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']")).click();
        Thread.sleep(2000);
        for(int i=0;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
    }
    @Test(testName = "dynamic static dropdwown")public void dynamicDropdown() throws InterruptedException {
                driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@value='BLR']")).click();
            Thread.sleep(2000);
            //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();//there were 2 occurrences of  xPaths ,since selenium does top left to right scan,hence pass index accordingly
            driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();//using parent child relationship to traverse to the option instead of index...selenium only searches inside the specified parent in this case
    }
    @Test(testName = "Auto suggesitve dropdowns")public void autoSuggestiveDropdowns() throws InterruptedException {
            driver.findElement(By.id("autosuggest")).sendKeys("India");
            Thread.sleep(3000);
            List<WebElement> list=driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"][a]"));
            for(int i=0;i<list.size();i++){
                WebElement option=list.get(i);
                if(option.getText().equalsIgnoreCase("India")){
                    option.click();
                    break;
                }
            }

    }
}
