package shadowrootpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandlingBasicClosedShadowRootUsingSelenium
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.click(driver.findElement(By.xpath("//h1[text()='Login']")))
                    .keyDown(Keys.TAB)
                    .keyUp(Keys.TAB)
                    .sendKeys("John Doe")
                    .keyDown(Keys.TAB)
                    .keyUp(Keys.TAB)
                    .sendKeys("Password@12345")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER)
                    .perform();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
