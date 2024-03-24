package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DoradoMainHw15Test {

    @Test
    public void testAskomdch() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://askomdch.com/");
        driver.findElement(By.id("menu-item-1229")).click();

        WebElement search = driver.findElement(By.id("woocommerce-product-search-field-0"));
        search.sendKeys("jeans");

        search.sendKeys(Keys.RETURN);

        driver.quit();
    }
}
