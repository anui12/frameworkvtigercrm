package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class actitimeLogoutPage {

	@FindBy(id="logoutLink")
	private WebElement logoutbtn;
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public actitimeLogoutPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void Logout() {
		logoutbtn.click();
	}
	
}
