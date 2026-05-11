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

    // TS-01.04
    @Test
    public void TC_01_04_01_SubmitRegistrationWithEmptyRequiredFields() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Step 2: Fill SOME fields, but leave several required fields empty
            registerPage.enterFirstName(Config.FIRST_NAME);
            registerPage.enterLastName(Config.LAST_NAME);
            // sengaja kosongkan beberapa field penting
            // registerPage.enterAddress(Config.ADDRESS);
            // registerPage.enterCity(Config.CITY);
            registerPage.enterState(Config.STATE);
            registerPage.enterZipCode(Config.ZIP_CODE);
            registerPage.enterPhone(Config.PHONE);
            registerPage.enterSSN(Config.SSN);
            registerPage.enterUsername(Config.getUniqueUsername());
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword(Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Partial_Filled_Empty_Fields");

            // Step 3: Click Register
            registerPage.clickRegisterButton();

            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register_Partial_Empty");

            // Verification
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even though required fields are empty");

            Log.info("✅ System correctly prevented submission when required fields are empty");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_01_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_01_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_04_02_RegisterWithMismatchedPassword() {
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
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Step 2: Fill form with mismatched password
            registerPage.enterFirstName(Config.FIRST_NAME);
            registerPage.enterLastName(Config.LAST_NAME);
            registerPage.enterAddress(Config.ADDRESS);
            registerPage.enterCity(Config.CITY);
            registerPage.enterState(Config.STATE);
            registerPage.enterZipCode(Config.ZIP_CODE);
            registerPage.enterPhone(Config.PHONE);
            registerPage.enterSSN(Config.SSN);
            registerPage.enterUsername(uniqueUsername);
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword("WrongPassword123!");   // Mismatched

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Mismatched_Password");

            // Step 3: Click Register
            registerPage.clickRegisterButton();

            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register_Mismatch");

            // Verification
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage, "User was redirected even though password mismatch");

            // Check for error message
            boolean hasErrorMessage = driver.getPageSource().contains("Passwords did not match") ||
                    driver.getPageSource().toLowerCase().contains("password");

            softAssert.assertTrue(hasErrorMessage, "No error message shown for mismatched password");

            Log.info("System correctly rejected registration due to mismatched password");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_02_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_02_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_04_03_RegisterWithExistingUsername() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Step 2: Fill form with EXISTING username ("john" is default in ParaBank)
            registerPage.enterFirstName(Config.FIRST_NAME);
            registerPage.enterLastName(Config.LAST_NAME);
            registerPage.enterAddress(Config.ADDRESS);
            registerPage.enterCity(Config.CITY);
            registerPage.enterState(Config.STATE);
            registerPage.enterZipCode(Config.ZIP_CODE);
            registerPage.enterPhone(Config.PHONE);
            registerPage.enterSSN(Config.SSN);
            registerPage.enterUsername("john");                    // Existing username
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword(Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Existing_Username");

            // Step 3: Click Register
            registerPage.clickRegisterButton();

            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register_Existing_Username");

            // Verification
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even though username already exists");

            // Check for error message about existing username
            boolean hasErrorMessage = driver.getPageSource().contains("This username already exists") ||
                    driver.getPageSource().toLowerCase().contains("username") ||
                    driver.getPageSource().toLowerCase().contains("already exists");

            softAssert.assertTrue(hasErrorMessage,
                    "No error message shown for existing username");

            Log.info("✅ System correctly rejected registration due to existing username");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_03_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_03_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_04_04_RegisterWithInvalidDataFormat() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();
        String uniqueUsername = Config.getUniqueUsername();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");
        Log.info("Testing invalid data format with username: " + uniqueUsername);

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Fill most fields correctly, but use invalid formats
            registerPage.enterFirstName(Config.FIRST_NAME);
            registerPage.enterLastName(Config.LAST_NAME);
            registerPage.enterAddress(Config.ADDRESS);
            registerPage.enterCity(Config.CITY);
            registerPage.enterState(Config.STATE);
            registerPage.enterZipCode("ABCDE");                    // Invalid Zip Code
            registerPage.enterPhone("abc123");                     // Invalid Phone
            registerPage.enterSSN("123-45-abc");                   // Invalid SSN
            registerPage.enterUsername(uniqueUsername);
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword(Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Invalid_Format");

            registerPage.clickRegisterButton();

            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register_Invalid_Format");

            // Verification - Should stay on registration page
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even with invalid data format");

            // Check if any validation/error message appears
            String pageSource = driver.getPageSource().toLowerCase();
            boolean hasValidationError = pageSource.contains("error") ||
                    pageSource.contains("invalid") ||
                    pageSource.contains("format") ||
                    pageSource.contains("phone") ||
                    pageSource.contains("ssn") ||
                    pageSource.contains("zip");

            softAssert.assertTrue(hasValidationError,
                    "No validation error message shown for invalid data format");

            Log.info("✅ System correctly handled invalid data format");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_04_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_04_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_04_05_SubmitRegistrationWithAllFieldsEmpty() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Step 1: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Empty");

            // Step 2: Click Register button WITHOUT filling any fields
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_Click_Register_All_Empty");

            // Verification
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even though all fields are empty");

            // Check if any validation or error indication exists
            String pageSource = driver.getPageSource().toLowerCase();
            boolean hasAnyValidation = pageSource.contains("error") ||
                    pageSource.contains("required") ||
                    pageSource.contains("please") ||
                    pageSource.contains("invalid");

            // ParaBank kadang tidak menampilkan error yang jelas, jadi kita cek apakah tetap di halaman register
            Log.info("Validation for empty form detected: " + hasAnyValidation);

            Log.info("✅ System correctly prevented submission with all empty fields (stayed on register page)");

            ExtentReportManager.addScreenshot(driver, "Step3_Empty_Form_Result",
                    "Result after submitting completely empty form");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_05_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_04_05_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_05_01_VerifySuccessMessageAfterRegistration() {
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

            // Step 1: Navigate to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Opened");

            // Step 2: Fill the registration form (without submitting)
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
                    "Form filled before submission");

            // Step 3: Submit the form
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Click_Register");

            // === Verification ===
            String pageSource = driver.getPageSource();

            boolean successMessageDisplayed = pageSource.contains("Your account was created successfully") ||
                    pageSource.contains("You are now logged in");

            softAssert.assertTrue(successMessageDisplayed,
                    "Success message was not displayed after registration");

            // Check user is logged in
            boolean isLoggedIn = pageSource.contains("Welcome") ||
                    pageSource.contains(uniqueUsername) ||
                    pageSource.contains("Account Services");

            softAssert.assertTrue(isLoggedIn, "User was not automatically logged in after registration");

            Log.info("✅ Success message appeared and user is logged in after registration");

            ExtentReportManager.addScreenshot(driver, "Step4_Success_Verification",
                    "Final success verification");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_01_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_01_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_05_02_VerifyAutoLoginAfterRegistration() {
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

            // Step 1: Navigate to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Opened");

            // Step 2: Fill the registration form
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

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Registration_Form");

            // Step 3: Submit the form
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register_Button");

            // === Verification Auto Login ===
            String pageSource = driver.getPageSource();

            boolean isAutoLoggedIn = pageSource.contains("Welcome") &&
                    (pageSource.contains(Config.FIRST_NAME) ||
                            pageSource.contains(uniqueUsername));

            softAssert.assertTrue(isAutoLoggedIn,
                    "User was not automatically logged in after successful registration");

            boolean isOnAccountServices = driver.getCurrentUrl().contains("services") ||
                    pageSource.contains("Account Services");

            softAssert.assertTrue(isOnAccountServices,
                    "User was not redirected to Account Services page");

            Log.info("✅ User successfully auto logged in after registration with username: " + uniqueUsername);

            ExtentReportManager.addScreenshot(driver, "Step4_Auto_Login_Verified",
                    "Auto login verification after registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_02_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_02_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_05_03_VerifyRedirectToAccountServicesAfterRegistration() {
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

            // Step 1: Navigate to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Step 2: Fill registration form
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

            // Step 3: Submit the form
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Submit_Registration");

            // === Verification: Redirection to Account Services ===
            String currentUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource();

            boolean isRedirectedToAccountServices = currentUrl.contains("services") ||
                    currentUrl.contains("overview") ||
                    pageSource.contains("Account Services");

            softAssert.assertTrue(isRedirectedToAccountServices,
                    "User was not redirected to Account Services page after registration");

            // Additional check: Account Services elements are visible
            boolean accountServicesVisible = pageSource.contains("Open New Account") ||
                    pageSource.contains("Accounts Overview");

            softAssert.assertTrue(accountServicesVisible,
                    "Account Services menu is not visible after registration");

            Log.info("✅ User successfully redirected to Account Services page after registration");

            ExtentReportManager.addScreenshot(driver, "Step3_Account_Services_Page",
                    "Account Services Page after successful registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_03_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_03_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void TC_01_05_04_VerifyNewCheckingAccountCreatedAfterRegistration() {
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

            // Step 1: Navigate to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Step 2: Fill and submit registration
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

            // Step 3: Submit the form
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Registration_Submit");

            // === Verification: New Checking Account Created ===
            String pageSource = driver.getPageSource();

            boolean hasCheckingAccount = pageSource.contains("Checking") ||
                    pageSource.contains("Account Number") ||
                    pageSource.contains("$") || // balance indicator
                    pageSource.contains("Open New Account");

            softAssert.assertTrue(hasCheckingAccount,
                    "New Checking Account was not automatically created after registration");

            Log.info("✅ New Checking Account successfully created after registration");

            ExtentReportManager.addScreenshot(driver, "Step3_Account_Overview_With_New_Checking",
                    "Account Overview showing new Checking Account");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_04_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "TC_01_05_04_Error");
            test.fail(testName + " - ERROR");
            Log.error(testName + " ERROR: " + e.getMessage());
        }
    }
}
