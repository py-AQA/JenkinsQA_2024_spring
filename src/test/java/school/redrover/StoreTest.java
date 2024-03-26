package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTest {

    @Test
    public void testFindItem() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");

        WebElement laptopMenu = driver.findElement(By.xpath("//a[text() = 'Laptops']"));
        laptopMenu.click();

        Thread.sleep(1500);

        WebElement item = driver.findElement(By.xpath("//h4[@class = 'card-title']/a[@href = 'prod.html?idp_=11']"));
        String value = item.getText();
        Assert.assertEquals(value, "MacBook air");

        driver.quit();
    }
}
