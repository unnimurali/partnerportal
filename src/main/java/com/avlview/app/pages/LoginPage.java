package com.avlview.app.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avlview.app.base.TestBase;

public class LoginPage extends TestBase {

	public static WebDriverWait wait;

	// initializing the objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Elements in the page

	@FindBy(xpath = "//input[@id='blinkLogInText']")
	WebElement username;

	@FindBy(xpath = "//*[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement signinBtn;

	@FindBy(xpath = "//span[contains(text(),'Invalid')]")
	WebElement Errormsg;

	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement signinxt;

	@FindBy(xpath = "//a[contains(text(),'Forgot')]")
	WebElement forgotpwd;

	@FindBy(xpath = "//*[@id='clientimglogo']")
	WebElement Clientlogo;

	@FindBy(xpath = "//div[2] [@class='sign_slider fl margin_botm_5']")
	WebElement Applogo;

	@FindBy(xpath = "//span[text()='Remember me']")
	WebElement Rememberme;

	@FindBy(xpath = "//a[text()='English']")
	WebElement Language;

	@FindBy(xpath = "//span[2][contains(text(),'Clients')]")
	WebElement Clientpage;

	// Actions

	public String validateLoginPage() {
		// System.out.println(signinxt.getText());
		return signinxt.getText();
	}

	public boolean validateClientLogo() throws InterruptedException {
		// System.out.println(Clientlogo);
		wait = new WebDriverWait(driver, 30); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(Clientlogo));

		System.out.println(Clientlogo.isDisplayed());
		return Clientlogo.isDisplayed();
	}

	public boolean validateApplogo() {
		wait = new WebDriverWait(driver, 30); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(Applogo));

		System.out.println(Applogo.isDisplayed());
		return true;
	}

	public String validateRememberme() {
		System.out.println(Rememberme.getText());
		return Rememberme.getText();
	}

	public String validateLanguage() {
		System.out.println(Language.getText());
		return Language.getText();
	}

	public String validateForgotPassword() {
		// System.out.println(forgotpwd.getText());
		return forgotpwd.getText();
	}

	public String validationMessage(String uname1, String pwd1) throws InterruptedException {
		username.sendKeys(uname1);
		password.sendKeys(pwd1);
		// Thread.sleep(3000);
		signinBtn.click();
		// Thread.sleep(3000);
		System.out.println(Errormsg.getText());
		return Errormsg.getText();
	}

	public ForgotPasswordPage ForgotPassword() throws IOException {
		forgotpwd.click();
		return new ForgotPasswordPage();
	}

	public ClientsPage login(String uname, String pwd) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signinBtn.sendKeys(Keys.ENTER);
		int count;

		count = driver.findElements(By.xpath("//span[2][contains(text(),'Client')]")).size();

		System.out.println(count);

		if (count == 0) {
			// Assert.fail("login failed");
			return null;

		} else {
			return new ClientsPage();
		}

	}

}
