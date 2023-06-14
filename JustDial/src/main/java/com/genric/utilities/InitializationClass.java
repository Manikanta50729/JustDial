package com.genric.utilities;

import org.openqa.selenium.WebElement;

import com.JDapp.pages.BookingPage;
import com.JDapp.pages.HomePage;
import com.JDapp.pages.LoginPage;
import com.JDapp.pages.SearchCityOrAirportPage;
import com.JDapp.pages.SearchFlightsPage;
import com.JDapp.pages.SelectDatesPage;
import com.JDapp.pages.TravelPage;

import io.appium.java_client.android.AndroidDriver;

public class InitializationClass extends BaseJD
{
	//static	InitializationClass pages ;
	public LoginPage loginPage;
	public HomePage homePage;
	public TravelPage travelPage;
	public SearchFlightsPage searchFlights;
	public SearchCityOrAirportPage searchCityOrAirport;
	public SelectDatesPage selectDates;
	public BookingPage booking;
	

	public InitializationClass(AndroidDriver<WebElement> driver) 
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		travelPage = new TravelPage(driver);
		searchFlights = new SearchFlightsPage(driver);
		searchCityOrAirport = new SearchCityOrAirportPage(driver);
		selectDates = new SelectDatesPage(driver);
		booking = new BookingPage(driver);
	}

}