package pages.documents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;


import base.testBase;
import global.globalActions.actionsMultipleSelect;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class documentsMultipleSelect  extends testBase {
	
	Tabs tabs;
	actionsMultipleSelect actionmultipleselect;
	
	@FindBy(className =  "in-progress")
	WebElement statusOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	public documentsMultipleSelect(){
		this.tabs = new Tabs();
		this.actionmultipleselect = new actionsMultipleSelect();
		PageFactory.initElements(driver, this);
	
	}

	 private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	//a function that press on document 
	public void pressDocument() throws InterruptedException {
		
		waitForVisibility(tabs.documentTab);
		
		tabs.documentTab.click();
		
		Thread.sleep(3000);
	}
	

}
