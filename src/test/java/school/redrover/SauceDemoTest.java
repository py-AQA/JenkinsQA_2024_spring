package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {
    @Test
    public void testLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.id("user-name"));
        WebElement psw = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.id("login-button"));

        login.sendKeys("standard_user");
        psw.sendKeys("secret_sauce");
        signInButton.submit();

        WebElement displayedPage = driver.findElement(By.className("title"));
        String targetText = displayedPage.getText();
        Assert.assertEquals(targetText, "Products");

        driver.quit();
    }
}
