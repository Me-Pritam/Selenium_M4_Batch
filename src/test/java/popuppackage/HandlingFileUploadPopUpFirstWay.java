package popuppackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFileUploadPopUpFirstWay
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://the-internet.herokuapp.com/upload");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          driver.findElement(By.xpath("//input[@id='file-upload']"))
                  .sendKeys("C:/Users/User/Desktop/DummyUpload.txt");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
