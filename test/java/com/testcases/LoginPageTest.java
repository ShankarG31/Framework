package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelReader;

import junit.framework.Assert;

public class LoginPageTest extends Base{
	LoginPage lp;
	DashBoardPage dp;
	@BeforeMethod
	public void launchBrowser()
	{
		initializaiton();
		lp=new LoginPage();
	}
	@AfterMethod
	public void closeSetup()
	{
		tearDown();
	}
	@BeforeTest
	public void reportSetup()
	{
		extentReportSetup();
	}
	@AfterTest
	public void closeReportSetup()
	{
		closeExtentReportSetup();
	}
	@Test
	public void titleTest()
	{
		ExtentTest test = extent.createTest("OrangeHRM Title Test");
		String actualTitle=lp.getTitle();
		String expectedTitle="OrangeHRm";
		Assert.assertEquals(actualTitle, expectedTitle);
		test.log(Status.FAIL, "Validate Title Test case failed");
		
	}

	@Test(dataProvider="getData")
	public void validateLoginTest(String userName,String password)
	{
		ExtentTest test = extent.createTest("OrangeHRM Login Test");
		dp = lp.validateLogin(userName,password);
		Assert.assertEquals(password,"admin123");
		test.log(Status.PASS, "Validate login Test case passed");
		
	}
	@DataProvider
	public Object[][] getData()
	{
		/*
		 * This Object data is a 2D array like a table with rows and columns
		 * first [] - row no which contains no. of test cases
		 * second [] - no of parameter combinations passed on each iteration
		 */
		Object data[][]=null;
		String excelpath=".\\src\\main\\resources\\LoginDetails.xlsx";
		String sheetName="Sheet1";
		ExcelReader reader=new ExcelReader(excelpath,sheetName);
		data=reader.getTestData();
		return data;
	}
	
}
