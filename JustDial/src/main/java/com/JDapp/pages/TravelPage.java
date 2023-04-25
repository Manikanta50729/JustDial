package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class TravelPage 
{
	//elements declaration
	@FindBy(xpath="//android.widget.TextView[@text='Flights']")
	private WebElement flightsIcon;
	
	
	//Constructor, elements initialization 
	public TravelPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Elements utilization
	public WebElement getFlightsIcon() {
		return flightsIcon;
	}
	
	
	
	
	
}
