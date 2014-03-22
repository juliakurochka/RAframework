package com.sqa.ra.page;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class ContactUsPageWithPageFactory extends com.sqa.ra.framework.RAPage {
	//@CacheLookup
	@FindBy(how=How.ID, using="your-name")
	WebElement yourName;
	
	@FindBy(how=How.ID, using="your-email")
	WebElement yourEmail;
	
	@FindBy(how=How.ID, using="your-subject")
	WebElement yourSubject;
	
	@FindBy(how=How.ID, using="your-message")
	WebElement yourMessage;
	
	
	@FindBy(how=How.CSS, using="input[value='Send1']")
	WebElement sendBtn;
	
	
	///
	
	
	
	
	
	
	
	
	

	public ContactUsPageWithPageFactory(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		
		Assert.assertNotNull(sendBtn);
		Assert.assertNotNull(yourMessage);
		Assert.assertNotNull(yourSubject);
		
	}
	
	public void enterContactUSvalidDetails(String name,String email,String subject,String message){
		
		yourName.sendKeys(name);
		yourEmail.sendKeys(email);
//		yourSubject.sendKeys(subject);
//		yourMessage.sendKeys(message);
		//sendBtn.click();
		
		
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
