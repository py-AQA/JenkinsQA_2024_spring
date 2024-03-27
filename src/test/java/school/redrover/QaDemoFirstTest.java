package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaDemoFirstTest {

    @Test
    public void findElementsOnMainPageAndCheck() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        String titleMain = driver.getTitle();
        Assert.assertEquals(titleMain, "DEMOQA");


        WebElement headerLink = driver.findElement(By.cssSelector("div#app header>a"));
        String hrefValue = headerLink.getAttribute("href");
        Assert.assertEquals(hrefValue, "https://demoqa.com/");


        WebElement headerImg = driver.findElement(By.cssSelector("div#app header>a>img"));
        String srcValue = headerImg.getAttribute("src");
        String fileName = srcValue.substring(srcValue.lastIndexOf("/") + 1);
        Assert.assertEquals(fileName,"Toolsqa.jpg");


//       div.home-banner>a>img[alt="Selenium Online Training"] проверить переход на страницу,
//       заголовок
//       div.home-body>div.category-cards как проверить длину списка и входящие элементы?

        WebElement firstLabelElement = driver.findElement(By.cssSelector("div.card:first-child"));
        firstLabelElement.click();

        String titleMainElements = driver.getTitle();
        Assert.assertEquals(titleMainElements, "DEMOQA");

        driver.quit();

    }

}
