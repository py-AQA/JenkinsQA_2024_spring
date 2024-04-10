package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import school.redrover.runner.BaseTest;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class AqaBaseTest extends BaseTest {
    private WebDriverWait wait15;

    @BeforeMethod
    @Override
    protected void beforeMethod(Method method) {
        super.beforeMethod(method);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    protected WebDriverWait getWait15() {
        if (wait15 == null) {
            wait15 = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        }
        return wait15;
    }

    @AfterMethod
    @Override
    protected void afterMethod(Method method, ITestResult testResult) {
        super.afterMethod(method, testResult);
        if (wait15 != null) {
            wait15 = null;
        }
    }

    protected static class Item {

        public static final String FREESTYLE_PROJECT = "hudson_model_FreeStyleProject";
        public static final String PIPELINE = "org_jenkinsci_plugins_workflow_job_WorkflowJob";
        public static final String MULTI_CONFIGURATION_PROJECT = "hudson_matrix_MatrixProject";
        public static final String FOLDER = "com_cloudbees_hudson_plugins_folder_Folder";
        public static final String MULTI_BRANCH_PIPELINE = "org_jenkinsci_plugins_workflow_multibranch_WorkflowMultiBranchProject";
        public static final String ORGANIZATION_FOLDER = "jenkins_branch_OrganizationFolder";
    }

    @DataProvider(name = "itemProvider")
    public Object[][] itemProvider() {

        return new Object[][]{
                {"Freestyle project", Item.FREESTYLE_PROJECT},
                {"Pipeline", Item.PIPELINE},
                {"Multi-configuration project", Item.MULTI_CONFIGURATION_PROJECT},
                {"Folder", Item.FOLDER},
                {"Multibranch pipeline", Item.MULTI_BRANCH_PIPELINE},
                {"Organization folder", Item.ORGANIZATION_FOLDER},
        };
    }

    @DataProvider(name = "itemNameProvider")
    public Object[][] itemNameProvider() {

        return new Object[][]{
                {""},
                {"I"},
                {"☼"},
                {"<!--"},
                {"'"},
                {"lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll" +
                        "llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll" +
                        "llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll"},
        };
    }

    private void sleep(long seconds) {
        new Actions(getDriver()).pause(seconds * 1000).perform();
    }

    protected void login() {

        getDriver().get("http://localhost:8080/login");

        getDriver().findElement(By.id("j_username")).sendKeys("admin");
        getDriver().findElement(By.id("j_password")).sendKeys("admin");
        getDriver().findElement(By.name("Submit")).click();
    }

    protected void createItem(String name, String itemClassName) {

        getDriver().findElement(By.cssSelector("#side-panel > div > div")).click();
        getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        getDriver().findElement(By.className(itemClassName)).click();
        getDriver().findElement(By.id("ok-button")).click();
    }

    protected void returnToDashBoard() {

        getDriver().findElement(By.cssSelector("a[href = '/']")).click();
    }

    protected void createItemAndReturnToDashboard(String name, String itemClassName) {

        createItem(name, itemClassName);
        returnToDashBoard();
    }

    protected void clickItemNameInCurrentView(String name) {
        Point item_left_upper_corner = getWait15().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name))))).getLocation();

        new Actions(getDriver())
                .moveToLocation(item_left_upper_corner.getX(), item_left_upper_corner.getY())
                .click()
                .perform();
    }

    protected void openItem(String name) {
//TODO check this one for super short names
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("td a[href = 'job/%s/']", name)))).click();
    }

    protected void createUser(String name) {

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

    protected String asURL(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20")
                .replaceAll("\\%21", "!")
                .replaceAll("\\%27", "'")
                .replaceAll("\\%28", "(")
                .replaceAll("\\%29", ")")
                .replaceAll("\\%7E", "~");
    }

    protected void deleteItem(String name) {

        clickItemNameInCurrentView(name);
        getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", asURL(name)))).click();
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("dialog .jenkins-button--primary"))).click();
    }
}