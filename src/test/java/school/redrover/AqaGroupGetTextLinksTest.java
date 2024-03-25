package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AqaGroupGetTextLinksTest {
    @Test
    public void GetTextLinksTest2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/links");
        driver.findElement(By.id("no-content")).click();
        //Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.id("linkResponse")).getText(), "Link has responded with staus 204 and status text No Content", "wrong answer");

        driver.quit();
    }
}
