package com.sqa.ra.page;

import static com.sqa.ra.locator.bid.BusStretchExPageLocator.BUDGET_TEXT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.CAR_DROP_DOWN;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.DSCRB_REQ_TEXT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.EMAIL_TEXT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.EXOTIC_SUBMIT_BTN;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.HOURS_SLCT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.MIN_SLCT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.ORIGIN_ADDRS_TEXT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.PHONE_TEXT_BOX;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.PSSNGR_DROP_DOWN;
import static com.sqa.ra.locator.bid.BusStretchExPageLocator.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sqa.ra.framework.RAPage;

public class BidOnRideBusStretchExPage extends RAPage{
	Logger logger = Logger.getLogger(BidOnRideBusStretchExPage.class);
	
	public BidOnRideBusStretchExPage(WebDriver driver){
		super(driver);		
	}
	
	@Override
	public void waitForPageToLoad() {
		waitForElementPresent(EXOTIC_SUBMIT_BTN);
		
	}

	public void verifyPageElements(){
		verifyElementPresent(PSSNGR_DROP_DOWN);
		verifyElementPresent(CAR_DROP_DOWN);
		verifyElementPresent(DATE_PICKER);
		verifyElementPresent(HOURS_SLCT_BOX);
		verifyElementPresent(MIN_SLCT_BOX);
		verifyElementPresent(ORIGIN_ADDRS_TEXT_BOX);
		verifyElementPresent(BUDGET_TEXT_BOX);
	}

	
	public void bidOnBusStretchExoticRide(
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
		
		setPassengers( noPassengers);		
		setCarType( carType);		
		setDate(date);
		setHour( hour);		
		setMin( min);		
		setOriginAddr( originAddr);
		setReqDescr( reqDescription);		
		setEmail( email);		
		setPhone( phone);		
		setBudget( budget);
		
		
//		verifyAndClick(EXOTIC_SUBMIT_BTN);		
	}
	
	/**
	 * Verify we remain on the page when
	 * the submit is not valid
	 */
	public void submitInvalidRequest(){
		verifyAndClick(EXOTIC_SUBMIT_BTN);
		verifyPageElements();
	}
	
	public BidOnRideBusStretchExPage setDate(String date){
		verifyAndClick(DATE_PICKER);
		DatePickerPage dp=new DatePickerPage(driver);
		dp.verifyPageElements();
		dp.verifyAndClickDate(date);		
		return this;
	}
	
	public BidOnRideBusStretchExPage setPassengers(String noPassengers){
		selectDropDownByValue(PSSNGR_DROP_DOWN, noPassengers);		
		return this;
	}
	
	public BidOnRideBusStretchExPage setCarType(String carType){
		selectDropDownByValue(CAR_DROP_DOWN, carType);
		return this;
	}
	
	public BidOnRideBusStretchExPage setHour(String hour){
		selectDropDownByValue(HOURS_SLCT_BOX, hour);
		return this;
	}
	
	public BidOnRideBusStretchExPage setMin(String minute){
		selectDropDownByValue(MIN_SLCT_BOX, minute);
		return this;
	}
	
	public BidOnRideBusStretchExPage setOriginAddr(String originAddr){
		type(ORIGIN_ADDRS_TEXT_BOX, originAddr);
		return this;
	}

	public BidOnRideBusStretchExPage setReqDescr(String reqDescr){
		type(DSCRB_REQ_TEXT_BOX, reqDescr);
		return this;
	}
	
	public BidOnRideBusStretchExPage setEmail(String email){
		type(EMAIL_TEXT_BOX, email);
		return this;
	}
	
	public BidOnRideBusStretchExPage setPhone(String phone){
		type(PHONE_TEXT_BOX, phone);
		return this;
	}
	
	public BidOnRideBusStretchExPage setBudget(String budget){
		type(BUDGET_TEXT_BOX, budget);
		return this;
	}





}
