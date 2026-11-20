package jspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HanldingDisabledElement
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

         driver.get("https://practicetestautomation.com/practice-test-exceptions/");

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          JavascriptExecutor executor = (JavascriptExecutor)driver;

          executor.executeScript("let inputField = document.querySelector(\"input.input-field\");" +
                  "inputField.removeAttribute(\"disabled\");" +
                  "inputField.value=\"Veg Momo\"");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
