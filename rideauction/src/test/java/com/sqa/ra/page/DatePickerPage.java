package com.sqa.ra.page;

import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PICKER_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PICKER_YEAR;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PKR_NEXT_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PKR_PREV_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.SUN_DAY_HDR;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sqa.ra.framework.RAPage;

public class DatePickerPage extends RAPage {
	static Logger logger = Logger.getLogger(DatePickerPage.class);
	static final String MM_dd_yyyy = "MM-dd-yyyy";

	Locale locale = Locale.ENGLISH;

	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();

	public DatePickerPage(WebDriver driver) {
		super(driver);
	}

	public DatePickerPage(WebDriver driver, Locale locale) {
		super(driver);
		this.locale = locale;
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementPresent(DATE_PKR_PREV_MONTH);
	};

	@Override
	public void verifyPageElements() {
		// verify header on Calendar
		verifyElementPresent(SUN_DAY_HDR);
		verifyElementPresent(DATE_PKR_NEXT_MONTH);
		verifyElementPresent(DATE_PKR_PREV_MONTH);
	}

	/**
	 * Verify Date element exist and click it
	 * 
	 * @param date
	 *            - fixed format MM-dd-yyyy e.g. "12-31-2014"
	 */
	public void verifyAndClickDate(String dateStr) {
		verifyAndClickDate(dateStr, MM_dd_yyyy);
	}

	/**
	 * Verify Date element exist and click it
	 * 
	 * @param dateStr
	 *            - variable date format
	 * @param dateFormat
	 */
	public void verifyAndClickDate(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
		Date date = null;
		try {
			date = sdf.parse(dateStr);

		} catch (ParseException e) {
			// Assert.assertNotNull(null, e.getLocalizedMessage());
			assertNotNull(date, "Bad Date string or format");
			logger.error("Error in parsing date", e);
		}

		selectDate(date);
	}

	/**
	 * Select day (+/-) relative to today
	 * 
	 * @param offsetFromToday
	 *            - 0 = Today, 1 = Tomorrow, ..
	 */
	public void verifyAndClickDate(int offsetFromToday) {
		assertTrue(offsetFromToday >= 0 && offsetFromToday <= 180);
		Date now = new Date();
		calEnd.setTime(now);
		calEnd.add(Calendar.DAY_OF_YEAR, offsetFromToday);
		Date desiredDate = calEnd.getTime();
		logger.debug(desiredDate);
		selectDate(desiredDate);
	}

	/**
	 * Adjust the calendar DatePicker Widget to the desired Day/Month/Year.
	 * Month/Year are both adjusted using a 0 or more PREV / NEXT Month
	 * button selects
	 * 
	 * @param desiredDate
	 *            - java date
	 * 
	 */
	private void selectDate(Date desiredDate) {

		calEnd.setTime(desiredDate);
		calStart.setTime(new Date());

		int prev_next_clicks = getMonthClicks(calStart, calEnd);

		while(prev_next_clicks != 0) {

			if (prev_next_clicks < 0) {
				verifyAndClick(DATE_PKR_PREV_MONTH);
				prev_next_clicks++;
			}
			if (prev_next_clicks > 0) {
				verifyAndClick(DATE_PKR_NEXT_MONTH);
				prev_next_clicks--;
			}
			waitForPageToLoad();
		}
		
		// (2) Verify Correct Year/Month
		assertEquals(calEnd.get(Calendar.YEAR), Integer.parseInt(getElement(DATE_PICKER_YEAR).getText()),
				"Unable to find correct Year");
		
		String month = new SimpleDateFormat("MMMM", locale).format(calEnd.getTime());
		assertEquals(month, getElement(DATE_PICKER_MONTH).getText(),"Unable to find correct Month");

		// (3) Select the Day
		By dateBy = By.linkText(String.valueOf(calEnd.get(Calendar.DATE)));
		verifyElementEnabled(dateBy);
		verifyAndClick(dateBy);

	} // endof selectDate

	private int getMonthClicks(Calendar startCal, Calendar endCal) {
		int next_prev_clicks = 0;
		int diffYear = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		next_prev_clicks = diffYear * 12 + endCal.get(Calendar.MONTH)
				- startCal.get(Calendar.MONTH);
		return next_prev_clicks;
	}

}
