package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceholderTest {
    @Test
    public void PlaceholderFillTest(){
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        WebElement textBoxUser = driver.findElement(By.name("user-name"));
        textBoxUser.sendKeys("standard_user");
        WebElement textBoxPass = driver.findElement(By.id("password"));
        textBoxPass.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.id("login-button"));

        submitButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

        driver.quit();
    }
}
