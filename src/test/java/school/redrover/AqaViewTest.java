package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaViewTest extends AqaBaseTest{

    @Test
    public void testCreateView() {
        createItemAndReturnToDashboard("Project", Item.FREESTYLE_PROJECT);
        addView("Second", View.MY_VIEW);

        Assert.assertTrue(getDriver().findElement(By.cssSelector(".tab.active")).getText().contains("Second"));
    }
}