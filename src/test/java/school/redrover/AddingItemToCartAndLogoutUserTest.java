package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingItemToCartAndLogoutUserTest {

    @Test
    public void testAddingItemToCart() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement labsBikeProduct = driver.findElement(By.id("item_0_title_link"));
        labsBikeProduct.click();

        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addButton.click();

        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();

        WebElement labsBikeText = driver.findElement(By.id("item_0_title_link"));
        String resultText = labsBikeText.getText();

        Assert.assertEquals(resultText, "Sauce Labs Bike Light");

        driver.quit();
    }

    @Test
    public void testLogoutUser() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("visual_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerButton.click();

        Thread.sleep(1000);

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();

        String textTitle = driver.getTitle();
        Assert.assertEquals(textTitle, "Swag Labs");

        driver.quit();
    }
}
