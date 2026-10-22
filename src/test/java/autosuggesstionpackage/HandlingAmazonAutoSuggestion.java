package autosuggesstionpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class HandlingAmazonAutoSuggestion
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.amazon.in/");

            FluentWait<WebDriver> wait = new FluentWait(driver);

            wait.pollingEvery(Duration.ofSeconds(2));

            wait.withTimeout(Duration.ofSeconds(10));

            wait.ignoring(Exception.class);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")))
                    .sendKeys("Chocolate");

            List<WebElement> allSuggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'sac-autocomplete-results-container')]/descendant::div[contains(@class,'s-suggestion-ellipsis-direction')]")));

            for(WebElement suggestion : allSuggestions)
            {
                if (suggestion.getText().contains("syrup"))
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
