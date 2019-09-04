package global.globalElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.testBase;

public class Tabs extends testBase {

	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[1]/div")
	public	WebElement searchTab;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[2]/div")
	public WebElement tasksTab;

	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[3]/div")
	public WebElement projectsTab;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[4]/div")
	public WebElement meetingsTab;
	
    @FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[5]/div/div[2]/span")
    public WebElement documentTab;
    
    @FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[6]/div")
    public  WebElement settingsTab;
    
    @FindBy (css = "[ui-sref='main.offices.all']")
    public	WebElement officesTab;
    
    @FindBy (css = "[ui-sref='main.templateDocs.all']")
    public	WebElement templateDocTab;
    
	
     
    public Tabs() {

    	PageFactory.initElements(driver, this);
    	
   }

}
