package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AqaJenkinsTest extends AqaBaseTest {

    @Test
    public void testAuthJenkins() {

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = '/logout']")).isDisplayed());
    }

    @Test
    public void testTitleJenkins() {

        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div h1"))).getText(),
                "Welcome to Jenkins!");
    }

    @Test
    public void testLogoutJenkins() {

        getDriver().findElement(By.cssSelector("a[href = '/logout']")).click();

        Assert.assertEquals(
                getDriver().findElement(By.tagName("h1")).getText(),
                "Sign in to Jenkins");
    }

    @Test
    public void testPeople() {

        getDriver().findElement(By.xpath("//a[@href='/asynchPeople/']")).click();

        Assert.assertEquals(
                getDriver().findElement(By.xpath("//div[@class='jenkins-app-bar__content']")).getText(),
                "People");
    }
    @Test
    public void testTitleDashboard() {
        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard"))).getText(),
                "Dashboard");
    }

    @Test
    public void testTitleText1() {
        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.className("content-block__link"))).getText(),
                "Create a job");
    }
    @Test
    public void testTitleText2() {
        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.id("description-link"))).getText(),
                "Add description");
    }
}
