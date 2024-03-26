package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class DemoQACheckboxTest {

    public void testHomeCheckbox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://demoqa.com/checkbox");
        WebElement checkboxHome = driver.findElement(new By.ByCssSelector("[class='rct-icon rct-icon-uncheck']"));
        checkboxHome.click();

        WebElement results = driver.findElement(By.id("result"));
        String textHome = """
                You have selected :
                home
                desktop
                notes
                commands
                documents
                workspace
                react
                angular
                veu
                office
                public
                private
                classified
                general
                downloads
                wordFile
                excelFile""";

        Assert.assertEquals(results.getText(), textHome);

        driver.quit();
    }

}
