package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class AqaGroupUitestingplaygroundTest {
    public void testClientSideDelay() {
        String link = "http://uitestingplayground.com/clientdelay";
        WebDriver driver = new ChromeDriver();

        try {
            driver.get(link);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("ajaxButton"))).click();

            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bg-success")));

            Assert.assertTrue(label.getText().startsWith("Data calculated"), "Label text wrong");
        } finally {
            driver.quit();
        }
    }
}
