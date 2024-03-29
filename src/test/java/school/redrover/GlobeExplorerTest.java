package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition; // Правильный импорт
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GlobeExplorerTest {

    @Test
    public void CoreTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://explorer.globe.engineer/");

        wait.until((ExpectedCondition<Boolean>) webDriver ->
                ((org.openqa.selenium.JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement textBox = driver.findElement(By.name("q"));
        String placeholder = driver.findElement(By.name("q")).getAttribute("placeholder");

        Assert.assertEquals(placeholder, "I want to discover...");
        textBox.sendKeys("IT");
        textBox.sendKeys(Keys.ENTER);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IT\"]")));

        driver.quit();
    }
}
