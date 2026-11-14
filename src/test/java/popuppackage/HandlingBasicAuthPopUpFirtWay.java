package popuppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingBasicAuthPopUpFirtWay
{
    public static void main(String[] args) {

        try
        {
            String user = "admin";
            String password = "admin";

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://"+user+":"+password+"@the-internet.herokuapp.com/basic_auth");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
