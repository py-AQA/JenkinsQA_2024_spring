package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaDemoFirstTest {

    @Test
    public void findElementElement() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        String titleMain = driver.getTitle();
        Assert.assertEquals(titleMain, "DEMOQA");

        WebElement firstLabelElement = driver.findElement(By.cssSelector("div.card:first-child"));
        firstLabelElement.click();

        String titleMainElements = driver.getTitle();
        Assert.assertEquals(titleMainElements, "DEMOQA");

        driver.quit();

    }

}
