package com.avlview.app.base;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase2 {

	private WebDriver driver;

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public WebDriver getdriver() {
		return dr.get();
	}

	public void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	public void openbrowsers(String browser) {

		Date d = new Date();

		System.out.println("bname is " + browser + " " + d);

		if (browser.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		setWebDriver(driver);

		getdriver().get("https://preapp.avlview.com");

	}

	public void quit() {
		getdriver().quit();
	}
}
