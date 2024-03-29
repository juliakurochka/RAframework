package com.sqa.ra.locator.bid;

import org.openqa.selenium.By;

public interface BidOnRideAirportPageLocator {
	
	By TO_AIRPORT_RADIO_BTN=By.id("toairport");
	By FROM_AIRPORT_RADIO_BTN=By.id("fromairport");
	By BID_ON_RIDE_BTN=By.cssSelector("#airport input[type=submit]");
	By PSNGR_DROP_DOWN=By.id("passengers");
	By DATE_PICKER=By.id("datepicker");
	By HOUR=By.id("hour");
	By MINUTE=By.id("minute");
	By AIRPORT_DROP_DOWN=By.id("ToAirport");
	By ORIGIN_ADDRS=By.name("OriginationAddress");
	By CAR_DROP_DOWN=By.id("Car");
	By PROMOCODE_TEXT_BOX=By.name("PromoCode");
	By PRICE_CHK_BTN=By.id("pricecheck");
	By BUY_BTN=By.id("garantserv");
	By AVERAGE_PRICE=By.xpath("//h2[contains(text(),'Average Price')]");
	By CONFIRM_PRICE=By.xpath("//h2[contains(text(),'Confirmed Ride')]");
	By TERMS_CHK_BOX=By.id("termscheck");
	By BID_BTN=By.id("bidsubmit");
	By BID_PRICE_TEXT_BOX=By.id("bidprice");
	

}
