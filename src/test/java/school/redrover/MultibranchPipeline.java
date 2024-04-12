package school.redrover;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class MultibranchPipeline extends BaseTest {

    @Test
    public void testChangeMultPipelineFromDisabledToEnabledOnStatusPage() {
        final String multPipelineName = "Multibranch Pipeline";

        createNewMultPipiline(multPipelineName);
        disableCratedMultPipiline(multPipelineName);

        getDriver().findElement(By.xpath("//span[text()='" + multPipelineName + "']")).click();
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();
        List<WebElement> disabledMultPipelineMessage = getDriver().findElements(
            By.xpath("//form[@id='enable-project']"));

        Assert.assertEquals(disabledMultPipelineMessage.size(), 0, "Message is displayed!!!");
    }

    private void disableCratedMultPipiline(String MultPipelineNameValue) {
        getDriver().findElement(By.xpath("//span[text()='" + MultPipelineNameValue + "']")).click();
        WebElement configureLink = getDriver().findElement(By.xpath("//div/div[2]/span"));
        configureLink.click();
        if (getDriver().findElement(By.className("jenkins-toggle-switch__label__checked-title"))
            .isDisplayed()) {
            getDriver().findElement(By.cssSelector("[data-title*='Disabled']")).click();
        }
        getDriver().findElement(By.cssSelector("[name*='Submit']")).click();
        getDriver().findElement(By.xpath("//a[text()='Dashboard']")).click();
    }

    private void createNewMultPipiline(String MultPipelineNameValue) {
        getDriver().findElement(By.xpath("//a[@href='newJob']")).click();
        getDriver().findElement(By.id("name")).sendKeys(MultPipelineNameValue);
        getDriver().findElement(By.cssSelector("[class*='WorkflowMultiBranchProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.xpath("//a[text()='Dashboard']")).click();
    }
}
