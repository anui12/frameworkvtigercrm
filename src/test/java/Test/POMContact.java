package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class POMContact {

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@alt=\"Create Contact...\"]")
	private WebElement plusbtn;
	
	@FindBy(name="salutationtype")
	private WebElement mr;
	
	@FindBy(name="firstname")
	private WebElement name;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="(//img[@alt=\"Select\"])[1]")
	private WebElement plus;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(xpath="(//a[@href=\"javascript:window.close();\"])[1]")
	private WebElement link;
	
	@FindBy(name="leadsource")
	private WebElement lead;
	
	@FindBy(xpath="(//input[@name=\"assigntype\"])[2]")
	private WebElement group;
	
	@FindBy(name="assigned_group_id")
	private WebElement groupdrop;
	
	@FindBy(xpath="(//input[@value=\"  Save  \"])[2]")
	private WebElement savebtn;
	
	@FindBy(xpath="(//td[@class=\"small\"])[2]")
	private WebElement Signimg;
	
	public WebElement Contactlink() {
		return contactlink;
	}
	public WebElement Plusbnt() {
		return plusbtn;
	}
	public WebElement Mr() {
		return mr;
	}
	public WebElement Name() {
		return name;
	}
	public WebElement Lastname() {
		return lastname;
	}
	public WebElement Plus() {
		return plus;
	}
	public WebElement Searchtext() {
		return searchtext;
	}
	public WebElement Searchbtn() {
		return searchbtn;
	}
	public WebElement Link() {
		return link;
	}
	public WebElement Lead() {
		return lead;
	}
	public WebElement Group() {
		return group;
	}
	public WebElement Groupdrop() {
		return groupdrop;
	}
	public WebElement Savebtn() {
		return savebtn;
	}
	public WebElement Signimg() {
		return Signimg;
	}
}
