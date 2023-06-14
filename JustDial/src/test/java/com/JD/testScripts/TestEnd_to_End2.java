package com.JD.testScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.JDapp.pages.BookingPage;
import com.JDapp.pages.HomePage;
import com.JDapp.pages.LoginPage;
import com.JDapp.pages.SearchCityOrAirportPage;
import com.JDapp.pages.SearchFlightsPage;
import com.JDapp.pages.SelectDatesPage;
import com.JDapp.pages.TravelPage;
import com.genric.utilities.BaseJD;
import com.genric.utilities.DateFetch;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class TestEnd_to_End2 extends BaseJD
{
	/**  open JD app click skip select while using the app access to contacts click on travel click on flights
	 * select Bangalore go to Hyderabad select next 10th day flight also book return ticket of next 20th day flight
	 */

	@Test
	public void flightBooking()
	{
		//pass departure and return days i:e departure days left and after howmany days to return
		int deptdaysreq=10;
		int retdaysreq=20;

		//click on skip once opening the APP
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getSkipButton().click();
		genricWaitinSec(2);


		//give permission to access location
		HomePage homePage = new HomePage(driver);
		homePage.getOnlyThisTimeButton().click();


		//give permission to access contacts
		homePage.getAllowButton().click();
		genricWaitinSec(2);


		//select travel icon
		homePage.getTavelIcon().click();


		//select Flights button
		TravelPage travelPage = new TravelPage(driver);
		travelPage.getFlightsIcon().click();


		//select round trip
		SearchFlightsPage searchFlights = new SearchFlightsPage(driver);
		searchFlights.getRoundTripTab().click();

		genricWaitinSec(3);

		//click on from button
		searchFlights.getFromButton().click();

		//send blr 
		SearchCityOrAirportPage searchCityOrAirport = new SearchCityOrAirportPage(driver);
		searchCityOrAirport.getSearchTextField().sendKeys("blr");

		genricWaitinSec(2);
		//select bangalore kempegowda airport
		searchCityOrAirport.getBangloreAirportOption().click();

		genricWaitinSec(1);

		//click on to button
		searchFlights.getToButton().click();

		//send hyd 
		searchCityOrAirport.getSearchTextField().sendKeys("hyd");
		genricWaitinSec(1);


		//select hyderabad Rajiv gandhi airport
		searchCityOrAirport.getHyderabadAirportOption().click();


		//click on departure button
		searchFlights.getDepartureButton().click();
		genricWaitinSec(1);

		//fetch next available date for booking (today visible or tomorrow)
		SelectDatesPage selectDates = new SelectDatesPage(driver);
		String s=selectDates.getDepartureDate().getText();




		//fetch selected elements in page
		List<String> values = new ArrayList<>();
		for(WebElement date : selectDates.getDates()) 
		{
			if(date.isSelected())
			{
				String	value=date.getText();
				values.add(value);
			}
		}


		//pass the departure days from today
		String txt = values.get(0);
		//int date = Integer.parseInt(txt);

		String currentDate = DateFetch.getNextDate(0);
		String nextDate="";
		if (txt.contains(currentDate)) 
		{
			nextDate = DateFetch.getNextDate(deptdaysreq+1);
		} else 
		{
			nextDate = DateFetch.getNextDate(deptdaysreq);
		}

		//System.out.println(nextDate);

		String[] lll = nextDate.split(" ");

		String kkk = lll[0];
		//System.out.println(kkk);
		int valuetobePassedinXpathtoGetDate = Integer.parseInt(kkk);
		int mmm = valuetobePassedinXpathtoGetDate;
		String nnn=null;
		if(kkk.contains("0")&&valuetobePassedinXpathtoGetDate<10)
		{
			nnn=kkk.replaceAll("0", "");
			valuetobePassedinXpathtoGetDate=Integer.parseInt(nnn);
			mmm=valuetobePassedinXpathtoGetDate;

		}
		//System.out.println(mmm);

		//act.longPress(PointOption.point(500, 2000)).moveTo(PointOption.point(500, 1900)).release().perform();

		genricWaitinSec(2);
		//select next 10th day flight
		List<AndroidElement> visibility=driver.findElementsByXPath("//android.widget.TextView[@text='"+mmm+"']");
		driver.findElementByXPath("(//android.widget.TextView[@text='"+mmm+"'])["+visibility.size()+"]").click();


		//pass the return date in days



		int ppp=deptdaysreq+retdaysreq;
		//System.out.println("ppp"+ ppp);
		//fetch return date
		String retrDate = DateFetch.getNextDate(ppp);
		//System.out.println("retDate"+ retrDate);
		String[] qqqq = retrDate.split(" ");
		//System.out.println("qqqq"+ qqqq);


		int rrrr;
		if(qqqq[0].contains("0")&&Integer.parseInt(qqqq[0])<10)
		{
			qqqq[0]=qqqq[0].replaceAll("0", "");
			rrrr = Integer.parseInt(qqqq[0]);

		}
		else
		{
			rrrr = Integer.parseInt(qqqq[0]);
		}



		//System.out.println(rrrr);


		List<AndroidElement> visibility2=driver.findElementsByXPath("//android.widget.TextView[@text='"+rrrr+"']");
		//click on next req date

		int ww = visibility2.size()-1;
		//System.out.println(ww);

		genricWaitinSec(2);
		if(rrrr>mmm)
		{
			WebElement ele = driver.findElementByXPath("(//android.widget.TextView[@text='"+rrrr+"'])");
			//System.out.println(ele.getText());
			ele.click();
		}
		else
		{
			WebElement ele = driver.findElementByXPath("(//android.widget.TextView[@text='"+rrrr+"'])["+visibility2.size()+"]");
			//System.out.println(ele.getText());
			ele.click();
		}

		genricWaitinSec(3);

		//click on search
		searchFlights.getSearchButton().click();
		genricWaitinSec(5);


		/** select indigo flight which are available after 7:30 PM for both departure and return */ 

		BookingPage booking = new BookingPage(driver);
		booking.clickLateDepture();

		act.longPress(PointOption.point(500, 1800)).moveTo(PointOption.point(500, 200)).release().perform();
		genricWaitinSec(1);

		if(booking.CheckIfIndigoavailable())
		{
			booking.checkforIndigoFlightafterbetween7_30and8_00andSelect();
		}
		else
		{
			booking.BookAvailable1stFlight();
		}
		genricWaitinSec(3);
		
		/**return ticket selection*/
		
		//booking.clickLateDepture();
		
		//Swipe left bottom navigation bar
		act.longPress(PointOption.point(590, 1446)).moveTo(PointOption.point(300, 1466)).release().perform();
		
		
		
		
		//tap late departure flight
		act.tap(PointOption.point(524, 1440)).release().perform();
		genricWaitinSec(4);
		
		act.longPress(PointOption.point(500, 1300)).moveTo(PointOption.point(500, 200)).release().perform();
		genricWaitinSec(4);
		
		act.longPress(PointOption.point(500, 1300)).moveTo(PointOption.point(500, 200)).release().perform();
		genricWaitinSec(4);
		
		
		
		//Swipe left bottom navigation bar
		act.longPress(PointOption.point(590, 1446)).moveTo(PointOption.point(300, 1466)).release().perform();
		
		
		//tap late departure flight
		act.tap(PointOption.point(524, 1440)).release().perform();
		genricWaitinSec(4);
		
		if(booking.CheckIfIndigoavailable())
		{
			booking.CheckforIndigoreturnFlight_bn7_30and8_00();
		}
		else
		{
			booking.BookAvailable1stRetFlight();
		}
	
		
		genricWaitinSec(2);
		
		//click on book
		booking.getBookButton().click();
		genricWaitinSec(2);

//		//Scroll down 2 times
//		act.longPress(PointOption.point(500, 1800)).moveTo(PointOption.point(500, 200)).release().perform();
//		genricWaitinSec(1);
//		act.longPress(PointOption.point(500, 1800)).moveTo(PointOption.point(500, 200)).release().perform();
//		genricWaitinSec(3);
//
//
//		//click on radio button Yes, secure my trip
//		act.tap(PointOption.point(84, 737)).release().perform();
//
//		genricWaitinSec(1);
//		//click on continue button
//
//		//driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
//		act.tap(PointOption.point(750, 2100)).release().perform();
//		genricWaitinSec(5);
//

		
		

	}
}
