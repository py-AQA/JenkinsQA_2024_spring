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

//    protected void deleteItem(String name) {
//        if (!getDriver().findElements(By.cssSelector(String.format("a[href = 'job/%s/']", name))).isEmpty()) {
//            new Actions(getDriver())
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("a[href = 'job/%s/']", name))))
//                    .pause(1000)
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("button[data-href = 'http://localhost:8080/job/%s/']", name))))
//                    .click()
//                    .perform();
//
//            getDriver().findElement(By.cssSelector(String.format("button[href='/job/%s/doDelete']", name))).click();
//            getDriver().findElement(By.className("jenkins-button--primary")).click();
//        }
//    }

//    protected void deleteItem(String name) throws InterruptedException {
//        if (!getDriver().findElements(By.cssSelector(String.format("a[href = 'job/%s/']", name))).isEmpty()) {
//
//            getDriver().findElement(By.cssSelector(String.format("a[href = 'job/%s/']", name))).click();
//            Thread.sleep(3000);
//            getDriver().findElement(By.cssSelector(String.format("a[href = 'job/%s/']", name))).click();
//            getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
//
//            getDriver().findElement(By.className("jenkins-button--primary")).click();
//        }
//    }

    protected void deleteItem(String name) {

        if (!getDriver().findElements(By.cssSelector(String.format("a[href = 'job/%s/']", name))).isEmpty()) {
            WebElement a = getDriver().findElement(By.cssSelector(String.format("a[href = 'job/%s/']", name)));
            Point b = a.getLocation();

            new Actions(getDriver())
                    .moveToLocation(b.getX(), b.getY())
                    .click()
                    .perform();

//            new Actions(getDriver()).moveToElement(getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name)))).contextClick().perform();
            getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
//            new Actions(getDriver()).pause(5000).perform();
            getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("dialog .jenkins-button--primary"))).click();
//            new Actions(getDriver()).moveToElement(getDriver().findElement(By.className("jenkins-button--primary"))).contextClick().perform();
//            new Actions(getDriver()).pause(5000).perform();
        }
    }

//    protected void deleteItem(String name) {
//        if (!getDriver().findElements(By.cssSelector(String.format("a[href = 'job/%s/']", name))).isEmpty()) {
//            new Actions(getDriver())
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("a[href = 'job/%s/']", name))))
//                    .doubleClick()
//                    .pause(1000)
//                    .perform();
//
//            getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
//            getDriver().findElement(By.className("jenkins-button--primary")).click();
//        }
//    }

    protected void renameItem(String name, String rename) {

        new Actions(getDriver())
                .moveToElement(getDriver().findElement(
                        By.cssSelector(String.format("a[href = 'job/%s/']", name))))
                .pause(1000)
                .moveToElement(getDriver().findElement(
                        By.cssSelector(String.format("button[data-href $= '/job/%s/']", name))))
                .click()
                .perform();

        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/confirm-rename']", name)))).click();
        getDriver().findElement(By.className("jenkins-input")).clear();
        getDriver().findElement(By.className("jenkins-input")).sendKeys(rename);
        getDriver().findElement(By.name("Submit")).click();
    }

    protected void openItem(String name) {

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

    @DataProvider(name = "itemsProvider")
    public Object[][] itemsProvider() {

        return new Object[][]{
                {"Freestyle project", Item.FREESTYLE_PROJECT},
                {"Pipeline", Item.PIPELINE},
                {"Multi-configuration project", Item.MULTI_CONFIGURATION_PROJECT},
                {"Folder", Item.FOLDER},
                {"Multibranch pipeline", Item.MULTI_BRANCH_PIPELINE},
                {"Organization folder", Item.ORGANIZATION_FOLDER},
        };
    }

    protected String asURL(String str) {

        return str.replace(" ", "%20");
    }
}