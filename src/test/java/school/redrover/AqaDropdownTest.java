package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaDropdownTest extends AqaBaseTest {

    @Test(dataProvider = "itemNameProvider")
    public void testSidePanelDeleteFolder(String name) {

        createItemAndReturnToDashboard(name, Item.PIPELINE);

        dropdownDoDelete(name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }

    @Test(dataProvider = "itemProvider")
    public void testDropdownDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        dropdownDoDelete(name);

        Assert.assertTrue(getDriver().findElement(EMPTY_STATE_BLOCK).isDisplayed());
    }
}
