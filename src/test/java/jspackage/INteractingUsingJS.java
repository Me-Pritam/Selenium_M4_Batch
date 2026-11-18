package jspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class INteractingUsingJS
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new EdgeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            executor.executeScript("""
                    document.querySelector("input[name='username']").value="admin";
                    setTimeout(()=>document.querySelector("input[name='password']").value="admin123",1000)
                    setTimeout(()=>document.querySelector("button[class^='oxd-button oxd-button--medium ']").click(),1000)
                    """);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
