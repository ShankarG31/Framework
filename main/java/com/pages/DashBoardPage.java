package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class DashBoardPage extends Base{

	@FindBy(id="Subscriber_link")
	WebElement subscribe;
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getText()
	{
		return subscribe.getText();
	}
}
