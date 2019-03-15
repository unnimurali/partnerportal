package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vehicle {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().version("2.40").arch32().proxy("192.168.1.224:8080").setup();
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://preapp.avlview.com");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='blinkLogInText']")).sendKeys("mkrish@mapview.co.in");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-input-0']")));

		driver.findElement(By.xpath("//*[@id='mat-input-0']")).click();
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys("Nidhin");
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(Keys.ENTER);
		// Thread.sleep(2000);
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//a[@class='settings_drop_icon']")).click();
		// Thread.sleep(2000);
		// Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'company')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[contains(text(),'Add Vehicle')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Add Vehicle')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'remaining')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Truck 01']")).sendKeys("Auto vehicle");
		driver.findElement(By.xpath("//input[@placeholder='SDK 6100 U']")).sendKeys("KL11A 3333");

		driver.findElement(By.xpath("//input[@placeholder='Choose Type']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Ambulance')]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Choose Segment']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Heavy Vehicle')]")).click();

		// driver.findElement(By.xpath("//span[@class='font_13 grey_txt fl txt_right
		// line_hgt_16']//..//a/img")).click();
		// driver.findElement(By.xpath("//input[@placeholder='John']")).sendKeys("Automated
		// driver");
		// driver.findElement(By.xpath("//input[@placeholder='Eg.
		// 1234567890']")).sendKeys("32222222");
		// driver.findElement(By.xpath("//span[@class='blue_link link_1
		// margin_top_09']/../button/span")).click();

		// driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();

		// driver.findElement(By.xpath("//input[@placeholder='Choose
		// Driver']")).click();
		// driver.findElement(By.xpath("//span[contains(text(),'Drv 458')]")).click();

		// driver.findElement(By.xpath("//input[@placeholder='Choose
		// Driver']")).click();
		// driver.findElement(By.xpath("//span[contains(text(),'Drv 458')]")).click();

		driver.findElement(By.xpath(
				"//span[@class='mat-form-field-label-wrapper mat-input-placeholder-wrapper mat-form-field-placeholder-wrapper']//../../input[@placeholder='Pasir Ris, Singapore']"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//span[@class='mat-form-field-label-wrapper mat-input-placeholder-wrapper mat-form-field-placeholder-wrapper']//../../input[@placeholder='Pasir Ris, Singapore']"))
				.sendKeys("Chennai, Tamil Nadu, India");

		driver.quit();

	}

}
