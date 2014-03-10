package com.sqa.ra.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
	
	public static WebDriver getWebDriver(){
		WebDriver driver;
		String browser=PropertyManager.getProperty("browser");
		if("firefox".equalsIgnoreCase(browser)){
			driver=new FirefoxDriver();
			
		}else if("ie".equalsIgnoreCase(browser)){
			driver=new InternetExplorerDriver();
			
		} else if("chrome".equalsIgnoreCase(browser)){
			driver=new ChromeDriver();
			
		}else{
			driver=new HtmlUnitDriver();
		}
		
		driver.get(PropertyManager.getProperty("appurl"));
		driver.manage().timeouts().
		implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
