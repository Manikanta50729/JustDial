package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SearchFlightsPage 
{
	//elements declaration
	@FindBy(id="com.justdial.search:id/flights_roundtrip")
	private WebElement roundTripTab;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.justdial.search:id/from_city']")
	private WebElement fromButton;

	@FindBy(id = "com.justdial.search:id/to_city")
	private WebElement toButton;
	
	@FindBy(id = "com.justdial.search:id/depature_date")
	private WebElement departureButton;
	
	@FindBy(id = "com.justdial.search:id/search_flights")
	private WebElement searchButton;
	
	//Constructor, elements initialization 
	public SearchFlightsPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Elements utilization
	public WebElement getRoundTripTab() {
		return roundTripTab;
	}

	public WebElement getFromButton() {
		return fromButton;
	}

	public WebElement getToButton() {
		return toButton;
	}

	public WebElement getDepartureButton() {
		return departureButton;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	
}
