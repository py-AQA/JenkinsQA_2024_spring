package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NikeTest {
    @Test
    public void testTest3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/es/");

        WebElement username = driver.findElement(By.id("VisualSearchInput"));
        username.sendKeys("Jordan");

        WebElement submitButton2 = driver.findElement(By.xpath("//button[@*='Buscar']"));
        submitButton2.click();

        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(pageUrl, "https://www.nike.com/es/w?q=Jordan&vst=Jordan");

        driver.quit();
    }
}
