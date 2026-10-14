package webelementpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingGetterMethods
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://blinkit.com/");

            Thread.sleep(2000);

            WebElement locationButton = driver.findElement(By.cssSelector("button.btn.location-box.mask-button"));

            System.out.println("The Visible Text ---->"+locationButton.getText());

            System.out.println("The Background colour ----> "+locationButton.getDomProperty("font-family"));

            System.out.println("The Size is ----> "+locationButton.getSize());

            System.out.println("The Location is ----> "+locationButton.getLocation());

            System.out.println("The Style is ----> "+locationButton.getAttribute("style"));

            System.out.println("The Point in Rectangle Object ----> "+locationButton.getRect().getPoint());

            System.out.println("The Dimension in Rectangle Object ----> "+locationButton.getRect().getDimension());


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
