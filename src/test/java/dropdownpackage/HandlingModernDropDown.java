package dropdownpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HandlingModernDropDown
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoqa.com/automation-practice-form");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.pause(Duration.ofSeconds(2))
                    .scrollToElement(driver.findElement(By.xpath("//button[@id='submit']")))
                    .pause(Duration.ofSeconds(2))
                    .click(driver.findElement(By.xpath("//div[text()='Select State']")))
                    .perform();

            List<WebElement> allOptions = driver.findElements(By.xpath("//div[@id='react-select-3-listbox']/child::div"));

            for(WebElement option : allOptions)
            {
                if (option.getText().equals("Uttar Pradesh"))
                {
                    option.click();
                    break;   
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
