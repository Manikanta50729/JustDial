package com.genric.utilities;

import com.JDapp.pages.BookingPage;
import com.JDapp.pages.HomePage;
import com.JDapp.pages.LoginPage;
import com.JDapp.pages.SearchCityOrAirportPage;
import com.JDapp.pages.SearchFlightsPage;
import com.JDapp.pages.SelectDatesPage;
import com.JDapp.pages.TravelPage;

public class InitializationClass extends BaseJD
{
	static	InitializationClass pages ;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	TravelPage travelPage = new TravelPage(driver);
	SearchFlightsPage searchFlights = new SearchFlightsPage(driver);
	SearchCityOrAirportPage searchCityOrAirport = new SearchCityOrAirportPage(driver);
	SelectDatesPage selectDates = new SelectDatesPage(driver);
	BookingPage booking = new BookingPage(driver);
}
