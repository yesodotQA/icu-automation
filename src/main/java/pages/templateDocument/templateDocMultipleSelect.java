package pages.templateDocument;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalElements.Tabs;

public class templateDocMultipleSelect extends testBase {
	
	Tabs tabs;
	
	public templateDocMultipleSelect(){
		
		this.tabs = new Tabs();
		PageFactory.initElements(driver, this);
	 }
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	//a function that press on document 
	public void pressTemplateDoc() throws InterruptedException {

		waitForVisibility(tabs.settingsTab);

		tabs.settingsTab.click();


		waitForVisibility(tabs.templateDocTab);

		tabs.templateDocTab.click();

		Thread.sleep(2000);

	}

	
	

}
