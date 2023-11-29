package TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.netty.channel.unix.DatagramSocketAddress;

public class webdriverUtils {

	public void maximize(WebDriver d) {
		d.manage().window().maximize();
	}
	public void minimize(WebDriver d) {
		d.manage().window().minimize();
	}
	public void timeout(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void action(WebDriver d,WebElement element) {
		Actions a=new Actions(d);
		a.moveToElement(element).perform();
	}
	public void singleclick(WebDriver d) {
		Actions a=new Actions(d);
		a.click().perform();
	}
	public void singleClick(WebDriver d,WebElement element) {
		Actions a=new Actions(d);
		a.click(element).perform();
	}
	public void Handledropdown(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public String takescreenshots(WebDriver d,String screenshotname) throws IOException {
		LocalDateTime dt=LocalDateTime.now();
		String timedate = dt.toString().replace(':','-');
		TakesScreenshot ts=(TakesScreenshot)d;
		File n = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./pics/vtiger"+timedate+screenshotname+".png");
		FileUtils.copyFile(n, destination);
		return  destination.getAbsolutePath();
	}
	public int Random() {
		Random r=new Random();
		int data = r.nextInt();
		return data;
	}
	public void switchtochild(WebDriver d,String childurl) {
		Set<String> allid = d.getWindowHandles();
		System.out.println(allid);
		for(String b:allid) {
			String c = d.switchTo().window(b).getCurrentUrl();
			System.out.println(c);
			String childurls=childurl;
			if(c.contains(childurls)) {
				break;
			}
		}
	}
	public void switchtoparent(WebDriver d,String parenturl) {
		Set<String> allid = d.getWindowHandles();
		System.out.println(allid);
		for(String b:allid) {
			String c=d.switchTo().window(b).getCurrentUrl();
			System.out.println(c);
			
			String parenturls=parenturl;
			if(c.contains(parenturls)) {
				break;
			}
		}
		
	}
	public void javascript(WebDriver d) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,800)");
	}
}
