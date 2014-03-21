package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;

import com.sqa.ra.framework.RAPage;
import com.sqa.ra.locator.login.LoginPageLocator;

import static com.sqa.ra.locator.registration.RegistrationPageLocator.*;

public class RegistrationPage extends RAPage {
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	public void verifyRegistrationElms(){
		verifyElementPresent(EMAIL);
		verifyElementPresent(USER_NAME);
		verifyElementPresent(PASSWORD);
		//Add more verification for other elements
		
	}
	/* provide ParameterList*/
	public RAHomePage registerWithValidDetails(String userName){
			
		//Add
		
		//Add the commands to type field values
		
		
		return new RAHomePage(driver);
		
	}
	public LoginPage clickOnLoginLink(){
		
		//Add
		
		//Add the commands to type field values
		verifyAndClick(LOGIN_LINK);
		
		return new LoginPage(driver);
		
	}
	
	//Add the method for Lost Password
	
	public RAHomePage clickBackToRideAuctionLink(){
		verifyAndClick(LoginPageLocator.BACKTO_RIDEAUCTION_LINK);
		return new RAHomePage(driver);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		
	}
	
	
}
