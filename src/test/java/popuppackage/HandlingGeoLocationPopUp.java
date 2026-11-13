package popuppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HandlingGeoLocationPopUp
{
    public static void main(String[] args) {

        try
        {
            Map<String,Object> prefs = new HashMap<>();

            prefs.put("profile.default_content_setting_values.geolocation",2);

            EdgeOptions options = new EdgeOptions();

            options.setExperimentalOption("prefs",prefs);

            WebDriver driver = new EdgeDriver(options);

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.lenskart.com/");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
