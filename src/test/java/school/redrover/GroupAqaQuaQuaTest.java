package school.redrover;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;



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

        WebElement shoppingCart = getDriver().findElement(By.className("cart-label"));
        shoppingCart.click();


        Assert.assertEquals(getDriver().findElement(By.className("product-name")).getText(), "Computing and Internet");

    }

    @Test
    public void testAddGiftCardToCart() {
        getDriver().get("https://demowebshop.tricentis.com/");

        WebElement selectSortBy = getDriver().findElement(
                By.cssSelector("div.header-menu>ul.top-menu>li>a[href='/gift-cards']"));
        selectSortBy.click();

        getDriver().findElement(
                        By.cssSelector("div.product-grid>div.item-box>div.product-item[data-productid='1']>div.picture"))
                .click();
        getDriver().findElement(
                By.cssSelector("div.breadcrumb>ul>li>strong.current-item"));

        Assert.assertEquals(getDriver().findElement(
                By.cssSelector("div.breadcrumb>ul>li>strong.current-item")).getText(), "$5 VIRTUAL GIFT CARD");

        getDriver().findElement(
                By.cssSelector("div.giftcard>div>input.recipient-name")).sendKeys("Ippolit");
        getDriver().findElement(
                By.cssSelector("div.giftcard>div>input.recipient-email")).sendKeys("ippolit@mail.ru");
        getDriver().findElement(
                By.cssSelector("div.giftcard>div>input.sender-name")).sendKeys("Barbara");
        getDriver().findElement(
                By.cssSelector("div.giftcard>div>input.sender-email")).sendKeys("barbara@mail.com");
        getDriver().findElement(
                By.cssSelector("div.giftcard>div>textarea.message")).sendKeys("Тебе от меня! :)");
        getDriver().findElement(
                By.cssSelector("input[type='button']#add-to-cart-button-1")).click();
        getDriver().findElement(
                By.cssSelector("div.header-links>ul>li#topcartlink")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demowebshop.tricentis.com/cart");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("div.page-title>h1")).getText(), "Shopping cart");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.product>a.product-name")).getText(), "$5 Virtual Gift Card");
        // как подцепить эл.адреса?
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.unit-price.nobr>span.product-unit-price")).getText(), "5.00");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.qty.nobr>input.qty-input")).getAttribute("value"), "1");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.subtotal.nobr.end>span.product-subtotal")).getText(), "5.00");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.cart-total-right>span.nobr>span.product-price")).getText(), "5.00");
        Assert.assertEquals(getDriver().findElement(
                        By.cssSelector("td.cart-total-right>span.nobr>span.product-price.order-total>strong")).getText(), "5.00");


        getDriver().findElement(By.cssSelector("input[type='checkbox']#termsofservice")).click();
        getDriver().findElement(By.id("checkout")).click();

        Assert.assertEquals(getDriver().findElement(
                By.cssSelector("div.page-title>h1")).getText(), "Welcome, Please Sign In!");

    }
}


