package school.redrover;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GtFirstTest {
    private WebDriver driver;
    private String baseUrl = "https://en.wikipedia.org/wiki/Wikipedia";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testArticleTitle() {
        // Find Page Title
        WebElement articleTitleElement = driver.findElement(By.className("mw-page-title-main"));
        String articleTitle = articleTitleElement.getText();

        // Expected Article Name
        String expectedTitle = "Wikipedia";

        // Check that page title equals
        Assert.assertEquals(articleTitle, expectedTitle, "Page title does not equals to the expected title");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}