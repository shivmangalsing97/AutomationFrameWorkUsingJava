package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static WebDriver driver ;
		
	public void InitializeWebDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("**********************************************Session Started**************************************");
	}
	
	public void launchApp(String URL) {
		driver.get(URL);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
		
		
	}
	public String getCuurentTitle() {
		return driver.getTitle();
		
	}
	
	public void logMessage(String msg) {
		System.out.println(msg);
		
	}
	
	public void CloseWebDriver()
	{
		driver.quit();
		System.out.println("********************************************Session Closed*************************************************");
	}
	
	
	public WebElement getElementBy(By element) {
		return driver.findElement(element);
		
	}
	
	public WebElement getElementBy(By element, String text) {
		String locator = element.toString().replaceAll("#option", text);
		element = By.xpath(locator.split(":")[1].trim());
		return driver.findElement(element);
		
	}
	
	public void checkElementIsdisplayed(By element) {
		if (driver.findElement(element).isDisplayed()) {
			logMessage("**[INFO] Element is Displayed");
		}
	}
	
	public void checkElementIsdisplayed(By element, String text ) {
		if (getElementBy(element, text).isDisplayed()) {
			logMessage("**[INFO] Element is Displayed");
		}
	}
	
	public void hardWait(int sec) {
		try {
			Thread.sleep(sec*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void implicitWait() {
//		driver.manage().timeouts().implicitlyWait(10);
//	}

}
