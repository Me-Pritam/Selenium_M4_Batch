package dropdownpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingTraditionalSingleSelectDropDown
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://proleed.academy/exercises/selenium/automation-practice-form-with-radio-button-check-boxes-and-drop-down.php");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          Actions action = new Actions(driver);

          action.scrollToElement(driver.findElement(By.xpath("//select[@name='country']")))
                  .perform();

          Select selectMobile = new Select(driver.findElement(By.xpath("//select[@name='country_code']")));

          selectMobile.selectByVisibleText("India (+91)");

          Select selectNationality = new Select(driver.findElement(By.xpath("//select[@name='nationality']")));

          selectNationality.selectByVisibleText("Indian");

          Thread.sleep(2000);

//          selectNationality.deselectByVisibleText("Indian");
          selectNationality.deselectAll();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
