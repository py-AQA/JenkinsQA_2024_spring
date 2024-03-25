import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTheInternetHerokuapp {
    @Test
    public void testPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        WebElement link = driver.findElement(By.linkText("Add/Remove Elements"));
        link.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        submitButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        deleteButton.click();

        driver.quit();
    }

}
