package listeners;

import java.util.LinkedList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.SetupDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;

public class AllureListener extends SetupDriver implements ITestListener {
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void onStart(ITestContext iTestContext) {
		iTestContext.setAttribute("WebDriver", driver);
	}

	public void onFinish(ITestContext iTestContext) {
	}

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {
		removeParameter();
	}

	public void onTestFailure(ITestResult iTestResult) {
		@SuppressWarnings("unused")
		Object testClass = iTestResult.getInstance();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			saveFailureScreenShot(driver);
		}
		removeParameter();
	}

	public void onTestSkipped(ITestResult iTestResult) {
		removeParameter();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		removeParameter();

	}
	
	
	
	public void removeParameter() {
		AllureLifecycle lifecycle = Allure.getLifecycle();
		lifecycle.updateTestCase(testResult -> testResult.setParameters(new LinkedList<>()));
	}

}
