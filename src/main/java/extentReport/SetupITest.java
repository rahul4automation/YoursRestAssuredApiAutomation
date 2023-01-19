package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.regex.*;

import java.util.Arrays;

public class SetupITest implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<>();
    public static String name="Rahul";

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTest TestReport =extentReports.createTest(" TestName " + iTestResult.getTestClass().getName() + " - " + iTestResult.getMethod().getMethodName());
        extentTest.set(TestReport);

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace= Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace=stackTrace.replaceAll(",", "<br>");
        String formmatedTrace="<details>\n" +
                " <summary>click Here To see Exception logs</summary>\n"  +
                "   "+stackTrace+"\n" +
                "</details>\n";
        ExtentReportManager.logExceptionDetails(formmatedTrace);


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String reportFilePath=System.getProperty("user.dir") +"\\reports\\" +fileName;
        extentReports = ExtentReportManager.createExtentReport(reportFilePath, "Test API Automation Report", "Test ExecutionReport");

    }

    @Override
    public void onFinish(ITestContext context) {

        if (extentReports != null)
            extentReports.flush();
    }


}
