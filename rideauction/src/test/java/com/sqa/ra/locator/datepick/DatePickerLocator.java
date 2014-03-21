package com.sqa.ra.locator.datepick;

import org.openqa.selenium.By;

public interface DatePickerLocator {
	/* JQuery date picker elements */
	
	public static final By SUN_DAY_HDR = By.cssSelector(".ui-datepicker-calendar span[title='Sunday']");
	public static final By DATE_PKR_NEXT_MONTH = By.cssSelector("#ui-datepicker-div a[title='Next']");
	public static final By DATE_PKR_PREV_MONTH = By.cssSelector("#ui-datepicker-div a[title='Prev']");

		/**
	 * Web Element of the Date Picker that has the calendar class name.
	 */
	public static final By DATE_PICKER = By
			.id("date_picker");

	/**
	 * Web Element of the Date Picker that has the calendar class name.
	 */
	public static final By DATE_PICKER_CAL = By
			.className("ui-datepicker-calendar");

	/**
	 * Web Element of the Date Picker that has the month as text.
	 */
	public static final By DATE_PICKER_MONTH = By
			.xpath("//span[@class='ui-datepicker-month']");
	/**
	 * Web Element of the Date Picker that has the year as text.
	 */
	public static final By DATE_PICKER_YEAR = By
			.xpath("//span[@class='ui-datepicker-year']");
	/**
	 * Left arrow for the Date Picker to go to the previous month.
	 */
	public static final By DATE_PICKER_PREV = By
			.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w");
	/**
	 * Right arrow for the Date Picker to go to the next month.
	 */
	public static final By DATE_PICKER_NEXT = By
			.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	/**
	 * First Thursday of the Month, [1]-Sun, [5]-Thurs.
	 */
	public static final By DATE_PICKER_FIST_THURS = By
			.xpath("//td[5]/a");


}
