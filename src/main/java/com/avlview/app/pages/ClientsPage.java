package com.avlview.app.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.avlview.app.base.TestBase;
import com.avlview.app.utilities.JavaScriptUtil;

public class ClientsPage extends TestBase {

	boolean count = false;

	public ClientsPage() throws IOException {
		// super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[2][contains(text(),'Clients')]")
	WebElement clients;

	@FindBy(xpath = "//button[starts-with(@class,'mat-button ')]")
	WebElement Totaltabs;

	@FindBy(xpath = "//img[@class='margin_top_7']")
	WebElement logo;

	@FindBy(xpath = "//a[contains(text(),'Add client')]")
	WebElement addclient;

	@FindBy(xpath = "//*[@id='mat-input-0']")
	WebElement search;

	@FindBy(xpath = "//span[1][@class='fnt-16 fl']")
	WebElement searchcount;

	@FindBy(xpath = "//i[@class='material-icons more_btn']")
	WebElement topright;

	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	WebElement settings;

	@FindBy(xpath = "//a[@class='settings_drop_icon']")
	WebElement settingsicon;

	@FindBy(xpath = "//span[contains(text(),'Remote Login')]")
	WebElement remotelogin;

	@FindBy(xpath = "//div[@class='maxwndw_left margin_top_7']")
	WebElement usertittile;

	@FindBy(xpath = "//a[@class='max_more relative']")
	WebElement usersettings;

	@FindBy(xpath = "//div[contains(text(),'Sign Out')]")
	WebElement signout;

	@FindBy(xpath = "//span[contains(text(),'You')]")
	WebElement txtaftersignout;

	@FindBy(xpath = "//*[@id='mat-select-1']/div/div[1]")
	WebElement itemcount;

	@FindBy(xpath = "//*[@id='mat-option-3']/span")
	WebElement itemsperpage25;

	@FindBy(xpath = "//*[@id='mat-option-4']/span")
	WebElement itemsperpage50;

	@FindBy(xpath = "//*[@id='mat-option-5']/span")
	WebElement itemsperpage100;

	@FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	WebElement rangelabel;

	@FindBy(xpath = "//button[2][@type='button']")
	WebElement paginationbtn;

	public String validateClientspage() {
		System.out.println(clients.getText());
		return clients.getText();
	}

	public boolean validatelogo() {
		WebDriverWait wait = new WebDriverWait(driver, 30); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(logo));

		return logo.isDisplayed();
	}

	public String validateAddclient() {
		System.out.println(addclient.getText());
		return addclient.getText();
	}

	public int validatetotaltabs() {

		int tabcount = driver.findElements(By.xpath("//button[starts-with(@class,'mat-button ')]")).size();
		// System.out.println(tabcount);

		return tabcount;
	}

	public boolean validateSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(search));
		System.out.println(search.isDisplayed());
		return search.isDisplayed();
	}

	public String validatesExistingclientearchresult1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(search));

		/*
		 * Actions builder = new Actions(driver); Action seriesofaction =
		 * builder.moveToElement(search).click().sendKeys(search,
		 * prop.getProperty("searchtxt")) .sendKeys(Keys.ENTER).build();
		 * seriesofaction.perform();
		 */

		search.click();
		search.sendKeys(prop.getProperty("searchtxt"));
		search.sendKeys(Keys.ENTER);

		Thread.sleep(6000);

		System.out.println(searchcount.getText());
		return searchcount.getText();
	}

	public AddClientPage addclientclick() throws IOException {
		// TODO Auto-generated method stub

		/*
		 * Actions actions = new Actions(driver); actions.moveToElement(addclient);
		 * actions.click(); actions.build().perform();
		 */

		addclient.click();

		return new AddClientPage();
	}

	public SettingsPage settingsclick() throws IOException {

		topright.click();

		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(settings));
		settings.click();

		return new SettingsPage();
	}

	public String validatesExistingclientearchresult() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(search));

		/*
		 * Actions builder = new Actions(driver); Action seriesofaction =
		 * builder.moveToElement(search).click().sendKeys(search,
		 * prop.getProperty("searchtxt")) .sendKeys(Keys.ENTER).build();
		 * seriesofaction.perform();
		 */

		search.click();
		search.sendKeys(prop.getProperty("searchtxt"));
		search.sendKeys(Keys.ENTER);

		Thread.sleep(6000);

		// WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		// wait.until(ExpectedConditions.visibilityOf(searchcount));
		// wait.until(ExpectedConditions.textToBePresentInElementValue(searchcount,prop.getProperty("searchtxt")));
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[1][@class='fnt-16
		// fl']")));

		System.out.println(searchcount.getText());
		return searchcount.getText();
	}

	public String validatesRemotelogin() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOf(search));

		search.click();
		search.sendKeys(prop.getProperty("clientforremotelogin"));
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		settingsicon.click();
		Thread.sleep(2000);

		remotelogin.click();
		Thread.sleep(2000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		String parentWindow = it.next();
		System.out.println(" Parent win id is " + parentWindow);
		System.out.println(" Parent tittle is " + driver.getTitle());

		String newWindow = it.next();
		System.out.println(" Child win id is " + newWindow);

		driver.switchTo().window(newWindow);
		System.out.println(" Child tittle is " + driver.getTitle());
		System.out.println(usertittile.getText());

		usersettings.click();
		signout.click();
		// driver.close();

		System.out.println(txtaftersignout.getText());
		return txtaftersignout.getText();
	}

	public void itemsperpage(String cnt) throws InterruptedException, UnsupportedCommandException {

		itemcount.click();

		if (cnt.equals("25")) {
			System.out.println("25");
			itemsperpage25.click();
			Thread.sleep(2000);
		} else if (cnt.equals("50")) {
			System.out.println("50");
			itemsperpage50.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Clicking 100");
			itemsperpage100.click();
			Thread.sleep(2000);
		}

	}

	public boolean items25() throws InterruptedException {
		int rows_count;
		List<WebElement> rows_table = driver.findElements(By.xpath("//mat-row[@class='mat-row ng-star-inserted']"));

		rows_count = rows_table.size();
		System.out.println("Total rows in the grid is" + rows_count);

		if (rows_count > 0) {

			if (rows_count > 1 && rows_count <= 25) {
				count = true;
			} else {
				throw new SkipException("Skipping Item25 as no data available.");
			}
		} else {
			throw new SkipException("Skipping as no client data available.");
		}

		JavaScriptUtil.scrollIntoView(rangelabel, driver);
		JavaScriptUtil.drawBorder(rangelabel, driver);

		Thread.sleep(3000);

		return count;
	}

	public boolean items50() throws InterruptedException {
		int rows_count;
		List<WebElement> rows_table = driver.findElements(By.xpath("//mat-row[@class='mat-row ng-star-inserted']"));

		rows_count = rows_table.size();
		System.out.println("Total rows in the grid is" + rows_count);

		if (rows_count > 0) {

			if (rows_count > 25 && rows_count <= 50) {
				count = true;
			} else {
				throw new SkipException("Skipping Item50 as no data available.");
			}
		} else {
			throw new SkipException("Skipping as no client data available.");
		}

		JavaScriptUtil.scrollIntoView(rangelabel, driver);
		JavaScriptUtil.drawBorder(rangelabel, driver);

		Thread.sleep(3000);

		return count;
	}

	public boolean items100() throws InterruptedException {
		int rows_count;
		List<WebElement> rows_table = driver.findElements(By.xpath("//mat-row[@class='mat-row ng-star-inserted']"));

		rows_count = rows_table.size();
		System.out.println("Total rows in the grid is" + rows_count);

		if (rows_count > 0) {

			if (rows_count > 50 && rows_count <= 100) {
				count = true;
			} else {
				throw new SkipException("Skipping Item100 as no data available.");
			}
		} else {
			throw new SkipException("Skipping as no client data available.");
		}

		JavaScriptUtil.scrollIntoView(rangelabel, driver);
		JavaScriptUtil.drawBorder(rangelabel, driver);

		Thread.sleep(3000);
		return count;
	}

	public String pagination() throws InterruptedException {
		String pagetxt;
		String substrtxt;

		// Actions actions = new Actions(driver);
		// actions.moveToElement(itemcount).build().perform();

		System.out.println(paginationbtn.isEnabled());

		if (paginationbtn.isEnabled()) {
			paginationbtn.click();

			Thread.sleep(2000);

			pagetxt = rangelabel.getText();
			System.out.println(pagetxt);

			int firstIndex = pagetxt.indexOf('o');
			System.out.println("First occurrence of char 'o'" + " is found at : " + firstIndex);

			substrtxt = pagetxt.substring(0, firstIndex).trim();
			System.out.println(substrtxt);

		} else {
			throw new SkipException("Skipping there is no data available for pagination.");
		}
		JavaScriptUtil.scrollIntoView(rangelabel, driver);
		JavaScriptUtil.drawBorder(rangelabel, driver);
		Thread.sleep(3000);
		return substrtxt;

	}

}
