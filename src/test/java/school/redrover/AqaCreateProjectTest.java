package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AqaCreateProjectTest extends AqaBaseTest {

    @Ignore
    @Test(dataProvider = "itemNameProvider")
    public void testDeleteFolder(String name) {

        createItemAndReturnToDashboard(name, Item.FOLDER);

        deleteItem(name);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))).isDisplayed());
    }

    @Test(dataProvider = "itemProvider")
    public void testCreateItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))).isDisplayed());
    }

    @Test(dataProvider = "itemProvider")
    public void testDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        deleteItem(name);

//        TODO add assert here please
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
