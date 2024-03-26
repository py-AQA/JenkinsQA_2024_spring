package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TheInternetTest {
    @Test
    public void loginPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");

        WebElement linkToLoginPage = driver.findElement(By.linkText("Form Authentication"));
        linkToLoginPage.click();

        WebElement inputLogin = driver.findElement(By.id("username"));
        inputLogin.sendKeys("tomsmith");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        loginButton.click();

        WebElement loggedIn = driver.findElement(By.tagName("h2"));
        String message = loggedIn.getText();
        Assert.assertEquals(message, "Secure Area");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

        WebElement loggedOut = driver.findElement(By.tagName("h2"));
        String messageLogOut = loggedOut.getText();
        Assert.assertEquals(messageLogOut, "Login Page");

        driver.quit();

    }
}
