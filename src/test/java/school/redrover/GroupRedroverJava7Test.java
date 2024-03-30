package school.redrover;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
}
