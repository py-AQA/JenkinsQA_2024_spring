package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ParabankLoginNonexistentUser {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();

            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            driver.getTitle();

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement usernameField = driver.findElement(By.name("username"));
            usernameField.sendKeys("testUser");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("testPassword");

            WebElement submitButton = driver.findElement(By.cssSelector("input.button"));
            submitButton.click();

            WebElement message = driver.findElement(By.cssSelector("p.error"));
            String actualErrorMessage = message.getText();
            String expectedErrorMessage = "The username and password could not be verified.";

            // Check if the actual error message matches the expected one
            if (actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Error message is as expected: " + actualErrorMessage);
            } else {
                System.out.println("Error message is not as expected.");
                System.out.println("Actual error message: " + actualErrorMessage);
            }

            driver.quit();
        }
    }

