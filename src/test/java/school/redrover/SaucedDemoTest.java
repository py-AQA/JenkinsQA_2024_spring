package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedDemoTest {
    private final String STANDARD_USER_LOGIN = "standard_user";
    private final String STANDARD_USER_PASSWORD = "secret_sauce";
    private final String EXPECTED_TEXT = "Sauce Labs Backpack";

    @Test
    public void testCheckingAddingCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement userPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.sendKeys(STANDARD_USER_LOGIN);
        userPassword.sendKeys(STANDARD_USER_PASSWORD);
        loginButton.click();
        WebElement addCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addCartButton.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
        WebElement cartList = driver.findElement(By.id("item_4_title_link"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Assert.assertEquals(cartList.getText(), EXPECTED_TEXT);
        driver.quit();
    }
}
