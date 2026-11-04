package dropdownpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandlingTraditionalMultiSelectDropDown
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://techcanvass.com/Examples/multi-select.html?srsltid=AYCX9vLEnbo_dnnvo4QmuaKM2kbVTPFGuk7HOCEyitVR0r3XrAxU1-47");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Select selectMulti = new Select(driver.findElement(By.xpath("//select[@id='multiselect']")));

            if (selectMulti.isMultiple())
            {
//                selectMulti.selectByVisibleText("Volvo");
//                selectMulti.selectByVisibleText("Audi");
//                selectMulti.selectByVisibleText("Hyundai");

                List<WebElement> allOptions = selectMulti.getOptions();

                for(WebElement option : allOptions)
                {
                    String optionName = option.getText();

                    if (optionName.equals("Volvo") | optionName.equals("Audi") | optionName.equals("Hyundai"))
                    {
                        option.click();
                    }
                }

                Thread.sleep(2000);

//                selectMulti.deselectByVisibleText("Hyundai");
//
//                selectMulti.deselectByVisibleText("Audi");
//
//                selectMulti.deselectByVisibleText("Volvo");

                selectMulti.deselectAll();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
