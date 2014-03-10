package com.sqa.ra.framework;

import static com.sqa.ra.framework.PropertyManager.getProperty;
import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverTestOld {
	
	protected WebDriver driver=null;
	
	@BeforeMethod(alwaysRun=true)
	public void initilizeWebDriver(){
		driver=WebDriverManager.getWebDriver();
		driver.get(PropertyManager.getProperty("appurl"));
	}
	

	
	/**
	 * Method to get WebElement
	 * @param by
	 * @return
	 */

	public  WebElement getElement(By by) {

		try {
			return driver.findElement(by);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to select a drop down box
	 * 
	 * @param by
	 * @param value
	 */

	public void selectDropDownByVisibleText( By by, String value) {

		try {
			WebElement elmement = driver.findElement(by);
			assertNotNull(elmement);
			Select selctBox = new Select(elmement);
			selctBox.selectByVisibleText(value);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void selectDropDownByValue( By by, String value) {

		try {
			WebElement elmement = driver.findElement(by);
			assertNotNull(elmement);
			Select selctBox = new Select(elmement);
			selctBox.selectByValue(value);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Method to verify the text of an element
	 * 
	 * 
	 * @param by
	 * @param value
	 * @return
	 */
	public  boolean verifyText( By by, String value) {
		WebElement element = getElement( by);
		assertNotNull(element);
		String text = element.getText();
		if (value.equals(text)) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * To verify if element is present or not.
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public  void verifyElementPresent(By by) {

		assertNotNull(getElement( by));

	}

	/**
	 * To verify if element is present or not.
	 * 
	 * 
	 * @param by
	 * @return
	 */
	public  boolean isElementPresent(WebDriver driver, By by) {

		if (getElement( by) == null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify the element and click on an element
	 * 
	 * @param driver
	 * @param by
	 */
	public  void verifyAndClickElement( By by) {

		WebElement elm = getElement( by);
		assertNotNull(elm);
		elm.click();

	}

	/**
	 * Type on the element
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 */
	public  void type( By by, String value) {

		try {
			WebElement elm = getElement( by);
			assertNotNull(elm);
			elm.sendKeys(value);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Wait for element present
	 * 
	 * @param driver
	 * @param by
	 * @param timeInSecs
	 */
	public  void waitForElementPresent( By by,
			int timeInSecs) {

		try {
			new WebDriverWait(driver, timeInSecs).until(ExpectedConditions
					.presenceOfElementLocated(by));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * This method is used to execute a script.
	 * @param script
	 */
	public void excuteJavaScript(WebDriver driver,String script){
		((JavascriptExecutor )driver).executeScript(script);
	}

	
	@AfterMethod(alwaysRun = true)
	public void catchExceptions(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		String dirName = "";
		if (!result.isSuccess()) {

//			TakesScreenshot ts=(TakesScreenshot)driver;
//		File file=	ts.getScreenshotAs(OutputType.FILE);
			
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils
						.copyFile(
								scrFile,
								new File(getProperty("screen_shot_dir")
										+ methodName + "_"
										+ formater.format(calendar.getTime())
										+ ".png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	@AfterMethod(alwaysRun=true)
	public void closeWebDriver(){
		driver.close();
		driver.quit();
	}


}
