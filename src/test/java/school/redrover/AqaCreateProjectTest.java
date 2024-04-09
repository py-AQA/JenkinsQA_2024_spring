package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaCreateProjectTest extends AqaBaseTest {

    @Test(dataProvider = "itemsProvider")
    public void testCreateItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))).isDisplayed());
    }

    @Test(dataProvider = "itemsProvider")
    public void testDeleteItem(String name, String itemClassName) {

        createItemAndReturnToDashboard(name, itemClassName);

        deleteItem(name);
    }
}
