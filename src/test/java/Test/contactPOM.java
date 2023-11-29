
package Test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

public class contactPOM extends baseClass{

	
	@Test
	public void contact() throws IOException, InterruptedException {
	
		fileUtils f=new fileUtils();
		excelUtils ex=new excelUtils();
		webdriverUtils wb=new webdriverUtils();
		
		Reporter.log("--screenshot of fail report");
		wb.takescreenshots(d,"Screenshotname");
		
		POMContact p=new POMContact();
		PageFactory.initElements(d, p);
		
		p.Contactlink().click();
		p.Plusbnt().click();

		String mr=ex.getExceldata("Sheet1", 7, 1);
		String firstname=ex.getExceldata("Sheet1", 3, 1);
		String lastname=ex.getExceldata("Sheet1", 8, 1);
		String orgname=ex.getExceldata("Sheet1", 14, 1);
		String parenturl=ex.getExceldata("Sheet1", 16, 1);
		String childurl=ex.getExceldata("Sheet1", 15, 1);
		String lead=ex.getExceldata("Sheet1", 12, 1);
		String group=ex.getExceldata("Sheet1", 13, 1);
		int random=wb.Random();
		
		
		
//		String actualtitle=" Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
//		String expectedtitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
//		Assert.assertEquals(actualtitle, expectedtitle);
		
		
		p.Mr().sendKeys(mr);
		p.Name().sendKeys(firstname);
		p.Lastname().sendKeys(lastname);
		p.Plus().click();
		wb.switchtochild(d, childurl);
		p.Searchtext().sendKeys(orgname);
		p.Searchbtn().click();
		p.Link().click();
		wb.switchtoparent(d, parenturl);
		p.Lead().sendKeys(lead);
		p.Group().click();
		p.Groupdrop().sendKeys(group);
		wb.javascript(d);
		WebElement save = p.Savebtn();
		wb.action(d, save);
		wb.singleClick(d, save);
		Thread.sleep(2000);
		
	}
}
