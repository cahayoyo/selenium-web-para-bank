package tests;

import base.BaseTest;
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

        Log.info("===== Running: " + testName + " =====");
        test = ExtentReportManager.createTest(testName);

        try{
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            homePage.clickLinkRegister();
            registerPage.verifyRegisterPageElements(softAssert);

            Log.info("===== " + testName + " Finished =====");
            softAssert.assertAll();
            test.pass("TC001_VerifyElementsRegisterPage - PASSED");
        } catch (AssertionError e) {
            test.fail(testName + " - FAILED");
            Log.error(testName + " FAILED: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail(testName + " - ERROR: " + e.getMessage());
            Log.error(testName + " ERROR: " + e.getMessage());
            throw e;
        }
    }
}
