package school.redrover;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalsQATest {

    @Test
    public void testCreateUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement managerButton = driver.findElement(By.xpath("//button[@ng-click='manager()']"));
        managerButton.click();

        WebElement addCustomerButton = driver.findElement(
            By.xpath("//button[@ng-click='addCust()']"));
        addCustomerButton.click();

        WebElement boxFNText = driver.findElement(By.xpath("//input[@ng-model='fName']"));
        boxFNText.sendKeys("testPV");

        WebElement boxLNText = driver.findElement(By.xpath("//input[@ng-model='lName']"));
        boxLNText.sendKeys("testPV");

        WebElement boxPCText = driver.findElement(By.xpath("//input[@ng-model='postCd']"));
        boxPCText.sendKeys("220000");

        WebElement addCustomerSubmitButton = driver.findElement(
            By.xpath("//button[@type='submit']"));
        addCustomerSubmitButton.click();

        driver.switchTo().alert().accept();

        WebElement goCustomersButton = driver.findElement(
            By.xpath("//button[@ng-click='showCust()']"));
        goCustomersButton.click();

        WebElement searchInput = driver.findElement(
            By.xpath("//input[@ng-model='searchCustomer']"));
        searchInput.sendKeys("testPV");

        WebElement searchResultsTable = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        String searchResultsSTR = searchResultsTable.getText();
        Assert.assertEquals(searchResultsSTR, "testPV");

        driver.quit();
    }
}