package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CrazyTestersTest {

    @Test
    public void testDragAndDrop() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        new Actions(driver)
                .dragAndDrop(columnA, columnB)
                .perform();

        Assert.assertEquals(columnB.getText(), "A");

        driver.quit();
    }
}
