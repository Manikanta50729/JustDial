package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SearchCityOrAirportPage 
{
	@FindBy(id = "com.justdial.search:id/search_edit_text_flight")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Bangalore, IN - Kempegowda')]")
	private WebElement bangloreAirportOption;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Hyderabad, IN - Rajiv')]")
	private WebElement hyderabadAirportOption;

	//Constructor, elements initialization 
	public SearchCityOrAirportPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Elements utilization
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getBangloreAirportOption() {
		return bangloreAirportOption;
	}


	public WebElement getHyderabadAirportOption() {
		return hyderabadAirportOption;
	}
	
}
