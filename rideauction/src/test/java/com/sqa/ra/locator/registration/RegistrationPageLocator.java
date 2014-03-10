package com.sqa.ra.locator.registration;

import org.openqa.selenium.By;

public interface RegistrationPageLocator {
	
	public static final By Register_Button = By.id("wp-submit");
	public static final By USER_NAME = By.name("user_login");
	public static final By EMAIL = By.name("user_email");
	public static final By PASSWORD= By.name("user_pass");
	public static final By PHONE = By.name("UserPhone");
	public static final By PROMO_CODE = By.name("promocode");
	public static final By CAPTCHA = By.id("recaptcha_response_field");
	public static final By Terms_Checkbox = By.id("terms");
	public static final By Register_Error = By.id("login_error");
	
	By ERROR_MSG=By.id("login_error");
	
	By LOGIN_LINK=By.linkText("Log in");
	

}
