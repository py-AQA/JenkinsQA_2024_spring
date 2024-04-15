package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;
import school.redrover.runner.TestUtils;

import static school.redrover.runner.TestUtils.*;

public class AqaMultibranchPipelineTest extends BaseTest {

    @Test(dataProvider = "itemProvider", dataProviderClass = TestUtils.class)
    public void testEnableItem(String name, String itemClassName) {

        if (!itemClassName.equals(Item.FOLDER)) {

            createItem(this, name, itemClassName);

            Assert.assertTrue(getDriver().findElement(By.cssSelector(".jenkins-app-bar #enable-disable-project")).isSelected());
        }
    }

    @Test(dataProvider = "itemProvider", dataProviderClass = TestUtils.class)
    public void testDisableItem(String name, String itemClassName) {

        if (!itemClassName.equals(Item.FOLDER)) {

            createItem(this, name, itemClassName);

            getWait15(this).until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format(
                    "a[href='/job/%s/']",
                    asURL(name))))).click();
            getWait15(this).until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();

            Assert.assertTrue(getDriver().findElement(By.id("enable-project")).getText().contains("is currently disabled"));
        }
    }
}
