package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AqaNewJenkinsTest extends AqaBaseTest{

    private static class Item {
        public static final String FREESTYLE_PROJECT = "hudson_model_FreeStyleProject";
        public static final String PIPELINE = "org_jenkinsci_plugins_workflow_job_WorkflowJob";
        public static final String MULTI_CONFIGURATION_PROJECT = "hudson_matrix_MatrixProject";
        public static final String FOLDER = "com_cloudbees_hudson_plugins_folder_Folder";
        public static final String MULTI_BRANCH_PROJECT = "org_jenkinsci_plugins_workflow_multibranch_WorkflowMultiBranchProject";
        public static final String ORGANIZATION_FOLDER = "jenkins_branch_OrganizationFolder";
    }

    private void sleep(long seconds) {
        new Actions(getDriver()).pause(seconds * 1000).perform();
    }

    private void login() {
        getDriver().get("http://localhost:8080/login");

        getDriver().findElement(By.id("j_username")).sendKeys("admin");
        getDriver().findElement(By.id("j_password")).sendKeys("admin");
        getDriver().findElement(By.name("Submit")).click();
    }

    private void createItem(String name, String itemClassName) {
        getDriver().findElement(By.cssSelector("#side-panel > div > div")).click();
        getWait15().until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).sendKeys(name);
        getDriver().findElement(By.className(itemClassName)).click();
        getDriver().findElement(By.id("ok-button")).click();
    }

    private void createItemAndReturnToDashboard(String name, String itemClassName) {
        createItem(name, itemClassName);
        returnToDashBoard();
    }

//    private void deleteItem(String name) {
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

//    private void deleteItem(String name) throws InterruptedException {
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

    private void deleteItem(String name) {
        clickItemNameInCurrentView(name);

//            new Actions(getDriver()).moveToElement(getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name)))).contextClick().perform();
        getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
//            new Actions(getDriver()).pause(5000).perform();
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("dialog .jenkins-button--primary"))).click();
//            new Actions(getDriver()).moveToElement(getDriver().findElement(By.className("jenkins-button--primary"))).contextClick().perform();
//            new Actions(getDriver()).pause(5000).perform();

    }

//    private void deleteItem(String name) {
//        if (!getDriver().findElements(By.cssSelector(String.format("td a[href = 'job/%s/']", name))).isEmpty()) {
//            new Actions(getDriver())
//                    .moveToElement(getDriver().findElement(
//                            By.cssSelector(String.format("td a[href = 'job/%s/']", name))))
//                    .doubleClick()
//                    .pause(1000)
//                    .perform();
//
//            getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
//            getDriver().findElement(By.className("jenkins-button--primary")).click();
//        }
//    }

    private void returnToDashBoard() {
        getDriver().findElement(By.cssSelector("a[href = '/']")).click();
    }

    @Test
    public void testAuthJenkins() {
        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href = '/logout']")).isDisplayed());
    }

    @Test
    public void testLogoutJenkins() {
        getDriver().findElement(By.cssSelector("a[href = '/logout']")).click();

        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Sign in to Jenkins");
    }

    @Test
    public void testNewItemJenkins() {

        createItemAndReturnToDashboard("FP", Item.FREESTYLE_PROJECT);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/FP/']")).isDisplayed());
    }

    @Test
    public void testCreateMultiConfigurationProject() {

        createItemAndReturnToDashboard("MCP", Item.MULTI_CONFIGURATION_PROJECT);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/MCP/']")).isDisplayed());
    }

    @Test
    public void testAddDescription() {

        createItem("MCP", Item.MULTI_CONFIGURATION_PROJECT);
        getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name = 'description']"))).sendKeys("xxx");;
        getDriver().findElement(By.xpath("//button[@formnovalidate = 'formNoValidate']")).click();
        Assert.assertTrue(getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#description"))).getText().startsWith("xxx"));
    }

    @Test
    public void testPeople() {

        getDriver().findElement(By.xpath("//a[@href='/asynchPeople/']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='jenkins-app-bar__content']")).getText(), "People");
    }

    @Test
    public void testTitleJenkins() {

        Assert.assertEquals(getDriver().findElement(By.cssSelector("div h1")).getText(), "Welcome to Jenkins!");
    }

    @Test
    public void testNewFolder() {

        createItemAndReturnToDashboard("Folder", Item.FOLDER);

        Assert.assertTrue(getDriver().findElement(By.cssSelector("td a[href = 'job/Folder/']")).isDisplayed());
    }


    private void openItem(String name) {

        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("td a[href = 'job/%s/']", name)))).click();
    }


    @Test
    public void testMoveItemToFolder() {

        createItemAndReturnToDashboard("newFolder", Item.FOLDER);

        createItemAndReturnToDashboard("Folder1", Item.FOLDER);

        openItem("newFolder");
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '/job/newFolder/move']"))).click();
        new Select(getDriver().findElement(By.name("destination"))).selectByValue("/Folder1");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertTrue(getDriver().findElement(By.id("breadcrumbBar")).getText().contains("Folder1"));
    }

    @Test
    public void testRenameFolder() {

        createItemAndReturnToDashboard("newFolder", Item.FOLDER);

        openItem("newFolder");
        getDriver().findElement(By.cssSelector("a[href='/job/newFolder/confirm-rename']")).click();
        WebElement name = getDriver().findElement(By.name("newName"));
        name.clear();
        name.sendKeys("renameFolder");
        getDriver().findElement(By.name("Submit")).click();

        Assert.assertEquals(
                getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#main-panel h1"))).getText(),
                "renameFolder");
    }

    private void clickItemNameInCurrentView(String name) {
        Point item_left_upper_corner = getWait15().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(String.format("td a[href = 'job/%s/']", name)))).getLocation();

        new Actions(getDriver())
                .moveToLocation(item_left_upper_corner.getX(), item_left_upper_corner.getY())
                .click()
                .perform();
    }

    private void renameItem(String name, String rename) {

          clickItemNameInCurrentView(name);

//        new Actions(getDriver())
//                .moveToElement(getDriver().findElement(
//                        By.cssSelector(String.format("td a[href = 'job/%s/']", name))))
//                .pause(500)
//                .moveToElement(getDriver().findElement(
//                        By.cssSelector(String.format("button[data-href $= '/job/%s/']", name))))
//                .click()
//                .perform();
//
//        new Actions(getDriver())
//                .moveToElement(getDriver().findElement(
//                        By.cssSelector(String.format("a[href = '/job/%s/confirm-rename']", name))))
//                .click()
//                .perform();

//        sleep(60);
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/confirm-rename']", name)))).click();
        getDriver().findElement(By.className("jenkins-input")).clear();
        getDriver().findElement(By.className("jenkins-input")).sendKeys(rename);
        getDriver().findElement(By.name("Submit")).click();
    }

    @Test
    public void testRenameItem() {

        createItemAndReturnToDashboard("org_folder", Item.ORGANIZATION_FOLDER);

        renameItem("org_folder", "Renamed1");

        Assert.assertTrue(getDriver().findElement(By.tagName("h1")).getText().contains("Renamed1"));
    }


//    @DataProvider(name = "itemsProvider")
//    public Object[][] itemsProvider() {
//        return new Object[][]{
//                {"Folder_project", Item.FOLDER},
//                {"Organization_folder", Item.ORGANIZATION_FOLDER},
//                {"Multi_configuration_project", Item.MULTI_CONFIGURATION_PROJECT},
//                {"Freestyle_project", Item.FREESTYLE_PROJECT},
//                {"Multibranch_project", Item.MULTI_BRANCH_PROJECT},
//                {"Pipeline_project", Item.PIPELINE},
//        };
//    }
    @DataProvider(name = "itemsProvider")
    public Object[][] itemsProvider() {
        return new Object[][]{
                {"Name1", Item.FOLDER},
                {"Name2", Item.ORGANIZATION_FOLDER},
                {"Name3", Item.MULTI_CONFIGURATION_PROJECT},
                {"Name4", Item.FREESTYLE_PROJECT},
                {"Name5", Item.MULTI_BRANCH_PROJECT},
                {"Name6", Item.PIPELINE},
        };
    }


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

    @Ignore
    @Test
    public void testChangeLanguage() {
        getDriver().findElement(By.cssSelector("a[href = '/manage']")).click();
        getDriver().findElement(By.cssSelector("a[href = 'configure']")).click();
        WebElement l = getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.name("_.systemLocale")));
        ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].scrollIntoView(true);", l);
        l.sendKeys("ru");
        getDriver().findElement(By.cssSelector("[name = '_.ignoreAcceptLanguage']~label")).click();
        WebElement submit = getDriver().findElement(By.className("jenkins-button--primary"));
        ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].scrollIntoView(true);", submit);
        submit.click();

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href='/manage/']")).getText().contains("Настроить Jenkins"));
//        getDriver().findElement(By.cssSelector("a[href = 'pluginManager']")).click();
//        getDriver().findElement(By.id("filter-box")).sendKeys("Locale" + Keys.ENTER);
    }
}

