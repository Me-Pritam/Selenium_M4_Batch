package taskpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DragAndDropTask
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://testautomationpractice.blogspot.com/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement lowerRange = driver.findElement(By.xpath("//div[@id='slider-range']/child::span[1]"));

            WebElement higherRange = driver.findElement(By.xpath("//div[@id='slider-range']/child::span[2]"));

            WebElement priceRange = driver.findElement(By.cssSelector("input#amount"));

            System.out.println(priceRange.getDomAttribute("placeholder"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
