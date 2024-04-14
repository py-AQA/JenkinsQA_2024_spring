package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import static school.redrover.runner.TestUtils.*;

public class AqaViewTest extends BaseTest {

    @Test
    public void testCreateView() {
        createItemAndReturnToDashboard(this, "Project", Item.FREESTYLE_PROJECT);
        createView(this, "Second", View.MY_VIEW);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(".tab.active")).getText().contains("Second"),
                "The view has not been created");
    }

    @Test
    public void testDeleteView() {
        createItemAndReturnToDashboard(this, "Folder", Item.FOLDER);
        createView(this, "I_see", View.MY_VIEW);

        getDriver().findElement(By.cssSelector("[href = '/view/I_see/']")).click();
        getDriver().findElement(By.className("icon-edit-delete")).click();
        getDriver().findElement(By.className("jenkins-button--primary")).click();

        Assert.assertTrue(getDriver().findElements(By.cssSelector("[href = '/view/I_see/']")).isEmpty(),
                "The view has not been deleted");
    }

    @Test
    public void testAddDescriptionToView() {

        createItemAndReturnToDashboard(this, "Folder", Item.FOLDER);
        createView(this, "I_see", View.MY_VIEW);

        getDriver().findElement(By.cssSelector("[href = '/view/I_see/configure']")).click();
        getDriver().findElement(By.name("_.description")).sendKeys("I love Jenkins");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertTrue(getDriver().findElement(By.id("description")).getText().contains("I love Jenkins"),
                "No description has been added");
    }
}