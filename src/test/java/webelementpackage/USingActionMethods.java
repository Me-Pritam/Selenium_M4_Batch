package webelementpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class USingActionMethods
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.get("https://www.hotstar.com/in");

          Thread.sleep(2000);

          driver.findElement(By.xpath("//a[@href='/in/explore']"))
                  .click();

          Thread.sleep(2000);

          WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Movies, shows and more']"));

          searchField.sendKeys("Walle", Keys.ENTER);

          Thread.sleep(4000);

          searchField.click();

          Thread.sleep(2000);

          searchField.clear();

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
