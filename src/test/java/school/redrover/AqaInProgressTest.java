package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AqaInProgressTest extends AqaBaseTest {

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


    //
//    private void renameItem(String name, String rename) {
//
//          clickItemNameInCurrentView(name);
//
////        new Actions(getDriver())
////                .moveToElement(getDriver().findElement(
////                        By.cssSelector(String.format("td a[href = 'job/%s/']", name))))
////                .pause(500)
////                .moveToElement(getDriver().findElement(
////                        By.cssSelector(String.format("button[data-href $= '/job/%s/']", name))))
////                .click()
////                .perform();
////
////        new Actions(getDriver())
////                .moveToElement(getDriver().findElement(
////                        By.cssSelector(String.format("a[href = '/job/%s/confirm-rename']", name))))
////                .click()
////                .perform();
//
////        sleep(60);
//        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/confirm-rename']", name)))).click();
//        getDriver().findElement(By.className("jenkins-input")).clear();
//        getDriver().findElement(By.className("jenkins-input")).sendKeys(rename);
//        getDriver().findElement(By.name("Submit")).click();
//    }
    @Ignore
    @Test
    public void testChangeLanguage() {
        getDriver().findElement(By.cssSelector("a[href = '/manage']")).click();
        getDriver().findElement(By.cssSelector("a[href = 'configure']")).click();
        WebElement l = getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.name("_.systemLocale")));
        ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].scrollIntoView(true);", l);
        l.sendKeys("ru");
        getDriver().findElement(By.cssSelector("[name = '_.ignoreAcceptLanguage']~label")).click();
        WebElement submit = getDriver().findElement(By.className("jenkins-button--primary"));
        ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].scrollIntoView(true);", submit);
        submit.click();

        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href='/manage/']")).getText().contains("Настроить Jenkins"));
//        getDriver().findElement(By.cssSelector("a[href = 'pluginManager']")).click();
//        getDriver().findElement(By.id("filter-box")).sendKeys("Locale" + Keys.ENTER);
    }
    //    private void createItem(String name, String itemClassName) {
//        getDriver().findElement(By.cssSelector("#side-panel > div > div")).click();
//        getWait15().until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).sendKeys(name);
//        getDriver().findElement(By.className(itemClassName)).click();
//        getDriver().findElement(By.id("ok-button")).click();
//    }
//
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

//    private void returnToDashBoard() {
//        getDriver().findElement(By.cssSelector("a[href = '/']")).click();
//    }

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

//    private void deleteItem(String name) {
//        clickItemNameInCurrentView(name);
//
////            new Actions(getDriver()).moveToElement(getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name)))).contextClick().perform();
//        getDriver().findElement(By.cssSelector(String.format("[data-url='/job/%s/doDelete']", name))).click();
////            new Actions(getDriver()).pause(5000).perform();
//        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector("dialog .jenkins-button--primary"))).click();
////            new Actions(getDriver()).moveToElement(getDriver().findElement(By.className("jenkins-button--primary"))).contextClick().perform();
////            new Actions(getDriver()).pause(5000).perform();
//
//    }

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

//    private void returnToDashBoard() {
//        getDriver().findElement(By.cssSelector("a[href = '/']")).click();
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

    @Ignore
    @Test
    public void testRenameItem() {
        final String initial_name = "org_folder";
        final String final_name = "Renamed1";

        createItemAndReturnToDashboard(initial_name, Item.ORGANIZATION_FOLDER);

        renameItem(initial_name, final_name);

        Assert.assertTrue(getDriver().findElement(By.tagName("h1")).getText().contains(final_name));
    }

    protected void deleteItemWORKING(String name) {

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
}
