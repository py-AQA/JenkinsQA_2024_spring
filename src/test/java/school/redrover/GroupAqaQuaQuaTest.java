package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupAqaQuaQuaTest extends BaseTest {
   @Test
    public void bookTest() {
        getDriver().get("https://demowebshop.tricentis.com/");

        WebElement books = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a"));
        books.click();

        WebElement myBook = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a"));
        myBook.click();

        WebElement addMyBook = getDriver().findElement(By.id("add-to-cart-button-13"));
        addMyBook.click();

        WebElement shoppingcart = getDriver().findElement(By.className("cart-label"));
        shoppingcart.click();

    }

}
