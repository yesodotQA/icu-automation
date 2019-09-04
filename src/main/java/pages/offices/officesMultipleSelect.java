package pages.offices;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalElements.Tabs;

public class officesMultipleSelect extends testBase {

	Tabs tabs;
	
	public officesMultipleSelect(){
		this.tabs = new Tabs();
		PageFactory.initElements(driver, this);
	 }
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//a function that press on document 
	public void pressOffices() throws InterruptedException {
				
				waitForVisibility(tabs.settingsTab);
				
				tabs.settingsTab.click();
				
				
				waitForVisibility(tabs.officesTab);

				tabs.officesTab.click();
				
				Thread.sleep(2000);
			
	}
	
	
	
	
}
