package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Config;
import utils.ExtentReportManager;
import utils.Log;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    protected String getTestName(){
        return new Exception().getStackTrace()[1].getMethodName();
    }

    @BeforeSuite
    public void setUpReport(){
        extent = ExtentReportManager.getReportInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String,Object>();

        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        Log.info("===== Starting WebDriver Chrome =====");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Config.URL);
        Log.info("===== Chrome Browser Opened =====");
        Log.info("===== Navigate URL to " + Config.URL + " =====");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, "DEFECT");
            test.fail("TC Failed - Check Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        if(driver != null){
            driver.quit();
            Log.info("===== Browser Closed =====");
        }
    }

    @AfterSuite
    public void tearDownReport(){
        extent.flush();
    }
}
