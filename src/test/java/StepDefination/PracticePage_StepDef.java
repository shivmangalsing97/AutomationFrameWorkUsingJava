package StepDefination;

import org.testng.Assert;

import PageActions.PracticePage_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import runner.BaseClass;

public class PracticePage_StepDef extends BaseClass {

	public PracticePage_StepDef() {
		super();
	}
	
	PracticePage_Actions prac = new PracticePage_Actions() ;
	
	@Given("I want to launch practice page url")
	public void i_want_to_launch_practice_page_url() {
		launchApp("https://rahulshettyacademy.com/AutomationPractice/");
		logMessage("**[INFO] Current URL: "+ getUrl());
	}
	
	@And("^I want to select (.*)$")
	public void i_want_to_select(String button) {
	   prac.selectRadioButton(button);
	}
	
	@And("^I search for (.*)$")
	public void i_want_to_select_Country(String country) {
	   prac.selectCountryInBx(country);
	}
	
	@Then("^I verify text in suggestion box is (.*)$")
	public void verifyCountryInSuggestionBox(String country){
		String actualCountryName = prac.getSugestionBoxValue() ;
		Assert.assertEquals(country,actualCountryName , "[ASSERT FAILED]: Country name is different: " + actualCountryName);
		logMessage("[ASSERT PASSED]: Country name matched: " + actualCountryName);	
	}
	
	@And("^I want to opt for (.*)$")
	public void selectFromoptions(String option) {
		 prac.selectFromoptions(option)	;
	}
	
	@Then("^I want to verify selected option is (.*)$")
	public void verifySelectedOptions(String option){
		String actualOption = prac.getSelectedOptionValue() ;
		Assert.assertEquals(actualOption.toLowerCase(),option.toLowerCase() , "[ASSERT FAILED]: Country name is different: " + actualOption);
		logMessage("[ASSERT PASSED]: Country name matched: " + actualOption);	
	}

}
