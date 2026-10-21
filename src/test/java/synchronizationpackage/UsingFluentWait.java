package synchronizationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class UsingFluentWait
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoqa.com/automation-practice-form");

            FluentWait<WebDriver> wait = new FluentWait<>(driver);

            wait.pollingEvery(Duration.ofSeconds(2));
            wait.withTimeout(Duration.ofSeconds(20));
            wait.ignoring(Exception.class);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstName']")))
                    .sendKeys("FirstName");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastName']")))
                    .sendKeys("LastName");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='userEmail']")))
                    .sendKeys("dummyMail@gmail.com");

            List<WebElement> allGender = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='genterWrapper']/descendant::label")));

            for(WebElement gender :allGender)
            {
                if (gender.getText().equals("Other"))
                {
                    gender.click();
                    break;
                }
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='userNumber']")))
                    .sendKeys("9988776655");

           WebElement calendar =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateOfBirthInput']")));

           calendar.clear();

//           calendar.sendKeys("15 Aug 1947");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")))
                    .sendKeys("English");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']")))
                    .click();

            List<WebElement> allHobbies= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='hobbiesWrapper']/descendant::div[starts-with(@class,'col-md-9')]/descendant::label")));

            for(WebElement hobby : allHobbies)
            {
                if (hobby.getText().equals("Reading"))
                {
                    hobby.click();

                    break;
                }
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='currentAddress']")))
                    .sendKeys("Hyderabad");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")))
                    .click();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
