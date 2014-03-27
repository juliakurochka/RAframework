package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;

import static com.sqa.ra.locator.bid.BidOnRideAirportPageLocator.*;

import com.sqa.ra.framework.RAPage;
import com.sqa.ra.page.bid.PassengerInfoPage;

public class BidOnRideToAirportPage extends RAPage{

	public BidOnRideToAirportPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void waitForPageToLoad() {
		waitForElementClickable(PRICE_CHK_BTN);
		
	}

	@Override
	public void verifyPageElements() {
		verifyElementPresent(PSNGR_DROP_DOWN);
		verifyElementPresent(DATE_PICKER);
		verifyElementPresent(HOUR);
		verifyElementPresent(MINUTE);
		
		verifyElementPresent(AIRPORT_DROP_DOWN);
		verifyElementPresent(ORIGIN_ADDRS);
		verifyElementPresent(CAR_DROP_DOWN);
		verifyElementPresent(PROMOCODE_TEXT_BOX);
		
		
	}
	
	public DatePickerPage selectDatePicker(){
		verifyAndClick(DATE_PICKER);
		DatePickerPage dp=new DatePickerPage(driver);
       return dp;
	}
	
	public void doPriceCheckAfterFillingRequiredFields(String noPsngr,String pickUpDate,String hour,
			String airport,String originAddress){
		selectDropDownByVisibleText(PSNGR_DROP_DOWN, noPsngr);
		//select a date using the date Picker Page

		DatePickerPage dp = selectDatePicker();
		dp.verifyPageElements();
		dp.verifyAndClickDate(pickUpDate);
		
		selectDropDownByVisibleText(HOUR, hour);
		selectDropDownByVisibleText(AIRPORT_DROP_DOWN, airport);
		type(ORIGIN_ADDRS, originAddress);
		verifyAndClick(PRICE_CHK_BTN);
		
		
		
	}
	public void verifyPriceAfterPriceCheckClick(String averagePrice,String confirmPrice){
		verifyElemenAfterPriceCheck();
		// 
		
		verifyElementContainText(AVERAGE_PRICE, averagePrice);
		verifyElementContainText(CONFIRM_PRICE, confirmPrice);
		
		
	}
	public void verifyElemenAfterPriceCheck(){
		// add the verification of elements after price check
		
		
	}
	public void clickBuyButtonWithoutAcceptingTermsCheckBox(){
		waitForElementClickable(BUY_BTN);
		// add the verification of elements after price check
		verifyAndClick(BUY_BTN);
		//very the terms and condition message
		//
		verifyPageElements();
	}
	public PassengerInfoPage clickBuyButtonWithAcceptingTermsCheckBox(){
		waitForElementClickable(BUY_BTN);
		// add the verification of elements after price check
		verifyAndClick(TERMS_CHK_BOX);
		verifyAndClick(BUY_BTN);
		//very the terms and condition message
		return new PassengerInfoPage(driver);
	}
	public void clickBidButtonWithoutAcceptingTermsCheckBox(){
		waitForElementClickable(BID_BTN);
		// add the verification of elements after price check
		verifyAndClick(BID_BTN);
		//very the terms and condition message
		//
		verifyPageElements();
	}
	public PassengerInfoPage clickBidButtonWithAcceptingTermsCheckBox(String minAmt){
		waitForElementClickable(BID_BTN);
		// add the verification of elements after price check
		verifyAndClick(TERMS_CHK_BOX);
		type(BID_PRICE_TEXT_BOX, minAmt);
		verifyAndClick(BID_BTN);
		//very the terms and condition message
		return new PassengerInfoPage(driver);
	}

	
	
	
	

}
