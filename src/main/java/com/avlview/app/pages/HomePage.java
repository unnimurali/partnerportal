package com.avlview.app.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avlview.app.base.TestBaseParallelTesting;

public class HomePage extends TestBaseParallelTesting {

	public HomePage() throws IOException {
		PageFactory.initElements(getdriver(), this);
	}

	// Elements in the page

	@FindBy(xpath = "//span[contains(text(),'Version')]")
	WebElement version;

	public String validateHomePage() throws InterruptedException {
		// Thread.sleep(15000);
		System.out.println(version.getText());
		return version.getText();
	}

}
