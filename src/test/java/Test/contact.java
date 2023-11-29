package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG.baseClass;
import TestNG.excelUtils;
import TestNG.fileUtils;
import TestNG.listerimplementation;
import TestNG.webdriverUtils;

@Listeners(listerimplementation.class)
public class contact extends baseClass{


	@Test
	public void contact1() throws EncryptedDocumentException, IOException {
		
		excelUtils ex=new excelUtils();
		fileUtils f=new fileUtils();
		webdriverUtils wb=new webdriverUtils();
				
		Reporter.log("--screenshot of fail result--");
		wb.takescreenshots(d, "Screenshotname");
		
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		String mr = ex.getExceldata("Sheet1", 7, 1);
		String firstname = ex.getExceldata("Sheet1", 3, 1);
		String lastname = ex.getExceldata("Sheet1", 8, 1);
		String group=ex.getExceldata("Sheet1", 13,1);
		int r = wb.Random();
		
//		String actualtitle=" Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		String expectedtitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRMs";
//		Assert.assertEquals(actualtitle,expectedtitle);
		
		String actualtitle=" Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		String expectedtitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		
		d.findElement(By.xpath("(//select[@class='small'])[2]")).sendKeys(mr);
		d.findElement(By.name("firstname")).sendKeys(firstname+r);
		d.findElement(By.name("lastname")).sendKeys(lastname);
		
		
		d.findElement(By.xpath("(//input[@name=\"assigntype\"])[2]")).click();
		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
		wb.Handledropdown(dropdown,group);
		d.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();

	}
//	@Test(dependsOnMethods = "contact1")
//	public void actitime() {
//		System.out.println("hello");
//	}
//	@Test
//	public void fb() {
//		System.out.println("Facebook");
//	}
}
