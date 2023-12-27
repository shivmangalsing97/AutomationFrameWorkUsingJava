package StepDefination;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import runner.BaseClass;

public class StepDef extends BaseClass{
	
	public StepDef() {
		PageFactory.initElements(driver, BaseClass.driver);
		
	}
	
	@Given("I Want to launch Google")
	public void launchUrl() {
		launchApp("https://www.google.com/");
	}
	
	@And("I print Url and page title")
	public void grtUrlAndPageTitle() {
		logMessage(getCuurentTitle());
		logMessage(getUrl());
	}
	
	

}
