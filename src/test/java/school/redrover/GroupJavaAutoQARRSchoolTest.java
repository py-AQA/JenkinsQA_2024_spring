package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupJavaAutoQARRSchoolTest extends BaseTest {

    @Test
    public void testReturnToHomePageFromInventoryDetailsCard() {

        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        WebElement inventoryName = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bike Light']"));
        inventoryName.click();

        WebElement backToProductBtn = driver.findElement(By.xpath("//button[@id = 'back-to-products']"));
        backToProductBtn.click();

        WebElement headerProductsOnTheHomePage = driver.findElement(By.xpath("//span[text() = 'Products']"));
        String value = headerProductsOnTheHomePage.getText();

        Assert.assertEquals(value, "Products");
    }
    @Test
    public void addGiftCardToCart() {
        WebDriver driver = getDriver();
        String recipientName = "Very Good Person";
        String senderName = "Very Generous Person";

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[7]/a")).click();
        driver.findElement(By.linkText("$100 Physical Gift Card")).click();
        driver.findElement(By.className("recipient-name")).sendKeys(recipientName);
        driver.findElement(By.className("sender-name")).sendKeys(senderName);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-4\"]")).click();
        driver.findElement(By.cssSelector("#topcartlink > a")).click();

        String productName = driver.findElement(By.className("product-name")).getText();
        String price = driver.findElement(By.className("unit-price")).getText();

        Assert.assertEquals(productName, "$100 Physical Gift Card");
        Assert.assertEquals(price, "100.00");
    }
}
