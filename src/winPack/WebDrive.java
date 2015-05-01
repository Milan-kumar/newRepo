package winPack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDrive {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		

		driver.get("http://www.teachmeselenium.com/p/automation-practice.html");

		String strParentWindowHandle = driver.getWindowHandle();
		System.out.println("ParentWindow" + strParentWindowHandle);
		

		driver.findElement(By.linkText("Click Me to open New Window")).click();
/*		String winOne = driver.getWindowHandle();
		driver.switchTo().window(winOne);
		System.out.println(driver.getTitle());*/
		Set<String> setwindowHandles = driver.getWindowHandles();		
		System.out.println(setwindowHandles.size());
		for (String winHandle : setwindowHandles) {
//			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			System.out.println(driver.getTitle());

		}
/*		Select list = new Select(
				driver.findElement(By.id("list-second-window")));
		list.selectByVisibleText("Second Window");*/
		
		driver.findElement(By.linkText("Click Me To Open Third Window")).click();
//		driver.findElement(By.cssSelector("#post-body-3063364410968351678>div>div>span>a"));
				Set<String> snw = driver.getWindowHandles();
				System.out.println(snw.size());
				
		
//		System.out.println("clicked third");		
				System.out.println(snw);
		System.out.println(snw.size());
		
		for(String s:snw){
			
			driver.switchTo().window(s);
			System.out.println(driver.getTitle());
			System.out.println(s);
//			System.out.println("Parent:"+strParentWindowHandle+"str:"+s);
			if(!strParentWindowHandle.equalsIgnoreCase(s))
			driver.close();
			
		}
		driver.switchTo().window(strParentWindowHandle);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
