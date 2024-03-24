package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest {
    @Test
    public void testCart() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement salePageButton = driver.findElement(By.id("ui-id-8"));
        salePageButton.click();
        WebElement shopWomanDealButton = driver.findElement(By.xpath("//span[@class = 'more button']"));
        shopWomanDealButton.click();
        WebElement bessYogaShortItemLink = driver.
                findElement(By.xpath("//a[contains(., 'Bess')]"));
        bessYogaShortItemLink.click();
        Thread.sleep(2000);
        WebElement sizeSelect = driver.findElement(By.xpath("//div[@option-id='171']"));
        sizeSelect.click();
        Thread.sleep(2000);
        WebElement colorSelect = driver.findElement(By.xpath("//div[@option-id='50']"));
        colorSelect.click();
        WebElement addToCard = driver.findElement(By.id("product-addtocart-button"));
        addToCard.click();
        Thread.sleep(3000);
        WebElement cartCounterNumber = driver.findElement(By.xpath("//span[@class ='counter-number']"));
        cartCounterNumber.click();

        Thread.sleep(3000);
        Assert.assertEquals((driver.findElement(By
                        .xpath("//strong[@class='product-item-name']/a")).getText()),
                "Bess Yoga Short");
        driver.quit();
    }
}
