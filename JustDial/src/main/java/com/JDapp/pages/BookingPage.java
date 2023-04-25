package com.JDapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class BookingPage 
{
	@FindBy(id = "com.justdial.search:id/flights_status")
	private WebElement bookButton;
	
	//Constructor, elements initialization 
		public BookingPage(AndroidDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getBookButton() {
			return bookButton;
		}
		
}
