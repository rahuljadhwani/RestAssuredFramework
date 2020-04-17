package com.employeecheck.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	int count = 0;
	int maxRetry = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxRetry) {
			count ++;
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result.getName());
			return true;
		}
		return false;
	}
}
