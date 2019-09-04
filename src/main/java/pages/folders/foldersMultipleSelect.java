package pages.folders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class foldersMultipleSelect  extends testBase{
	
	Tabs tabs;
	
	public foldersMultipleSelect(){
		this.tabs = new Tabs();
		PageFactory.initElements(driver, this);
	 }
	
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//a function that press on document 
	public void pressFolders() throws InterruptedException {
			
			waitForVisibility(tabs.settingsTab);
			
			tabs.settingsTab.click();
			
			Thread.sleep(3000);
			
	 }
}
		
