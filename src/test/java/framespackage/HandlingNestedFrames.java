package framespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingNestedFrames
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://app.thetestingacademy.com/playwright/frames/nested-iframes");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pact1']")));

            driver.findElement(By.xpath("//input[@name='inp_val']"))
                    .sendKeys("Happy Testing");

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pact2']")));

            WebElement secondFrameInput  = driver.findElement(By.xpath("//input[@id='jex']"));

            secondFrameInput.sendKeys("Happy Happy Testing");

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pact3']")));

            driver.findElement(By.xpath("//input[@name='glaf']")).sendKeys("Happy Happy Happiest Testing");

            driver.switchTo().parentFrame();

            secondFrameInput.clear();

            secondFrameInput.sendKeys("Developers Rock !! QAs also Rock!!!!!");

            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("//a[text()='Playwright Automation Mastery']"))
                    .click();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
