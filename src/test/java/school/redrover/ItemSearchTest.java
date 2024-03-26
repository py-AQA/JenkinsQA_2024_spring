package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ItemSearchTest {
    @Test
    public void testItemSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.applebees.com/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement menuButton = driver.findElement(By.xpath("//ul/li/a[@href='/en/menu'][1]"));
        menuButton.click();

        WebElement searchMenu = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-text']"));
        searchMenu.click();

        WebElement textBox = driver.findElement(By.xpath("//input[contains(@class,'menu-search')]"));
        textBox.sendKeys("salmon");

        WebElement massage = driver.findElement(By.xpath("//a[@href='/en/menu/seafood/blackened-cajun-salmon']"));
        String value = massage.getText();
        Assert.assertEquals("Blackened Cajun Salmon", value);

        driver.quit();
    }
}

