package school.redrover.runner;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public final class TestUtils {

    public static final String FREESTYLE_PROJECT = "Freestyle project";
    public static final String PIPELINE = "Pipeline";
    public static final String MULTI_CONFIGURATION_PROJECT = "Multi-configuration project";
    public static final String FOLDER = "Folder";
    public static final String MULTIBRANCH_PIPELINE = "Multibranch Pipeline";
    public static final String ORGANIZATION_FOLDER = "Organization Folder";

    public static String getUserID(WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(@href, 'user')]")).getText();
    }

    public static void createItem(String type, String name, WebDriver driver) {
        driver.findElement(By.linkText("New Item")).click();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.xpath("//span[text()='" + type + "']")).click();
        driver.findElement(By.id("ok-button")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
    }

    public static void goToMainPage(WebDriver driver) {
        driver.findElement(By.id("jenkins-name-icon")).click();
    }

    public static final By SIDE_PANEL_DELETE = By.cssSelector("[data-url $= '/doDelete']");
    public static final By DROPDOWN_DELETE = By.cssSelector("button[href $= '/doDelete']");
    public static final By DIALOG_DEFAULT_BUTTON = By.cssSelector("dialog .jenkins-button--primary");
    public static final By EMPTY_STATE_BLOCK = By.cssSelector("div.empty-state-block");

    public static class Item {

        public static final String FREESTYLE_PROJECT = "hudson_model_FreeStyleProject";
        public static final String PIPELINE = "org_jenkinsci_plugins_workflow_job_WorkflowJob";
        public static final String MULTI_CONFIGURATION_PROJECT = "hudson_matrix_MatrixProject";
        public static final String FOLDER = "com_cloudbees_hudson_plugins_folder_Folder";
        public static final String MULTI_BRANCH_PIPELINE = "org_jenkinsci_plugins_workflow_multibranch_WorkflowMultiBranchProject";
        public static final String ORGANIZATION_FOLDER = "jenkins_branch_OrganizationFolder";
    }

    public static void sleep(BaseTest baseTest, long seconds) {
        new Actions(baseTest.getDriver()).pause(seconds * 1000).perform();
    }

    public static WebDriverWait getWait15(BaseTest baseTest) {
        return new WebDriverWait(baseTest.getDriver(), Duration.ofSeconds(15));
    }

    public static void createUser(BaseTest baseTest, String name) {

        baseTest.getDriver().findElement(By.cssSelector("[href = '/manage']")).click();
        baseTest.getDriver().findElement(By.cssSelector("[href = 'securityRealm/']")).click();
        baseTest.getDriver().findElement(By.cssSelector("[href = 'addUser']")).click();

        baseTest.getDriver().findElement(By.id("username")).sendKeys(name);
        baseTest.getDriver().findElement(By.name("password1")).sendKeys(name);
        baseTest.getDriver().findElement(By.name("password2")).sendKeys(name);
        baseTest.getDriver().findElement(By.name("fullname")).sendKeys(name);
        baseTest.getDriver().findElement(By.name("email")).sendKeys(String.format("%s@user.com", name));
        baseTest.getDriver().findElement(By.name("Submit")).click();
    }


    public static void createItem(BaseTest baseTest, String name, String itemClassName) {

        baseTest.getDriver().findElement(By.cssSelector("#side-panel > div > div")).click();
        getWait15(baseTest).until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        baseTest.getDriver().findElement(By.className(itemClassName)).click();
        baseTest.getDriver().findElement(By.id("ok-button")).click();
    }

    public static void returnToDashBoard(BaseTest baseTest) {

        baseTest.getDriver().findElement(By.cssSelector("a[href = '/']")).click();
    }

    public static  void createItemAndReturnToDashboard(BaseTest baseTest, String name, String itemClassName) {

        createItem(baseTest, name, itemClassName);
        returnToDashBoard(baseTest);
    }

    public static String asURL(String str) {
        return URLEncoder.encode(str.trim(), StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20")
                .replaceAll("%21", "!")
                .replaceAll("%27", "'")
                .replaceAll("%28", "(")
                .replaceAll("%29", ")")
                .replaceAll("%7E", "~");
    }

    public static void openItemByNameClickInCurrentView(BaseTest baseTest, String name) {
        Point item_left_upper_corner = getWait15(baseTest).until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name))))).getLocation();

        new Actions(baseTest.getDriver())
                .moveToLocation(item_left_upper_corner.getX(), item_left_upper_corner.getY())
                .click()
                .perform();
    }

    public static void sidePanelDoDelete(BaseTest baseTest, String name) {

        openItemByNameClickInCurrentView(baseTest, name);

        baseTest.getDriver().findElement(SIDE_PANEL_DELETE).click();
        getWait15(baseTest).until(ExpectedConditions.elementToBeClickable(DIALOG_DEFAULT_BUTTON)).click();
    }

    public static void openElementDropdown(BaseTest baseTest, WebElement element) {

        WebElement chevron = element.findElement(By.className("jenkins-menu-dropdown-chevron"));

        ((JavascriptExecutor) baseTest.getDriver()).executeScript("arguments[0].dispatchEvent(new Event('mouseenter'));", chevron);
        ((JavascriptExecutor) baseTest.getDriver()).executeScript("arguments[0].dispatchEvent(new Event('click'));", chevron);
    }

    public static void dropdownDoDelete(BaseTest baseTest, String name) {

        openElementDropdown(baseTest, baseTest.getDriver().findElement(
                By.cssSelector(String.format("td a[href = 'job/%s/']", asURL(name)))));

        baseTest.getDriver().findElement(DROPDOWN_DELETE).click();
        getWait15(baseTest).until(ExpectedConditions.elementToBeClickable(DIALOG_DEFAULT_BUTTON)).click();
    }

    public static class View {
        public static final String MY_VIEW = "hudson.model.MyView";
        public static final String LIST_VIEW = "hudson.model.ListView";

    }

    public static void createView(BaseTest baseTest, String viewName, String viewType) {
        baseTest.getDriver().findElement(By.className("addTab")).click();
        baseTest.getDriver().findElement(By.id("name")).sendKeys(viewName);
        baseTest.getDriver().findElement(By.cssSelector(String.format("[for = '%s']", viewType))).click();
        baseTest.getDriver().findElement(By.id("ok")).click();
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
    }
}
