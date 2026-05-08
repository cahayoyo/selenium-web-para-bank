package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;
import utils.Config;
import utils.ExtentReportManager;
import utils.Helper;
import utils.Log;

public class RegisterTest extends BaseTest {

    @Test
    public void TC_01_01_01_AccessRegistrationPageFromHomePage() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try{
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            ExtentReportManager.addScreenshot(driver, "Home_Page");

            homePage.clickRegisterLink();

            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),"Failed to navigate to Registration Page");

            Log.info("User successfully navigated to Registration Page");

            ExtentReportManager.addScreenshot(driver, "Register_Page_Verification","Final verification of Register Page elements");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");
        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_01_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_01_Error");
            test.fail(testName + " - ERROR: " + e.getMessage());
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_01_02_AccessRegistrationPageDirectlyViaURL() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            RegisterPage registerPage = new RegisterPage(driver);

            driver.get(Config.URL_REGISTER);

            ExtentReportManager.addScreenshot(driver, "Register_Page_Direct_URL",
                    "Registration Page opened via direct URL");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "Failed to open Registration Page via direct URL");

            Log.info("Successfully accessed Registration Page using direct URL");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Registration header is not displayed");

            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_02_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_02_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_01_03_VerifyRegistrationPageLoadsSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            RegisterPage registerPage = new RegisterPage(driver);

            // Direct access to registration page
            driver.get(Config.URL_REGISTER);
            ExtentReportManager.addScreenshot(driver, "Step1_Open_Register_Page",
                    "Opened Registration Page directly");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "Registration Page URL is incorrect");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Registration header 'Signing up is easy!' is not displayed");

            Log.info("Registration Page loaded successfully with all elements visible");

            ExtentReportManager.addScreenshot(driver, "Step2_Register_Page_Loaded",
                    "Registration Page loaded successfully");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_03_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_03_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_03_01_RegisterNewAccountWithValidData() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();
        String uniqueUsername = Config.getUniqueUsername();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page",
                    "User opened Registration Page");

            // Step 2: Fill Registration Form
            registerPage.registerNewUser(
                    Config.FIRST_NAME,
                    Config.LAST_NAME,
                    Config.ADDRESS,
                    Config.CITY,
                    Config.STATE,
                    Config.ZIP_CODE,
                    Config.PHONE,
                    Config.SSN,
                    uniqueUsername,
                    Config.PASSWORD
            );

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Registration_Form",
                    "User filled all registration fields");

            registerPage.clickRegisterButton();

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("overview.htm") ||
                            driver.getPageSource().contains("Your account was created successfully"),
                    "Registration failed or wrong redirection");

            Log.info("User successfully registered a new account");

            ExtentReportManager.addScreenshot(driver, "Step3_Success_Registration",
                    "Final result after successful registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_03_01_Failed", "Registration Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_03_01_Error", "Test Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }
}
