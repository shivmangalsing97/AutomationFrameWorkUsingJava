package StepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import PageActions.Saucedemo_Actions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import runner.BaseClass;

public class Saucedemo_StepDef  extends BaseClass {
	public Saucedemo_StepDef() {
		super();
	}
	
	Saucedemo_Actions sauceActions = new Saucedemo_Actions() ;
	
	@Before
	public void BeforeScenario(Scenario scenario)
	{
		System.out.println("-----------------------------------------------------[Starting Scenario]-----------------------------------") ;
		System.out.println(" Scenario:" + scenario.getName()) ;
		System.out.println("-----------------------------------------------------------------------------------------------------------") ;
	}
	
	@After
	public void AfterScenario(Scenario scenario)
	{
		System.out.println("-----------------------------------------------------[Scenario Result]-----------------------------------") ;
		System.out.println(" Scenario:" + scenario.getName() + "Result: " + scenario.getStatus() );
		System.out.println("---------------------------------------------------------------------------------------------------------") ;
		
		if(scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver ;
			scenario.attach(takesScreenshot.getScreenshotAs(OutputType.BYTES), 
					"image/png", "Scenario Failed Taking Screenshot");
		}
	}
	
	@Given("I launch website url")
	public void i_launch_website_url() {
		sauceActions.launchApp("https://www.saucedemo.com/");
		logMessage("**[INFO] Current URL: "+ getUrl());
	    
	}
	@And("^User enters (.*) as username$")
	public void user_enters_a_valid_username(String username){
		sauceActions.enterUserName(username);
	}
	@And("^User enters (.*) as valid password$")
	public void user_enters_a_valid_password(String password) {
		sauceActions.enterpassword(password);
	}
	
	@And ("I click on login")
	public void I_click_on_login() {
		sauceActions.clickLogin();
	}
	
	
	@Then("^I verify website title is (.*)$")
	public void i_verify_user_is_loggedin_successfully(String title) {
	    sauceActions.veryfyLoggedInSuccessFull(title);
	}

}
