package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseClass {

	
	public static WebDriver d;
	
	excelUtils ex=new excelUtils();
	fileUtils f=new fileUtils();
	webdriverUtils wb=new webdriverUtils();
	
@BeforeSuite
	
	public void BSConfig()
	{
		Reporter.log("--Connect to DB----",true);
	}

	@BeforeClass
	public void BCConfig() throws IOException {
		String browser = f.getFiledata("Browser");
		String url=f.getFiledata("URL");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			d=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			d=new FirefoxDriver();
		}else {
			d=new EdgeDriver();
		}
		
		wb.maximize(d);
		wb.timeout(d);
		d.get(url);
	}
	@BeforeMethod
	public void BMConfig() throws IOException {
		String user = f.getFiledata("UserName");
		String pass=f.getFiledata("Password");
		
		d.findElement(By.name("user_name")).sendKeys(user);
		d.findElement(By.name("user_password")).sendKeys(pass);
		d.findElement(By.id("submitButton")).click();
	}
	@AfterMethod
	public void AFConfig() throws InterruptedException {
		WebElement signout = d.findElement(By.xpath("(//td[@class=\"small\"])[2]"));
		wb.action(d, signout);
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	@AfterClass
	public void ACConfig() {
		d.quit();;
	}
	@AfterSuite
	public void ASconfig()
	{
		Reporter.log("--Disconnect to DB----",true);
	
	}

}
