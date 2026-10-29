package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UsingScrollByAmount
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            WebElement ourFlag = driver.findElement(By.xpath("//img[@src='/images/flags/w240/in.webp']"));

            action.pause(Duration.ofSeconds(2))
                    .scrollByAmount(0,ourFlag.getLocation().getY())
                    .perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
