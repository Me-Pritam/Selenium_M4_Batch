package autosuggesstionpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingAutoSuggestionInFlipKart
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://www.flipkart.com/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          driver.findElement(By.xpath("//span[text()='✕']"))
                          .click();

          driver.findElement(By.xpath("//input[@name='q']"))
                  .sendKeys("DSA");

          List<WebElement> allSuggestions = driver.findElements(By.xpath("//ul[starts-with(@class,'VCplLH lTpUwR')]/descendant::a/child::div[2]"));

          for(WebElement suggestion : allSuggestions)
          {
              if (suggestion.getText().contains("dsa with java"))
              {
                  suggestion.click();
                  break;
              }
          }
      }
      catch (Exception e)
      {

          e.printStackTrace();
      }
    }
}
