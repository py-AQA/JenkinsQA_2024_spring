package school.redrover;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

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

        Assert.assertEquals(value,"Received!");
    }

    @Test
    public void testSubmitOrder(){
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
    public void testApplitoolsDemo() {

        //pass on the target URL
        getDriver().get("https://demo.applitools.com/");

        //find username field and send over an input
        WebElement userNameField = getDriver().findElement(By.id("username"));
        userNameField.sendKeys("standard_user");

        // find password field and send over an input
        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.sendKeys("12345qwera");

        // find log-in button and do the click
        getDriver().findElement(By.id("log-in")).click();

        //find the static text visible after the user is logged in
        WebElement h6FindText = getDriver().findElement(By.xpath(("(//h6[@class='element-header'])[1]")));
        String h6String = h6FindText.getText();

        //check if the "Financial Overview" text exists
        Assert.assertEquals(h6String, "Financial Overview");

    }
}
