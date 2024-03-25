package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupQaTheBestTest {

    @Test
    public void kmTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationintesting.online");
        // Открываем веб-страницу с помощью метода get
        driver.findElement(By.id("name")).sendKeys("John Doe");
        // Находим элемент на странице по его ID и вводим текст "John Doe"
        driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");
        // Находим элемент на странице по его ID и вводим текст "johndoe@gmail.com"
        driver.findElement(By.id("phone")).sendKeys("12345678900");
        // Находим элемент на странице по его ID и вводим текст "12345678900"
        driver.findElement(By.id("subject")).sendKeys("Test Subject");
        // Находим элемент на странице по его ID и вводим текст "Test Subject"
        driver.findElement(By.id("description")).sendKeys("Hello World Hello World");
        // Находим элемент на странице по его ID и вводим текст "Hello World Hello World"
        driver.findElement(By.id("submitContact")).click();
        // Находим элемент на странице по его ID и кликаем на него для отправки формы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Создаем объект WebDriverWait с таймаутом 5 секунд
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div > div.row.contact > " +
                "div:nth-child(2) > div > h2")));
        // Ждем, пока элемент будет присутствовать на странице с помощью ожидания до наступления условия
        Assert.assertEquals("Thanks for getting in touch John Doe!", driver.findElement(By.cssSelector("#root " +
                "> div > div > div.row.contact > div:nth-child(2) > div > h2")).getText());
        // Проверяем, что текст элемента соответствует ожидаемому тексту
        driver.quit();
        // Закрываем браузер и завершаем сеанс
    }
}
