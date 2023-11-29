package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class actitimebrowser {

	public static void main(String[] args) throws IOException {
		
		final WebDriver d;
		FileInputStream file=new FileInputStream("src\\test\\resources\\actitime.properties");
		Properties p =new Properties();
		p.load(file);
		
		String browser = p.getProperty("Browser");
		if(browser.equals("Chrome")) {
			d=new ChromeDriver();	
		}else if(browser.equals("Firefox")) {
		d=new FirefoxDriver();
		}else {
			d=new EdgeDriver();
		}
		String url=p.getProperty("URL");
		String name=p.getProperty("UserName");
		String pass=p.getProperty("Password");
		
		d.get(url);
		d.findElement(By.id("username")).sendKeys(name);
		d.findElement(By.name("pwd")).sendKeys(pass);
		d.findElement(By.id("loginButton")).click();
	}
}