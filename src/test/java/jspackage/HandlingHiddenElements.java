package jspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingHiddenElements
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            executor.executeScript("document.querySelector(\"input#input2\").value=\"Demo Name\"");

            executor.executeScript("document.querySelector(\"input#checkbox2\").click()");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
