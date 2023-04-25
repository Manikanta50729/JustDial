package com.genric.utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class Utils 
{
	//staticdriver=driver;
	
 // public static AndroidDriver<AndroidElement> driver;
public static void genricWaitinSec(int i) 
  {
	  try {
		Thread.sleep(i*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
	  public static void tapRandom(AndroidDriver<AndroidElement> driver, int x, int y) 
	  { 
		  
		  AndroidDriver<AndroidElement> s = driver;
		  TouchAction t = new TouchAction(s); 
		  t.tap(PointOption.point(x, y)).perform(); 
	  }
	 
  //public static void scrollaction()
  {
	  
  }
}
