package pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;


public class projectsMultipleSelect extends testBase {
	
	multipleSelect projectsmultipleselect;	
	middlePane projectsmiddlepane;	
	Tabs projectstab;	
	theRightOfTheScreen template;
	
	@FindBy(className =  "assigned")
	WebElement statusOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
			
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  projectsMultipleSelect() {
		
		this.projectsmultipleselect = new multipleSelect();
		this.projectsmiddlepane = new middlePane();
		this.projectstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	public void pressproject() throws InterruptedException {
		
		waitForVisibility(projectstab.projectsTab);
		
		projectstab.projectsTab.click();
		
		Thread.sleep(3000);
	}
	
	
}
