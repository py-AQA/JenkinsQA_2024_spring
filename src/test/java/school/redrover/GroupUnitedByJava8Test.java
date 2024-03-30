package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupUnitedByJava8Test extends BaseTest {

    private static final String STANDARD_USER_LOGIN = "standard_user";
    private static final String STANDARD_USER_PASSWORD = "secret_sauce";
    private static final String EXPECTED_TEXT = "Sauce Labs Backpack";

    @Test
    public void testDemoQADoubleClick() {
        getDriver().get("https://demoqa.com/");

        WebElement elementsPage = getDriver().findElement(By.xpath("//h5[text()='Elements']"));
        elementsPage.click();
        WebElement buttons = getDriver().findElement(By.xpath("//span[@class='text' and text()='Buttons']"));
        buttons.click();

        WebElement doubleClickMe = getDriver().findElement(By.id("doubleClickBtn"));
        new Actions(getDriver())
            .doubleClick(doubleClickMe)
            .perform();

        String doubleClickMessageText = getDriver().findElement(By.id("doubleClickMessage")).getText();

        Assert.assertEquals(doubleClickMessageText, "You have done a double click");
    }

    @Test
    public void testCheckingAddingCart() {
        WebDriver driver = getDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(STANDARD_USER_LOGIN);
        WebElement userPassword = driver.findElement(By.id("password"));
        userPassword.sendKeys(STANDARD_USER_PASSWORD);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addCartButton.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();

        WebElement cartList = driver.findElement(By.id("item_4_title_link"));

        Assert.assertEquals(cartList.getText(), EXPECTED_TEXT);
    }
}
