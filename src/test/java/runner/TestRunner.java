package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "src/test/resources/Features",
		glue = "StepDefination",
		tags = "@Test"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	BaseClass baseObj = new BaseClass() ;
	
	@BeforeTest
	public void InitializeWebDriver()
	{
		baseObj.InitializeWebDriver();
	}
	
	@AfterTest
	public void CloseWebDriver()
	{
		baseObj.CloseWebDriver();
	}
	
}
