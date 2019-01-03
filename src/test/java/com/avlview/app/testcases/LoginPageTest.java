package com.avlview.app.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlview.ExtentReporterListner.ExtentManager;
import com.avlview.app.base.TestBase;
import com.avlview.app.pages.ClientsPage;
import com.avlview.app.pages.ForgotPasswordPage;
import com.avlview.app.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {

	//public ExtentReports extent;
	//public static ExtentTest extentTest;
	
	LoginPage lp;
	ClientsPage cp;
	ForgotPasswordPage fp;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 

	@BeforeMethod
	public void setup(Method method) throws IOException {
		//extentTest = ExtentManager.getInstance().startTest((this.getClass().getName() + "::" + method.getName()), method.getName());
		Initialization();
		
		lp = new LoginPage();
		cp = new ClientsPage();
		fp = new ForgotPasswordPage();
		
	}

	@Test(priority = 1, enabled = false)
	public void validateLoginPageExistTest() {
		
		
		log.debug("Inside validateLoginPageExistTest");
		//extentTest = extent.startTest("validateLoginPageExistTest");

		String validateloginpage = lp.validateLoginPage();
		Assert.assertEquals(validateloginpage, "Sign in");
		log.debug("Sucessfully executed validateLoginPageExistTest");
	}

	@Test(priority = 2, enabled = false)
	public void validateClientLogoExistTest() throws InterruptedException {

		//extentTest = extent.startTest("validateClientLogoExistTest");

		boolean validateClientLogo = lp.validateClientLogo();
		Assert.assertTrue(validateClientLogo);
	}

	@Test(priority = 3, enabled = false)
	public void validateApplogoExistTest() {

		//extentTest = extent.startTest("validateApplogoExistTest");

		boolean ApplogoExist = lp.validateApplogo();
		Assert.assertTrue(ApplogoExist);
	}

	@Test(priority = 4, enabled = false)
	public void validateRemembermeExistTest() {

		//extentTest = extent.startTest("validateRemembermeExistTest");
		String Rememberme = lp.validateRememberme();
		Assert.assertEquals(Rememberme, "Remember me");
	}

	@Test(priority = 5, enabled = false)
	public void validateLanguageExistTest() {

		//extentTest = extent.startTest("validateLanguageExistTest");
		String Language = lp.validateLanguage();
		Assert.assertEquals(Language, "English");
	}

	@Test(priority = 6, enabled = false)
	public void forgotpasswordclick() throws IOException, InterruptedException {
		//extentTest = extent.startTest("forgotpasswordclick");
		fp = lp.ForgotPassword();
		String validateForgotpage = fp.ValidateForgotpasswordpage();
		System.out.println(validateForgotpage);
		Assert.assertEquals(validateForgotpage, "Forgot your password?");

	}

	@Test(priority = 7, enabled = true)
	public void loginclickWithInvaliduser() throws InterruptedException {
		//extentTest = extent.startTest("loginclickWithInvaliduser");
		String valmsg = lp.validationMessage(prop.getProperty("invaliduname"), prop.getProperty("invalidpwd"));
		Assert.assertEquals(valmsg, "Invalid username/password, please try again!");

	}

	@Test(priority = 8, enabled = false)
	public void loginclick() throws IOException {
		//extentTest = extent.startTest("loginclick");
		cp = lp.login(prop.getProperty("uname"), prop.getProperty("pwd"));

		System.out.println(cp.toString());

		Assert.assertTrue(cp != null, "Login failed");
		System.out.println("Login done sucessfully");

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {

		/*if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case failed is" + result.getName());
			extentTest.log(LogStatus.FAIL, "Test case failed is" + result.getThrowable());

			String screenshotPath = TestBase.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest);*/
		
		// ExtentManager.getInstance().endTest(extentTest);

		driver.quit();
		log.info("Execution comleted");

	}

}
