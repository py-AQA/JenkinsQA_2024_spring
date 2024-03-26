package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTest {

    private final static String URL = "https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";

    @Test
    public void testSearchWord() throws InterruptedException {

        String expectedResult = "Абракадабра";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Абракадабра");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        Thread.sleep(2000);

        String value = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();

        Assert.assertEquals(value, expectedResult);

        driver.quit();
    }

}
