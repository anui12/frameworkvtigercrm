package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class POMOrganization {

	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organlink;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusbtn;
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(xpath="//img[@alt=\"Select\"]")
	private WebElement plus;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(xpath="(//a[@href=\"javascript:window.close();\"])[1]")
	private WebElement link;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="rating")
	private WebElement rating;
	
	@FindBy(name="accounttype")
	private WebElement type;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement group;
	
	@FindBy(name="assigned_group_id")
	private WebElement groupdrop;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	private WebElement save;
	
	public WebElement Organlink() {
		return organlink;
	}
	public WebElement Plusbnt() {
		return plusbtn;
	}
	public WebElement Orgname() {
		return orgname;
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
	public WebElement Industry() {
		return industry;
	}
	public WebElement Rating() {
		return rating;
	}
	public WebElement Type() {
		return type;
	}
	public WebElement Group() {
		return group;
	}
	public WebElement Groupdrop() {
		return groupdrop;
	}
	public WebElement Save() {
		return save;
	}
}
