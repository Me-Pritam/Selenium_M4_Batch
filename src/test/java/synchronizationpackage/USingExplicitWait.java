package synchronizationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class USingExplicitWait
{
    public static void main(String[] args)
    {
     try
     {
         WebDriver driver = new ChromeDriver();

         driver.manage().window().maximize();

         driver.get("https://testautomationpractice.blogspot.com/");

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")))
                 .sendKeys("Selenium");

         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='wikipedia-search-button']")))
                 .click();

         List<WebElement> allLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wikipedia-search-results']/child::div")));

         for(WebElement link : allLinks)
         {
             if (link.getText().equals("Selenium (software)"))
             {
                 link.click();
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
