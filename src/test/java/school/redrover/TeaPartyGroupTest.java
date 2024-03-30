package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeaPartyGroupTest {

    @Test
    public void ivansTest() {

    }
    @Test
    public void testTest (){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement textBox = driver.findElement(By.id("user-name"));
        textBox.sendKeys("visual_user");

        WebElement textBox2 = driver.findElement(By.id("password"));
        textBox2.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        button.getText();

//        WebElement menu = driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]"));
//        String result = menu.;
        Assert.assertEquals(button,"Swag Labs");

        driver.quit();
    }


}
