package testBase;

import Listeners.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;

public class BaseClass {
    protected WebDriver driver;
    protected static ExtentReports extent;
    public Logger log;

    @BeforeSuite
    public void beforeSuite(){
        extent= ExtentReportManager.getReportInstance();
    }

    @BeforeMethod
    public void setUp(){
        log= LogManager.getLogger(this.getClass());
        log.info("====Test Started====");

        driver= DriverFactory.initDriver();
        log.info("Browser launched");
    }

    @AfterMethod
    public void tearDown(){
        log.info("====Test Ended====");
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
    }
}
