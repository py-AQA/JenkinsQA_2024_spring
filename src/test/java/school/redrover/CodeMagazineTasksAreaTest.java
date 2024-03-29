package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CodeMagazineTasksAreaTest {

    @Test
    public void testTasksArea() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://thecode.media/");

        WebElement search_area = driver.findElement(By.className("tab-questions"));

        Action myAction = new Actions(driver).doubleClick(search_area).build();
        myAction.perform();

        WebElement found_text = driver.findElement(By.xpath("(//h1[@class='search__title'])"));
        String found_search_title = found_text.getText();

        Assert.assertEquals(found_search_title, "Как решить");

        driver.quit();

    }

}
