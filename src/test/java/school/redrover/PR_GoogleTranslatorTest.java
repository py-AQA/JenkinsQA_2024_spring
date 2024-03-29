package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PR_GoogleTranslatorTest {

    @Test
    public void googleTranslatorTest() throws InterruptedException {

        WebDriver drv = new ChromeDriver();
        drv.get("https://translate.google.com/");

        Thread.sleep(2000);

        WebElement textField = drv.findElement(By.className("er8xn"));
        textField.sendKeys("Hello World");

        Thread.sleep(2000);

        WebElement translationFieldText = drv.findElement(By.
                xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div" +
                        "[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[2]/div/div[6]/div/div[1]/span[1]/span/span"));

        Assert.assertEquals(translationFieldText.getText(), "Привет, мир");

        drv.quit();
    }
}
