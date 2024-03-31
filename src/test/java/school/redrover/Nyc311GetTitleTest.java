package school.redrover;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Nyc311GetTitleTest {

    @Test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://portal.311.nyc.gov/");

        String expectedResult = "Home  · NYC311";
        String actualTitleResult = driver.getTitle();

        System.out.println("Title of the website is: " + actualTitleResult);

        Assert.assertEquals(actualTitleResult, expectedResult);

        driver.quit();
    }
}
