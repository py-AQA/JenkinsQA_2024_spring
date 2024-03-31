package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SwagLabsShopTest {
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.findElement(By.className("app_logo")).getText(), "Swag Labs");

        driver.quit();
    }

    @Test
    public void addToCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//a[@id='item_3_title_link']/div[@class = 'inventory_item_name']")).getText(), "Test.allTheThings() T-Shirt (Red)");

        driver.quit();
    }

    @Test
    public void removeFromCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());
        Assert.assertTrue(driver.findElements(By.className("cart_item")).isEmpty());

        driver.quit();
    }
}
