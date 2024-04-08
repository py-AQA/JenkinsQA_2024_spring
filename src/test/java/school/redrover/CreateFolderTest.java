package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class CreateFolderTest extends BaseTest {
    @Test
    public void testCreateFolder(){
        String firstFolderName = "FirstFolder";
        String innerFolderName = "InnerFolder";
        String anotherFolderName = "AnotherInnerFolder";

        createFolder(firstFolderName);

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), firstFolderName);
        Assert.assertTrue(getLinkToFolder(firstFolderName).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.className("empty-state-section")).isDisplayed());

        createFolder(innerFolderName);
        getLinkToFolder(firstFolderName).click();
        createFolder(anotherFolderName);
        getLinkToFolder(firstFolderName).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), firstFolderName);
        Assert.assertTrue(getLinkToFolder(innerFolderName).isDisplayed());
        Assert.assertTrue(getLinkToFolder(anotherFolderName).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//a[.='New Item']")).isDisplayed());
    }

    private void createFolder(String name){
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        getDriver().findElement(By.id("name")).sendKeys(name);
        getDriver().findElement(By.className("com_cloudbees_hudson_plugins_folder_Folder")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
    }

    private WebElement getLinkToFolder(String folderName){
        return getDriver().findElement(By.xpath("//a[.='" + folderName + "']"));
    }
}
