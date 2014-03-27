package com.sqa.ra.webtest.bid;


import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.BidOnRideBusStretchExPage;

/*
 * @author Tim Reynolds
 */
public class TestBidOnRideBusStretchEx extends WebDriverTest{
	Logger logger = Logger.getLogger(TestBidOnRideBusStretchEx.class);
	
	String ORIGIN_ADDRS_TEXT_VALUE = "140 San Pedro Road, Daly City, CA, United States";
	String DSCRB_REQ_TEXT_VALUE = "Drive around have fun";
		
	
	@DataProvider(name="exotictDataProvider")
	public Object[][] registrationDataProvider(){
		Object[][] objs = com.sqa.ra.framework.ExcelReader.readExcelData("exoticRideData.xlsx", "Sheet1");
		return objs;		
	}
	
	
	@Test
	public void testBidOnRideBusStretchEx(){
		BidOnRideBusStretchExPage stretchRidePg = homePage.clickOnBusStretchExoticCarRide();
		stretchRidePg.bidOnBusStretchExoticRide(
				 "10", 
				 "SUV Stretch (10+ Pass)", 
				 "04-01-2014",
				 "09",
				 "30",
				 ORIGIN_ADDRS_TEXT_VALUE,
				 DSCRB_REQ_TEXT_VALUE,
				 "phony@email.com",
				 "555-1212",
				 "200");
	}
	
	@Test
	public void testSubmitWithoutBudgetInvalid(){
		BidOnRideBusStretchExPage stretchRidePg = homePage.clickOnBusStretchExoticCarRide();
		stretchRidePg.
			setPassengers("1").
			setCarType("SUV Stretch (10+ Pass)").
			setDate("04-01-2014").setHour("08").
			setMin("30").
			setOriginAddr(ORIGIN_ADDRS_TEXT_VALUE).
			setReqDescr(DSCRB_REQ_TEXT_VALUE).
			setEmail("phony@email.com").
			setPhone("555-1212");
		stretchRidePg.submitInvalidRequest();
	}
	
	@Test(dataProvider="exotictDataProvider", enabled=true)
	public void testBidOnRideBusStretchExData(	
			String noPassengers, 
			String carType, 
			String date,
			String hour,
			String min,
			String originAddr,
			String reqDescription,
			String email,
			String phone,
			String budget){

		BidOnRideBusStretchExPage stretchRidePg = homePage.clickOnBusStretchExoticCarRide();
		stretchRidePg.
			setPassengers(noPassengers).
			setCarType(carType).
			setDate(date).
			setHour(hour).
			setMin(min).
			setOriginAddr(originAddr).
			setReqDescr(reqDescription).
			setEmail(email).
			setPhone(phone);
		stretchRidePg.submitInvalidRequest();
	}

}
