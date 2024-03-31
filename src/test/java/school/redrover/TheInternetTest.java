package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class TheInternetTest extends BaseTest {
    @Test
    public void loginPage() {
        WebDriver driver = getDriver();
        driver.get("https://the-internet.herokuapp.com/");

//        String title = driver.getTitle();

        Assert.assertEquals(driver.getTitle(), "The Internet");

        driver.findElement(By.linkText("Form Authentication")).click();

//        WebElement linkToLoginPage = driver.findElement(By.linkText("Form Authentication"));
//        linkToLoginPage.click();

        driver.findElement(By.id("username")).sendKeys("tomsmith");

//        WebElement inputLogin = driver.findElement(By.id("username"));
//        inputLogin.sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button")).click();

//        WebElement loginButton = driver.findElement(By.cssSelector("button"));
//        loginButton.click();

//        driver.findElement(By.tagName("h2")).getText();

//        WebElement loggedIn = driver.findElement(By.tagName("h2"));
//        String message = loggedIn.getText();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Secure Area");

        driver.findElement(By.linkText("Logout")).click();

//        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
//        logoutButton.click();

        driver.findElement(By.tagName("h2")).getText();

//        WebElement loggedOut = driver.findElement(By.tagName("h2"));
//        String messageLogOut = loggedOut.getText();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Login Page");
    }
}
