package com.sqa.ra.locator.bid;

import org.openqa.selenium.By;

public interface BidOnRidePointToPointPageLocators {

	By PASSENGERS_DROPDOWN = By.id("passengers");
	By DATE_PICKER = By.id("datepicker");
	By HOUR_PICKER = By.id("hour");
	By MINUTE_PICKER = By.id("minute");
	By ORIGINATION_ADDRESS_FIELD = By.name("OriginationAddress");
	By DESTINATION_ADDRESS_FIELD = By.name("DestinationAddress");
	By CAR_SELECTOR = By.id("Car");
	By PROMOCODE_FIELD = By.name("PromoCode");
	By POINT_TO_POINT_SUBMIT_BTN = By
			.cssSelector("#transfers input[type=submit]");
	By PRICECHECK_BTN = By.id("pricecheck");

}
