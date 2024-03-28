package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaPracticeTest {
    @Test
    public void purchaseItemTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-practice.netlify.app");

        driver.findElement( By.id("products-list") ).click();
        driver.findElement(By.xpath("//div[@class='shop-item-details']/button")).click();
        driver.findElement(By.xpath("//button[text()='PURCHASE']")).click();
        String value = driver.findElement(By.id("message")).getText();

        Assert.assertEquals(value, "Congrats! Your order of $905.99 has been registered!");

        driver.quit();
    }
}
