package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;
import utils.ExtentReportManager;
import utils.Helper;
import utils.Log;

public class RegisterTest extends BaseTest {

    @Test
    public void TC001_VerifyElementsRegisterPage() {
        SoftAssert softAssert = new SoftAssert();
        String testName = getTestName();

        test = ExtentReportManager.createTest(testName);
        Log.setExtentTest(test);
        Log.info("===== Running: " + testName + " =====");

        try{
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            homePage.clickRegisterLink();
            registerPage.verifyRegisterPageElements(softAssert);

            ExtentReportManager.addScreenshot(driver, "Register_Page_Verification","Final verification of Register Page elements");

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass(testName + " - PASSED");
        } catch (AssertionError e) {
            ExtentReportManager.addScreenshot(driver, "Register_Page_Failed");
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            ExtentReportManager.addScreenshot(driver, "Register_Page_Error");
            test.fail(testName + " - ERROR: " + e.getMessage());
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }
}
