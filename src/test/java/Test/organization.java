package Test;

import java.io.IOException;


import org.openqa.selenium.By;
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
public class organization extends baseClass{
	
	@Test
	public void organization1() throws IOException, InterruptedException {
		
		excelUtils ex=new excelUtils();
		fileUtils f=new fileUtils();
		webdriverUtils wb=new webdriverUtils();
				
		Reporter.log("--screenshot of fail result--");
		wb.takescreenshots(d, "Screenshotname");
		
//		String actualtitle=d.getTitle();
//		System.out.println(actualtitle);
//		String expectedtitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		Assert.assertEquals(actualtitle, expectedtitle);
		
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		String orgname = ex.getExceldata("Sheet1", 20, 1);
		String industry=ex.getExceldata("Sheet1", 21, 1);
		String rating =ex.getExceldata("Sheet1", 22, 1);
		String group=ex.getExceldata("Sheet1", 23, 1);
		String phone=ex.getExceldata("Sheet1", 24, 1);
		String type=ex.getExceldata("Sheet1", 25, 1);
		String mail=ex.getExceldata("Sheet1", 26, 1);
		int random = wb.Random();
		
		String actualtitle=" Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String expectedtitle="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRMs";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		d.findElement(By.name("accountname")).sendKeys(orgname+random);
//		d.findElement(By.name("phone")).sendKeys(phone);
//		d.findElement(By.name("email1")).sendKeys(mail);
		d.findElement(By.name("industry")).sendKeys(industry);
		d.findElement(By.name("rating")).sendKeys(rating);
		d.findElement(By.name("accounttype")).sendKeys(type);
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		d.findElement(By.name("assigned_group_id")).sendKeys(group);
		d.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		Thread.sleep(5000);
		
	}

}
