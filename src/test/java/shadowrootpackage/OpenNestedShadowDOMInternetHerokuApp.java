package shadowrootpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OpenNestedShadowDOMInternetHerokuApp
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://the-internet.herokuapp.com/shadowdom_advanced");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            SearchContext outerShadowRoot = driver.findElement(By.cssSelector("outer-card#outer-card")).getShadowRoot();

            SearchContext innerShadowRoot = outerShadowRoot.findElement(By.cssSelector("inner-card#inner-card")).getShadowRoot();

            innerShadowRoot.findElement(By.cssSelector("button#inner-button"))
                    .click();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
