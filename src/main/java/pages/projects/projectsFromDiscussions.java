package pages.projects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;

public class projectsFromDiscussions extends testBase{
	
	Tabs tabs;
	actionsMiddlePane actionmiddlepane;
	middlePane middlepane;
	actionsRightSide actionsrightside;
	
	@FindBy(css = "[data-ng-repeat='discussion in discussionsList"
			+ " | filterRecycled | limitTo:displayLimit.discussions']")
	List<WebElement>  listOfMeetings = new ArrayList<>();
	
	@FindBy(css = ".list.discussions .more")
	WebElement showMore;
	
	public  projectsFromDiscussions() {

		PageFactory.initElements(driver, this);
		this.tabs =new Tabs();
		this.actionmiddlepane = new actionsMiddlePane();
		this.middlepane = new middlePane();
		this.actionsrightside = new actionsRightSide();
	}

	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void getIntoProjectFromDiscussions() throws InterruptedException { 
		
		waitForVisibility(tabs.meetingsTab);
		
		tabs.meetingsTab.click();
		
		 Thread.sleep(1000);
		
		actionmiddlepane.openEntity("projects from discussions", "dasd");
		
		actionsrightside.changePermission();
		
		int numberOfMeetings  = middlepane.listOfEntities.size();
		
		waitForVisibility(tabs.projectsTab);
		
		tabs.projectsTab.click();
		
		Thread.sleep(2000);
		
		String SHOWMORE = "SHOW MORE";
		
		if (numberOfMeetings > 4) {

			while (showMore.getText().equals(SHOWMORE)) {

				showMore.click();
			}
		}
	
		String nameOfMeetings = "projects from discussions";
		
		for (int i = 0; i < listOfMeetings.size(); i++) {
		
			if (listOfMeetings.get(i).getText().equals(nameOfMeetings)) {
				
				listOfMeetings.get(i).click();
				break;
			}
		}
		
		Thread.sleep(1000);
		
		actionmiddlepane.openEntity("projects from discussions 124354", "dasd");
		
		
	}
}
