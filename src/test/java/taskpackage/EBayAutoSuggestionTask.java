package taskpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class EBayAutoSuggestionTask
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.ebay.com/");

            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.pollingEvery(Duration.ofSeconds(2));
            wait.withTimeout(Duration.ofSeconds(20));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search']")))
                    .sendKeys("iPhone");

            List<WebElement> allSuggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ebay-autocomplete']/descendant::span[@class='suggestion-text']")));

            for(WebElement suggestion : allSuggestions)
            {
                if (suggestion.getText().contains("iphone 16 pro max"))
                {
                    suggestion.click();

                    System.out.println("The element is selected");

                    break;
                }
                else {
                    System.out.println("Teh element is not selected");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
