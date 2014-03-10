package com.sqa.ra.webtest.home;

import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.HowItWorksPage;
import com.sqa.ra.page.LoginPage;
import com.sqa.ra.page.RAHomePage;

public class TestHomePage extends WebDriverTest{
	
	@Test
	public void testHomePaheLinks(){
		
		RAHomePage homePage=new RAHomePage(driver);
		homePage.verifyHomePageLinks();
		
	}
	
	@Test
	public void testHowItWorks(){
		RAHomePage homePage=new RAHomePage(driver);
		HowItWorksPage howPage=homePage.clickOnHowItWorksLink();
		howPage.verifyHowItWorksHeadings();
	}
	
	@Test
	public void testLoginPage(){
		RAHomePage homePage=new RAHomePage(driver);
		LoginPage loginPage=homePage.clickOnLoginLink();
		 homePage=loginPage.
				 loginWithValidUserId("sdfdf","dvdfgg");
		 //Verify User Logo On Home Page
		 //homepage.verifyUserLogo
	  homePage.verifyHomePageLinks();
	}
	
	/***
	 * 1 Login Link
	 * 2 Verify login Page
	 * 3. Click
	 */


}
