package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AqaManageJenkinsTest extends AqaBaseTest {

    @Test
    public void testCreateUser() {

        createUser("user");
        Assert.assertTrue(getDriver().findElement(By.cssSelector("[href = 'user/user/']")).getText().contains("user"));
    }

    @Test
    public void testDeleteUser() {

        createUser("user");

        int count = getDriver().findElements(By.cssSelector("tbody tr")).size();
        getDriver().findElement(By.cssSelector("a[data-url = 'user/user/doDelete']")).click();
        getDriver().findElement(By.cssSelector("[data-id = 'ok']")).click();

        Assert.assertEquals(getDriver().findElements(By.cssSelector("tbody tr")).size(), count - 1);
    }
}
