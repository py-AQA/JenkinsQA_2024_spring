package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATest {
    @Test
    public void tetTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        String title = driver.getTitle();
        Assert.assertEquals(title, "DEMOQA");

        String name = "Ivan";
        String email = "ivan@gmail.com";
        String currentAddress = "1000000, Moscow, Nagatinskaya st., 2";
        String permanentAddress = "1000000, Moscow, Nagatinskaya st., 2";

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement inputUserName = driver.findElement(By.cssSelector("input#userName"));
        inputUserName.sendKeys(name);
        WebElement inputUserEmail = driver.findElement(By.cssSelector("input#userEmail"));
        inputUserEmail.sendKeys(email);
        WebElement inputCurrentAddress = driver.findElement(By.cssSelector("textarea#currentAddress"));
        inputCurrentAddress.sendKeys(currentAddress);
        WebElement inputPermanentAddress = driver.findElement(By.cssSelector("textarea#permanentAddress"));
        inputPermanentAddress.sendKeys(permanentAddress);

        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();

        WebElement getName = driver.findElement(By.cssSelector("p#name"));
        WebElement getEmail = driver.findElement(By.cssSelector("p#email"));
        WebElement getCurrentAddress = driver.findElement(By.cssSelector("p#currentAddress"));
        WebElement getPermanentAddress = driver.findElement(By.cssSelector("p#permanentAddress"));
        Assert.assertEquals(getName.getText(), "Name:"+name);
        Assert.assertEquals(getEmail.getText(), "Email:"+email);
        Assert.assertEquals(getCurrentAddress.getText(), "Current Address :"+currentAddress);
        Assert.assertEquals(getPermanentAddress.getText(), "Permananet Address :"+permanentAddress);
        driver.quit();

    }
}
