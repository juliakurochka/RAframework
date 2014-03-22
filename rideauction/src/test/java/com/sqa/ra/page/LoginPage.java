package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;

import static com.sqa.ra.locator.login.LoginPageLocator.*;

import com.sqa.ra.framework.PropertyManager;
import com.sqa.ra.framework.RAPage;

public class LoginPage extends RAPage {
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public void verifyPageElements(){
		verifyElementPresent(LOGIN_BTN);
		//Verify other Elements
	}
	
	public RAHomePage loginWithValidUserId(String userId, String password){
		type(USER_NAME_TXT_BOX, userId);
		type(PASSWORD_TXT_BOX,password);
		verifyAndClick(LOGIN_BTN);
		return new RAHomePage(driver);
	}
	
	public RAHomePage clickonBackToRideAuctionLink(){
		//verifyAttribute(elmLocator, "href", PropertyManager.getProperty("appurl"));;
		verifyAndClick(BACKTO_RIDEAUCTION_LINK);
		return new RAHomePage(driver);
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		
	}

	
	
	//Add the method for Lost Password page
	

}
