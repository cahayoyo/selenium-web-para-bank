package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Helper {
    public static void verifyElementContainsText(WebElement element, String expectedText, String elementName) {
        try {
            if (element.isDisplayed() && element.getText().contains(expectedText)) {
                Log.info("[PASS] " + elementName + " contains correct info.");
            } else {
                Log.error("[FAIL] " + elementName + " does not contain: " + expectedText + " Actual : " + element.getText());
            }
        } catch (Exception e) {
            Log.error("[FAIL] " + elementName + " error: " + e.getMessage());
        }
    }

    public static void verifyElementEqualsText(SoftAssert softAssert, WebElement element, String expectedText, String elementName) {
        try {
            String actual = element.getText();

            if(element.getTagName().equals("input") &&
                    (element.getAttribute("type").equals("submit") ||
                            element.getAttribute("type").equals("button"))){
                actual = element.getAttribute("value");
            }else{
                actual = element.getText();
            }

            softAssert.assertEquals(actual.trim(), expectedText, elementName + " mismatch!");

            if (actual.trim().equals(expectedText)) {
                Log.info("[PASS] " + elementName + " is correct.");
            } else {
                Log.error("[FAILED] " + elementName + " is incorrect. Actual : " + actual);
            }
        }catch(Exception e) {
            Log.error("[FAIL] " + elementName + " not found or error: " + e.getMessage());
        }

    }

    public static void verifyElementDisplayed(WebElement element, String elementName) {
        try {
            if (element.isDisplayed()) {
                Log.info("[PASS] " + elementName + " is displayed.");
            } else {
                Log.error("[FAIL] " + elementName + " is NOT displayed.");
            }
        } catch (Exception e) {
            Log.error("[FAIL] " + elementName + " not found or error: " + e.getMessage());
        }
    }

    public static void verifyElementEnabled(WebElement element, String elementName) {
        try {
            if (element.isEnabled()) {
                Log.info("[PASS] " + elementName + " is enabled.");
            } else {
                Log.error("[FAIL] " + elementName + " is NOT enabled.");
            }
        } catch (Exception e) {
            Log.error("[FAIL] " + elementName + " not found or error: " + e.getMessage());
        }
    }

    public static void verifyEqualsUrl(SoftAssert softAssert, WebDriver driver, String expectedUrl, String platformName) {
        try {
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, platformName + " mismatch!");

            if (actualUrl.equals(expectedUrl)) {
                Log.info("[PASS] - Redirected to " + platformName + ".");
            } else {
                Log.error("[FAIL] - Not redirected to " + platformName + ".");
                Log.error("Actual URL   : " + actualUrl);
                Log.error("Expected URL : " + expectedUrl);
            }
        }catch(Exception e) {
            Log.error("[FAIL] - Error while verifying URL for " + platformName + ": " + e.getMessage());
        }

    }

    public static void verifyContainsUrl(WebDriver driver, String expectedUrl, String platformName) {
        try {
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl)) {
                Log.info("[PASS] - Redirected to " + platformName + ".");
            } else {
                Log.error("[FAIL] - Not redirected to " + platformName + ".");
                Log.error("Actual URL   : " + actualUrl);
                Log.error("Expected URL Contains : " + expectedUrl);
            }
        }catch(Exception e) {
            Log.error("[FAIL] - Error while verifying URL for " + platformName + ": " + e.getMessage());
        }
    }

    public static void verifyValidationMessage(WebElement element, String expected, String elementName) {
        try {
            String actual = element.getAttribute("validationMessage");
            if (actual.contains(expected)) {
                Log.info("[PASS] " + elementName + " validation: " + expected);
            } else {
                Log.error("[FAIL] " + elementName + " validation mismatch. Actual: " + actual);
            }
        } catch (Exception e) {
            Log.error("[FAIL] Validation check failed on " + elementName);
        }
    }

    // Wait Helper
    public static void waitUrlContains(WebDriver driver, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlContains(text));
    }

    public static void waitVisible(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitClickable(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void handleTestFailure(WebDriver driver, ExtentTest test,
                                         String testName, Exception e) {

        ExtentReportManager.addScreenshot(driver, testName + "_Failed");

        if (test != null) {
            test.fail(testName + " - FAILED");
        }

        Log.error(testName + " FAILED: " + e.getMessage());

        // Throw lagi agar TestNG tahu test gagal
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        } else {
            throw new RuntimeException(e);
        }
    }
}
