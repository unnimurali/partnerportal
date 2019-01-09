package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hashmapTest {

	public WebDriver driver;
	public String credentials;
	public String credentialinfo[];

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
		// WebDriverManager.chromedriver().version("2.40").arch32().proxy("192.168.1.224:8080").setup();
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://preapp.avlview.com");
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

	}

	@Test(enabled = true)
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
