package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UsingScrollToElement
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://www.amazon.in/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          Actions action = new Actions(driver);

          action.pause(Duration.ofSeconds(2))
                  .scrollToElement(driver.findElement(By.xpath("//div[text()='Back to top']")))
                  .pause(Duration.ofSeconds(2))
                  .perform();

          action.pause(Duration.ofSeconds(2))
                  .click(driver.findElement(By.xpath("//h2[text()='See personalized recommendations']/parent::div/descendant::a[contains(@href,'https://www.amazon.in/ap/signin?')]")))
                  .perform();

          action.pause(Duration.ofSeconds(2))
                  .sendKeys(driver.findElement(By.xpath("//input[@id='ap_email_login']")),
                            "9988776655")
                  .perform();

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
