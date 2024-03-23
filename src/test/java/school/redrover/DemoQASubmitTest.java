package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQASubmitTest {
    @Test
    public void testPracticeForm() {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement textName = driver.findElement(By.id("firstName"));
        textName.sendKeys("Anastasia");

        WebElement textLastName = driver.findElement(By.id("lastName"));
        textLastName.sendKeys("Belugina");

        WebElement radioButton = driver.findElement(By.xpath("//label[text()='Female']"));
        radioButton.click();

        WebElement textMobile = driver.findElement(By.id("userNumber"));
        textMobile.sendKeys("1234567890");

        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();

        WebElement result = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String resultText = result.getText();

        Assert.assertEquals("Thanks for submitting the form", resultText);

        driver.quit();
    }
}
