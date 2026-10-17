package synchronizationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopperStackLogIn
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://www.shoppersstack.com/");

//          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//          driver.findElement(By.xpath("//button[@id='loginBtn']"))
//                  .click();
//
//          driver.findElement(By.xpath("//input[@id='Email']"))
//                  .sendKeys("demoMail@gmail.com");
//
//          driver.findElement(By.xpath("//input[@id='Password']"))
//                  .sendKeys("Password@1234");
//
//          driver.findElement(By.xpath("//button[@id='Login']"))
//                  .click();

          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']")))
                  .click();

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Email']")))
                  .sendKeys("demoMail@gmail.com");

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Password']")))
                  .sendKeys("Password@1234");

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='Login']")))
                  .click();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
