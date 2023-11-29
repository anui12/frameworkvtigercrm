package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM {

	public static void main(String[] args) throws IOException {
		
		final WebDriver d;
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\Orane.properties");
		Properties p=new Properties();
		p.load(file);
		
		String browser = p.getProperty("Browser");
		if(browser.equals("Chrome")) {
			d=new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			d=new FirefoxDriver();
		}else {
			d=new EdgeDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url = p.getProperty("URL");
		String name = p.getProperty("UserName");
		String pass = p.getProperty("Password");
		
		d.get(url);
		d.findElement(By.name("username")).sendKeys(name);
		d.findElement(By.name("password")).sendKeys(pass);
		d.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
}
