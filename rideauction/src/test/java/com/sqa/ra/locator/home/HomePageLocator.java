package com.sqa.ra.locator.home;

import org.openqa.selenium.By;

public interface HomePageLocator {
	By REGISTRAION_LINK=By.linkText("Registration");
By HOME_PAGE_LOGO			= By.cssSelector("img[title=RideAuction]");
	
	//Bid On Ride buttons for each module
	By TO_AIRPORT_RADIO_BTN 	= By.id("toairport");
	By FROM_AIRPORT_RADIO_BTN 	= By.id("fromairport");
	By BID_ON_RIDE_AIRPORT_BTN 	= By.cssSelector("#airport input[type='submit']");
	
	By BID_ON_RIDE_HOURLY_BTN 	= By.cssSelector("#hourly input[type='submit']");
	By INTHECITY_RADIO_BTN		= By.id("hourlydriver");
	By OUTSIDE_RADIO_BTN		= By.id("hourlycircle");
	
	By BID_ON_RIDE_POINT_TO_POINT_BTN = By.cssSelector("#transfers input[type='submit']");	
	
	By BID_ON_RIDE_BSEC_BTN 	= By.cssSelector("#exotic input[type='submit']");

	
	
	//Bottom links
	By HOW_IT_WORKS_LNK			= By.linkText("How it works");
	By BECOME_OUR_PARTNER_LNK	= By.linkText("Become our Partner");
	By FAQ_LNK					= By.linkText("FAQ");
	By ABOUT_US_LNK				= By.linkText("About Us");
	By CORPORATE_LNK			= By.linkText("Corporate");
	By CONTACT_US_LNK			= By.linkText("Contact Us");
	By LOGIN_LNK				= By.linkText("Login");
	By REGISTRATION_LNK			= By.linkText("Registration");

	By FOOTER_PRESENT           = By.cssSelector("div[class='wrapper footer']");

}
