package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupCarlthefogTest {

    @Test
    public void testSaucedemo() {
        String expectedPageName = "Swag Labs";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualPageName = driver.findElement(By.xpath("//div[@class= 'app_logo']")).getText();

        Assert.assertEquals(expectedPageName, actualPageName);
        driver.quit();
    }

    @Test
    public void testPageHeader() {
        String expectedPageHeader1 = "99 Bottles of Beer";
        String expectedPageHeader2 = "Welcome to 99 Bottles of Beer";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.99-bottles-of-beer.net/");

        String actualPageHeader1 = driver.findElement(By.xpath("//h1")).getText();
        String actualPageHeader2 = driver.findElement(By.xpath("//div[@id='main']//h2")).getText();

        Assert.assertEquals(expectedPageHeader1, actualPageHeader1);
        Assert.assertEquals(expectedPageHeader2, actualPageHeader2);

        driver.quit();
    }

    @Test
    public void testElementsList() {
        int expectedElementsQuantity = 6;
        List<String> expectedElementsHeader = new ArrayList<>(Arrays.asList(
                "Elements",
                "Forms",
                "Alerts, Frame & Windows",
                "Widgets",
                "Interactions",
                "Book Store Application"));

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        int actualElementsQuantity = driver.findElements(By.xpath("//div[@class='card-body']")).size();

        List<WebElement> elementsHeaderList = driver.findElements(By.xpath("//div[@class='card-body']"));
        List<String> actualElementsHeader = WebElementsToString(elementsHeaderList);

        Assert.assertEquals(expectedElementsQuantity, actualElementsQuantity);
        Assert.assertEquals(expectedElementsHeader,actualElementsHeader);

        driver.quit();
    }

    public static List<String> WebElementsToString(List<WebElement> elementsHeaderList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementsHeaderList) {
            stringList.add(element.getText());
        }

        return stringList;
    }
}
