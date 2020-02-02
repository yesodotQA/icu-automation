package pages.profilepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.testBase;

public class Profilepage extends testBase {
	Profilepage profilepage;
	
	@FindBy(css = ".dropdown-toggle .avatar .ng-binding.ng-scope")
	public WebElement avatar;
	
	@FindBy(css = "[modal-name=\'currentUser\']")
	public WebElement enterprofile;
	
	@FindBy(id = "name")
	public WebElement profilename;
	
	@FindBy(id = "email")
	public WebElement profileemail;
	
	@FindBy(css ="[ngf-change='uploadAvatar($files)']")
	public WebElement changeprofilepic;
	
	@FindBy(xpath = "/html/body/section/section/div[1]/header/div[4]/ul/li[1]/a")
	public WebElement profilepageclick;
	
	@FindBy(xpath = "/html/body/section/section/div[1]/header/div[4]/ul/li[1]/a")
	public WebElement mytasksweekly;
	
	@FindBy(xpath = "/html/body/section/section/div[1]/header/div[4]/ul/li[1]/a")
	public WebElement GiventasksWeekly;
	
	@FindBy(xpath = "/html/body/section/section/div[1]/header/div[4]/ul/li[1]/a")
	public WebElement MyTasksDaily;
	
	@FindBy(xpath = "/html/body/section/section/div[1]/header/div[4]/ul/li[1]/a")
	public WebElement GivenTasksDaily;
	

	
public Profilepage  () {
	
    PageFactory.initElements(driver, this);
    	
}
}