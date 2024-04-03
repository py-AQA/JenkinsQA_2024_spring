package school.redrover.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class VivaTest {
    @Test
    public void testTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://www.yrt.ca/en/schedules-and-maps/viva-routes.aspx");
        WebElement textBox = driver.findElement(By.name("search"));
        textBox.sendKeys("aaabbb");
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"search-box\"]/button"));//find button
        driver.quit();
    }
}
