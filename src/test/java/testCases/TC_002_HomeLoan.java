package testCases;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageObjects.HomeLoanPage;
import testBase.BaseClass;
import utils.ExcelUtils;

import java.util.List;

public class TC_002_HomeLoan extends BaseClass {


    ExtentTest test;
    @Test
    public void homeLoanStep2Test() {

        test = extent.createTest("TC_002 - Home Loan EMI Calculator");

        HomeLoanPage homeLoan = new HomeLoanPage(driver);

        test.info("Opening Home Loan EMI Calculator");
        homeLoan.openHomeLoanCalculator();

        test.info("Entering Home Loan details till Date Picker");
        homeLoan.enterDetailsTillDatePicker();

        test.info("Capturing Home Loan Results Screenshot");
        homeLoan.captureResultScreenshot();

        test.info("Extracting Year-on-Year table data");
        List<List<String>> tableData = homeLoan.extractYearWiseTable();

        test.info("Writing extracted data into Excel");
        ExcelUtils.writeHomeLoanData(
                "src/test/resources/testdata/HomeLoan_YearlyData.xlsx",
                tableData
        );

        test.pass("STEP 2 completed and data written to Excel successfully");
    }
}
