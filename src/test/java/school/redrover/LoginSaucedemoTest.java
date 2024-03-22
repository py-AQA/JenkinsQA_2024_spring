package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSaucedemoTest {
   @Test
    public void testLoginSaucedemo () {
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.saucedemo.com/");

       driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
       driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
       driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

       String actual = driver.findElement(By.xpath("//span[@class='title']")).getText();

       Assert.assertEquals(actual, "Products");

       driver.quit();
   }

}
