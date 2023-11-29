package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baisc {

	public static void main(String[] args) throws IOException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//to read data from external resources
		FileInputStream file=new FileInputStream("src\\test\\resources\\actitime.properties");
		//to read data from property files
		Properties p=new Properties();
		//to fetch the location of property files
		p.load(file);
		// to read the keys of property files
		String url = p.getProperty("URL");
		String user = p.getProperty("UserName");
		String pass = p.getProperty("Passwor");
		
		d.get(url);
		d.findElement(By.id("username")).sendKeys(user);
		d.findElement(By.name("pwd")).sendKeys(pass);
		d.findElement(By.id("loginButton")).click();
	}
}
