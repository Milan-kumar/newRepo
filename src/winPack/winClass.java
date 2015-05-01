package winPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.WebWindow;
//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class winClass {
	public static void main(String s[]) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver;
		FirefoxProfile profi = new FirefoxProfile();		
		profi.setAcceptUntrustedCertificates(true);
		driver = new FirefoxDriver(profi);
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		/*WebDriverWait fwait = (WebDriverWait) new FluentWait(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement foo = fwait.until(isTrue)
		*/		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
//		WebElement ele =driver.findElement(By.id("a"));
		System.out.println("Page Source"+driver.getPageSource());
		driver.get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("remote_webdriver.png")); 
		
		WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
	
		Actions builder = new Actions(driver);
		builder.dragAndDrop(From, To).perform();
		
		/*Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("as"))).moveToElement(ele).build().perform();
		action.dragAndDrop(source, target)*/
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ParentConcept-code ng-binding'][text()='493']")));
//		driver.get("https://www.google.com");
//		driver.get("http://www.techlearn.in");
		driver.get("http://qa/");
		driver.findElement(By.name("username")).sendKeys("milan.kumar@rsystems.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Trinetx@123");
		driver.findElement(By.xpath("//button[@ng-click='onSignIn()']")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='NetworkSelectionButton ng-binding']"))));
//		driver.findElement(By.xpath("//*[@eventname='mustHave']//input[@ng-model='searchTermPreview']")).click();
		driver.findElement(By.xpath("//*[@eventname='mustHave']//input[@ng-model='searchTerm']")).sendKeys("Asthma");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ParentConcept-code ng-binding'][text()='493']")));
		driver.findElement(By.xpath("//*[@eventname='mustHave']//input[@ng-model='searchTerm']")).sendKeys(Keys.ENTER);
	
		Select sel = new Select(driver.findElement(By.className("a")));
		
		WebElement el = driver.findElement(By.id("a"));
		
		
		
//		action.keyDown(Keys.ENTER);
//		action.keyUp(Keys.ENTER);
		
		/*driver.get("http://www.teachmeselenium.com/p/automation-practice.html");
		
		String strParentWindowHandle = driver.getWindowHandle();k
		System.out.println("ParentWindow"+strParentWindowHandle);
		
		
		driver.findElement(By.linkText("Click Me to open New Window")).click();
		Set<String> setwindowHandles = driver.getWindowHandles();
		for(String winHandle : setwindowHandles){
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			System.out.println(driver.getTitle());
			
		}
		Select list = new Select(driver.findElement(By.id("list-second-window")));
		list.selectByVisibleText("Second Window");
		
		
		driver.quit();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Message:"+alertText);
		Thread.sleep(10000);
//		alert.accept();
//		driver.findElement(By.id("lst-ib")).sendKeys("test");
		for (int i = 0; i < 5; i++) {
//			driver.findElement(By.id("lst-ib")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
			driver.findElement(By.linkText("TechLearn.in")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
			System.out.println("in for");
		}
		
		 for(int i=0; i<9; i++){
			   driver.findElement(By.linkText("TechLearn.in")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			  }
		((JavascriptExecutor) driver)
				.executeScript("document.body.style.transform='scale(0.7)';");
		String zoom = ((JavascriptExecutor) driver).executeScript(
				"return document.body.style.transform").toString();
		System.out.println("zoom text:" + zoom);

		// driver.manage().window().setSize(new Dimension(1920,1080));
		// Thread.sleep(20);

		// driver.get("https://www.google.com");

		Actions action = new Actions(driver);
		// action.keyDown(Keys.ADD)
		// action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();
		// action.keyDown(Keys.CONTROL).sendKeys(Keys.ADD,Keys.SUBTRACT,Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();

		// driver.quit();

		driver.findElement(By.className("flight_booking")).click();
		driver.findElement(By.id("journeyOneWay")).click();
		Select dep = new Select(driver.findElement(By
				.id("departCityCodeSelect")));

		dep.selectByValue("FLL");
		Select to = new Select(driver.findElement(By.id("destCityCodeSelect")));
		to.selectByValue("LAS");

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('destCityCodeSelect').removeAttribute('readonly',0);");
		WebElement dat = driver.findElement(By.id("destCityCodeSelect"));

		// dat.sendKeys(Keys.CONTROL);
		dat.clear();
		dat.sendKeys("December 14");
		driver.findElement(By.xpath(".//*[@id='book-travel-form']/p/button"));

		// driver.findElement(By.xpath(".//*[@id='block-block-7']/div/div/p/a[2]/img")).click();
		
		 * Actions builder = new Actions(driver); Action dragDrop=
		 * builder.clickAndHold(driver.findElement(By.id("one")))
		 * .moveToElement(driver.findElement(By.xpath(".//*[@id='bin']")))
		 * .release(driver.findElement(By.xpath(".//*[@id='bin']"))) .build();
		 * dragDrop.perform();
		 
		// builder.dragAndDrop(driver.findElement(By.id("one")),driver.findElement(By.id("bin"))).build().perform();
		//
		// act.moveToElement(driver.findElement(By.linkText("Follow us on Facebook"))).perform();
		// ArrayList<String> tabs = new
		// ArrayList<String>(driver.getWindowHandles());
		// driver.switchTo().window(tabs.get(1));
		// driver.get("http://rsystems.com");
		// System.out.println("hovering done");
		// driver.findElement(By.xpath(".//*[@id='abt']/li[1]/a")).click();

*/	}

}
