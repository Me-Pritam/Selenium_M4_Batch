package jspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingScrollingFunctions
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            JavascriptExecutor executor = (JavascriptExecutor) driver;

//            executor.executeScript("window.scrollBy(0,2000)");
//
//            Thread.sleep(2000);
//
//            executor.executeScript("window.scrollBy(0,2000)");

//            executor.executeScript("window.scrollTo(0,2000)");
//
//            Thread.sleep(2000);
//
//            executor.executeScript("window.scrollTo(0,2000)");

            executor.executeScript("window.scrollTo({top:2000,left:0,behavior:'smooth'})");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
