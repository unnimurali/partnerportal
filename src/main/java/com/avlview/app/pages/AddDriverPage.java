package com.avlview.app.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avlview.app.base.TestBase;

public class AddDriverPage extends TestBase {

	WebDriverWait wait;

	public AddDriverPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(text(),'Add Driver')]")
	WebElement adddriver;

	@FindBy(xpath = "//input[@placeholder='John']")
	WebElement fname;

	@FindBy(xpath = "//input[@placeholder='Eg.1234567890']")
	WebElement phoneno;

	@FindBy(xpath = "//span[@class='blue_link link_1 margin_top_09']/../button/span")
	WebElement save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement cancel;

	@FindBy(xpath = "//div[@class='header_notification ng-star-inserted']/span")
	WebElement validationmsg;

	public String validateAddNewDriver() throws IOException, InterruptedException {

		System.out.println(adddriver.getText());
		return adddriver.getText();

	}

}
