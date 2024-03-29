package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Kg312 {

    @Test

    public void testKg312(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://312.kg/");

        WebElement buttonBlog = driver.findElement(By.linkText("Знаете ли Вы?"));
        buttonBlog.click();


        WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/h1"));
        String value = text.getText();

        Assert.assertEquals("Блог", value);

        driver.quit();

    }

}
