package com.pathnxt.commonUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 * @author -Priyaranajan Mohanty-
 *
 */
public class RetryAnalyzerImptn implements IRetryAnalyzer
{
	int count=0;
	int retrylimit=3; 

	public boolean retry(ITestResult result) 
	{

		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
