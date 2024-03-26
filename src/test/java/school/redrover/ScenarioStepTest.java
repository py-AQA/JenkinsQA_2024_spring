package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import school.redrover.model.StepExecution;
import school.redrover.model.StepTuple;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static school.redrover.model.StepFactory.execute;
import static school.redrover.model.StepLocator.aHoliday;
import static school.redrover.model.StepLocator.certificateCard;
import static school.redrover.model.StepLocator.dropId;
import static school.redrover.model.StepLocator.h2Tag;
import static school.redrover.model.StepLocator.listId;
import static school.redrover.model.StepLocator.searchInput;

public class ScenarioStepTest {

    private WebDriver driver;

    private static final String url = "https://gift-store-certificate.netlify.app/";

    @BeforeClass
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGiftShopFilterHolidayByDay() {
        driver.manage().window().maximize();
        driver.get(url);

        int expected = 2;
        String value = "Book";
        By dropdown = By.id(dropId);
        By holiday = By.xpath(aHoliday);
        By input = By.xpath(searchInput);

        Queue<StepTuple> tuples = new LinkedList<>();

        tuples.add(new StepTuple(input, StepExecution.SEND));
        tuples.add(new StepTuple(input, StepExecution.SLEEP));
        tuples.add(new StepTuple(dropdown, StepExecution.CLICK));
        tuples.add(new StepTuple(holiday, StepExecution.CLICK));

        executeScenario(tuples, value);

        List<WebElement> certificates = getWebElements();
        Assert.assertEquals(certificates.size(), expected);

        for (WebElement certificate : certificates) {
            assertContainsText(certificate, value);
        }
    }

    private void executeScenario(
            Queue<StepTuple> tuples, String value) {
        StepTuple tuple;
        while (!tuples.isEmpty()) {
            tuple = tuples.poll();
            execute(driver.findElement(tuple.by()), tuple.step(), value);
        }
    }

    private static void assertContainsText(
            WebElement certificate, String value) {
        String h2Text = certificate.findElement(By.tagName(h2Tag)).getText();
        Assert.assertTrue(h2Text.contains(value));
    }

    private List<WebElement> getWebElements() {
        WebElement list = driver.findElement(By.id(listId));
        return list.findElements(By.xpath(certificateCard));
    }
}
