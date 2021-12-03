package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.LoginPage;

public class LoginPageTest extends Base{
	LoginPage lp;
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
		String expectedTitle=""
	}

}
