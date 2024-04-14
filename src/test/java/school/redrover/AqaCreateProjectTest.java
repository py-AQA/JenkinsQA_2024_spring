package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;
import school.redrover.runner.TestUtils;

import static school.redrover.runner.TestUtils.*;

public class AqaCreateProjectTest extends BaseTest {

    @Test(dataProvider = "itemNameProvider", dataProviderClass = TestUtils.class)
    public void testSidePanelDeleteFolder(String name) {

        createItemAndReturnToDashboard(this, name, Item.FOLDER);

        sidePanelDoDelete(this, name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test(dataProvider = "itemProvider", dataProviderClass = TestUtils.class)
    public void testCreateItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(this, name, itemClassName);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))).isDisplayed());
    }
    @Test
    public void testAddDescriptionFolder() {

        createItemAndReturnToDashboard(this, "FirstProject", Item.FOLDER);
        openItemByNameClickInCurrentView(this, "FirstProject");

        getDriver().findElement(By.id("description-link")).click();
        getDriver().findElement(By.name("description")).sendKeys("Hello, it's a first project");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertEquals(
                getDriver().findElement(By.cssSelector("#description div:first-child")).getText(),
                "Hello, it's a first project");
    }

    @Test(dataProvider = "itemProvider", dataProviderClass = TestUtils.class)
    public void testSidePanelDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(this, name, itemClassName);

        sidePanelDoDelete(this, name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test
    public void testCreateMultiConfigurationProject() {

        createItemAndReturnToDashboard(this, "MCP", Item.MULTI_CONFIGURATION_PROJECT);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/MCP/']")).isDisplayed());
    }

    @Test
    public void testAddDescription() {

        createItem(this, "MCP", "hudson_matrix_MatrixProject");

        getWait15(this).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name = 'description']"))).sendKeys("xxx");
        getDriver().findElement(By.xpath("//button[@formnovalidate = 'formNoValidate']")).click();

        Assert.assertTrue(
                getWait15(this).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#description"))).getText().startsWith("xxx"));
    }

    @Test
    public void testNewItemJenkins() {

        createItemAndReturnToDashboard(this, "FP", "hudson_model_FreeStyleProject");

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = 'job/FP/']")).isDisplayed());
    }

}
