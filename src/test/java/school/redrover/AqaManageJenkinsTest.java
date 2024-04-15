package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;
import static school.redrover.runner.TestUtils.*;


public class AqaManageJenkinsTest extends BaseTest {

    @DataProvider(name = "usersProvider")
    private Object[][] usersProvider() {

        return new Object[][]{{"user1"}, {"user2"}, {"user3"}};
    }

    @Test
    public void testCreateUser() {

        createUser(this, "user");

        Assert.assertTrue(getDriver().findElement(By.cssSelector("[href = 'user/user/']")).getText().contains("user"));
    }

    @Test(dataProvider = "usersProvider")
    public void testDeleteUser(String user_name) {

        createUser(this, user_name);

        int count = getDriver().findElements(By.cssSelector("tbody tr")).size();
        getDriver().findElement(By.cssSelector(String.format("a[data-url = 'user/%s/doDelete']", user_name))).click();
        getDriver().findElement(By.cssSelector("[data-id = 'ok']")).click();

        Assert.assertEquals(getDriver().findElements(By.cssSelector("tbody tr")).size(), count - 1);
    }
}
