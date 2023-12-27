package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static WebDriver driver ;
		
	public void InitializeWebDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("Session Started");
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
		System.out.println("Session Closed");
	}
	

}
