package autosuggesstionpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionYoutube
{
    public static void main(String[] args)
    {
       try
       {
           WebDriver driver = new ChromeDriver();

           driver.manage().window().maximize();

           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

           driver.get("https://www.youtube.com/");

           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           driver.findElement(By.xpath("//input[@name='search_query']"))
                   .sendKeys("Godzilla");

           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

           List<WebElement> allSuggestion = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@role='listbox']/descendant::div[@class='ytSuggestionComponentLeftContainer']/child::span"))));

           for(WebElement suggestion : allSuggestion)
           {
               if (suggestion.getText().contains("Minus Zero"))
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
