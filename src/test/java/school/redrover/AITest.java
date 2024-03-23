package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AITest {
    private WebDriver webDriver;

    @BeforeTest
    public void initWebDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterTest
    public void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    void testFields() {

        String fullName = "Ali Ian";
        webDriver.get("https://letcode.in/test");
        webDriver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
        webDriver.findElement(By.id("fullName")).sendKeys(fullName);
        webDriver.findElement(By.id("join")).sendKeys(" and happy \t");
        webDriver.findElement(By.id("clearMe")).clear();

        boolean isDisabled = webDriver.findElement(By.id("noEdit")).isDisplayed();
        Assert.assertTrue(isDisabled);


    }
}
