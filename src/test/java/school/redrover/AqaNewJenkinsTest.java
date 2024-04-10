package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaNewJenkinsTest extends AqaBaseTest {

    @Test
    public void testAuthJenkins() {
        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = '/logout']")).isDisplayed());
    }

    @Test
    public void testLogoutJenkins() {
        getDriver().findElement(By.cssSelector("a[href = '/logout']")).click();

        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Sign in to Jenkins");
    }

    @Test
    public void testNewItemJenkins() {

        createItemAndReturnToDashboard("FP", Item.FREESTYLE_PROJECT);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/FP/']")).isDisplayed());
    }

    @Test
    public void testAddDescription() {

        createItem("MCP", Item.MULTI_CONFIGURATION_PROJECT);
        getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name = 'description']"))).sendKeys("xxx");

        getDriver().findElement(By.xpath("//button[@formnovalidate = 'formNoValidate']")).click();
        Assert.assertTrue(getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#description"))).getText().startsWith("xxx"));
    }

    @Test
    public void testPeople() {

        getDriver().findElement(By.xpath("//a[@href='/asynchPeople/']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='jenkins-app-bar__content']")).getText(), "People");
    }

    @Test
    public void testTitleJenkins() {

        Assert.assertEquals(getDriver().findElement(By.cssSelector("div h1")).getText(), "Welcome to Jenkins!");
    }

    @Test
    public void testNewFolder() {

        createItemAndReturnToDashboard("Folder", Item.FOLDER);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/Folder/']")).isDisplayed());
    }

    @Test
    public void testMoveItemToFolder() {

        createItemAndReturnToDashboard("newFolder", Item.FOLDER);

        createItemAndReturnToDashboard("Folder1", Item.FOLDER);

        openItem("newFolder");
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '/job/newFolder/move']"))).click();
        new Select(getDriver().findElement(By.name("destination"))).selectByValue("/Folder1");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertTrue(getDriver().findElement(By.id("breadcrumbBar")).getText().contains("Folder1"));
    }

    @Test
    public void testRenameFolder() {

        createItemAndReturnToDashboard("newFolder", Item.FOLDER);

        openItem("newFolder");
        getDriver().findElement(By.cssSelector("a[href='/job/newFolder/confirm-rename']")).click();
        WebElement name = getDriver().findElement(By.name("newName"));
        name.clear();
        name.sendKeys("renameFolder");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#main-panel h1"))).getText(),
                "renameFolder");
    }
}

