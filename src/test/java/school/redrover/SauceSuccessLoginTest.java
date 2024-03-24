package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SauceSuccessLoginTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void testLoginSuccess() throws InterruptedException {
        String expectedResult = "https://www.saucedemo.com/inventory.html";

        driver.get("https://www.saucedemo.com/");
        WebElement name = driver.findElement(By.xpath("//input[@id='user-name']"));
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @AfterMethod
    public void quit(){driver.quit();
    }
}