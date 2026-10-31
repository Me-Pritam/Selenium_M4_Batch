package robotpackage;

import java.awt.*;
import java.awt.event.MouseEvent;

public class USingMouseClicking
{
    public static void main(String[] args)
    {
      try
      {
          Robot robot = new Robot();

          robot.delay(2000);
//          robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
//          robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);

          robot.mouseMove(100,50);
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
