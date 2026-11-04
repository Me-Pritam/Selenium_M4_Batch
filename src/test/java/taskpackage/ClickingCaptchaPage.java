package taskpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickingCaptchaPage
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://proleed.academy/exercises/selenium/automation-practice-form-with-radio-button-check-boxes-and-drop-down.php");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.scrollToElement(driver.findElement(By.xpath("//input[@value='Submit']")))
                    .perform();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            Select selectCountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));

            selectCountry.selectByVisibleText("India");

            action.pause(Duration.ofSeconds(2))
                    .keyDown(Keys.TAB)
                    .keyUp(Keys.TAB)
                    .pause(Duration.ofSeconds(1))
                    .keyDown(Keys.ENTER)
                    .keyUp(Keys.ENTER)
                    .pause(Duration.ofSeconds(15))
                    .click(driver.findElement(By.xpath("//input[@value='Submit']")))
                    .perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
