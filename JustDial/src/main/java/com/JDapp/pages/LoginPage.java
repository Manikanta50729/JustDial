package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genric.utilities.BaseJD;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage 
{
	//elements declaration
	@FindBy(id="com.justdial.search:id/tvSkip")
	private WebElement skipButton;
	
	
	//Constructor, elements initialization
	public LoginPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Elements utilization
	public WebElement getSkipButton() {
		return skipButton;
	}
	
	
	
}
