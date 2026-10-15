package synchronizationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingImplicitWait
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://www.youtube.com/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@name='search_query']"))
                    .sendKeys("dude orchestral suite");

//            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[@title='Search']"))
                    .click();

//            Thread.sleep(2000);

            driver.findElement(By.xpath("//yt-formatted-string[text()='Dude – Orchestral Suite']"))
                    .click();

//            Thread.sleep(2000);

            driver.manage().window().fullscreen();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
