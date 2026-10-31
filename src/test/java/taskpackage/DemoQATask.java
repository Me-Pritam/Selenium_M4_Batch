package taskpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DemoQATask
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoqa.com/automation-practice-form");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions actions = new Actions(driver);

            actions.pause(Duration.ofSeconds(2))
                    .sendKeys(driver.findElement(By.xpath("//input[@id='firstName']")),"Name")
                    .pause(Duration.ofSeconds(2))
                    .keyDown(Keys.CONTROL)
                    .sendKeys("A")
                    .keyUp(Keys.CONTROL)
//                    .pause(Duration.ofSeconds(1))
                    .keyDown(Keys.CONTROL)
                    .keyUp("C")
                    .keyUp(Keys.CONTROL)
                    .perform();

            actions.pause(Duration.ofSeconds(2))
                    .click(driver.findElement(By.xpath("//input[@id='lastName']")))
                    .pause(Duration.ofSeconds(2))
                    .keyDown(Keys.CONTROL)
                    .sendKeys("V")
                    .keyUp(Keys.CONTROL)
                    .perform();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
