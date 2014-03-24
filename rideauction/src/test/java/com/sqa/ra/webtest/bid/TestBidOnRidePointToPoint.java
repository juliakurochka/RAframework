package com.sqa.ra.webtest.bid;

import org.testng.annotations.Test;

import com.sqa.ra.framework.WebDriverTest;
import com.sqa.ra.page.BidOnRidePointToPointPage;
import com.sqa.ra.page.RAHomePage;

public class TestBidOnRidePointToPoint extends WebDriverTest {

	@Test
	public void TestBidOnRidePointToPointElements() {
		RAHomePage homePage = new RAHomePage(driver);
		BidOnRidePointToPointPage ptpPage = homePage
				.clickOnBidOnRidePointToPoint();
		ptpPage.verifyPageElements();
	}

	@Test
	public void TestPTPsubmitAllFieldsWithValidData() {
		RAHomePage homePage = new RAHomePage(driver);
		BidOnRidePointToPointPage ptpPage = homePage
				.clickOnBidOnRidePointToPoint();
		ptpPage.verifyPageElements();
		ptpPage.submitAllFields("3",
				"140 San Pedro Road, Daly City, CA, United States",
				"1080 Ralston Avenue, Belmont, CA, United States", "Luxury");
	}

}
