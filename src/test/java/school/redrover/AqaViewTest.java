package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaViewTest extends AqaBaseTest{

    @Test
    public void testCreateView() {
        createItemAndReturnToDashboard("Project", Item.FREESTYLE_PROJECT);
        createView("Second", View.MY_VIEW);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(".tab.active")).getText().contains("Second"),
                "The view has not been created");
    }

    @Test
    public void testDeleteView() {
        createItemAndReturnToDashboard("Folder", Item.FOLDER);
        createView("I_see", View.MY_VIEW);

        getDriver().findElement(By.cssSelector("[href = '/view/I_see/']")).click();
        getDriver().findElement(By.className("icon-edit-delete")).click();
        getDriver().findElement(By.className("jenkins-button--primary")).click();

        Assert.assertTrue(getDriver().findElements(By.cssSelector("[href = '/view/I_see/']")).isEmpty(),
                "The view has not been deleted");
    }

    @Test
    public void testAddDescriptionToView() {
        createItemAndReturnToDashboard("Folder", Item.FOLDER);
        createView("I_see", View.MY_VIEW);

        getDriver().findElement(By.cssSelector("[href = '/view/I_see/configure']")).click();
        getDriver().findElement(By.name("_.description")).sendKeys("I love Jenkins");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertTrue(getDriver().findElement(By.id("description")).getText().contains("I love Jenkins"),
                "No description has been added");
    }
}