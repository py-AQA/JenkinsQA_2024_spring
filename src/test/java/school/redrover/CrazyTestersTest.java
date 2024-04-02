package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

public class CrazyTestersTest extends BaseTest {

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

    @Test
    public void testTest3() {
        WebDriver driver = getDriver();
        driver.get("https://www.nike.com/es/");

        WebElement username = driver.findElement(By.id("VisualSearchInput"));
        username.sendKeys("Jordan");

        WebElement submitButton2 = driver.findElement(By.xpath("//button[@*='Buscar']"));
        submitButton2.click();

        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(pageUrl, "https://www.nike.com/es/w?q=Jordan&vst=Jordan");
    }

    public void testTest2() {
        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Swag Labs");
    }
}
