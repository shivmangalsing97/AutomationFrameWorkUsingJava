package selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	@Test	@SuppressWarnings("deprecation")
	public void mouseOver() {
		try {
//		setup driver using webdriverManger
		WebDriverManager.firefoxdriver().setup();
		
//		Initialize webdriver
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement button1 = driver.findElement(By.xpath("//button[text()='Mouse Hover']"));
		
//		use javascripExecutor to scroll into webelement
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView(true)", button1);
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		act.moveToElement(button1).perform();		
		
		Thread.sleep(1000);
		WebElement moouseOver = driver.findElement(By.xpath("//a[@href='#top']"));
//		"//button[text()='Mouse Hover']/following-sibling :: div/a[@href='']"
		System.out.println(moouseOver.getText());
		moouseOver.click();
		
		driver.close();
		driver.quit();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
