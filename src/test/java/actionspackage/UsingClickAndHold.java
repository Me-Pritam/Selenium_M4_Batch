package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsingClickAndHold
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://yonobusiness.sbi.bank.in/");

          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

          Actions action = new Actions(driver);

         action.click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'titlebar-close ui-corner-all')]"))))
                 .pause(Duration.ofSeconds(2))
                 .click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Login']"))))
                 .pause(Duration.ofSeconds(2))
                 .perform();

         action.click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='loginOfmenu']"))))
                 .perform();

         boolean isStale = wait.until(ExpectedConditions.stalenessOf(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")))));

         if (isStale)
         {
             action.sendKeys(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")))
                            ,"Password@1234")
                     .perform();

             action.pause(Duration.ofSeconds(2))
                     .clickAndHold(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/img/Revamp/icon_eye_close.svg']"))))
                     .pause(Duration.ofSeconds(2))
                     .release()
                     .perform();
         }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
