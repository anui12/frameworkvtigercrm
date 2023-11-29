package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import POM.actitimeLoginPage;
import POM.actitimeLogoutPage;

public class Actitime {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demo.actitime.com/login.do");
		
		actitimeLoginPage lp = new actitimeLoginPage(d);
		PageFactory.initElements(d, lp);
		lp.getUsernametf().sendKeys("admin");
		lp.getPasswordtf().sendKeys("manager");
		lp.getCheckbox().click();
		lp.getLoginbtn().click();
		
		lp.Login("admin", "manager");
		
		actitimeLogoutPage lc=new actitimeLogoutPage(d);
		lc.Logout();
	}
}
