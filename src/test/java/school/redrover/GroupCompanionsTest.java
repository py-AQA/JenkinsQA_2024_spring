package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupCompanionsTest extends BaseTest {
    @Test
    public void testExp86() {
        WebDriver driver = getDriver();
        driver.get("https://exp86.ru/");

        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Hello world!");

//        How find element "Личный кабинет"
        WebElement registrationHrev = driver.findElement(By.linkText("Личный кабинет"));
        registrationHrev.click();

        WebElement text = driver.findElement(By.className("form_default_star"));
        String value = text.getText();

        Assert.assertEquals("* обязательные поля для заполнения", value);
    }

    @Test
    public void Firsttest() throws InterruptedException {

        WebDriver driver = getDriver();
        driver.get("https://exp86.ru");

        Thread.sleep(1000); //добавила для себя, чтобы было видно на тесте

        WebElement test = driver.findElement(By.xpath("//input[@type='text']"));
        test.sendKeys("Привет, мир!");

        WebElement buttonSearch = driver.findElement(By.name("Поиск"));
        buttonSearch.click();

        Thread.sleep(1000);

        WebElement button = driver.findElement(By.xpath("//a[@href='/user/']"));
        button.click();

        WebElement string = driver.findElement(By.className("form_default_star"));
        String result = string.getText();

        Assert.assertEquals("* обязательные поля для заполнения", result);
    }

}
