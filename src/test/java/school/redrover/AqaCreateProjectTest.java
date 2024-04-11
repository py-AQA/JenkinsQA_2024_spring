package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaCreateProjectTest extends AqaBaseTest {

    @Test(dataProvider = "itemNameProvider")
    public void testSidePanelDeleteFolder(String name) {

        createItemAndReturnToDashboard(name, Item.FOLDER);

        sidePanelDoDelete(name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test(dataProvider = "itemProvider")
    public void testCreateItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))).isDisplayed());
    }
    @Test
    public void testAddDescriptionFolder() {

        createItemAndReturnToDashboard("FirstProject", Item.FOLDER);
        openItemByNameClickInCurrentView("FirstProject");

        getDriver().findElement(By.id("description-link")).click();
        getDriver().findElement(By.name("description")).sendKeys("Hello, it's a first project");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertEquals(
                getDriver().findElement(By.cssSelector("#description div:first-child")).getText(),
                "Hello, it's a first project");
    }

    @Test(dataProvider = "itemProvider")
    public void testSidePanelDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        sidePanelDoDelete(name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test
    public void testCreateMultiConfigurationProject() {

        createItemAndReturnToDashboard("MCP", Item.MULTI_CONFIGURATION_PROJECT);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/MCP/']")).isDisplayed());
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
    public void testNewItemJenkins() {

        createItemAndReturnToDashboard("FP", "hudson_model_FreeStyleProject");

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = 'job/FP/']")).isDisplayed());
    }

}
