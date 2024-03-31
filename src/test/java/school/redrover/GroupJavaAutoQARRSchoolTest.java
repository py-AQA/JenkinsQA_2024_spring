package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupJavaAutoQARRSchoolTest extends BaseTest {

    @Test
    public void testReturnToHomePageFromInventoryDetailsCard() {

        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        WebElement inventoryName = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bike Light']"));
        inventoryName.click();

        WebElement backToProductBtn = driver.findElement(By.xpath("//button[@id = 'back-to-products']"));
        backToProductBtn.click();

        WebElement headerProductsOnTheHomePage = driver.findElement(By.xpath("//span[text() = 'Products']"));
        String value = headerProductsOnTheHomePage.getText();

        Assert.assertEquals(value, "Products");
    }

    @Test
    public void testTasksAreaWithDoubleclick() {

        getDriver().get("https://thecode.media/");

        WebElement searchArea = getDriver().findElement(By.className("tab-questions"));

        Action myAction = new Actions(getDriver()).doubleClick(searchArea).build();
        myAction.perform();

        WebElement foundText = getDriver().findElement(By.xpath("(//h1[@class='search__title'])"));
        String foundSearchTitle = foundText.getText();

        Assert.assertEquals(foundSearchTitle, "Как решить");
    }

    @Test
    public void testCheckTextField() {

        getDriver().get("https://thecode.media/");

        WebElement searchButton = getDriver().findElement(By.className("heading-search__open"));
        searchButton.click();

        WebElement searchText = getDriver().findElement(By.className("heading-search__input"));
        searchText.sendKeys("Api");

        searchButton.click();

        WebElement foundText = getDriver().findElement(By.className("search__title"));
        String resultSearch = foundText.getText();

        Assert.assertEquals(resultSearch,"api");
    }

}
