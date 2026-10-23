package webdriverpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekPiramidFirstScript
{
    public static void main(String[] args)
    {
      try
      {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
