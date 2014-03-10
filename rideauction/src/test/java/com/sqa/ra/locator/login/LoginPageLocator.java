package com.sqa.ra.locator.login;

import org.openqa.selenium.By;

public interface LoginPageLocator {
	
	By LOGIN_LINK=By.linkText("Login");
	By LOGIN_PAGE_IMG=By.cssSelector("#login>h1>a");
	By USER_NAME_TXT_BOX=By.id("user_login");
	By PASSWORD_TXT_BOX=By.id("user_pass");
	By LOGIN_BTN=By.id("wp-submit");
	By BACKTO_RIDEAUCTION_LINK=By.cssSelector("#backtoblog>a");

}
