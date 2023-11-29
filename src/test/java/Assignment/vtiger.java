package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vtiger {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\actitime.properties");
		Properties p=new Properties();
		p.load(file);
		
		String url=p.getProperty("URL");
		String user=p.getProperty("UserName");
		String pass=p.getProperty("Passwor");
		
		d.get(url);
		Thread.sleep(1000);
		d.findElement(By.id("username")).sendKeys(user);
//		Thread.sleep(1000);
		d.findElement(By.name("pwd")).sendKeys(pass);
//		Thread.sleep(1000);
//		d.findElement(By.id("keepLoggedInCheckBox")).click();
//		Thread.sleep(1000);
		d.findElement(By.id("loginButton")).click();

	}
}
