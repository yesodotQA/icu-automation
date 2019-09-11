package pages.offices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;

public class foldersFromOffices extends testBase {

	@FindBy (css = ".tab.three ")
	List<WebElement>  tabsListOnRightSide = new ArrayList<>();

	@FindBy (css = "[ng-click='manageFolders()']")
	WebElement managefolders;
	
	public  foldersFromOffices() {

		PageFactory.initElements(driver, this);
	}
	
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void getIntoFoldersFromOffices () throws InterruptedException {
		
		tabsListOnRightSide.get(2).click();
		
		
		waitForVisibility(managefolders);
		
		managefolders.click();
		
		Thread.sleep(2000);
		
		
	}
	


}