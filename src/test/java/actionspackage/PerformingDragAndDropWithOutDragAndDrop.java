package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PerformingDragAndDropWithOutDragAndDrop
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://excalidraw.com/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          Actions action = new Actions(driver);

          action.click(driver.findElement(By.xpath("//button[@aria-label='Draw']")))
                  .pause(Duration.ofSeconds(2))
                  .moveByOffset(-50,100)
                  .pause(Duration.ofSeconds(2))
                  .clickAndHold()
                  .pause(Duration.ofSeconds(2))
                  .moveByOffset(600,0)
                  .pause(Duration.ofSeconds(2))
                  .release()
                  .perform();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
