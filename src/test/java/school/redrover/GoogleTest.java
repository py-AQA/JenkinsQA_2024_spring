package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleTest {
    @Test
    public void testGoogle() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement text = driver.findElement(By.id("APjFqb"));
        text.sendKeys("Selenium");

       Thread.sleep(1000);

        WebElement button = driver.findElement(By.className("gNO89b"));
        button.click();

        WebElement link = driver.findElement(By.xpath("//a[@href = 'https://www.selenium.dev/']/h3"));
        String resultText = link.getText();

        assertEquals(resultText, "Selenium");

        driver.quit();
    }
}
