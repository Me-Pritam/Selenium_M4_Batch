package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UsingDragAndDrop
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.qa-practice.com/elements/dragndrop/boxes");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

//            action.pause(Duration.ofSeconds(2))
//                    .dragAndDrop(driver.findElement(By.xpath("//div[@id='rect-draggable']")),
//                                driver.findElement(By.xpath("//div[@id='rect-droppable']")))
//                    .perform();

            action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='rect-draggable']")),200,-100)
                    .pause(Duration.ofSeconds(2))
                    .dragAndDropBy(driver.findElement(By.xpath("//div[@id='rect-draggable']")),-200,-400)
                    .pause(Duration.ofSeconds(2))
                    .dragAndDropBy(driver.findElement(By.xpath("//div[@id='rect-draggable']")),200,400)
                    .perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
