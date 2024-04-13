package selenium.practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrernShot {

	@Test @SuppressWarnings("deprecation")
	public  void ScreenShot() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String timeStamp = new SimpleDateFormat("hhmmss").format(new Date());
		
		driver.get("https://www.saucedemo.com/");

		TakesScreenshot screeshot = (TakesScreenshot)driver ;
		File source = screeshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("src/main/java/selenium/practice/SeleniumScreenshots/Screen"+timeStamp+".png"));
	
		driver.quit();
	}

}
