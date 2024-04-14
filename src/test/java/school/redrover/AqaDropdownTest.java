package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;
import school.redrover.runner.TestUtils;

import static school.redrover.runner.TestUtils.*;

public class AqaDropdownTest extends BaseTest {

    @Test(dataProvider = "itemNameProvider", dataProviderClass = TestUtils.class)
    public void testSidePanelDeletePipeline(String name) {

        createItemAndReturnToDashboard(this, name, Item.PIPELINE);

        dropdownDoDelete(this, name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test(dataProvider = "itemProvider", dataProviderClass = TestUtils.class)
    public void testDropdownDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(this, name, itemClassName);

        dropdownDoDelete(this, name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }
}
