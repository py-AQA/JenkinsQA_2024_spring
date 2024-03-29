package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaygroundTest {
    @Test
    public void testSubmitOrder(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://play1.automationcamp.ir/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h5[contains(text(), 'Sample Pages')]")));

        driver.findElement(By.xpath("//h5[contains(text(), 'Sample Pages')]/parent::div/following-sibling::div//a")).click();

        WebElement user = driver.findElement(By.xpath("//input[@id='user']"));
        user.click();
        user.clear();
        user.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.click();
        password.clear();
        password.sendKeys("admin");

        driver.findElement(By.xpath("//button[@id='login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Dinesh's Pizza House");

        driver.quit();
    }
}
