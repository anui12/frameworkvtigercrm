package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class actitime {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\actitime.properties");
		Properties p=new Properties();
		p.load(file);
		
		String url=p.getProperty("URL");
		String name=p.getProperty("UserName");
		String pass=p.getProperty("Password");
		
		d.get(url);
		d.findElement(By.id("username")).sendKeys(name);
		d.findElement(By.name("pwd")).sendKeys(pass);
		Thread.sleep(1000);;
		d.findElement(By.xpath("//div[text()='Login ']")).click();
	}
}
