package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utils.Config;
import utils.ExtentReportManager;
import utils.Helper;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void TC_02_01_01_AccessLoginFormFromHomePage() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);   // meskipun form di home, kita tetap pakai LoginPage object

            // Step 1: Open Home Page
            driver.get(Config.URL);
            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page");

            // Verification
            softAssert.assertTrue(loginPage.isLoginFormDisplayed(),
                    "Login form is not displayed on Home Page");

            Log.info("Login form is visible on Home Page");

            ExtentReportManager.addScreenshot(driver, "Step2_Login_Form_Visible");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
        }
    }

    @Test
    public void TC_02_01_02_VerifyLoginFormDisplayedCorrectly() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);

            driver.get(Config.URL);
            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page");

            loginPage.verifyLoginPageElements(softAssert);

            ExtentReportManager.addScreenshot(driver, "Step2_Login_Form_Verification");

            Log.info("Login Form displayed correctly with all elements and texts verified");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
        }
    }

    @Test
    public void TC_02_01_03_VerifyUserCanInteractWithLoginForm() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            LoginPage loginPage = new LoginPage(driver);

            driver.get(Config.URL);
            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page");

            // Test interaction
            loginPage.enterUsername("testuser");
            loginPage.enterPassword("testpass");

            ExtentReportManager.addScreenshot(driver, "Step2_Typing_In_Fields");

            // Check fields are editable
            softAssert.assertFalse(loginPage.getUsernameField().getAttribute("value").isEmpty(),
                    "Username field is not editable");

            softAssert.assertFalse(loginPage.getPasswordField().getAttribute("value").isEmpty(),
                    "Password field is not editable");

            Log.info("User can successfully interact with Login Form fields");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
        }
    }
}
