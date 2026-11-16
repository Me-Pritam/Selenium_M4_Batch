package screenshotpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class CapturingElementScreenshot
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.incredibleindia.gov.in/en");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            File tempElementFile = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='inc-logo']/a[@href='https://www.incredibleindia.gov.in/en']"))))
                                        .getScreenshotAs(OutputType.FILE);

            File srcElementFile = new File("./ScreenshotFolder/FirstElementSS.png");

            FileHandler.copy(tempElementFile,srcElementFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
