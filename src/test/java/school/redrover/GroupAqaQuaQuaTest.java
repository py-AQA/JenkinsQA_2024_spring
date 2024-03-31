package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

public class GroupAqaQuaQuaTest extends BaseTest {

    @Test
    public void testyAddingBookToCart() {
        getDriver().get("https://demowebshop.tricentis.com/");


        WebElement books = getDriver().findElement(By.xpath("//ul[@class='top-menu']//a[@href='/books']"));
        books.click();

        WebElement myBook = getDriver().findElement(By.xpath("//div[@class = 'details']//a[@href= '/computing-and-internet']"));
        myBook.click();

        WebElement addMyBook = getDriver().findElement(By.id("add-to-cart-button-13"));
        addMyBook.click();

        WebElement shoppingСart = getDriver().findElement(By.className("cart-label"));
        shoppingСart.click();


        Assert.assertEquals(getDriver().findElement(By.className("product-name")).getText(), "Computing and Internet");

    }
}


