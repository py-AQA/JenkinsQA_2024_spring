package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

public class ByteBustersGroupTest extends BaseTest {

        @Test
        public void CoreTest() {

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            getDriver().get("https://explorer.globe.engineer/");

            wait.until((ExpectedCondition<Boolean>) webDriver ->
                    ((org.openqa.selenium.JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            WebElement textBox = getDriver().findElement(By.name("q"));
            String placeholder = getDriver().findElement(By.name("q")).getAttribute("placeholder");

            Assert.assertEquals(placeholder, "I want to discover...");
            textBox.sendKeys("IT");
            textBox.sendKeys(Keys.ENTER);

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IT\"]")));

        }
    }
