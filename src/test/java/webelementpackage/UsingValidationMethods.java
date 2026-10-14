package webelementpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingValidationMethods
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new EdgeDriver();

            driver.manage().window().maximize();

            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            Thread.sleep(2000);

            WebElement checkBox = driver.findElement(By.xpath("//input[@label='blah']"));

            if (checkBox.isSelected())
            {
                System.out.println("The checkbox is selected");
            }
            else
            {
                System.out.println("The cehckbox is not selected");

                checkBox.click();

            }

            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[text()='Remove']"))
                    .click();

            Thread.sleep(2000);

//            if (checkBox.isDisplayed())
//            {
//                System.out.println("The CheckBox is displayed");
//            }
//            else
//            {
//                System.out.println("The CheckBox is hidden");
//            }

            WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

            if (inputField.isEnabled())
            {
                System.out.println("The Input Field is enabled");
            }
            else{
                System.out.println("The Input Field is disabled . So we will enable that");

                driver.findElement(By.xpath("//button[text()='Enable']"))
                        .click();

                Thread.sleep(10000);

                inputField.sendKeys("Text");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
