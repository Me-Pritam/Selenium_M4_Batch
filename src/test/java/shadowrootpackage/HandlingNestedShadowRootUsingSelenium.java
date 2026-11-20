package shadowrootpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandlingNestedShadowRootUsingSelenium
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          SearchContext outerShadowRootElement = driver.findElement(By.cssSelector("div.shadowOuter")).getShadowRoot();

          Actions action = new Actions(driver);

          action.click(outerShadowRootElement.findElement(By.cssSelector("label.shadowLabel")))
                  .sendKeys(Keys.TAB)
                  .sendKeys("John Doe")
                  .sendKeys(Keys.TAB)
                  .sendKeys("Password@1234")
                  .sendKeys(Keys.TAB)
                  .sendKeys(Keys.ENTER)
                  .perform();


      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
