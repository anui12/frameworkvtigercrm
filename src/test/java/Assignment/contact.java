package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class contact {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("aniket@1432");
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		d.findElement(By.xpath("(//img[@alt=\"Select\"])[1]")).click();
		Set<String> wd = d.getWindowHandles();
		for(String e:wd) {
			d.switchTo().window(e);
		}
		
		d.findElement(By.name("search_text")).sendKeys("Maharashtra");
		d.findElement(By.name("search")).click();
		d.findElement(By.xpath("//a[text()='Maharashtra']")).click();
	}
}
