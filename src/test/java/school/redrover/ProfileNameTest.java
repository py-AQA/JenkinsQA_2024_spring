package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileNameTest {

    @Test
    public static void testPraktikum() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/signin");

        WebElement eMail = driver.findElement(By.id("email"));
        eMail.sendKeys("wovibic859@mnsaf.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");

        WebElement LoginEnter = driver.findElement(By.className("auth-form__button"));
        LoginEnter.click();
        Thread.sleep(3000);

        WebElement accountName = driver.findElement(By.className("profile__title"));
        accountName.getText();
        Assert.assertEquals(accountName.getText(), "Жак-Ив Кусто");
        driver.quit();
    }

}
