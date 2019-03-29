package rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlview.app.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hashmapTest extends TestBase {

	public WebDriver driver;
	public String credentials;
	public String credentialinfo[];
	ArrayList<String> ar = new ArrayList<String>();

	public hashmapTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='mat-input-0']")
	WebElement search;

	// @FindBy(xpath = "//input[@id='blinkLogInText']")
	// WebElement username;
	//
	// @FindBy(xpath = "//*[@id='password']")
	// WebElement password;
	//
	// @FindBy(xpath = "//input[@type='submit']")
	// WebElement signinBtn;

	// public hashmapTest() throws IOException {
	// PageFactory.initElements(driver,this);
	// }

	// public hashmapTest(WebDriver driver) {
	//
	// this.driver = driver;
	//
	// // This initElements method will create all WebElements
	//
	// PageFactory.initElements(driver, this);
	//
	// }

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().version("2.40").arch32().proxy("192.168.1.224:8080").setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.avlview.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	public void loginexisting() throws InterruptedException {
		credentials = Data.userdetails().get("Existing");
		credentialinfo = credentials.split("_");

		System.out.println(credentialinfo[0]);
		System.out.println(credentialinfo[1]);

		// username.sendKeys(credentialinfo[0]);
		// password.sendKeys(credentialinfo[1]);
		// signinBtn.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='blinkLogInText']")).sendKeys(credentialinfo[0]);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(credentialinfo[1]);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='mat-input-0']")).click();
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys("testcl45@gmail.com");
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(Keys.ENTER);
		// search.sendKeys("hhhh@hhhs.com");
		// search.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//a[@title='testcl45@gmail.com']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

		Thread.sleep(2000);

		// System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'You
		// are')]")).getText());

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

		/*
		 * for (String num : ar) { System.out.println(num); }
		 */

		// System.out.println(ar.get(0));

		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		hm.put("Status", ar);

		String b = "[Moving, Stopped, Idling, Disconnected]";

		Set<String> keys = hm.keySet();
		for (String key : keys) {
			// System.out.println("Value of " + key + " is: " + hm.get(key));

			String a = hm.get(key).toString();
			System.out.println(a);
			System.out.println(b);
			System.out.println(a.equals(b));

		}

		// Boolean a = al.contains("Moving");
		// System.out.println(a);

		// String[] candidates = "Moving|Moving|Idling|Disconnected".split("|");

		/*
		 * boolean stat1 = hm.containsValue("Moving, Stopped, Idling, Disconnected");
		 * System.out.println(stat1);
		 */

	}

	@Test(enabled = false)
	public void loginnew() {
		credentials = Data.userdetails().get("New");
		credentialinfo = credentials.split("_");

		driver.findElement(By.xpath("//input[@id='blinkLogInText']")).sendKeys(credentialinfo[0]);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(credentialinfo[1]);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
