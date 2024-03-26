package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LegionOfJavaGroupTest {

    @Test
    public void testFerosorSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://ferosor.cl");
            Thread.sleep(1000);
            WebElement textBox = driver.findElement(By.name("s"));
            textBox.sendKeys("alimento");
            driver.findElement(By.cssSelector("[type='submit']")).click();
            Thread.sleep(1000);
            driver.get("https://ferosor.cl/jardin-y-mascotas/262-alimento-para-perro-cachorro-fit-formula-saco-10-kg-130622000123.html");
            String result = String.valueOf(driver.findElement(By.className("h1")).getText());
            Assert.assertEquals(result, "Alimento para Perro cachorro FIT FORMULA Saco 10 kg");
        } finally {
            driver.quit();
        }
    }

}
