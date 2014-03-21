package com.sqa.ra.webtest.bid;

import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.BidOnRideToAirportPage;

public class TestBidOnRideToAirport extends WebDriverTest {
	
	@Test 
	public void testBidOnRideToAirport(){
		BidOnRideToAirportPage toAiportPage=homePage.clickOnBidOnRideToAirport();
		toAiportPage.doPriceCheckAfterFillingRequiredFields("3", "03-23-2014", "2 AM", 
				"SFO-San Francisco International", "140 San Pedro Road, Daly City, CA, United States");
		toAiportPage.clickBuyButtonWithoutAcceptingTermsCheckBox();
		
	}
	
	

}
