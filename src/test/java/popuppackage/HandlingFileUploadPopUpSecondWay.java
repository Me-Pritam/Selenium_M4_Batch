package popuppackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HandlingFileUploadPopUpSecondWay
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://the-internet.herokuapp.com/upload");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            StringSelection path = new StringSelection("C:\\Users\\User\\Desktop\\DummyUpload.txt");

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path,null);

            driver.findElement(By.xpath("//div[@id='drag-drop-upload']"))
                    .click();

            Thread.sleep(2000);

            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(200);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
