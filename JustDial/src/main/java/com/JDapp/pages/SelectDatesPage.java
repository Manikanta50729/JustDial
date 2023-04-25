package com.JDapp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.genric.utilities.DateFetch;
import com.genric.utilities.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SelectDatesPage extends Utils
{
	@FindBy(id = "com.justdial.search:id/depart_date")
	private WebElement departureDate;

	@FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]")
	private List<WebElement> dates;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Constructor, elements initialization 
	public SelectDatesPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getDepartureDate() {
		return departureDate;
	}



	public List<WebElement> getDates() {
		return dates;
	}
}
