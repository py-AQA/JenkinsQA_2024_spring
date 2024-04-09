package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaMultibranchPipelineTest extends AqaBaseTest {

    @Test(dataProvider = "itemsProvider")
    public void testEnableItem(String name, String itemClassName) {

        if (!itemClassName.equals(Item.FOLDER)) {
            createItem(name, itemClassName);

            Assert.assertTrue(getDriver().findElement(By.cssSelector(".jenkins-app-bar #enable-disable-project")).isSelected());
        }
    }

    @Test(dataProvider = "itemsProvider")
    public void testDisableItem(String name, String itemClassName) {

        if (!itemClassName.equals(Item.FOLDER)) {
            createItem(name, itemClassName);

            getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/']", asURL(name))))).click();
            getWait15().until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();

            Assert.assertTrue(getDriver().findElement(By.id("enable-project")).getText().contains("is currently disabled"));
        }
    }
}
