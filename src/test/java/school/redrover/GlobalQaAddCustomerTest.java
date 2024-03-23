package school.redrover;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalQaAddCustomerTest {

    @Test
    public void testCreateUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // https://comaqa.gitbook.io/selenium-webdriver-lectures/selenium-webdriver.-vvedenie/ozhidaniya
//        WebElement header = driver.findElement(By.xpath("//strong"));
//        String headerStr = header.getText();
//        Assert.assertEquals("XYZ Bank", headerStr);

        WebElement managerButton = driver.findElement(By.xpath("//div[2]/button"));
        managerButton.click();
        // перешли на https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager

        WebElement addCustomerButton = driver.findElement(
            By.xpath("//div[2]/div/div[1]/button[1]"));
        addCustomerButton.click();

        WebElement boxFNText = driver.findElement(By.xpath("//div[1]/input"));
        boxFNText.sendKeys("testPV");

        WebElement boxLNText = driver.findElement(By.xpath("//div[2]/input"));
        boxLNText.sendKeys("testPV");

        WebElement boxPCText = driver.findElement(By.xpath("//div[3]/input"));
        boxPCText.sendKeys("220000");

        WebElement addCustomerSubmitButton = driver.findElement(By.xpath("//form/button"));
        addCustomerSubmitButton.click();

        //закончили заполнять и отправили запрос
//        String strAlertSuccess = driver.switchTo().alert().getText();
//        Assert.assertEquals("Customer added successfully with customer id :6", strAlertSuccess);
        driver.switchTo().alert().accept();
        // проверили алерт и закрыли алерт успеха

        WebElement goCustomersButton = driver.findElement(By.xpath("//button[3]"));
        goCustomersButton.click();

        WebElement searchInput = driver.findElement(By.xpath("//form/div/div/input"));
        searchInput.sendKeys("testPV");
        //нестабильно отрабатывает, когда-нибудь в будущем попробовать стабилизировать

        WebElement searchResultsTable = driver.findElement(By.xpath("//tbody/tr/td[1]"));
        String searchResultsSTR = searchResultsTable.getText();
        Assert.assertEquals(searchResultsSTR, "testPV");

        WebElement deleteButton = driver.findElement(By.xpath("//tr/td[5]/button"));
        deleteButton.click();
        //запись удалена
        driver.quit();
    }
}
