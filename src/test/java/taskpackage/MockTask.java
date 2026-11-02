package taskpackage;


/*
*1. Open Firefox Browser and open this URL “https://www.saucedemo.com/”.
2. Perform LogIn using UserName - “standard_user ” and Password - “secret_sauce”.
3. Verify Inventory Page is opened . If it is opened ,print in console ~ “Inventory Page is opened”.
4. Count the number of Products in the Inventory Page and Print the number of the products.
5. Print the Name and the Price of all Products.
6. From all products click on the Fourth Product without using xpath by index.(You have to use the loop)
7. After opening the Product Page verify the Product Name which is visible in the Product page was the same present in the Inventory Page.
8. Add that Product to Cart and verify in the Cart Icon the number of Product is equal to “1”.
9. Go to Cart Page and click on Check Out Button.
10. Check-out-step-one page will be opened. Fill the First name , Last name and ZIP code then continue.
11. Then the Check-out-step-two page will be opened. Fetch the Total Price and print in the console. (Print without “$”)
12. Click and Continue Button so the Check-out-complete page will be opened. Verify “Thank you for your order !” is visible.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class MockTask
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new FirefoxDriver();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.saucedemo.com/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//input[@id='user-name']"))
                    .sendKeys("standard_user");

            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.xpath("//input[@id='login-button']"))
                    .click();

            if (driver.getCurrentUrl().contains("inventory.html"))
            {
                System.out.println("The Inventory Page is opened");

                List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));

                System.out.println("The Count of the Products --> "+allProducts.size());

                for(WebElement product : allProducts)
                {
                    String productName= product.findElement(By.xpath(".//descendant::div[normalize-space(@class)='inventory_item_name']")).getText();
                    String productPrice = product.findElement(By.xpath(".//descendant::div[normalize-space(@class)='inventory_item_price']")).getText();

                    System.out.println("Product name --> "+productName+" | Product price --> "+productPrice);
                }

                Thread.sleep(2000);

                String desiredProductName=null ;

                for(int i=0;i<=allProducts.size();i++)
                {
                    if (i==3)
                    {
                        WebElement desiredProduct = allProducts.get(i).findElement(By.xpath("descendant::div[normalize-space(@class)='inventory_item_name']"));
                        desiredProductName = desiredProduct.getText();
                        desiredProduct.click();
                        break;
                    }
                }

                if (driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText().equals(desiredProductName))
                {
                    System.out.println("The Prouct name is same in Inventory Page as well as Product Page");
                }

                driver.findElement(By.xpath("//button[@data-test='add-to-cart']"))
                        .click();

                String actualProductCount = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/descendant::span")).getText();

                if (actualProductCount.equals("1"))
                {
                    System.out.println("The Product count is equals to 1");
                }

                driver.findElement(By.xpath("//div[@id='shopping_cart_container']"))
                        .click();

                driver.findElement(By.xpath("//button[@id='checkout']"))
                        .click();

                driver.findElement(By.xpath("//input[@aria-label='First Name']"))
                        .sendKeys("FirstName");

                driver.findElement(By.xpath("//input[@aria-label='Last Name']"))
                        .sendKeys("LastName");

                driver.findElement(By.xpath("//input[@aria-label='Zip/Postal Code']"))
                        .sendKeys("998877");

                driver.findElement(By.xpath("//input[@name='continue']"))
                        .click();

                String desiredProductPrice = driver.findElement(By.xpath("//div[@data-test='total-label']"))
                        .getText().substring(8);

                System.out.println("DesiredProduct Price --> "+desiredProductPrice);


                driver.findElement(By.xpath("//button[@id='finish']"))
                        .click();

                if (driver.findElement(By.xpath("//h2[@data-test='complete-header']")).isDisplayed())
                {
                    System.out.println("The \"Thank you for your Order\" is displayed");
                }

            }
            else
            {
                System.out.println("The Inventory Page is not opened");
            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
