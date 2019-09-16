package pages.projects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalActions.actionsMiddlePane;

public class tasksFromProjects extends testBase {

	actionsMiddlePane actionsmiddlepane;
	
	@FindBy (css = ".tab.three ")
	List<WebElement>  tabsListOnRightSide = new ArrayList<>();
	
	@FindBy(css = "[ng-click='manageTasks()']")
	WebElement manageTasks;
	
	public tasksFromProjects() {
		PageFactory.initElements(driver, this);
		this.actionsmiddlepane = new actionsMiddlePane();
	}
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void getIntoTasksFromProjects() throws InterruptedException {
		
		actionsmiddlepane.openEntity("tasksFromProjects", "adsdgt");
		
		tabsListOnRightSide.get(2).click();
		
		waitForVisibility(manageTasks);
		manageTasks.click();
		
		Thread.sleep(2000);
		
	}
}
