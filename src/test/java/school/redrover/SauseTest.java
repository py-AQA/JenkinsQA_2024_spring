package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SauseTest {

    WebDriver driver = new ChromeDriver();
    private final String SITE = "https://www.saucedemo.com/";
    private final String LOGIN_FIELD = "//input[@id='user-name']";
    private final String PASSWORD_FIELD = "//input[@id='password']";
    private final String LOGIN_BUTTON = "//input[@id='login-button']";

    private String standartUser;
    private String lockedOutUser;
    private String problemUser;
    private String performanceGlitchUser;
    private String errorUser;
    private String visualUser;
    private String password;

    public void login(String login) {
        driver.get(SITE);
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @BeforeSuite
    public void getCredentials() {
        driver.get(SITE);

        String[] loginsArray = driver
                .findElement(By.xpath("//div[@id='login_credentials']"))
                .getAttribute("innerText")
                .split("\n");

        standartUser = loginsArray[1];
        lockedOutUser = loginsArray[2];
        problemUser = loginsArray[3];
        performanceGlitchUser = loginsArray[4];
        errorUser = loginsArray[5];
        visualUser = loginsArray[6];

        String[] passArray = driver
                .findElement(By.xpath("//div[@class='login_password']"))
                .getAttribute("textContent")
                .split(":");
        password = passArray[1];

    }

    @Test
    public void testStandartUser() {
        int expectedResult = 6;
        driver.get(SITE);

        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(standartUser);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();

        List<WebElement> listProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualResult = listProducts.size();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testlockedOutUser() {
        String expectedResult = "Epic sadface: Sorry, this user has been locked out.";

        login(lockedOutUser);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-message-container error']")).getAttribute("textContent"), expectedResult);
    }

    @Test
    public void testProblemUser() {
        driver.get(SITE);
        login(problemUser);

        WebElement imageSourceList = driver.findElement(By.xpath("//div[@class='inventory_list']/div/div/a/img"));
        String actualResult = imageSourceList.getAttribute("src");
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        WebElement imageSourceItem = driver.findElement(By.xpath("//img[@alt='Sauce Labs Fleece Jacket']"));
        String expectedResult = imageSourceItem.getAttribute("src");

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testErrorUser() throws InterruptedException {
        login(errorUser);

        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
        WebElement removeButton = driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']"));

        Assert.assertEquals(removeButton.getText(), "Remove");
        Thread.sleep(1000);
        removeButton.click();
        Assert.assertEquals(removeButton.getText(), "Remove");
    }

    @Test
    public void testVisualUser() {
        login(visualUser);
        String expectedRes = "Inherit";

        WebElement cssAtribute = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String actualRes = cssAtribute.getCssValue("position");

        Assert.assertEquals(actualRes, expectedRes);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

