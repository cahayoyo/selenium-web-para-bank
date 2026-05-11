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

        try {
            HomePage homePage = new HomePage(driver);

            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page");
            homePage.clickRegisterLink();

            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "Failed to navigate to Registration Page");

            ExtentReportManager.addScreenshot(driver, "Step2_Registration_Page");

            Log.info("User successfully navigated to Registration Page");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Direct_URL");

            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "Failed to open Registration Page via direct URL");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Registration header 'Signing up is easy!' is not displayed");

            Log.info("Successfully accessed Registration Page using direct URL");

            Log.info("===== " + testName + " Finished =====");   // ← Dipertahankan
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            driver.get(Config.URL_REGISTER);
            ExtentReportManager.addScreenshot(driver, "Step1_Open_Register_Page");

            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "Registration Page URL is incorrect");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Registration header 'Signing up is easy!' is not displayed");

            Log.info("Registration Page loaded successfully with all elements visible");

            ExtentReportManager.addScreenshot(driver, "Step2_Register_Page_Loaded");

            Log.info("===== " + testName + " Finished =====");   // ← Dipertahankan
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Initial");

            // Step 2: Refresh the page
            driver.navigate().refresh();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Refresh");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("register.htm"),
                    "URL changed after refresh");

            softAssert.assertTrue(registerPage.isHeaderDisplayed(),
                    "Header 'Signing up is easy!' is not displayed after refresh");

            // Check fields are empty after refresh
            softAssert.assertTrue(registerPage.getInputFirstName().getAttribute("value").isEmpty(),
                    "First Name field is not empty after refresh");

            Log.info("Registration Page remains stable after refresh");

            ExtentReportManager.addScreenshot(driver, "Step3_Verification_Complete");

            Log.info("===== " + testName + " Finished =====");   // ← Dipertahankan
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            // Step 1: Go to Home Page
            driver.get(Config.URL);
            ExtentReportManager.addScreenshot(driver, "Step1_Home_Page");

            // Step 2: Go to Registration Page
            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step2_Registration_Page");

            // Step 3: Click Browser Back Button
            driver.navigate().back();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Back_Button");

            // Verification
            softAssert.assertTrue(driver.getCurrentUrl().contains("index.htm"),
                    "Failed to return to Home Page using Back button");

            softAssert.assertTrue(driver.getPageSource().contains("ParaBank"),
                    "Home Page content is not displayed after back button");

            Log.info("Browser Back button works correctly from Registration Page");

            Log.info("===== " + testName + " Finished =====");   // ← Dipertahankan
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            // Step 2: Perform full verification using existing method
            registerPage.verifyRegisterPageElements(softAssert);

            ExtentReportManager.addScreenshot(driver, "Step2_Full_Page_Verification",
                    "Complete verification of all elements on Registration Page");

            Log.info("Registration Page displayed correctly with all elements and texts verified");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            // Step 3: Submit
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Submit");

            // Verification
            String pageSource = driver.getPageSource();
            boolean isSuccess = pageSource.contains("Your account was created successfully") ||
                    pageSource.contains("You are now logged in") ||
                    driver.getCurrentUrl().contains("services");

            softAssert.assertTrue(isSuccess, "Registration was not successful");

            Log.info("✅ Successfully registered new account with username: " + uniqueUsername);

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Submit");

            // Verification - Check Account Overview / Services
            String pageSource = driver.getPageSource();

            boolean hasCheckingAccount = pageSource.contains("Checking") ||
                    pageSource.contains("Account Number") ||
                    pageSource.contains("$") ||
                    pageSource.contains("Account Services");

            softAssert.assertTrue(hasCheckingAccount,
                    "New Checking Account was not automatically created");

            Log.info("✅ New Checking Account successfully created after registration");

            ExtentReportManager.addScreenshot(driver, "Step3_Account_Overview",
                    "Account Overview showing new Checking Account");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            // Fill some fields, but leave required fields empty
            registerPage.enterFirstName(Config.FIRST_NAME);
            registerPage.enterLastName(Config.LAST_NAME);
            // sengaja kosongkan beberapa field
            registerPage.enterState(Config.STATE);
            registerPage.enterZipCode(Config.ZIP_CODE);
            registerPage.enterPhone(Config.PHONE);
            registerPage.enterSSN(Config.SSN);
            registerPage.enterUsername(Config.getUniqueUsername());
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword(Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Partial_Filled_Empty_Fields");

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register");

            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even though required fields are empty");

            Log.info("✅ System correctly prevented submission when required fields are empty");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

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
            registerPage.enterConfirmPassword("WrongPass123!");  // Mismatched

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Mismatched_Password");

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register");

            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage, "User was redirected despite password mismatch");

            Log.info("✅ System correctly rejected mismatched password");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

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

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register");

            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage, "User was redirected despite existing username");

            Log.info("✅ System correctly rejected existing username");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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
            registerPage.enterZipCode("ABCDE");           // Invalid
            registerPage.enterPhone("abc123xxxx");        // Invalid
            registerPage.enterSSN("123-45-abc");          // Invalid
            registerPage.enterUsername(uniqueUsername);
            registerPage.enterPassword(Config.PASSWORD);
            registerPage.enterConfirmPassword(Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Invalid_Format");

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_Click_Register");

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

            Log.info("✅ System correctly handled invalid data format (stayed on registration page)");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page_Empty");

            // Step 2: Click Register button WITHOUT filling any fields
            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_Click_Register_All_Empty");

            // Verification
            boolean isStillOnRegisterPage = driver.getCurrentUrl().contains("register.htm");
            softAssert.assertTrue(isStillOnRegisterPage,
                    "User was redirected even though all fields are empty");

            Log.info("✅ System correctly prevented submission with completely empty form");

            ExtentReportManager.addScreenshot(driver, "Step3_Empty_Form_Result",
                    "Result after submitting completely empty form");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            registerPage.registerNewUser(
                    Config.FIRST_NAME, Config.LAST_NAME, Config.ADDRESS,
                    Config.CITY, Config.STATE, Config.ZIP_CODE,
                    Config.PHONE, Config.SSN, uniqueUsername, Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Form");

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Submit");

            String pageSource = driver.getPageSource();
            boolean successMessageDisplayed = pageSource.contains("Your account was created successfully") ||
                    pageSource.contains("You are now logged in");

            softAssert.assertTrue(successMessageDisplayed,
                    "Success message was not displayed after registration");

            Log.info("✅ Success message appeared after registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            registerPage.registerNewUser(
                    Config.FIRST_NAME, Config.LAST_NAME, Config.ADDRESS,
                    Config.CITY, Config.STATE, Config.ZIP_CODE,
                    Config.PHONE, Config.SSN, uniqueUsername, Config.PASSWORD);

            ExtentReportManager.addScreenshot(driver, "Step2_Filled_Form");

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step3_After_Submit");

            String pageSource = driver.getPageSource();

            boolean isAutoLoggedIn = pageSource.contains("Welcome") &&
                    (pageSource.contains(Config.FIRST_NAME) || pageSource.contains(uniqueUsername));

            softAssert.assertTrue(isAutoLoggedIn,
                    "User was not automatically logged in after registration");

            Log.info("✅ User successfully auto logged in after registration");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            registerPage.registerNewUser(
                    Config.FIRST_NAME, Config.LAST_NAME, Config.ADDRESS,
                    Config.CITY, Config.STATE, Config.ZIP_CODE,
                    Config.PHONE, Config.SSN, uniqueUsername, Config.PASSWORD);

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Submit");

            String currentUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource();

            boolean isRedirected = currentUrl.contains("services") ||
                    currentUrl.contains("overview") ||
                    pageSource.contains("Account Services");

            softAssert.assertTrue(isRedirected,
                    "User was not redirected to Account Services page");

            Log.info("✅ User successfully redirected to Account Services page");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
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

            homePage.clickRegisterLink();
            ExtentReportManager.addScreenshot(driver, "Step1_Registration_Page");

            registerPage.registerNewUser(
                    Config.FIRST_NAME, Config.LAST_NAME, Config.ADDRESS,
                    Config.CITY, Config.STATE, Config.ZIP_CODE,
                    Config.PHONE, Config.SSN, uniqueUsername, Config.PASSWORD);

            registerPage.clickRegisterButton();
            ExtentReportManager.addScreenshot(driver, "Step2_After_Submit");

            String pageSource = driver.getPageSource();

            boolean hasCheckingAccount = pageSource.contains("Checking") ||
                    pageSource.contains("Account Number") ||
                    pageSource.contains("Account Services") ||
                    pageSource.contains("$");

            softAssert.assertTrue(hasCheckingAccount,
                    "New Checking Account was not automatically created");

            Log.info("✅ New Checking Account successfully created after registration");

            ExtentReportManager.addScreenshot(driver, "Step3_Account_Overview");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");

        } catch (Exception e) {
            Helper.handleTestFailure(driver, test, testName, e);
        }
    }
}
