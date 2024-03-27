package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArMobiTest {

    private final By getPaswordText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text'][contains(.,'Мы отправили по адресу')]");

    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820,1080));
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
    @Test
    public void removePaswordTest() throws InterruptedException {

        driver.get("http://23.105.246.172:5000/login");

        Thread.sleep(1000);

        WebElement inputMail = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputMail.sendKeys("yyyyyyyyyy@mail.xx");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();
        Thread.sleep(1000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");

    }

    @Test
    public void regaTest() throws InterruptedException {

        driver.get("http://23.105.246.172:5000/login");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        WebElement inputMail = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputMail.sendKeys("n-k-65@list.ru");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();
        Thread.sleep(1000);

        String getPasError = driver.findElement(getPaswordText).getText();

        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");

    }
}
