package com.avlview.app.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBaseGridTesting;
import com.avlview.app.pages.ClientsPage2;
import com.avlview.app.pages.ForgotPasswordPage;
import com.avlview.app.pages.HomePage;
import com.avlview.app.pages.LoginPage2;

public class LoginPageTest2 extends TestBaseGridTesting {
	// TestBaseParallelTesting
	// public ExtentReports extent;
	// public static ExtentTest extentTest;

	LoginPage2 lp;
	ClientsPage2 cp;
	ForgotPasswordPage fp;
	HomePage hp;

	public LoginPageTest2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	@Parameters("browsername")
	public void setup(Method method, @Optional String browser) throws IOException {
		// extentTest = ExtentManager.getInstance().startTest((this.getClass().getName()
		// + "::" + method.getName()), method.getName());

		long id = Thread.currentThread().getId();
		System.out.println("Before test-method. Thread id is: " + id);

		Initialization(browser);

		lp = new LoginPage2();
		cp = new ClientsPage2();
		fp = new ForgotPasswordPage();
		hp = new HomePage();

	}

	@Test(enabled = true)
	public void validateLoginPageExistTest() {

		log.info("Inside validateLoginPageExistTest");
		// extentTest = extent.startTest("validateLoginPageExistTest");

		String validateloginpage = lp.validateLoginPage();
		Assert.assertEquals(validateloginpage, "Sign in");
		log.info("Sucessfully executed validateLoginPageExistTest");
	}

	@Test(enabled = true)
	public void validateClientLogoExistTest() throws InterruptedException {

		// extentTest = extent.startTest("validateClientLogoExistTest");

		boolean validateClientLogo = lp.validateClientLogo();
		Assert.assertTrue(validateClientLogo);
	}

	@Test(enabled = true)
	public void validateApplogoExistTest() {

		// extentTest = extent.startTest("validateApplogoExistTest");

		boolean ApplogoExist = lp.validateApplogo();
		Assert.assertTrue(ApplogoExist);
	}

	@Test(enabled = true)
	public void validateRemembermeExistTest() {

		// extentTest = extent.startTest("validateRemembermeExistTest");
		String Rememberme = lp.validateRememberme();
		Assert.assertEquals(Rememberme, "Remember me");
	}

	@Test(enabled = true)
	public void validateLanguageExistTest() {

		// extentTest = extent.startTest("validateLanguageExistTest");
		String Language = lp.validateLanguage();
		Assert.assertEquals(Language, "English");
	}

	@Test(enabled = false)
	public void forgotpasswordclick() throws IOException, InterruptedException {
		// extentTest = extent.startTest("forgotpasswordclick");
		fp = lp.ForgotPassword();
		String validateForgotpage = fp.ValidateForgotpasswordpage();
		System.out.println(validateForgotpage);
		Assert.assertEquals(validateForgotpage, "Forgot your password?");

	}

	@Test(enabled = true)
	public void loginclickWithInvaliduser() throws InterruptedException {
		// extentTest = extent.startTest("loginclickWithInvaliduser");
		String valmsg = lp.validationMessage(prop.getProperty("invaliduname"), prop.getProperty("invalidpwd"));
		Assert.assertEquals(valmsg, "Invalid username/password, please try again!");

	}

	@Test(enabled = true)
	public void loginclick() throws IOException {
		// extentTest = extent.startTest("loginclick");
		hp = lp.login(prop.getProperty("uname"), prop.getProperty("pwd"));

		System.out.println(cp.toString());

		Assert.assertTrue(cp != null, "Login failed");
		System.out.println("Login done sucessfully");

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {

		/*
		 * if (result.getStatus() == ITestResult.FAILURE) {
		 * extentTest.log(LogStatus.FAIL, "Test case failed is" + result.getName());
		 * extentTest.log(LogStatus.FAIL, "Test case failed is" +
		 * result.getThrowable());
		 * 
		 * String screenshotPath = TestBase.getScreenshot(driver, result.getName());
		 * extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		 * 
		 * } else if (result.getStatus() == ITestResult.SKIP) {
		 * extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName()); }
		 * else if (result.getStatus() == ITestResult.SUCCESS) {
		 * extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		 * 
		 * }
		 * 
		 * extent.endTest(extentTest);
		 */

		// ExtentManager.getInstance().endTest(extentTest);

		getdriver().quit();
		log.info("Execution comleted");

	}

}
