package school.redrover.model;

import org.openqa.selenium.WebElement;

public class StepFactory {

    public static String execute(
            WebElement element,
            StepExecution step,
            String text) {
        return switch (step) {
            case CLICK -> {
                element.click();
                yield null;
            }
            case SEND -> {
                element.clear();
                element.sendKeys(text);
                yield null;
            }
            case ATTRIBUTE -> element.getAttribute("value");
            case TEXT -> element.getText();
            case SLEEP -> waiting();
        };
    }

    private static String waiting() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
        }
        return null;
    }
}
