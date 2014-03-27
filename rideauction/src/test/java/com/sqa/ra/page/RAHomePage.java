package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;

import com.sqa.ra.framework.RAPage;

import static com.sqa.ra.locator.home.HomePageLocator.*;

public class RAHomePage extends RAPage{
	public RAHomePage(WebDriver driver){
		super(driver);
		
	}
	
	@Override
	public void waitForPageToLoad() {
		waitForElementPresent(FOOTER_PRESENT);
		
	}

	
	public void verifyPageElements(){
		verifyElementPresent(HOW_IT_WORKS_LNK);
		verifyElementPresent(FAQ_LNK);
		verifyElementPresent(ABOUT_US_LNK);
		verifyElementPresent(CORPORATE_LNK);
		verifyElementPresent(BECOME_OUR_PARTNER_LNK);
		verifyElementPresent(CONTACT_US_LNK);
		verifyElementPresent(LOGIN_LNK);
		
	}
	
	public HowItWorksPage clickOnHowItWorksLink(){
		verifyAndClick(HOW_IT_WORKS_LNK);
		return new HowItWorksPage(driver);
		
	}
	public LoginPage clickOnLoginLink(){
		verifyAndClick(LOGIN_LNK);
		return new LoginPage(driver);
		
	}
	public BidOnRideToAirportPage clickOnBidOnRideToAirport(){
		verifyAndClick(TO_AIRPORT_RADIO_BTN);
		verifyAndClick(BID_ON_RIDE_AIRPORT_BTN);
		return new BidOnRideToAirportPage(driver);
		
	}
	
	public BidOnRidePointToPointPage clickOnBidOnRidePointToPoint(){
		verifyAndClick(BID_ON_RIDE_POINT_TO_POINT_BTN);
		return new BidOnRidePointToPointPage(driver);
	}







}
