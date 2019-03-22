package com.avlview.app.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.avlview.app.base.TestBase;

public class ClientDetailsPage extends TestBase {

	WebDriverWait wait;

	public ClientDetailsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'CREATE NEW VEHICLE')]")
	WebElement createnew;

	@FindBy(xpath = "//h3[contains(text(),'You are')]")
	WebElement template;

	@FindBy(xpath = "//span[contains(text(),'Add Vehicle')]")
	WebElement addvehicle;

	@FindBy(xpath = "//mat-icon[@class='back_btn margin_top_4 mat-icon material-icons']")
	WebElement backbutton;

	@FindBy(xpath = "//button[@role='menuitem']")
	WebElement menuitems;

	@FindBy(xpath = "//button[contains(text(),'Add Vehicle')]")
	WebElement addvehiclemenu;

	@FindBy(xpath = "//div[contains(text(),'Vehicle(s)')]/../div[1]")
	WebElement vehiclesummarycount;

	// div[@class='default_row']

	public String validateTemplate() throws InterruptedException {

		// Thread.sleep(2000);// Script wouldn't work if this statement removed
		Boolean iselementpresent = driver.findElements(By.xpath("//div[@class='default_row']")).size() != 0;
		System.out.println(iselementpresent);
		if (iselementpresent == true) {
			throw new SkipException("Vehicle data's are avaialble so skipping the testcase.");
		} else {
			WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
			wait.until(ExpectedConditions.visibilityOf(template));
			return template.getText();

		}
	}

	public String validateAddVehicle() {
		System.out.println(addvehicle.getText());
		return addvehicle.getText();
	}

	public boolean validateBackButtonExist() {
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(backbutton));
		System.out.println(backbutton.isDisplayed());
		return backbutton.isDisplayed();
	}

	public String validateBackbutton() throws IOException {
		wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(backbutton));
		backbutton.click();
		ClientsPage cp = new ClientsPage();
		return cp.validateClientspage();
	}

	public int validateMenuItems() {
		addvehicle.click();
		int menuitems = driver.findElements(By.xpath("//button[@role='menuitem']")).size();
		return menuitems;
	}

	public boolean validateTotalVehicleCount() {

		Boolean vehcntstatus = false;
		Boolean iselementpresent = driver.findElements(By.xpath("//div[@class='default_row']")).size() != 0;
		System.out.println(iselementpresent);

		if (iselementpresent == true) {

			String vehiclecntsummary = driver.findElement(By.xpath("//div[contains(text(),'Vehicle(s)')]/../div[1]"))
					.getText();
			System.out.println(vehiclecntsummary);

			int totalsummaycnt = Integer.parseInt(vehiclecntsummary);

			if (totalsummaycnt > 0) {
				int vehiclegridcount = driver.findElements(By.xpath("//div[@class='default_row']")).size();
				System.out.println(vehiclegridcount);

				if (totalsummaycnt == vehiclegridcount) {
					vehcntstatus = true;
					System.out.println(vehcntstatus);

				}
			} else {

				vehcntstatus = false;
			}

		} else {
			throw new SkipException("No Vehicle data's are avaialble so skipping the testcase.");
		}
		return vehcntstatus;

	}

}
