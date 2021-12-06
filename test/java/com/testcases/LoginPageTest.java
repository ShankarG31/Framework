package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	@Test
	public void titleTest()
	{
		String actualTitle=lp.getTitle();
		String expectedTitle="OrangeHRm";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(dataProvider="getData")
	public void validateLoginTest(String userName,String password)
	{
		dp = lp.validateLogin(userName,password);
		Assert.assertEquals(password,"admin123");
		
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
