package com.avlview.app.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBase;
import com.avlview.app.pages.ClientsPage;
import com.avlview.app.pages.LoginPage;

public class ClientsPageTest extends TestBase {

	LoginPage lp;
	ClientsPage cp;

	public ClientsPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		Initialization();
		lp = new LoginPage();
		cp = lp.login(prop.getProperty("existing_uname"), prop.getProperty("existing_pwd"));
	}

	@Test(priority = 1, enabled = true)
	public void validateclientpageExistTest() {
		// extentTest = extent.startTest("validateclientpageExistTest");
		String validateclientpage = cp.validateClientspage();
		Assert.assertEquals(validateclientpage, "Clients");
	}

	@Test(priority = 2, enabled = true)
	public void validatePartnerLogoExistTest() throws InterruptedException {
		// extentTest = extent.startTest("validatePartnerLogoExistTest");
		boolean validatePartnerLogo = cp.validatelogo();
		Assert.assertTrue(validatePartnerLogo);
	}

	@Test(priority = 3, enabled = true)
	public void validateAddclientExistTest() {
		// extentTest = extent.startTest("validateAddclientExistTest");
		String validateaddclient = cp.validateAddclient();
		Assert.assertEquals(validateaddclient, "ADD CLIENT");
	}

	@Test(priority = 4, enabled = true)
	public void validateSearchExistTest() {
		// extentTest = extent.startTest("validateSearchExistTest");
		boolean validateSearch = cp.validateSearch();
		Assert.assertTrue(validateSearch);
	}

	@Test(priority = 5, enabled = true)
	public void validateSearchResultTest() throws InterruptedException {
		// extentTest = extent.startTest("validateSearchResultTest");
		String validateSearchResult = cp.validatesExistingclientearchresult();
		Assert.assertEquals(validateSearchResult, "1");
	}

	@Test(priority = 6, enabled = true)
	public void validateTotalTabsTest() throws InterruptedException {
		// extentTest = extent.startTest("validateTotalTabsTest");
		int validateTabcount = cp.validatetotaltabs();
		Assert.assertEquals(validateTabcount, 2);

	}

	@Test(priority = 7, enabled = true)
	public void validateRemoteLoginTest() throws InterruptedException {
		// extentTest = extent.startTest("validateTotalTabsTest");
		String validatetxt = cp.validatesRemotelogin();
		Assert.assertEquals(validatetxt, "You're signed out, you may re-login here");

	}

	@Test(priority = 8, enabled = true)
	public void items25Test() throws InterruptedException {
		// extentTest = extent.startTest("items25Test");

		// boolean cnt = ac.itemsperpage("25");
		// Assert.assertTrue(cnt);

		cp.itemsperpage("25");
		boolean cnt = cp.items25();
		Assert.assertTrue(cnt);

		/*
		 * String result = ac.itemsperpage("25"); Assert.assertEquals(result, "1 - 25");
		 */

	}

	@Test(priority = 9, enabled = true)
	public void items50Test() throws InterruptedException {
		// extentTest = extent.startTest("items50Test");

		// boolean cnt = ac.itemsperpage("50");
		// Assert.assertTrue(cnt);

		cp.itemsperpage("50");
		boolean cnt = cp.items50();
		Assert.assertTrue(cnt);

		/*
		 * String result = ac.itemsperpage("50"); Assert.assertEquals(result, "1 - 50");
		 */
	}

	@Test(priority = 10, enabled = true)
	public void items100Test() throws InterruptedException {
		// extentTest = extent.startTest("items100Test");

		cp.itemsperpage("100");
		boolean cnt = cp.items100();
		Assert.assertTrue(cnt);

	}

	@Test(priority = 11, enabled = true)
	public void PaginationTestfor25Items() throws InterruptedException {
		// extentTest = extent.startTest("PaginationTest");
		cp.itemsperpage("25");
		String paginationtxt = cp.pagination();
		Assert.assertEquals(paginationtxt, "26 - 50");
	}

	@Test(priority = 12, enabled = true)
	public void PaginationTestfor50Items() throws InterruptedException {
		// extentTest = extent.startTest("PaginationTest");
		cp.itemsperpage("50");
		String paginationtxt = cp.pagination();
		Assert.assertEquals(paginationtxt, "51 - 100");
	}

	@Test(priority = 13, enabled = true)
	public void PaginationTestfor100Items() throws InterruptedException {
		// extentTest = extent.startTest("PaginationTest");
		cp.itemsperpage("100");
		String paginationtxt = cp.pagination();
		Assert.assertEquals(paginationtxt, "101 - 200");
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
		 */

		// extent.endTest(extentTest);

		driver.quit();

	}

}
