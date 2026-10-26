package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class UsingMoveToElementInAmazon
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.amazon.in/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']")))
                    .pause(Duration.ofSeconds(2))
                    .click(driver.findElement(By.xpath("//a[.='Sign in']")))
                    .perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
