package com.genric.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayUsingDate 
{
 public String getDay()
 {
	 String dateString = "24-Apr-2023";
	 String day="";
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
     try {
         Date date = dateFormat.parse(dateString);
         SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
         day = dayFormat.format(date);
     } catch (Exception e) {
         e.printStackTrace();
     }
     return day;
 }
}
