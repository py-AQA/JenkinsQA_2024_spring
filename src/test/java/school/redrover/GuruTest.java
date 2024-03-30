package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class GuruTest {
    @Test
    public void FormTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://demo.guru99.com/test/login.html");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abcd@gmail.com");

        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("abcdefghlkjl");

        WebElement login = driver.findElement(By.id("SubmitLogin"));
        login.click();

        driver.quit();
    }
}
