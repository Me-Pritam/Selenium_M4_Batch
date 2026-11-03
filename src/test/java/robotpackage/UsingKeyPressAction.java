package robotpackage;

import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UsingKeyPressAction
{
    public static void main(String[] args)
    {
        try
        {
           Thread.sleep(2000);

            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
