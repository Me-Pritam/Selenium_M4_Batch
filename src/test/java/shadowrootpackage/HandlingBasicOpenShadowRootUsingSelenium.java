package shadowrootpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingBasicOpenShadowRootUsingSelenium
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            SearchContext shadowRootElement = driver.findElement(By.cssSelector("div.my-3")).getShadowRoot();

            shadowRootElement.findElement(By.cssSelector("input[placeholder='Enter your username']"))
                    .sendKeys("JohnDoe");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
