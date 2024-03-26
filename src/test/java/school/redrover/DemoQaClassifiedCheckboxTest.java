package school.redrover;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DemoQaClassifiedCheckboxTest {

    @Test
    public void testClassified(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com");

        WebElement elementsPage = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsPage.click();

        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();

        WebElement expandButton = driver.findElement(By.className("rct-option-expand-all"));
        expandButton.click();

        WebElement classifiedCheckbox = driver.findElement(By.xpath("//label[@for='tree-node-classified']"));
        classifiedCheckbox.click();

        WebElement result = driver.findElement(By.id("result"));
        String value = result.getText();

        Assert.assertEquals(value,"You have selected :\n" + "classified");

        driver.quit();
    }
}
