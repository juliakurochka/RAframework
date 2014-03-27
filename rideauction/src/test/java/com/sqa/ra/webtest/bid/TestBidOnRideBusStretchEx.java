package com.sqa.ra.webtest.bid;


import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.BidOnRideBusStretchExPage;

/*
 * @author Tim Reynolds
 */
public class TestBidOnRideBusStretchEx extends WebDriverTest{
	String ORIGIN_ADDRS_TEXT_VALUE = "140 San Pedro Road, Daly City, CA, United States";
	String DSCRB_REQ_TEXT_VALUE = "Drive around have fun";
		
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
}
