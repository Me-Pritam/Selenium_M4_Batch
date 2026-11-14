package popuppackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HandlingPasswordPopUp
{
    public static void main(String[] args)
    {
        try
        {
            Map<String,Object> prefs = new HashMap<>();

            prefs.put("profile.password_manager_leak_detection",false);

            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption("prefs",prefs);

            WebDriver driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.saucedemo.com/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//input[@id='user-name']"))
                    .sendKeys("standard_user");

            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.xpath("//input[@name='login-button']"))
                    .click();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
