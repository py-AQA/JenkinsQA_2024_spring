package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest {

    @Test

    public void testLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("student");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));

        submitButton.click();

        WebElement result = driver.findElement(By.xpath("//h1"));
        String resultText = result.getText();
        Assert.assertEquals("Logged In Successfully", resultText);

        driver.quit();



    }

}



