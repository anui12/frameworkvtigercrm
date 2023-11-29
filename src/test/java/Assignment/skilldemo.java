package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class skilldemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver d=new ChromeDriver();;
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\skilldemo.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String url=p.getProperty("URL");
	   	String user=p.getProperty("UserName");
		String pass=p.getProperty("Passwor");
		
		d.get(url);
		d.findElement(By.xpath("//a[text()=' GEARS ']")).click();
		d.findElement(By.xpath("(//a[text()=' SkillRary Demo APP'])[2]")).click();
		Set<String> c = d.getWindowHandles();
		for(String e:c) {
			d.switchTo().window(e);
		}
		d.findElement(By.xpath("//a[text()='LOGIN']")).click();
		d.findElement(By.id("email")).sendKeys(user);
		d.findElement(By.name("password")).sendKeys(pass);
		Thread.sleep(1000);
		d.findElement(By.xpath("//button[text()='Login']")).click();
	}
}
