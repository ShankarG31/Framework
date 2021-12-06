package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class LoginPage extends Base{

	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public DashBoardPage validateLogin(String userName,String Password)
	{
		username.sendKeys(userName);
		password.sendKeys(Password);
		loginButton.click();
		return new DashBoardPage();
	}
}
