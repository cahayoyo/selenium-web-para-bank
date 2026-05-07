package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);
    private static ExtentTest test;

    public static void setExtentTest(ExtentTest extentTest){
        test = extentTest;
    }

    public static void info(String message){
        logger.info(message);
        if(test != null){
            test.log(Status.INFO, message);
        }
    }

    public static void pass(String message) {
        logger.info("[PASS] " + message);
        if (test != null) {
            test.log(Status.PASS, message);
        }
    }

    public static void warn(String message) {
        logger.warn(message);
        if (test != null) {
            test.log(Status.WARNING, message);
        }
    }

    public static void error(String message) {
        logger.error(message);
        if (test != null) {
            test.log(Status.FAIL, message);   // atau Status.ERROR
        }
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
