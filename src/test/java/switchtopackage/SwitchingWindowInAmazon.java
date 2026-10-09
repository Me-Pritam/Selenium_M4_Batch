package switchtopackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SwitchingWindowInAmazon
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://www.amazon.in/");

            Thread.sleep(2000);

            String parentPageId = driver.getWindowHandle();

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
                    .sendKeys("Lego Star wars");

            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"))
                    .click();

            Thread.sleep(4000);

            driver.findElement(By.xpath("//h2[contains(@aria-label,'Star Wars Millennium Falcon Set ')]"))
                    .click();

            Thread.sleep(2000);

            Set<String> allPageIds = driver.getWindowHandles();

            for(String pageId : allPageIds)
            {
                if (pageId.equals(parentPageId))
                {
                    continue;
                }
                else {
                    driver.switchTo().window(pageId);
                    break;
                }
            }

            driver.findElement(By.xpath("//a[text()=' See All Buying Options ']"))
                    .click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
