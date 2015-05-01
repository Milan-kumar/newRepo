package winPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class winClassTest {
	
  WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String port = System.getProperty("user.port");
		String user = System.getProperty("user.username");
		String pass = System.getProperty("user.password");
		String db = System.getProperty("user.database");
		
//		System.out.println(host);
		System.out.println(port);
		System.out.println(user);
		System.out.println(pass);
		System.out.println(db);
	  driver.get("https://www.spirit.com/Default.aspx");
	  
	  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("html/body/div[3]/div[1]/a/span")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='booking-type']/div[1]/ul/li[1]/a/span[2]")).click();
		driver.findElement(By.id("journeyOneWay")).click();
		Select dep = new Select(driver.findElement(By.id("departCityCodeSelect")));
		dep.selectByValue("FLL");
		Select to = new Select(driver.findElement(By.id("destCityCodeSelect")));
		to.selectByValue("LAS");
		
		List<WebElement> inputs = driver.findElements(By.tagName("input"));

		for (WebElement input : inputs) {
		    ((JavascriptExecutor) driver).executeScript(
		                "arguments[0].removeAttribute('readonly','readonly')",input);
		}
		
		((JavascriptExecutor)driver).executeScript("document.getElementById('departDateDisplay').value='December 20';");
//		WebElement dat = driver.findElement(By.id("destCityCodeSelect"));
//		dat.clear();
//		dat.sendKeys("December 14");
		driver.findElement(By.xpath(".//*[@id='book-travel-form']/p/button")).click();
  }
/*  @Test
  public void f1() {
	  driver.get("http://yahoo.com");
  }*/
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
//	  driver.quit();
  }

}
