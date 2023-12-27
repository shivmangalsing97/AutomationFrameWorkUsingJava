package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import runner.BaseClass;

public class Saucedemo_Actions extends BaseClass {
	
	public Saucedemo_Actions() {
		super();
		PageFactory.initElements(driver, BaseClass.driver);
	}
	
	public By user_name = By.id("user-name");
	public By pass_word = By.id("password");
	public By login_button = By.id("login-button");
	public By title_text = By.xpath("//div[contains(text(),'Swag Labs')]");

	public void launchApplication(String Url) {
		launchApp(Url);
		
	}
	
	public void enterUserName(String username) {
		getElementBy(user_name).clear();
		getElementBy(user_name).sendKeys(username);
		logMessage("**[INFO] Username Enter: " + username );
	}
	
	public void enterpassword(String password) {
		getElementBy(user_name).clear();
		getElementBy(pass_word).sendKeys(password);
		logMessage("**[INFO] Password Enter: " + password );
	}
	
	public void clickLogin() {
		try {
			checkElementIsdisplayed(login_button);
			getElementBy(login_button).click();
			logMessage("**[INFO] Clicked On Login Button");
		} catch (Exception e) {
			getElementBy(login_button).click();
		}
	}
	
	public void veryfyLoggedInSuccessFull(String expectedTitle) {
		String actualTitle =  getElementBy(title_text).getText();
		Assert.assertEquals(actualTitle,expectedTitle, 
				"**[Error]Expected Tilte: "+ expectedTitle + " Does not matches with Actual Title: " +  actualTitle);
		logMessage("**[Assert Passed] Expected Title: "+ expectedTitle + " matches with Actual Title: " +  actualTitle);
	}
	

}
