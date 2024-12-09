import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prr-qa.inframarket.cloud/");
        driver.navigate().to("https://groww.in/login/enter");
        driver.navigate().back();
        driver.quit();
    }
}
