package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


    public static final By SIDE_PANEL_DELETE = By.cssSelector("[data-url $= '/doDelete']");
    public static final By DROPDOWN_DELETE = By.cssSelector("button[href $= '/doDelete']");
    public static final By DIALOG_DEFAULT_BUTTON = By.cssSelector("dialog .jenkins-button--primary");
    public static final By EMPTY_STATE_BLOCK = By.cssSelector("div.empty-state-block");

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
                {"123"},
                {"123 123"},
                {" 123"},
                {"123 "},
                {"1"},
                {"123456789"},
        };
//        return new Object[][]{
//                {""},
//                {"I"},
//                {"☼"},
//                {"<!--"},
//                {"'"},
//                {"lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll" +
//                        "llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll" +
//                        "llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll"},
//        };
    }

    protected void sleep(long seconds) {
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

    protected void openItemByNameClickInCurrentView(String name) {
        Point item_left_upper_corner = getWait15().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name))))).getLocation();

        new Actions(getDriver())
                .moveToLocation(item_left_upper_corner.getX(), item_left_upper_corner.getY())
                .click()
                .perform();
    }

    protected void sidePanelDoDelete(String name) {

        openItemByNameClickInCurrentView(name);

        getDriver().findElement(SIDE_PANEL_DELETE).click();
        getWait15().until(ExpectedConditions.elementToBeClickable(DIALOG_DEFAULT_BUTTON)).click();
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
        //TODO check this if it works well
        return URLEncoder.encode(str.trim(), StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20")
                .replaceAll("%21", "!")
                .replaceAll("%27", "'")
                .replaceAll("%28", "(")
                .replaceAll("%29", ")")
                .replaceAll("%7E", "~");
    }

    protected void openElementDropdown(WebElement element) {

        WebElement chevron = element.findElement(By.className("jenkins-menu-dropdown-chevron"));

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].dispatchEvent(new Event('mouseenter'));", chevron);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].dispatchEvent(new Event('click'));", chevron);
    }

    protected void dropdownDoDelete(String name) {

        openElementDropdown(getDriver().findElement(
                By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))));

        getDriver().findElement(DROPDOWN_DELETE).click();
        getWait15().until(ExpectedConditions.elementToBeClickable(DIALOG_DEFAULT_BUTTON)).click();
    }

    protected static class View {
        public static final String MY_VIEW = "hudson.model.MyView";
        public static final String LIST_VIEW = "hudson.model.ListView";

    }

    public void createView(String viewName, String viewType) {
        getDriver().findElement(By.className("addTab")).click();
        getDriver().findElement(By.id("name")).sendKeys(viewName);
        getDriver().findElement(By.cssSelector(String.format("[for = '%s']", viewType))).click();
        getDriver().findElement(By.id("ok")).click();
    }
}