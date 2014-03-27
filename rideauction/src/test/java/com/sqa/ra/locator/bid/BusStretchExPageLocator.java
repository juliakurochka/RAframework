package com.sqa.ra.locator.bid;

import org.openqa.selenium.By;

public interface BusStretchExPageLocator {
	By BID_ON_RIDE_BTN = By.cssSelector("#exotic input[type=submit]");
	By PSSNGR_DROP_DOWN = By.id("NoOfPass");
	By CAR_DROP_DOWN = By.name("selectcar");

	By DATE_PICKER = By.id("datepicker");
	By HOURS_SLCT_BOX = By.id("hour");
	By MIN_SLCT_BOX = By.id("minute");
	By ORIGIN_ADDRS_TEXT_BOX = By.name("OriginationAddress");
	By DSCRB_REQ_TEXT_BOX = By.name("RequestBody");
			
	By EMAIL_TEXT_BOX = By.name("Mail");
	By PHONE_TEXT_BOX = By.name("Phone");
	By BUDGET_TEXT_BOX = By.name("budget");

	By EXOTIC_SUBMIT_BTN=By.id("orderexoticsubmit");
	By OK_BTN=By.id("exoticclose");
	
    String BUDGET_TEXT_VALUE = "200";
}
