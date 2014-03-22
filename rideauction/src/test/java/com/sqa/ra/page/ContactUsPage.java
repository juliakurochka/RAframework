package com.sqa.ra.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.RAPage;

public class ContactUsPage extends RAPage {
	@FindBy(how=How.ID_OR_NAME,using="your-name")
	WebElement yourName;
	@FindBy(how=How.ID_OR_NAME,using="your-email")
	WebElement yourEmail;
	@FindBy(how=How.ID_OR_NAME,using="your-subject")
	WebElement yourSubj;
	@FindBy(how=How.ID_OR_NAME,using="your-message")
	WebElement yourMessage;
	

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void verifyPageElements() {
		
		///
		

	}


	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementClickable(By.id("user-name"));
		
	}
	public void enterContactUSDetail(String userName,String email){
		yourName.sendKeys(userName);
		yourEmail.sendKeys(email);
		
	}

}
