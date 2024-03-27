package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArSoftTest {

    private final By getPaswordText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text'][contains(.,'Мы отправили по адресу')]");

    @Test
    public void restorePaswordTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("http://23.105.246.172:5000/login");
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        WebElement inputMail = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputMail.sendKeys("n-k-65@list.ru");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();
        Thread.sleep(1000L);

        String getPasError = driver.findElement(getPaswordText).getText();

        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");

        driver.quit();
    }
}
