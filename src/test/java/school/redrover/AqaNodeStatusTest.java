package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaNodeStatusTest extends AqaBaseTest {

    @Test
    public void testNodeStatus() {
//        Assert.assertTrue(getDriver().findElement(By.cssSelector("#executors th > span")).getText(). contains("offline"));
        System.out.println(getDriver().findElement(By.id("executors")).getText());
        Assert.assertTrue(getDriver().findElement(By.id("executors")).getText().contains("Idle"));
    }

    @Test
    public void testChangeNodeStatus() {
        getDriver().findElement(By.cssSelector("[href = '/computer/']")).click();
        getDriver().findElement(By.cssSelector("[data-href = '/computer/']")).click();
        getDriver().findElement(By.className("jenkins-dropdown__item")).click();
        getDriver().findElement(By.name("Submit")).click();
        getWait15().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector("#main-panel button")))).click();

        Assert.assertTrue(getDriver().findElement(By.className("message")).getText().contains("Disconnected"));
    }
}
