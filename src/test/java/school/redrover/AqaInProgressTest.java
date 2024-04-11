package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AqaInProgressTest extends AqaBaseTest {

//TODO rename item - fix and move to BaseClass

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

    private void renameItem1(String name, String rename) {

        openItemByNameClickInCurrentView(name);

        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/confirm-rename']", name)))).click();
        getDriver().findElement(By.className("jenkins-input")).clear();
        getDriver().findElement(By.className("jenkins-input")).sendKeys(rename);
        getDriver().findElement(By.name("Submit")).click();
    }

    private void renameItem2(String name, String rename) {

        new Actions(getDriver())
                .moveToElement(getDriver().findElement(
                        By.cssSelector(String.format("td a[href = 'job/%s/']", name))))
                .pause(500)
                .moveToElement(getDriver().findElement(
                        By.cssSelector(String.format("button[data-href $= '/job/%s/']", name))))
                .click()
                .perform();

        new Actions(getDriver())
                .moveToElement(getDriver().findElement(
                        By.cssSelector(String.format("a[href = '/job/%s/confirm-rename']", name))))
                .click()
                .perform();

        sleep(60);
        getWait15().until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='/job/%s/confirm-rename']", name)))).click();
        getDriver().findElement(By.className("jenkins-input")).clear();
        getDriver().findElement(By.className("jenkins-input")).sendKeys(rename);
        getDriver().findElement(By.name("Submit")).click();
    }
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
    public void testRenameItem() {
        final String initial_name = "org_folder";
        final String final_name = "Renamed1";

        createItemAndReturnToDashboard(initial_name, Item.ORGANIZATION_FOLDER);

        renameItem(initial_name, final_name);

        Assert.assertTrue(getDriver().findElement(By.tagName("h1")).getText().contains(final_name));
    }



//TODO make it work well
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



    @Ignore
    @Test
    public void testChangeLanguage1() {
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
