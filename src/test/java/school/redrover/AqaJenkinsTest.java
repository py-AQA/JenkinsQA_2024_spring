package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaJenkinsTest extends AqaBaseTest {

//    private void createItem(String name, String itemClassName) {
//        getDriver().findElement(By.cssSelector("#side-panel > div > div")).click();
//        getWait15().until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).sendKeys(name);
//        getDriver().findElement(By.className(itemClassName)).click();
//        getDriver().findElement(By.id("ok-button")).click();
//    }
//
//    private void deleteItem(String name) {
//        if (!getDriver().findElements(By.cssSelector(String.format("a[href = 'job/%s/']", name))).isEmpty()) {
//            new Actions(getDriver())
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("a[href = 'job/%s/']", name))))
//                    .pause(1000)
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("button[data-href = 'http://localhost:8080/job/%s/']", name))))
//                    .click()
//                    .perform();
//
//            getDriver().findElement(By.cssSelector(String.format("button[href='/job/%s/doDelete']", name))).click();
//            getDriver().findElement(By.className("jenkins-button--primary")).click();
//        }
//    }

//    private void returnToDashBoard() {
//        getDriver().findElement(By.cssSelector("a[href = '/']")).click();
//    }

    @Test
    public void testAuthJenkins() {
        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = '/logout']")).isDisplayed());
    }

    @Test
    public void testLogoutJenkins() {
        getDriver().findElement(By.cssSelector("a[href = '/logout']")).click();

        Assert.assertEquals(
                getDriver().findElement(By.tagName("h1")).getText(),
                "Sign in to Jenkins");
    }

    @Test
    public void testNewItemJenkins() {
        createItem("FP", "hudson_model_FreeStyleProject");

        returnToDashBoard();

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = 'job/FP/']")).isDisplayed());
    }

    @Test
    public void testCreateMultiConfigurationProject() {
        createItem("MCP", "hudson_matrix_MatrixProject");

        returnToDashBoard();

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = 'job/MCP/']")).isDisplayed());
    }

    @Test
    public void testAddDescription() {
        createItem("MCP", "hudson_matrix_MatrixProject");

        getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name = 'description']"))).sendKeys("xxx");
        getDriver().findElement(By.xpath("//button[@formnovalidate = 'formNoValidate']")).click();

        Assert.assertTrue(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#description"))).getText().startsWith("xxx"));
    }

    @Test
    public void testPeople() {
        getDriver().findElement(By.xpath("//a[@href='/asynchPeople/']")).click();

        Assert.assertEquals(
                getDriver().findElement(By.xpath("//div[@class='jenkins-app-bar__content']")).getText(),
                "People");
    }

    @Test
    public void testTitleJenkins() {
        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div h1"))).getText(),
                "Welcome to Jenkins!");
    }
}
