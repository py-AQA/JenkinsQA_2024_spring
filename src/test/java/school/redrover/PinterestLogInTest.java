package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertTrue;


public class PinterestLogInTest extends BaseTest {

    @Test
    public void testMyPinterest() {
        WebDriver driver = getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.pinterest.com/");

        String title = driver.getTitle();
        Assert.assertEquals("Pinterest", title);

        WebElement buttonLogIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Log in')]")));
        buttonLogIn.click();

        WebElement userEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        userEmailInput.sendKeys("ii8281294@gmail.com");

        WebElement userPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        userPasswordInput.sendKeys("test2024!");

        WebElement buttonSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        buttonSubmit.click();

        WebElement homeWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));

        assertTrue(homeWebElement.isDisplayed());
        assertTrue(homeWebElement.isEnabled());
    }
}

