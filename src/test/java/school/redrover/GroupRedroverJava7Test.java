package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GroupRedroverJava7Test extends BaseTest {

    @Test
    public void testSearch() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textBox = getDriver().findElement(By.name("my-text"));
        textBox.sendKeys("Selenium");

        WebElement submitButton = getDriver().findElement(By.cssSelector("button"));
        submitButton.click();

        WebElement message = getDriver().findElement(By.id("message"));
        String value = message.getText();

        Assert.assertEquals(value, "Received!");
    }

    @Test
    public void testSubmitOrder() {
        getDriver().get("https://play1.automationcamp.ir/");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.xpath("//h5[contains(text(), 'Sample Pages')]")));

        getDriver().findElement(By.xpath("//h5[contains(text(), 'Sample Pages')]/parent::div/following-sibling::div//a")).click();

        WebElement user = getDriver().findElement(By.xpath("//input[@id='user']"));
        user.click();
        user.clear();
        user.sendKeys("admin");

        WebElement password = getDriver().findElement(By.xpath("//input[@id='password']"));
        password.click();
        password.clear();
        password.sendKeys("admin");

        getDriver().findElement(By.xpath("//button[@id='login']")).click();

        WebElement header = getDriver().findElement(By.xpath("//h3"));

        Assert.assertEquals(header.getText(), "Dinesh's Pizza House");
    }

    @Test
    public void testItemSearch() {
        getDriver().get("https://www.applebees.com/en");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        getDriver().manage().window().maximize();

        WebElement menuButton = getDriver().findElement(By.xpath("//ul/li/a[@href='/en/menu'][1]"));
        menuButton.click();

        WebElement searchMenu = getDriver().findElement(By.xpath("//a[@class='btn btn-lg btn-text']"));
        searchMenu.click();

        WebElement textBox = getDriver().findElement(By.xpath("//input[contains(@class,'menu-search')]"));
        textBox.sendKeys("salmon");

        WebElement massage = getDriver().findElement(By.xpath("//a[@href='/en/menu/seafood/blackened-cajun-salmon']"));
        String value = massage.getText();

        Assert.assertEquals("Blackened Cajun Salmon", value);
    }

    @Test
    public void testLocationList() {
        List<String> actualLocationNames = List.of("Bensalem", "Doylestown", "Langhorne", "Levittown", "Perkasie", "Quakertown", "Yardley-Makefield");
        List<String> expectedLocationNames = new ArrayList<>();

        getDriver().get("https://buckslib.org/");
        getDriver().manage().window().maximize();

        getDriver().findElement(By.xpath("//*[contains(text(),' Locations')]")).click();

        for (String locationName : actualLocationNames) {
            String locationText = getDriver()
                    .findElement(By.xpath("//div[@id='wp-faqp-accordion-1']/div/div[@class='faq-title']/h4[text()='" + locationName + "']")).getText();
            expectedLocationNames.add(locationText);
        }

        Assert.assertEquals(actualLocationNames, expectedLocationNames);
    }
}


