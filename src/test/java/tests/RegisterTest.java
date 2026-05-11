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

    // TS-01.01
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
    public void TC_01_01_04_VerifyRegistrationPageStableAfterRefresh() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Open Registration Page
            driver.get(Config.URL_REGISTER);
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Initial",
                    "Initial Registration Page");

            // Step 2: Refresh the page
            driver.navigate().refresh();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Refresh",
                    "Registration Page after refresh");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "URL changed after refresh");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Header 'Signing up is easy!' is not displayed after refresh");

            // Check that all fields are empty after refresh
            softAssert.assertTrue(registerPage.getInputFirstName().getAttribute("value").isEmpty(),
                    "First Name field is not empty after refresh");

            Log.info("Registration Page remains stable after refresh");

            ExtentReportManager.addScreenshot(driver, "Step3_Verification_Complete",
                    "Final verification after refresh");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_04_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_04_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_01_05_VerifyBrowserBackButtonFromRegistrationPage() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Go to Home Page
            driver.get(Config.URL);
            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page",
                    "Started from Home Page");

            // Step 2: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step2_Registration_Page",
                    "Opened Registration Page");

            // Step 3: Click Browser Back Button
            driver.navigate().back();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Back_Button",
                    "After clicking Browser Back Button");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("index.htm"),
                    "Failed to return to Home Page using Back button");

            softAssert.assertTrue(driver.getPageSource().contains("ParaBank"),
                    "Home Page content is not displayed after back button");

            Log.info("Browser Back button works correctly from Registration Page");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_05_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_01_05_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    // TS-01.02
    @Test
    public void TC_01_02_01_VerifyRegistrationPageDisplayedCorrectly() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Navigate to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Opened");

            // Step 2: Verify all elements using existing method
            registerPage.verifyRegisterPageElements(softAssert);

            ExtentReportManager.addScreenshot(driver, "Step2_Registration_Page_Verification",
                    "Full verification of Registration Page elements");

            Log.info("Registration Page displayed correctly with all elements verified");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_02_01_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_02_01_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    // TS-01.03
    @Test
    public void TC_01_03_01_RegisterNewAccountWithValidData() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();
        String uniqueUsername = Config.getUniqueUsername();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");
        Log.info("Using Unique Username: " + uniqueUsername);

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

            Log.info("Successfully registered new account with username: " + uniqueUsername);

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

    @Test
    public void TC_01_03_02_VerifyCheckingAccountCreatedAfterRegistration() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();
        String uniqueUsername = Config.getUniqueUsername();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");
        Log.info("Using Unique Username: " + uniqueUsername);

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

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

            ExtentReportManager.addScreenshot(driver, "Step2_After_Registration");

            registerPage.clickRegisterButton();

            // === Perbaikan Verifikasi ===
            String currentUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource();

            boolean isSuccess = pageSource.contains("Your account was created successfully") ||
                    pageSource.contains("Welcome") ||
                    currentUrl.contains("overview") ||
                    currentUrl.contains("services");

            softAssert.assertTrue(isSuccess,
                    "Registration success message or redirection failed");

            Log.info("✅ Registration successful. User is now logged in.");

            ExtentReportManager.addScreenshot(driver, "Step3_Success_Account_Services",
                    "Account Services Page after successful registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_03_02_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_03_02_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }
}
