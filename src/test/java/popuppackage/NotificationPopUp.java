package popuppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class NotificationPopUp
{
    public static void main(String[] args) {

        try
        {
            ChromeOptions option = new ChromeOptions();

            option.addArguments("--disable-notifications");

            WebDriver driver = new ChromeDriver(option);

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.easemytrip.com/");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
