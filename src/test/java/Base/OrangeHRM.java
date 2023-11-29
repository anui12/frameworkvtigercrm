package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import POM.OrangeLoginPage;

public class OrangeHRM {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		OrangeLoginPage orange=new OrangeLoginPage();
		PageFactory.initElements(d, orange);
		orange.getUsernametf().sendKeys("Admin");
		orange.getPasswordtf().sendKeys("admin123");
		orange.getLoginbtn().click();
		
	}
}
