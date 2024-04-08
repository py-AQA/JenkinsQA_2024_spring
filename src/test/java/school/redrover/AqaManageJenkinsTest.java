package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AqaManageJenkinsTest extends AqaBaseTest{

    public void createUser(String name) {
        getDriver().findElement(By.cssSelector("[href = '/manage']")).click();
        getDriver().findElement(By.cssSelector("[href = 'securityRealm/']")).click();
        getDriver().findElement(By.cssSelector("[href = 'addUser']")).click();

        getDriver().findElement(By.id("username")).sendKeys(name);
        getDriver().findElement(By.name("password1")).sendKeys(name);
        getDriver().findElement(By.name("password2")).sendKeys(name);
        getDriver().findElement(By.name("fullname")).sendKeys(name);
        getDriver().findElement(By.name("email")).sendKeys(String.format("%s@user.com", name));
        getDriver().findElement(By.name("Submit")).click();
    }

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
