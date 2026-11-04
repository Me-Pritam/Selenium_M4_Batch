package dropdownpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectFirstAndLastOptionDemoQspiders
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Select selectMulti = new Select(driver.findElement(By.xpath("//select[@id='select-multiple-native']")));

            List<WebElement> allOptions = selectMulti.getOptions();

            for(int i=0;i<=allOptions.size();i++)
            {
                if (i==0 | i== allOptions.size()-1)
                {
                    allOptions.get(i).click();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
