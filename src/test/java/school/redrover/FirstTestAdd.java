package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestAdd {

    @Test

    public void testComputers (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://computer-database.gatling.io/computers");

        WebElement addButton = driver.findElement(By.id("add"));
        addButton.click();
        WebElement computerName = driver.findElement(By.id("name"));
        computerName.sendKeys("macbook");
        WebElement Introduced = driver.findElement(By.id("introduced"));
        Introduced.sendKeys("2022-01-23");
        WebElement submitButton = driver.findElement(By.className("btn"));
        submitButton.click();

        driver.quit();
    }

}
