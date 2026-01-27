package testCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import testBase.BaseClass;

public class TC_001_CarLoan extends BaseClass {
    @Test
    public void carLoanTest() throws InterruptedException {
        ExtentTest test=extent.createTest("TC_001_-CarLoanTest");
        log.info("*** Started Test Case TC_001_CarLoan ***");
        CarLoanPage carLoan=new CarLoanPage(driver);
        test.info("Selecting Car Loan Tab");
        carLoan.selectCarLoan();

        test.info("Clearing default values and entering new data");
        carLoan.enterCarLoanDetails();

        test.info("Scrolling to Results Section");
        carLoan.printCarLoanResults();


        test.pass("Car Loan Emi Calculated and displayed successfully");
    }
}
