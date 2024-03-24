package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauseTest {
    @Test
    public void testSauceDemo() {
        int expectedResult = 6;
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        List<WebElement> listProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualResult = listProducts.size();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}

