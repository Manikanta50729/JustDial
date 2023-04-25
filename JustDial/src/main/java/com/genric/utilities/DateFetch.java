package com.genric.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFetch 
{
public static String getNextDate(int d)
{
	String requiredDate="";
	
	// Get today's date
    LocalDate currentDate = LocalDate.now();
    
    // Define the date formatter
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MMM yyyy");

    // Print the next 30th day' date is
    LocalDate nextDate = currentDate.plusDays(d);
    requiredDate = nextDate.format(f);
       
	
	//return requiredDate;
    return requiredDate;
}
}
