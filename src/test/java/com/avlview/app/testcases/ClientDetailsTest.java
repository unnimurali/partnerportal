package com.avlview.app.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBase;
import com.avlview.app.pages.ClientDetailsPage;
import com.avlview.app.pages.ClientsPage;
import com.avlview.app.pages.LoginPage;

public class ClientDetailsTest extends TestBase {

	LoginPage lp;
	ClientsPage cp;
	ClientDetailsPage cd;

	public ClientDetailsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod()
	public void setup() throws IOException, InterruptedException {
		Initialization();
		lp = new LoginPage();
		cp = lp.login(prop.getProperty("uname"), prop.getProperty("pwd"));

		if (cp == null) {
			Assert.fail("Login failed");
		}

		cd = cp.clientclick();

	}

	@Test(priority = 1, enabled = true)
	public void TemplateTest() throws IOException, InterruptedException {

		// extentTest = extent.startTest("TemplateTest");
		String template = cd.validateTemplate();
		Assert.assertEquals(template, "You are yet to add a vehicle!");

	}

	@Test(priority = 2, enabled = false)
	public void AddVehicleTest() throws IOException, InterruptedException {

		// extentTest = extent.startTest("TemplateTest");
		String template = cd.validateAddVehicle();
		Assert.assertEquals(template, "ADD VEHICLE");

	}

	@Test(priority = 3, enabled = false)
	public void validateBackButtonExistTest() throws InterruptedException {
		// extentTest = extent.startTest("validatePartnerLogoExistTest");
		boolean validateBackButton = cd.validateBackButtonExist();
		Assert.assertTrue(validateBackButton);

	}

	@Test(priority = 4, enabled = false)
	public void validateBackButtonClickTest() throws InterruptedException, IOException {
		// extentTest = extent.startTest("validatePartnerLogoExistTest");
		String validateclientpage = cd.validateBackbutton();
		Assert.assertEquals(validateclientpage, "Clients");
	}

	@Test(priority = 5, enabled = false)
	public void validateMenuItemsTest() throws InterruptedException, IOException {
		// extentTest = extent.startTest("validatePartnerLogoExistTest");
		int validatemenuitems = cd.validateMenuItems();
		Assert.assertEquals(validatemenuitems, 2);
	}

	@Test(priority = 5, enabled = true)
	public void validateVehicleCountTest() throws InterruptedException, IOException {
		// extentTest = extent.startTest("validatePartnerLogoExistTest");
		boolean countstatus = cd.validateTotalVehicleCount();
		System.out.println(countstatus);
		Assert.assertTrue(countstatus);

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

		driver.quit();

	}

}
