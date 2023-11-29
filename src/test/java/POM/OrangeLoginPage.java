package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeLoginPage {

	@FindBy(name="username")
	WebElement usernametf;
	
	@FindBy(name="password")
	WebElement passwordtf;

	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
	
	
}
