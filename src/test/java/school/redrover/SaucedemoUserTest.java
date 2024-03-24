package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoUserTest {

    @Test
    public void testStandartUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://www.saucedemo.com/");

        WebElement textUserName = driver.findElement(By.id("user-name"));
        String userName = "standard_user";
        textUserName.sendKeys(userName);

        WebElement textPassword = driver.findElement(By.id("password"));
        textPassword.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        Thread.sleep(1000);
        WebElement img1 = driver.findElement(By.xpath("//img[@src='/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg']"));
        boolean result1 = img1.isDisplayed();
        Assert.assertTrue(result1);

        WebElement img2 = driver.findElement(By.xpath("//img[@src='/static/media/bike-light-1200x1500.37c843b0.jpg']"));
        boolean result2 = img2.isDisplayed();
        Assert.assertTrue(result2);

        driver.quit();
    }

    @Test
    public void testLockedOutUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement textUserName = driver.findElement(By.id("user-name"));
        String userName = "locked_out_user";
        textUserName.sendKeys(userName);

        WebElement textPassword = driver.findElement(By.id("password"));
        textPassword.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        WebElement link = driver.findElement(By.cssSelector("h3"));
        String resultText = link.getText();

        Assert.assertEquals(resultText, "Epic sadface: Sorry, this user has been locked out.");

        driver.quit();
    }

    @Test
    public void testProblemUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement textUserName = driver.findElement(By.id("user-name"));
        String userName = "problem_user";
        textUserName.sendKeys(userName);

        WebElement textPassword = driver.findElement(By.id("password"));
        textPassword.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        Thread.sleep(1000);
        WebElement img1 = driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']"));
        boolean result1 = img1.isDisplayed();
        Assert.assertTrue(result1);

        WebElement img2 = driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']"));
        boolean result2 = img2.isDisplayed();
        Assert.assertTrue(result2);

        driver.quit();
    }
}
