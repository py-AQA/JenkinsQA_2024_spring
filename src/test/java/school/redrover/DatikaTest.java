package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatikaTest {
    @Test
    public void testTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://datika.me/ru/");

        WebElement textBox = driver.findElement(By.id("search"));
        textBox.sendKeys("Акция");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/form/button"));
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"page-content\"]/h1"));
        String value = message.getText();

        Assert.assertEquals(value, "По запросу «Акция»");

        driver.quit();
    }
}
