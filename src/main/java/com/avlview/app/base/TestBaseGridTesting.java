package com.avlview.app.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.avlview.app.utilities.ExcelReader;
import com.avlview.app.utilities.TestUtil;
import com.avlview.app.utilities.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBaseGridTesting {

	private RemoteWebDriver driver;

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	public WebDriver getdriver() {
		return dr.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	public static Properties OR = new Properties();
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public ExtentReports rep = com.avlview.ExtentReporterListner.ExtentManager.getInstance();

	public static ExtentTest test;
	// public static Logger log = Logger.getLogger("devpinoyLogger");

	public static Logger log = Logger.getLogger(TestBaseGridTesting.class);

	public TestBaseGridTesting() throws IOException {

		// PropertyConfigurator.configure(System.getProperty("user.dir") +
		// "\\src\\main\\resources\\log4j.properties");

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\app\\config\\config.properties");
		prop.load(fis);
		// log.debug("Config file loaded");

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\app\\config\\OR.properties");
		OR.load(fis);
		// log.debug("Property file loaded");

		excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\app\\testdata\\testdata.xlsx");
		// log.debug("Excel file loaded");
	}

	public void Initialization(String browser) throws IOException {

		// PropertyConfigurator.configure(System.getProperty("user.dir") +
		// "\\src\\main\\resources\\log4j.properties");

		// String browser1 = prop.getProperty("browser");

		/*
		 * if (browser.equalsIgnoreCase("Chrome")) { //
		 * WebDriverManager.chromedriver().setup();
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\src\\main\\resources\\drivers\\chromedriver.exe"); driver = new
		 * ChromeDriver(); } else if (browser.equalsIgnoreCase("ff")) {
		 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		 * "\\src\\main\\resources\\drivers\\geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 * 
		 * }
		 * 
		 * setWebDriver(driver);
		 */

		DesiredCapabilities dc = null;
		if (browser.equalsIgnoreCase("ff")) {
			dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.ANY);

		} else if (browser.equalsIgnoreCase("Chrome")) {
			dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.ANY);
			// driver = new RemoteWebDriver(new URL("http://192.168.0.47:5555/wd/hub"), dc);
		}

		driver = new RemoteWebDriver(new URL("http://192.168.0.16:4444/wd/hub"), dc);

		// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		// driver = new RemoteWebDriver(new
		// URL("http://192.168.0.16:".concat(Port).concat("/wd/hub")), dc);

		setWebDriver(driver);

		getdriver().manage().timeouts().pageLoadTimeout(TestUtil.Page_timeout, TimeUnit.SECONDS);
		getdriver().manage().timeouts().implicitlyWait(TestUtil.Imp_wait, TimeUnit.SECONDS);

		getdriver().get("https://app.avlview.com");

		// driver.get(prop.getProperty("url"));
		log.debug("Navigated to" + prop.getProperty("url"));

	}

	/*
	 * @BeforeClass public void setExtent() { extent = new
	 * ExtentReports(System.getProperty("user.dir") +
	 * "/test-output/ExtentReport.html", true); extent.addSystemInfo("Host Name",
	 * "Murali"); extent.addSystemInfo("User Name", "mkrishnan");
	 * extent.addSystemInfo("Environment", "QA");
	 * 
	 * }
	 * 
	 * @AfterClass public void endReport() { extent.flush(); extent.close(); }
	 */

	public void click(String locator, WebElement element) {

		if (locator.endsWith("_CSS")) {
			// driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			element.click();
		} else if (locator.contains("XPATH")) {
			// driver.findElement(By.xpath(OR.getProperty(locator))).click();
			element.click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		// log.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
