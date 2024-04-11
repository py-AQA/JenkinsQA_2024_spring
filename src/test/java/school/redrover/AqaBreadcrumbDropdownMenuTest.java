package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AqaBreadcrumbDropdownMenuTest extends AqaBaseTest{

    @Test
    public void testBreadcrumbDropdownMenu() {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath("//a[contains (text(), 'Dashboard')]")))
                .perform();

        openElementDropdown(getDriver().findElement(By.xpath("//a[contains (text(), 'Dashboard')]")));
//        getWait15().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=\"breadcrumbBar\"] button"))).click();

        Set<String> words = new HashSet<>();
        List<WebElement> lst = getDriver().findElements(By.className("jenkins-dropdown__item"));
        for (WebElement element : lst) {
            words.add(element.getText());
        }

        Set<String> menu = new HashSet<>(Set.of("New Item", "People", "Build History", "Manage Jenkins", "My Views"));

        Assert.assertEquals(words, menu);
    }
}
