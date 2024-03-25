package school.redrover;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Nyc311GetTitleTest {

        @Test
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            String baseUrl = "https://portal.311.nyc.gov/";
            String expectedResult = "Home &nbsp;· NYC311";
            String actualTitleResult = " ";

            driver.get(baseUrl);
            driver.getTitle();

            Assert.assertEquals(actualTitleResult, expectedResult);

            driver.quit();
        }
    }

