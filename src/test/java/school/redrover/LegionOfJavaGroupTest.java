package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LegionOfJavaGroupTest {

    @Test
    public void testFerosorSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://ferosor.cl");
            Thread.sleep(1000);
            WebElement textBox = driver.findElement(By.name("s"));
            textBox.sendKeys("alimento");
            driver.findElement(By.cssSelector("[type='submit']")).click();
            Thread.sleep(1000);

        } finally {
            driver.quit();
        }
    }

}
