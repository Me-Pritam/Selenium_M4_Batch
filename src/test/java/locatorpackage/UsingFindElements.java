package locatorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UsingFindElements
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.get("https://www.myntra.com/");

          Thread.sleep(4000);

          List<WebElement> allLinks = driver.findElements(By.tagName("a"));

          for(WebElement link : allLinks)
          {
              System.out.println(link.getText());
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
