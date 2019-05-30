package com.avlview.app.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBaseParallelTesting;
import com.avlview.app.pages.HomePage;
import com.avlview.app.pages.LoginPage2;

public class HomePageTest extends TestBaseParallelTesting {

	LoginPage2 lp;
	HomePage hp;

	public HomePageTest() throws IOException {
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
		hp = lp.login(prop.getProperty("existing_uname"), prop.getProperty("existing_pwd"));

	}

	@Test(enabled = true)
	public void validateHomePageExistTest() throws InterruptedException {

		log.info("Inside validateLoginPageExistTest");
		// extentTest = extent.startTest("validateLoginPageExistTest");

		String validateHomePage = hp.validateHomePage();
		String expected = validateHomePage.substring(0, 7);
		System.out.println(expected);

		Assert.assertEquals(expected, "Version");
		log.info("Sucessfully executed validateHomePageExistTest");
	}

}
