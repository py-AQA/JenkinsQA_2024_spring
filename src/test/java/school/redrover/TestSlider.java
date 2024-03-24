package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class TestSlider {
    @Test
    public void TestSlider() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");


        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/input"));
        WebElement text = driver.findElement(By.xpath("//*[@id='range']"));


        Actions actions = new Actions(driver);

        double expectedValue = 0;
        Assert.assertEquals(Double.parseDouble(text.getText()), expectedValue);
        final double step = 0.5;
        for (int i = 0; i < 10; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
            expectedValue += step;
            Assert.assertEquals(Double.parseDouble(text.getText()), expectedValue);
        }
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals(Double.parseDouble(text.getText()), expectedValue);
            slider.sendKeys(Keys.ARROW_LEFT);
            expectedValue -= step;
        }

        driver.quit();

    }

    @Test
    public void testHorizontalSliderMovedByMouse() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicElement = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        xpath("//a [@href='/horizontal_slider']")));

        WebElement linkToHorizontalSliderPage = driver.findElement(xpath("//a [@href='/horizontal_slider']"));
        linkToHorizontalSliderPage.click();

        String expectedResult = "1";

        int x = driver.findElement(By.xpath("//input [@type='range']")).getLocation().getX() + 2;
        int y = driver.findElement(By.xpath("//input [@type='range']")).getLocation().getY();
        int width = driver.findElement(xpath("//input [@type='range']")).getSize().width;
        double getStepValue = Double.parseDouble(driver.findElement
                (xpath("//input [@type='range']")).getAttribute("step"));
        double getMaxValue = Double.parseDouble(driver.findElement
                (xpath("//input [@type='range']")).getAttribute("max"));
        int getOffset = (int) (width / (getMaxValue / getStepValue));

        int stepsQtt;

        if (expectedResult.contains(".")) {
            stepsQtt = (int) (Double.parseDouble(expectedResult) * 2);
        } else {
            stepsQtt = Integer.parseInt(expectedResult) * 2;
        }

        Actions mouse = new Actions(driver);

        for (int i = 0; i < stepsQtt; i++) {
            mouse.moveToLocation(x, y)
                    .clickAndHold()
                    .moveByOffset(getOffset, 0)
                    .release()
                    .perform();
            x += getOffset;
        }

        String actualResult = driver.findElement(xpath("//span [@id='range']")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}


