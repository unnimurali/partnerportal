package com.avlview.app.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBase2;
import com.avlview.app.pages.ClientsPage;
import com.avlview.app.pages.ForgotPasswordPage;
import com.avlview.app.pages.LoginPage2;

public class LoginPageTest2 extends TestBase2 {

	// public ExtentReports extent;
	// public static ExtentTest extentTest;

	LoginPage2 lp;
	ClientsPage cp;
	ForgotPasswordPage fp;

	public LoginPageTest2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Parameters("browsername")
	@BeforeMethod
	public void setup(String bname) throws IOException {
		// extentTest = ExtentManager.getInstance().startTest((this.getClass().getName()
		// + "::" + method.getName()), method.getName());

		openbrowsers(bname);

		lp = new LoginPage2();
		// cp = new ClientsPage();
		// fp = new ForgotPasswordPage();

	}

	@Test(priority = 1, enabled = true)
	public void validateLoginPageExistTest() {

		log.info("Inside validateLoginPageExistTest");
		// extentTest = extent.startTest("validateLoginPageExistTest");

		String validateloginpage = lp.validateLoginPage();
		Assert.assertEquals(validateloginpage, "Sign in");
		log.info("Sucessfully executed validateLoginPageExistTest");
	}

	@Test(priority = 2, enabled = true)
	public void validateClientLogoExistTest() throws InterruptedException {

		// extentTest = extent.startTest("validateClientLogoExistTest");

		boolean validateClientLogo = lp.validateClientLogo();
		Assert.assertTrue(validateClientLogo);
	}

	@Test(priority = 3, enabled = true)
	public void validateApplogoExistTest() {

		// extentTest = extent.startTest("validateApplogoExistTest");

		boolean ApplogoExist = lp.validateApplogo();
		Assert.assertTrue(ApplogoExist);
	}

	@Test(priority = 4, enabled = true)
	public void validateRemembermeExistTest() {

		// extentTest = extent.startTest("validateRemembermeExistTest");
		String Rememberme = lp.validateRememberme();
		Assert.assertEquals(Rememberme, "Remember me");
	}

	@Test(priority = 5, enabled = false)
	public void validateLanguageExistTest() {

		// extentTest = extent.startTest("validateLanguageExistTest");
		String Language = lp.validateLanguage();
		Assert.assertEquals(Language, "English");
	}

	@Test(priority = 6, enabled = false)
	public void forgotpasswordclick() throws IOException, InterruptedException {
		// extentTest = extent.startTest("forgotpasswordclick");
		fp = lp.ForgotPassword();
		String validateForgotpage = fp.ValidateForgotpasswordpage();
		System.out.println(validateForgotpage);
		Assert.assertEquals(validateForgotpage, "Forgot your password?");

	}

	@Test(priority = 7, enabled = false)
	public void loginclickWithInvaliduser() throws InterruptedException {
		// extentTest = extent.startTest("loginclickWithInvaliduser");
		String valmsg = lp.validationMessage(prop.getProperty("invaliduname"), prop.getProperty("invalidpwd"));
		Assert.assertEquals(valmsg, "Invalid username/password, please try again!");

	}

	@Test(priority = 8, enabled = false)
	public void loginclick() throws IOException {
		// extentTest = extent.startTest("loginclick");
		cp = lp.login(prop.getProperty("uname"), prop.getProperty("pwd"));

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
