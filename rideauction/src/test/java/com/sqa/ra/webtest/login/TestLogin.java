package com.sqa.ra.webtest.login;

import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.LoginPage;
import com.sqa.ra.page.RAHomePage;

public class TestLogin extends WebDriverTest {
	
	@Test
	public void testLoginWithValidDetails(){
		
		RAHomePage homepage=new RAHomePage(driver);
		LoginPage loginPage=homepage.clickOnLoginLink();
		homepage=loginPage.loginWithValidUserId("dfsdfsfd", "dfsgd");
		homepage.verifyHomePageLinks();
	}
	
	@Test
	public void testBackToHomePageLink(){
		RAHomePage homePage=new RAHomePage(driver);
		LoginPage loginPage=homePage.clickOnLoginLink();
		loginPage.verifyLoginPageEements();
		homePage=loginPage.clickonBackToRideAuctionLink();
		homePage.verifyHomePageLinks();
	}
	
	// Write The Test Case for Lost your Password
	
	//Write Test Case to test Register Link from Login Page
	
	
	
	

}
