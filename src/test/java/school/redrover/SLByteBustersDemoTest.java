package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SLByteBustersDemoTest {
    @Test
    public void testSelenium() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");

        WebElement text = driver.findElement(By.id("sb_form_q"));
        text.sendKeys("Java");
        text.sendKeys(Keys.ENTER);

        Thread.sleep(10000);

        driver.quit();
    }

}
