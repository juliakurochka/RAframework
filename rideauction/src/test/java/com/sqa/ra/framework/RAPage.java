package com.sqa.ra.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RAPage {
	Logger logger=Logger.getLogger(RAPage.class);
	protected WebDriver driver;
	public RAPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	/**
	 * To get Web Element
	 * @param elmLocator
	 * @return
	 */
	public WebElement getElement(By elmLocator){
		try{
			return driver.findElement(elmLocator);
			
		}catch(Exception ex){
			logger.error("Error while finding an element", ex);
			ex.printStackTrace();
		}
		return null;
		
	}
	/**
	 *  Verify and click on element 
	 * @param elmLocator
	 */
	
	public void verifyAndClick(By elmLocator){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		elm.click();
	}
	/**
	 *  Verify and click on element 
	 * @param elmLocator
	 */
	
	public void verifyAttribute(By elmLocator,String attrKey,String expectedValue){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		Assert.assertEquals(elm.getAttribute(attrKey), expectedValue);
	}
	
/**
 * check if element is present or not . If present returns true otherwise false
 * @param elmLocaotr
 * @return
 */
	public boolean isElementPresent(By elmLocator){
		if(getElement(elmLocator)==null){
			return false;
		}else{
			return true;
		}
			
		
	}
	/**
	 * check if element is present or not . If present returns true otherwise false
	 * @param elmLocaotr
	 * @return
	 */
		public void verifyElementPresent(By elmLocator){
			Assert.assertNotNull(getElement(elmLocator));
				
			
		}
	/**
	 * To Type into text box . takes two parameter 
	 * @param elmLocator:- Locator of element
	 * @param value :- Value to be typed
	 */
	
	public void type(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		elm.sendKeys(value);
		
	}
	/**
	 *  To select a value from drop down box
	 * @param elmLocator :- Element Locator
	 * @param value :value to be selected
	 */
	public void selectDropDownByVisibleText(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		Select select=new Select(elm);
		select.selectByVisibleText(value);
		
	}
	
	
	/**
	 *  To select a value from drop down box
	 * @param elmLocator :- Element Locator
	 * @param value :value to be selected
	 */
	public void selectDropDownByValue(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		Select select=new Select(elm);
		select.selectByValue(value);
		
	}
	/**
	 *  Wait for a element Present
	 * @param elmLocator Locator of the element
	 * @param timeInSecs time in seconds
	 */
	public void waitForElementPresent(By elmLocator,long timeInSecs){
		WebDriverWait wait=new WebDriverWait(driver,timeInSecs);
		wait.until(ExpectedConditions.presenceOfElementLocated(elmLocator));
		
	}
	
	public void verifyElementSelected(By elmLocator){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		Assert.assertTrue(elm.isSelected());
		
	}
	public void verifyElementEnabled(By elmLocator){
		WebElement elm=getElement(elmLocator);
		Assert.assertNotNull(elm);
		Assert.assertTrue(elm.isEnabled());
		
	}


}
