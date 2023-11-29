package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrm {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\orangehrm.properties");
		Properties p=new Properties();
		p.load(file);
		
		String url=p.getProperty("URL");
		String user=p.getProperty("username");
		String pass=p.getProperty("password");
		
		d.get(url);
		d.findElement(By.name("username")).sendKeys(user);
		d.findElement(By.name("password")).sendKeys(pass);
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//button[text()=' Login ']")).click();
		d.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(1000);
		d.quit();
	}
}
