package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}


