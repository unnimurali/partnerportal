package com.avlview.app.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import com.avlview.app.base.TestBase;

public class ClientDetailsPage extends TestBase {

	WebDriverWait wait;
	ArrayList<String> ar = new ArrayList<String>();

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

	@FindBy(xpath = "//mat-icon[@class='search_btn mat-icon material-icons']")
	WebElement vehiclesearchicon;

	@FindBy(xpath = "//button[@title='Download as .xls']")
	WebElement downloadicon;

	@FindBy(xpath = "//button[@class='settings_drop_icon margin_left_14 mat-button ng-star-inserted']")
	WebElement settingsicon;

	@FindBy(xpath = "//span[@class='fnt_18 padd_rgt_5 black_txt']")
	WebElement searchedresult;

	@FindBy(xpath = "//input[@placeholder='Type in Vehicle name and press Enter key..']")
	WebElement vehicleseach;

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

	public boolean validateStatus() {
		boolean status = false;

		List<WebElement> rows_table = driver.findElements(
				By.xpath("//div[@class='margin_left_12 fl']/div[@class='fnt-13 grey04_txt margin_top_ms1']"));
		int rows_count = rows_table.size();
		System.out.println("Total rows in the grid is" + rows_count);

		String before_xpath = "//div[@class='ng-star-inserted']/div[";
		String after_xpath = "]/div[@class='fnt-13 grey04_txt margin_top_ms1']";

		for (int i = 2; i <= rows_count + 1; i++) {
			String items = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			// System.out.println("Irems are" + items);
			ar.add(items);
		}

		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		hm.put("Status", ar);

		String expected = "[Moving, Stopped, Idling, Disconnected]";

		Set<String> keys = hm.keySet();
		for (String key : keys) {
			// System.out.println("Value of " + key + " is: " + hm.get(key));
			String actual = hm.get(key).toString();
			// System.out.println(a);
			// System.out.println(b);
			status = actual.equals(expected);

		}

		return status;

	}

	public boolean validateSeachButton() {
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(vehiclesearchicon));
		System.out.println(vehiclesearchicon.isDisplayed());
		return vehiclesearchicon.isDisplayed();
	}

	public boolean validateVehicleSeach() throws InterruptedException {

		boolean searchstatus = false;
		System.out.println(vehiclesearchicon.isDisplayed());
		if (vehiclesearchicon.isDisplayed()) {

			Thread.sleep(2000);
			System.out.println("inside");
			// vehiclesearchicon.click();

			Actions actions = new Actions(driver);
			actions.moveToElement(vehiclesearchicon).click().build().perform();

			String texttosearch = prop.getProperty("vehicletosearch");
			vehicleseach.sendKeys(texttosearch);

			vehicleseach.sendKeys(Keys.ENTER);

			String actual = searchedresult.getText();
			String expected = texttosearch;

			searchstatus = actual.equals(expected);

		}
		return searchstatus;

	}

	public boolean validateExcelDownload() throws InterruptedException {

		boolean download = false;
		System.out.println(downloadicon.isDisplayed());

		if (downloadicon.isDisplayed()) {

			downloadicon.click();
			Thread.sleep(2000);
			File listOfFiles[] = folder.listFiles();
			Assert.assertTrue(listOfFiles.length > 0);

			for (File file : listOfFiles) {
				// make sure that downloaded file is not empty
				Assert.assertTrue(file.length() > 0);
				download = true;
			}

			for (File file : folder.listFiles()) {
				file.delete();
			}
			folder.delete();

		}
		return download;

	}

	public boolean validateSettingsIconclick() {
		int menuitemcnt = 0;
		boolean status = false;
		System.out.println(settingsicon.isDisplayed());
		if (settingsicon.isDisplayed()) {
			settingsicon.click();
			List<WebElement> rows_table = driver.findElements(By.xpath("//button[@role='menuitem']"));
			System.out.println(rows_table);
			menuitemcnt = rows_table.size();
			System.out.println(menuitemcnt);

			String before_xpath = "//div[@class='mat-menu-content ng-trigger ng-trigger-fadeInItems']/button[";
			String after_xpath = "]";

			for (int i = 1; i <= menuitemcnt; i++) {
				String items = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				// System.out.println("Irems are" + items);
				ar.add(items);
				System.out.println(ar);
			}

			HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
			hm.put("Status", ar);

			String expected = "[Remote Login, Invite to Join, View Subscriptions]";

			Set<String> keys = hm.keySet();
			for (String key : keys) {
				// System.out.println("Value of " + key + " is: " + hm.get(key));
				String actual = hm.get(key).toString();
				// System.out.println(a);
				// System.out.println(b);
				status = actual.equals(expected);

			}

		}

		return status;

	}

}
