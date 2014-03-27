package com.sqa.ra.webtest.bid;

import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.BidOnRideToAirportPage;

public class TestBidOnRideToAirport extends WebDriverTest {
	
	@Test 
	public void testBidOnRideToAirport(){
		BidOnRideToAirportPage toAirportPage=homePage.clickOnBidOnRideToAirport();
		// NOTE: a fixed date will go BAD once its past and cause the test to fail
		toAirportPage.doPriceCheckAfterFillingRequiredFields("3", "07-30-2014", "2 AM", 
				"SFO-San Francisco International", "140 San Pedro Road, Daly City, CA, United States");
		toAirportPage.clickBuyButtonWithoutAcceptingTermsCheckBox();
		
	}
	
	

}
