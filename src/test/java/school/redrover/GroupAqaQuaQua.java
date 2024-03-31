package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class GroupAqaQuaQua extends BaseTest {

    @Test
    public void BooksTest() {
        getDriver().get("https://demowebshop.tricentis.com/");

        WebElement books = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]"));
        books.click();

        WebElement myBook = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a"));
        myBook.click();

        WebElement addBook = getDriver().findElement(By.id("add-to-cart-button-13"));
        addBook.click();

        WebElement shoppingCart = getDriver().findElement(By.className("cart-label"));
        shoppingCart.click();

////        WebElement bookInShoppingCart = getDriver().findElement(By.className("product-name"));
//        WebElement bookInShoppingCart = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[3]/a"));
//        String value = bookInShoppingCart.getText();
//
//        Assert.assertEquals(value, "Computing and Internet");
    }
}
