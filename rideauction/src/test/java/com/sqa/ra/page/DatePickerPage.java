package com.sqa.ra.page;

import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PKR_NEXT_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PKR_PREV_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.SUN_DAY_HDR;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PICKER_MONTH;
import static com.sqa.ra.locator.datepick.DatePickerLocator.DATE_PICKER_YEAR;
import static org.testng.AssertJUnit.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sqa.ra.framework.RAPage;

public class DatePickerPage extends RAPage {
	static Logger logger = Logger.getLogger(DatePickerPage.class);

	public DatePickerPage(WebDriver driver) {
		super(driver);
	}

	public void verifyPageElements() {
		// verify header on Calendar
		verifyElementPresent(SUN_DAY_HDR);
		verifyElementPresent(DATE_PKR_NEXT_MONTH);
		verifyElementPresent(DATE_PKR_PREV_MONTH);
	}
	
	/**
	 * Select day relative to today
	 * 
	 * @param offsetFromToday - 0 = Today, 1 = Tomorrow, ..
	 */
	public void verifyAndClickDate(int offsetFromToday) {
		assertTrue(offsetFromToday >= 0 && offsetFromToday <= 180);
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, offsetFromToday); // <--
		Date desiredDate = cal.getTime();
		logger.debug(desiredDate);

		selectDate(desiredDate);
	}
	
	/**
	 * String format is mm-DD-yyyy
	 * e.g. "12-31-2014"  for New Years Eve
	 * @param date
	 */
	public void verifyAndClickDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("mm-DD-yyyy");
		try {
			Date date = sdf.parse(dateStr);
		} catch (ParseException e) {
			Assert.assertNotNull(null, e.getLocalizedMessage());
		}
	}
	/**
	 * Probably should have a string and a date format string
	 * 
	 * @FIXME - ignoring input for now
	 * @param value
	 */
	public void selectDate(Date desiredDate) {

		SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM"); // Full Month
																	// String

		Calendar calDesired = Calendar.getInstance();
		calDesired.setTime(desiredDate);
		String desiredMonthStr = sdfMonth.format(calDesired.getTime());

		// Prev/Next Until Year is correct
		while (calDesired.get(Calendar.YEAR) > Integer.parseInt(getElement(
				DATE_PICKER_YEAR).getText())) {

			logger.debug("NEXT_YEAR: DesMonth: " + desiredMonthStr
					+ " desYear: " + calDesired.get(Calendar.YEAR)
					+ " currYear: "
					+ Integer.parseInt(getElement(DATE_PICKER_YEAR).getText()));

			verifyAndClick(DATE_PKR_NEXT_MONTH);
		}
		while (calDesired.get(Calendar.YEAR) < Integer.parseInt(getElement(
				DATE_PICKER_YEAR).getText())) {

			logger.debug("PREV_YEAR: DesMonth: " + desiredMonthStr
					+ " desYear: " + calDesired.get(Calendar.YEAR)
					+ " currYear: "
					+ Integer.parseInt(getElement(DATE_PICKER_YEAR).getText()));

			verifyAndClick(DATE_PKR_PREV_MONTH);
		}

		// @FIXME Note that this method does not take locale into account,
		// and will result in an unsatisfactory ordering for certain locales.
		// The java.text package provides collators to allow locale-sensitive
		// ordering.
		// Collator.compare(String, String)
		
		// Prev/Next until the Month is correct
		int desMon= MONTH.getNum(desiredMonthStr);
		int curMon = -1;
		do {
			
			curMon = MONTH.getNum(getElement(
					DATE_PICKER_MONTH).getText());
			if (desMon < curMon) {

				logger.debug("PREV_MONTH: DesMonth: " + desiredMonthStr
						+ " desYear: " + calDesired.get(Calendar.YEAR)
						+ " currMonth: "
						+ getElement(DATE_PICKER_MONTH).getText());

				verifyAndClick(DATE_PKR_PREV_MONTH);
			} else if (desMon > curMon) {

				logger.debug("NEXT_MONTH: DesMonth: " + desiredMonthStr
						+ " desYear: " + calDesired.get(Calendar.YEAR)
						+ " currMonth: "
						+ getElement(DATE_PICKER_MONTH).getText());

				verifyAndClick(DATE_PKR_NEXT_MONTH);
			}
		} while (desMon != curMon);

		verifyAndClick(By
				.linkText(String.valueOf(calDesired.get(Calendar.DATE))));
	}


	enum MONTH {
		JAN(0, "January"), FEB(1, "February"), MAR(2, "March"), APR(3, "April"), MAY(
				4, "May"), JUN(5, "June"), JUL(6, "July"), AUG(7, "August"), SEPT(
				8, "September"), OCT(9, "October"), NOV(10, "November"), DEC(
				11, "December");

		String month;
		int num;

		private MONTH(int num, String month) {
			this.month = month;
			this.num = num;
		}

		public String getMonth() {
			return month;
		}

		public int getNum() {
			return num;
		}

		private static final Map<String, MONTH> lookup = new HashMap<String, MONTH>();
		static {
			for (MONTH m : EnumSet.allOf(MONTH.class))
				lookup.put(m.getMonth(), m);
		}
		public static int getNum(String month){
			return lookup.get(month).getNum();
		}

	};
}
