package actionspackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class USingKeyDownKeyUp
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.amazon.in/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.pause(Duration.ofSeconds(4))
                    .keyDown(Keys.CONTROL)
                    .sendKeys("A")
                    .keyUp(Keys.CONTROL)
                    .perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
