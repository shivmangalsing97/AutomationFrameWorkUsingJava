package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import runner.BaseClass;

public class PracticePage_Actions extends BaseClass{
	public PracticePage_Actions() {
		super();
		PageFactory.initElements(driver, BaseClass.driver);
	}
	
	
	By radio = By.xpath("//input[@value='#option']");
	By suggestionBox = By.id("autocomplete");
	By suggestedOption = By.xpath("//div[text()='#option']");
	By selecOption = By.xpath("//select/option[text()='#option']");
	By selecBox = By.xpath("//select");
	
	public void selectRadioButton(String button) {
		getElementBy(radio,button).click();
	}
	
	
	public void selectCountryInBx(String countryName){
		getElementBy(suggestionBox).clear();
		getElementBy(suggestionBox).sendKeys(countryName);
		
		try {
			checkElementIsdisplayed(suggestedOption,countryName) ;
			logMessage("Element is displayed in try");
			getElementBy(suggestedOption,countryName).click();
		} catch (NoSuchElementException e) {
			hardWait(10);
			checkElementIsdisplayed(suggestedOption,countryName) ;
			logMessage("Element is displayed in catch");
			getElementBy(suggestedOption,countryName).click();
		}
	}
	
	public String getSugestionBoxValue() {
		
		String value = getElementBy(suggestionBox).getAttribute("value");
		logMessage("Current text in Suggestion Box is: " + value);
		return value ;
	}
	
	public void selectFromoptions(String option) {
		
		try {
			checkElementIsdisplayed(selecOption,option) ;
			logMessage("Element is displayed in try");
			getElementBy(selecOption,option).click();
		} catch (NoSuchElementException e) {
			hardWait(10);
			checkElementIsdisplayed(selecOption,option) ;
			logMessage("Element is displayed in catch");
			getElementBy(selecOption,option).click();
		}
	}
	
	public String getSelectedOptionValue() {
		
		String value = getElementBy(selecBox).getAttribute("value");
		logMessage("Current text in Suggestion Box is: " + value);
		return value ;
	}
	
}
