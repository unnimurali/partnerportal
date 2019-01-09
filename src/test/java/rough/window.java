package rough;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class window {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// WebDriverManager.chromedriver().version("2.40").arch32().proxy("192.168.1.224:8080").setup();
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://preapp.avlview.com");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='blinkLogInText']")).sendKeys("mapview");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("ZRidata2019ai");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60); // wait for 5 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-input-0']")));

		driver.findElement(By.xpath("//*[@id='mat-input-0']")).click();
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys("Balaganesh Travels");
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(Keys.ENTER);
		// Thread.sleep(2000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='settings_drop_icon']")).click();
		// Thread.sleep(2000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Remote Login')]")).click();
		// Thread.sleep(5000);
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		String parentWindow = it.next();
		System.out.println(" Parent win id is " + parentWindow);
		System.out.println(" Parent tittle is " + driver.getTitle());

		// driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		String newWindow = it.next();
		System.out.println(" Child win id is " + newWindow);

		driver.switchTo().window(newWindow);

		System.out.println(" Child tittle is " + driver.getTitle());

		System.out.println(driver.findElement(By.xpath("//div[@class='maxwndw_left margin_top_7']")).getText());

		driver.findElement(By.xpath("//a[@class='max_more relative']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Sign Out')]")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'You')]")).getText());
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println(" Parent win id is " + parentWindow);
		System.out.println(" Parent tittle is " + driver.getTitle());

	}

}
