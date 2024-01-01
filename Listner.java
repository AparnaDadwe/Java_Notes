package com.param.b5.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listner implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		// onTestStart means test start hone ke bad kya karna hai
		Reporter.log("Test case started"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		//onTestSuccess means test success hine ke bad kya karna hai

		Reporter.log("Test case succeded"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// onTestFailure means test fail hone ke bad kya karna hai
		Reporter.log("Test case failed"+result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		// onTestSkipped means test case skip hone ke bad kya karna hai
		Reporter.log("Test case skipped"+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub


	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub


	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub


	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub


	}

}
