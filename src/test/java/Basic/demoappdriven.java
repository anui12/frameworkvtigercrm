package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoappdriven {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\demoapp.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String url = p.getProperty("URL");
		String user = p.getProperty("UserName");
		String pass = p.getProperty("Passwor");
		
		d.get(url);
		d.findElement(By.xpath("//a[text()='LOGIN']")).click();
		d.findElement(By.name("email")).sendKeys(user);
		d.findElement(By.name("password")).sendKeys(pass);
		d.findElement(By.id("keepLoggedInCheckBox")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[text()='Login']")).click();
		d.findElement(By.xpath("//span[text()='SkillRary Admin']")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//a[text()='Sign out']")).click();
	}
}
