package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyLoginTest {
        @Test

        public void testTest() {

            WebDriver driver = new ChromeDriver();
            driver.get("https://practice.expandtesting.com/login");

            driver.findElement(By.id("username")).sendKeys("practice");
            driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]")).click();

            String actual = driver.findElement(By.id("flash")).getText();
            Assert.assertEquals(actual, "You logged into a secure area!");

            driver.quit();
        }
    }
