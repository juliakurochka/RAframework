package com.sqa.ra.page;

import static com.sqa.ra.locator.bid.BidOnRideAirportPageLocator.DATE_PICKER;
import static com.sqa.ra.locator.bid.BidOnRideAirportPageLocator.PRICE_CHK_BTN;
import static com.sqa.ra.locator.bid.BidOnRidePointToPointPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sqa.ra.framework.RAPage;
import com.sqa.ra.framework.Tomorrow;

public class BidOnRidePointToPointPage extends RAPage {

	public BidOnRidePointToPointPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementClickable(PRICE_CHK_BTN);
	}

	@Override
	public void verifyPageElements() {
		verifyElementPresent(PASSENGERS_DROPDOWN);
		verifyElementPresent(DATE_PICKER);
		verifyElementPresent(HOUR_PICKER);
		verifyElementPresent(MINUTE_PICKER);
		verifyElementPresent(ORIGINATION_ADDRESS_FIELD);
		verifyElementPresent(DESTINATION_ADDRESS_FIELD);
		verifyElementPresent(CAR_SELECTOR);
		verifyElementPresent(PROMOCODE_FIELD);
		verifyElementPresent(POINT_TO_POINT_SUBMIT_BTN);

	}
	
	public DatePickerPage selectDatePicker(){
		verifyAndClick(DATE_PICKER);
		DatePickerPage dp=new DatePickerPage(driver);
       return dp;
	}
	
	public void submitAllFields(String noPassengers, String origAddress, String destAddress, String car) {

		selectDropDownByVisibleText(PASSENGERS_DROPDOWN, noPassengers);
		
		DatePickerPage dp = selectDatePicker();
		dp.verifyPageElements();
		dp.verifyAndClickDate(Tomorrow.getTomorrow().getDate());

		selectDropDownByVisibleText(HOUR_PICKER, "5 PM");
		selectDropDownByVisibleText(MINUTE_PICKER, ":15");
		type(ORIGINATION_ADDRESS_FIELD,
				origAddress);
		type(DESTINATION_ADDRESS_FIELD,
				destAddress);
		selectDropDownByVisibleText(CAR_SELECTOR, car);
		verifyAndClick(PRICECHECK_BTN);

	}


}
