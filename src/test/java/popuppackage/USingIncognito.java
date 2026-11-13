package popuppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class USingIncognito
{
    public static void main(String[] args) {

        try
        {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless");
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");

            options.setAcceptInsecureCerts(true);

            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://untrusted-root.badssl.com/");

            System.out.println(driver.getCurrentUrl());


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
