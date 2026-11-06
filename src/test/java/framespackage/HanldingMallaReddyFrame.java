package framespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HanldingMallaReddyFrame
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://www.mallareddyuniversity.ac.in/");

//          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

          FluentWait<WebDriver> wait = new FluentWait<>(driver);
          wait.pollingEvery(Duration.ofSeconds(2));
          wait.withTimeout(Duration.ofSeconds(25));
          wait.ignoring(Exception.class);

          Actions action = new Actions(driver);

          action.pause(Duration.ofSeconds(2))
                  .scrollToElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='Featured Events']"))))
                  .perform();

          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Malla Reddy University, Hyderabad - 2025 | Shaping Minds. Changing Futures.']")));

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Play video']")))
                  .click();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
