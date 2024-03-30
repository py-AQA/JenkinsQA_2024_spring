package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

import static org.openqa.selenium.By.className;

public class LegionOfJavaGroupTest extends BaseTest {

    @Test
    public void testFerosorSearch() throws InterruptedException {


        try {
            getDriver().get("https://ferosor.cl");
            Thread.sleep(1000);
            WebElement textBox =  getDriver().findElement(By.name("s"));
            textBox.sendKeys("alimento");
            getDriver().findElement(By.cssSelector("[type='submit']")).click();
            Thread.sleep(1000);
            getDriver().get("https://ferosor.cl/jardin-y-mascotas/262-alimento-para-perro-cachorro-fit-formula-saco-10-kg-130622000123.html");
            String result = String.valueOf( getDriver().findElement(By.className("h1")).getText());
            Assert.assertEquals(result, "Alimento para Perro cachorro FIT FORMULA Saco 10 kg");
        } finally {
            getDriver().quit();
        }
    }
    @Test
    public void testFerosorLogin() {

        try{
            getDriver().get("https://ferosor.cl");
            getDriver().findElement(className("login")).click();
            WebElement email =  getDriver().findElement(By.className("form-control"));
            email.sendKeys("test@test.com");
            WebElement password =  getDriver().findElement(By.className("js-child-focus"));
            password.sendKeys("12345");
            getDriver().findElement(By.id("submit-login")).click();
            String result = String.valueOf( getDriver().findElement(By.className("page-header")).getText());
            Assert.assertEquals(result, "Su cuenta");
        }finally{
            getDriver().quit();
        }
    }

    @Ignore
    @Test
    public void searchTest() {

        getDriver().get("https://www.amazon.com");

        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement searchBox = getDriver().findElement(By.id("twotabsearchtextbox"));
        WebElement submitButton = getDriver().findElement(By.id("nav-search-submit-button"));

        searchBox.sendKeys("RaisedGardenBeds");
        submitButton.click();

        WebElement message = getDriver().findElement(By.xpath("//div[@class='a-sectiona-spacing-smalla-spacing-top-small']"));
        String value = message.getText();
        String[] arr = value.split("\"");
        Assert.assertEquals(arr[1], "RaisedGardenBeds");

    }
    @Test
    public void testFindElement(){
        getDriver().get("https://www.w3schools.com/");

        WebElement textBox=getDriver().findElement(By.id("search2"));
        textBox.sendKeys("Java Tutorial");
        WebElement button=getDriver().findElement(By.id("learntocode_searchbtn"));
        button.click();
        WebElement text=getDriver().findElement(By.xpath("//*[@id=\"leftmenuinnerinner\"]/a[1]"));

        Assert.assertEquals(text.getText(),"Java HOME");
    }

}
