package selenium.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindow {

	@Test
	public void SwitchWindow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement windowBtn = driver.findElement(By.xpath("//*[@id=\"openwindow\"]"));
		//Get Parent window forst
		String parent = driver.getWindowHandle();
		
//		System.out.println(parent);
//		open multiple child windows now 
		windowBtn.click();
		windowBtn.click();
		windowBtn.click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String child = itr.next();
//			System.out.println(child);
			if(!parent.equals(child))
				driver.switchTo().window(child);
			System.out.println(driver.switchTo().window(child).getTitle());
		}
		
		driver.close();		
		driver.switchTo().window(parent);
		driver.quit();
	}

}
