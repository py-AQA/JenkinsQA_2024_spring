package school.redrover;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;

public class GroupLearnForWinAK2024 {
    String login = "academic198405@gmail.com";
    String myAccount = "[aria-label='person']";
    String password = "StateOf2024!";

    @Test
    public void testVisiableSupercaliberSLR98() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));


        driver.get("https://www.trekbikes.com/us/en_US/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(myAccount)).click();
        driver.findElement(By.cssSelector("span[data-v-27f1dc12]")).click();
        driver.findElement(By.id("j_username")).sendKeys(login);
        driver.findElement(By.id("j_password")).sendKeys(password);
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        driver.findElement(By.cssSelector(myAccount)).click();



        driver.findElement(By.xpath("//span[@data-v-27f1dc12='' and normalize-space(text())='My account']")).click();
        System.out.println(10);
//        driver.findElement(By.id("nav-link-'viewBikesMountainCategoryAll-large")).click();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//div[@id='layout']//button[@aria-label='Close Modal']"));
        actions.moveToElement(element).click().perform();
    }


    @Test
    public void testVisiableSupercaliberSLR982() throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));


        driver.get("https://www.trekbikes.com/us/en_US/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(myAccount)).click();
        driver.findElement(By.cssSelector("span[data-v-27f1dc12]")).click();
        driver.findElement(By.id("j_username")).sendKeys(login);
        driver.findElement(By.id("j_password")).sendKeys(password);
        driver.findElement(By.xpath("//span[text()='Log in']")).click();


        driver.findElement(By.xpath("//a[@id='expandMountainBikesMainMenu-large']")).click();
        driver.findElement(By.xpath("(//span[text()='Shop all mountain bikes'])[2]")).click();

        Robot robot = new Robot();
        // Задержка перед началом движения мыши
        TimeUnit.SECONDS.sleep(1);
        // Получаем размеры экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Двигаем мышь к центру экрана
        int centerX = 1160;
        int centerY = 580;
        robot.mouseMove(centerX, centerY);

        // Задержка после движения мыши
        TimeUnit.SECONDS.sleep(1);


        // Выполняем клик левой кнопкой мыши в указанной точке
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        WebElement element = driver.findElement(By.xpath("//h3[contains(text(), 'Fuel EXe 8 GX AXS T-Type')]"));
//        String fuelExeText = element.getText();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        int subm = element.getLocation().getY();
//        for (int i = 0; i < subm; i += 20) {
//            js.executeScript("window.scrollTo(0, " + i + ")");
//            Thread.sleep(50);
//        }
        WebElement element = driver.findElement(By.xpath("//h3[contains(text(), 'Fuel EXe 8 GX AXS T-Type')]"));
        String fuelExeText = element.getText();
        JavascriptExecutor js = (JavascriptExecutor) driver;

// Прокручиваем страницу до того, чтобы элемент был виден на экране
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", element);
        Assert.assertEquals(fuelExeText, "Fuel EXe 8 GX AXS T-Type");
        driver.quit();





    }


}

