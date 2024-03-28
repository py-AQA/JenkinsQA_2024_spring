package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceTest {

    @Test
    public void testSite() {

        WebDriver drive = new ChromeDriver();
        drive.get("https://www.saucedemo.com/");

        String title = drive.getTitle();
        Assert.assertEquals("Swag Labs", title);

        drive.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement userName = drive.findElement(By.id("user-name"));
        userName.sendKeys("visual_user");

        WebElement passw = drive.findElement(By.id("password"));
        passw.sendKeys("secret_sauce");

        WebElement submitButton = drive.findElement(By.name("login-button"));
        submitButton.click();

        WebElement page = drive.findElement(By.className("title"));
        String value = page.getText();

        Assert.assertEquals("Products", value);

        drive.quit();
    }

}
