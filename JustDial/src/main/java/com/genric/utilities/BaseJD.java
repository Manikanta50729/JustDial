package com.genric.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.genric.utilities.Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseJD extends Utils
{
	public static AndroidDriver driver;
	 public TouchAction act;
	//public static AndroidDriver staticdriver;
@BeforeMethod
public void beforeM() throws MalformedURLException
{
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "POCO");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");
	//cap.setCapability(MobileCapabilityType.UDID, "98dfb6d6");
	
	cap.setCapability("appPackage", "com.justdial.search");
	cap.setCapability("appActivity", "com.justdial.search.SplashScreenNewActivity");
	
	URL url = new URL("http://localhost:4725/wd/hub");
	
	driver=new AndroidDriver(url, cap);   System.out.println("app open");
	
	act = new TouchAction(driver);
	
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.resetApp();
	genricWaitinSec(5);
}

@AfterMethod
public void afterM()
{
	
	//driver.quit();   
	//System.out.println("app closed");
}
}
