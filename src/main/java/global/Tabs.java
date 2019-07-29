package global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Tabs extends TestBase {

	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[1]/div")
	public	WebElement searchTab;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[2]/div")
	public WebElement tasksTab;

	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[3]/div")
	public WebElement projectsTab;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[4]/div")
	public WebElement meetingsTab;
	
    @FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[5]/div/div[2]/span")
    public WebElement documentTabs;
    
    @FindBy(xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[6]/div")
    public  WebElement settingsTab;
	
     
    public Tabs() {

    	PageFactory.initElements(driver, this);
    	
   }

}
