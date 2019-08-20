package pages.tasks;

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

public class tasksMultipleSelect extends testBase {
	
	multipleSelect tasksmultipleselect;	
	middlePane tasksmiddlepane;	
	Tabs taskstab;	
	theRightOfTheScreen template;
	
	@FindBy(className =  "assigned")
	WebElement statusOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
			
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  tasksMultipleSelect() {
		
		this.tasksmultipleselect = new multipleSelect();
		this.tasksmiddlepane = new middlePane();
		this.taskstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	public void pressTask() throws InterruptedException {
		
		waitForVisibility(taskstab.tasksTab);
		
		taskstab.tasksTab.click();
		
		Thread.sleep(3000);
	}
	
	
	
}
