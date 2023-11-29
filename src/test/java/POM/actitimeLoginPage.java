package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class actitimeLoginPage {

	@FindBy(id="username")
	private WebElement usernametf;
	
	@FindBy(name="pwd")
	private WebElement passwordtf;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement checkbox; 
	
	@FindBy(id="loginButton")
	private WebElement loginbtn ;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//create constructor
	public actitimeLoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	//create a method
	public void Login(String usernamedata, String passworddata) {
		usernametf.sendKeys(usernamedata);
		passwordtf.sendKeys(passworddata);
		checkbox.click();
		loginbtn.click();
	}
	
	
}
