package Test;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import TestNG.baseClass;
import TestNG.excelUtils;
import TestNG.fileUtils;
import TestNG.webdriverUtils;

public class organizationPOM extends baseClass{
	
	@Test
	public void organization1() throws IOException, InterruptedException {
		
		excelUtils ex=new excelUtils();
		fileUtils f=new fileUtils();
		webdriverUtils wb=new webdriverUtils();
	
		Reporter.log("--screenshot of fail report--");
		wb.takescreenshots(d, "screenshotname");
		
		POMOrganization p=new POMOrganization();
		PageFactory.initElements(d, p);
		
//		String actualtitle=d.getTitle();
//		System.out.println(actualtitle);
//		String expectedtitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		Assert.assertEquals(actualtitle, expectedtitle);
		
		p.Organlink().click();
		p.Plusbnt().click();
	
		String actualtitle=" Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String expectedtitle="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRMs";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		String name = ex.getExceldata("Sheet1", 20, 1);
		String industry=ex.getExceldata("Sheet1", 21, 1);
		String rating =ex.getExceldata("Sheet1", 22, 1);
		String group=ex.getExceldata("Sheet1", 23, 1);
		String childurl=ex.getExceldata("Sheet1", 28, 1);
		String parenturl=ex.getExceldata("Sheet1", 27, 1);
		String orgname=ex.getExceldata("Sheet1", 29, 1);
		String type=ex.getExceldata("Sheet1", 25, 1);
		int random = wb.Random();
		
		p.Orgname().sendKeys(name+random);
		wb.switchtochild(d, childurl);
		p.Searchtext().sendKeys(orgname);
		p.Searchbtn().click();
		p.Link().click();
		wb.switchtoparent(d, parenturl);
		p.Industry().sendKeys(industry);
		p.Rating().sendKeys(rating);
		p.Type().sendKeys(type);
		p.Group().click();
		p.Groupdrop().sendKeys(group);
		p.Save().click();
		Thread.sleep(2000);
		
	}

}
