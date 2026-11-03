package robotpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class PerformingMouseWheel
{
    public static void main(String[] args)
    {
       try
       {
           WebDriver driver = new ChromeDriver();

           driver.manage().window().maximize();

           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

           driver.get("https://www.worldometers.info/geography/flags-of-the-world/");


           Thread.sleep(4000);

           Robot robot = new Robot();

           robot.mouseWheel(100);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
