package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("**********************************************************************");
        System.out.println("Running test : "+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is passed : "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test is failed : "+ result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("**********************************************************************");
    }
}
