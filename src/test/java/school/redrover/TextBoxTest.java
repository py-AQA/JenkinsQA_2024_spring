package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest {
    @Test
    public void testTextBox() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.findElement(By.cssSelector(".card:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".btn-light:nth-child(1)")).click();

        driver.findElement(By.id("userName")).sendKeys("Lilia");
        driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");

        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();

        Thread.sleep(1000);

        driver.findElement(By.className("text-right")).click();

        Assert.assertEquals(driver.findElement(By.id("name")).getText(), "Name:Lilia");
        Assert.assertEquals(driver.findElement(By.id("email")).getText(), "Email:test@gmail.com");

        driver.quit();

    }
}
