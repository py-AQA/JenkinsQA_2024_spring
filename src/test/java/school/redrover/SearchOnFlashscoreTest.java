package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchOnFlashscoreTest {
    @Test
    public void testFlashscore() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flashscore.ua/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.findElement(By.id("search-window"))
                .click();

        driver.findElement(By.cssSelector("input"))
                .sendKeys("aaaaaaaaa");

        Assert.assertEquals(driver
                .findElement(By.className("searchResults__noResult"))
                .getText(), "За Вашим запитом нічого не знайдено.");

        driver.quit();
    }
}
