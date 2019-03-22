package com.avlview.app.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.avlview.app.base.TestBase;
import com.avlview.app.pages.AddClientPage;
import com.avlview.app.pages.AddVehiclePage;
import com.avlview.app.pages.ClientsPage;
import com.avlview.app.pages.LoginPage;

public class AddDriverTest extends TestBase {

	LoginPage lp;
	ClientsPage cp;
	AddClientPage ac;
	AddVehiclePage av;

	public AddDriverTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		Initialization();
		lp = new LoginPage();
		cp = lp.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		if (cp == null) {
			Assert.fail("Login failed");
		}

	}

}
