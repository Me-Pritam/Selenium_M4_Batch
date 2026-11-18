package jspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingScrollIntoView
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

//            executor.executeScript("document.querySelector(\"img[alt='Flag of India']\").scrollIntoView({block:'start',behavior:'smooth'})");

            WebElement ourFlag = driver.findElement(By.cssSelector("img[alt='Flag of India']"));

            WebElement theirFlag = driver.findElement(By.cssSelector("img[alt='Flag of Japan']"));

            executor.executeScript("arguments[0].scrollIntoView({block:'start',behavior:'smooth'});" +
                                            "arguments[1].click();",ourFlag,theirFlag);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
