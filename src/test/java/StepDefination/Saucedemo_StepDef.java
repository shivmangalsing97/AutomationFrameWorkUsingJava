package StepDefination;

import PageActions.Saucedemo_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import runner.BaseClass;

public class Saucedemo_StepDef  extends BaseClass {
	public Saucedemo_StepDef() {
		super();
	}
	
	Saucedemo_Actions sauceActions = new Saucedemo_Actions() ;
	
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
