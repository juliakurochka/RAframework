package com.sqa.ra.framework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {

	public static WebDriver getWebDriver() {
		WebDriver driver;
		String browser = PropertyManager.getProperty("browser");
		if ("firefox".equalsIgnoreCase(browser)) {
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			//cap.setVersion("3.7");
			//cap.setPlatform(Platform.WINDOWS);
			//cap.set
			driver = new FirefoxDriver(cap);

		} else if ("ie".equalsIgnoreCase(browser)) {
			
			File file = new File(PropertyManager.getProperty("InternetExplorerServerPath"));
			//get the path of webdriver exe
			
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

			DesiredCapabilities capabilities = DesiredCapabilities. internetExplorer();
			capabilities.setCapability(" ignoreZoomSetting", true);
			capabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 driver =  new InternetExplorerDriver( capabilities);
			driver = new InternetExplorerDriver();

		} else if ("chrome".equalsIgnoreCase(browser)) {
			
			File file = new File(PropertyManager.getProperty("ChromeServerPath"));
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();

		} else {
			driver = new HtmlUnitDriver();
		}

		driver.get(PropertyManager.getProperty("appurl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}