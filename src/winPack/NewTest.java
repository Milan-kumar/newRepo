package winPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;



public class NewTest {
	WebDriver driver;
	String baseUrl,nodeUrl;
	  @BeforeTest
	  public void f() throws MalformedURLException {
		  baseUrl = "http://google.com";
		  nodeUrl = "http://10.131.60.170:5566/wd/hub";
//		  driver.get("http://google.com");
		  DesiredCapabilities capabilty = DesiredCapabilities.firefox();
		  capabilty.setBrowserName("firefox");
		  capabilty.setPlatform(Platform.WINDOWS);
		  driver = new RemoteWebDriver(new URL(nodeUrl),capabilty);
	  }
	  @AfterTest
	  public void f1() {
		  driver.quit();
	  }
	  
	  @Test
	  public void simpleTest(){
		  driver.get(baseUrl);
		  System.out.println(driver.getTitle());
		  Assert.assertEquals("Google",driver.getTitle());
	  }
	 /* @BeforeMethod
	  public void beforeMethod() {		  
		  System.setProperty("webdriver.chrome.driver", "D:\\Auto\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }*/

}
