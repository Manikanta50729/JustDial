package com.JDapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BookingPage 
{
	@FindBy(id = "com.justdial.search:id/flights_status")
	private WebElement bookButton;

	@FindBy( xpath = "//android.view.View[@content-desc=\"Late Departures (6pm - 12am)\"]")
	private WebElement lateDepatureBtn;

	@FindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[@text='Indigo']/../../android.widget.TextView[1]")
	private List<WebElement> indDprtTimes;

	@FindBy(xpath = "//android.widget.TextView[@text='Indigo']")
	private List<WebElement> indigoFlights;

	@FindBy(xpath = "//android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView[1]")
	private List<WebElement> allAvailableFlights;

	@FindBy(xpath = "//android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[@text='Indigo']/../../android.widget.TextView[1]")
	private List<WebElement> indRetTimes;
	
	

	//Constructor, elements initialization 
	public BookingPage(AndroidDriver<WebElement> driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookButton() {
		return bookButton;
	}

	public void clickLateDepture()
	{
		lateDepatureBtn.click();
	}

	public void checkforIndigoFlightafterbetween7_30and8_00andSelect()
	{

		//List<WebElement> indDprtTimes = driver.findElementsByXPath("");

		for (int i = indDprtTimes.size()-1; i >= 0 ; i--) 
		{
			String time = indDprtTimes.get(i).getText();
			//System.out.println(time);
			int timerForCondition = Integer.parseInt(time.replace(":", ""));
			//System.out.println(timerForCondition);
			if(timerForCondition>=1930 && timerForCondition<=2000)
			{
				WebElement flight = indDprtTimes.get(i);
				flight.click();
				System.out.println("flight selected for departure at " + flight.getText());
				break;
			}   
		}
	}
	
	public void CheckforIndigoreturnFlight_bn7_30and8_00()
	{
		for (int i = indRetTimes.size()-1; i >= 0 ; i--) 
		{
			String time = indRetTimes.get(i).getText();
			//System.out.println(time);
			int timerForCondition = Integer.parseInt(time.replace(":", ""));
			//System.out.println(timerForCondition);
			if(timerForCondition>=1930 && timerForCondition<=2100)
			{
				WebElement flight = indRetTimes.get(i);
				flight.click();
				System.out.println("flight selected  " + flight.getText());
				break;
			}
			
		}
	}
	
	//public void 
	
	
	public boolean CheckIfIndigoavailable()
	{
		boolean b = indigoFlights.size()!=0;
		return b;
	}

	public void BookAvailable1stRetFlight()
	{
		for (int i = allAvailableFlights.size()-1; i >= 0; i--) {
			
		
		WebElement flight = allAvailableFlights.get(allAvailableFlights.size()-1);
		String str=flight.getText();
		String no = str.replaceAll(":", "");
		int timerofRetflight=Integer.parseInt(no);
		if (timerofRetflight>=1930 && timerofRetflight <=2100)
		{
			flight.click();
			break;
		} 
	}
		
		//flight.click();
		//System.out.println("flightSelected in  " +flight.getText());
	}
	
	public void BookAvailable1stFlight()
	{
		WebElement flight = allAvailableFlights.get(allAvailableFlights.size()-1);
		flight.click();
		System.out.println("flightSelected in  " +flight.getText());
	}
	




}
