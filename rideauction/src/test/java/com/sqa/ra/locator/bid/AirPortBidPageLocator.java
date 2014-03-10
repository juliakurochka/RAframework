package com.sqa.ra.locator.bid;

public interface AirPortBidPageLocator {
	String FROM_AIRPORT_RADIO_BTN="//input[@id='fromairport']";
	String BID_ON_RIDE_BTN="//div[@id='airport']/input[@type='submit']";
	String PSNGR_SLCT_BOX="CSS=#passengers";
	String DATE_PICKER="CSS=#datepicker";
	String HOUR_SLCT_BOX="CSS=#hour";
	String MINUTE_SLCT_BOX="CSS=#minute";
	String AIRPORT_SLCT_BOX="CSS=#FromAirport";
	String DEST_ADDRS_TEXT_BOX="CSS=textarea[name=DestinationAddress]";
	String FLIGHT_NO_TEXT_BOX="CSS=input[name=Airline]";
	
	String PRICE_CHK_BTN="CSS=#pricecheck";
	

}
