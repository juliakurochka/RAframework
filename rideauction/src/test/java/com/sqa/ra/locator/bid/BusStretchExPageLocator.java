package com.sqa.ra.locator.bid;

import org.openqa.selenium.By;

public interface BusStretchExPageLocator {
	By HOURLY_IN_CITY_RADIO_BTN = By.xpath("//input[@id='hourlydriver']");
	By HOURLY_OUT_CITY_RADIO_BTN = By.xpath("//input[@id='hourlycircle']");
	
	By BID_ON_RIDE_BTN = By.cssSelector("#exotic input[type=submit]");
	By PSSNGR_DROP_DOWN = By.id("NoOfPass");
	By CAR_DROP_DOWN = By.cssSelector("select[name=selectcar]");
	
	By DATE_PICKER = By.id("datepicker");
	By HOURS_SLCT_BOX = By.id("hour");
	By MIN_SLCT_BOX = By.id("minute");
//	By NUM_HOURS_SLCT_BOX = By.cssSelector("select[name=NumberOfHours]");
	By ORIGIN_ADDRS_TEXT_BOX = By.cssSelector("textarea[name=OriginationAddress]");
//	By DSCRB_REQ_TEXT_BOX = By.cssSelector("textarea[name=RequestBody]");
	By DSCRB_REQ_TEXT_BOX = By.name("RequestBody");
	
	By EMAIL_TEXT_BOX = By.cssSelector("input[name=Mail]");
	By PHONE_TEXT_BOX = By.cssSelector("input[name=Phone]");
	By BUDGET_TEXT_BOX = By.cssSelector("input[name=budget]");
	By EXOTIC_SUBMIT_BTN=By.id("orderexoticsubmit");
	By OK_BTN=By.id("exoticclose");
	
    String BUDGET_TEXT_VALUE = "200";
}
