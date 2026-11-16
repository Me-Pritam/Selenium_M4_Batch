package popuppackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingToastPopUP
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://chat.qspiders.com/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          driver.findElement(By.xpath("//input[@id='username']"))
                  .sendKeys("dummymail@gmail.com");

          driver.findElement(By.xpath("//input[@id='password']"))
                  .sendKeys("Password@1234");
          
          driver.findElement(By.xpath("//button[text()='Login']"))
                  .click();

          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='close']")))
                  .click();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
