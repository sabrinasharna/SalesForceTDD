package com.SalesForceListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SalesForceListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("<<<<Test case starts>>>>>"+result.getName());
		//System.out.println("<<<<Test case starts>>>>>"+result.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("<<<<Test : " +result.getName()+ "  pass>>>>>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ "  FAIL >>>>>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("  SKIPPED >>>>>"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" Test Start********** : "+ context.getName()+"**************");
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" Test finish********** : "+ context.getName()+"**************");
	}
	
	public void getScreenShot() {
		System.out.println("this is own method and implement latter");
	}

}
