package com.JD.testScripts;

import org.openqa.selenium.WebElement;

import com.genric.utilities.BaseJD;
import com.genric.utilities.DateFetch;
import com.genric.utilities.DayUsingDate;

public class dummy extends BaseJD
{
	public static void main(String[]args)
	{
		System.out.println(DateFetch.getNextDate(30));
		
		DayUsingDate dud = new DayUsingDate();
		System.out.println(dud.getDay());
		
		
	
}}