package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaHashGroupTest {

    @Test
    public void mainPafeTitleTest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://www.saucedemo.com");

        WebElement loginField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        loginField.sendKeys("standard_user");
        passField.sendKeys("secret_sauce");
        submitButton.click();

        String expectedTitle = "Swag Labs";

        String actualTitle = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();

        Assert.assertEquals(actualTitle,expectedTitle);

        driver.quit();
    }
}
