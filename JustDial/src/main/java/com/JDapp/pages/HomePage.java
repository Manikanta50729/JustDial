package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage 
{
	//elements declaration
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement onlyThisTimeButton;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	private WebElement allowButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='Travel']")
	private WebElement tavelIcon;
	
	
	//Constructor, elements initialization 
	public HomePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Elements utilization
	public WebElement getOnlyThisTimeButton() {
		return onlyThisTimeButton;
	}


	public WebElement getAllowButton() {
		return allowButton;
	}


	public WebElement getTavelIcon() {
		return tavelIcon;
	}
	
	
	
}
