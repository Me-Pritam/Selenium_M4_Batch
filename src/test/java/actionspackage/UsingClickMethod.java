package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsingClickMethod
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new FirefoxDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

          driver.get("https://demoqa.com/buttons");

          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(35));

          WebElement singleClickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
          WebElement doubleClickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='doubleClickBtn']")));
          WebElement rightClickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='rightClickBtn']")));

          Actions action = new Actions(driver);

          action.click(singleClickButton);
//          action.doubleClick(doubleClickButton).perform();
//          action.contextClick(rightClickButton).perform();

//          action.click(singleClickButton)
//                  .pause(Duration.ofSeconds(1))
//                  .doubleClick(doubleClickButton)
//                  .pause(Duration.ofSeconds(1))
//                  .contextClick()
//                  .perform();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
