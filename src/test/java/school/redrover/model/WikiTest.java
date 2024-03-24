package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WikiTest {

    @Test
    public void seleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.id("searchInput"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button"));

        textBox.sendKeys("test");
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("//*[@id='firstHeading']/span"));
        String value = message.getText();
        assertEquals(value, "Test");

        driver.quit();
    }
}
