package jspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

//            executor.executeScript("""
//                    document.querySelector("input[name='username']").value="admin";
//                    setTimeout(()=>document.querySelector("input[name='password']").value="admin123",1000)
//                    setTimeout(()=>document.querySelector("button[class^='oxd-button oxd-button--medium ']").click(),1000)
//                    """);

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[name='username']"))));
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[name='password']"))));
            WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[class^='oxd-button oxd-button--medium']"))));

//            executor.executeScript("arguments[0].value='Admin'",userNameField);
//            executor.executeScript("arguments[0].value='admin123'",passwordField);
//            executor.executeScript("arguments[0].click()",logInButton);


            userNameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");
            logInButton.click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
