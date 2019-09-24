package pages.meetings;


import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.css.Counter;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class MeetingsFunctions extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	actionsRightSide    actionsrightside;
	middlePane			middlepane;
	actionsMiddlePane	actionmiddlepane;
	public MeetingsFunctions() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleSelect		 = new multipleSelect();
		this.actionsrightside    = new actionsRightSide();
		this.middlepane			 = new middlePane();
		this.actionmiddlepane    = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}
	// Variables that related to SetDate
	@FindBy (css = "[ng-click='dueClicked()']")
	WebElement DateButton;
	@FindBy (id = "startDate")
	WebElement StartDateButton;
	@FindBy (css = "[ng-model='item.endDate']")
	WebElement EndDateButton;
	@FindBy (css = "[title='Next']")
	WebElement NextArrow;
	@FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a")
	WebElement StartDate;
	@FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a" )
	WebElement EndDate;
	@FindBy (id = "firstStr")
	WebElement FirstDate;
	@FindBy (id = "secondStr")
	WebElement SecondDate;

	// Variables related to location
	@FindBy (className = "location")
	WebElement LocationButton;
	
	@FindBy (css ="[ng-model='item.location']")
	WebElement fillLocation;

	// Variables related to set a date via multipleSelect
	@FindBy (css = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/input")
	WebElement CheckBoxMultipleSelect;
	@FindBy (css = ".corner-button")
	WebElement SelectAll;
	@FindBy(className = "due")
	WebElement SetDateButtonViaMS;
	@FindBy (id = "modalBulk")
	WebElement SetDateWindow;
	@FindBy (css = "[ng-click=\"dueClicked()\"]")
	WebElement Deadline;
	@FindBy (xpath = "//*[@id=\"startTime\"]/table/tbody/tr[2]/td[1]/input")
	WebElement startHH;
	@FindBy (xpath = "//*[@id=\"endTime\"]/table/tbody/tr[2]/td[1]/input")
	WebElement EndHH;
	@FindBy (css = "[title=\"multiple Select > set a date\"]")
	List<WebElement> ListOfEntities = new ArrayList<>();

	// Variables that related to meetings from projects

	@FindBy (css = "[data-ng-repeat='project in projectsList | filterRecycled | limitTo: displayLimit.projects']")
	List <WebElement> ProjectsList = new ArrayList<>();
	@FindBy (css = "ng-click=\"reset(context.main);removeFilterValue();\"")
	WebElement ShowAllButton;
	@FindBy (css = "[ng-click='visible.project = !visible.project']")
	WebElement MeetingsFromProjectsButton;
	@FindBy(css = ".list.projects .more")
	WebElement ShowMoreButton;
	@FindBy (css = "[ng-bind-html='parentName']")
	WebElement EntityTitle;
	@FindBy (css = "[user='member']")
	WebElement MemberList;
	@FindBy (css = ".avatar.editor")
	List <WebElement> EditorsMembers;
	@FindBy (className = "commenter")
	WebElement CommenterMember;
	@FindBy (className = "viewer")
	WebElement ViewerMember;
	
	@FindBy (css = ".tab.three ")
	List<WebElement>  tabsListOnRightSide = new ArrayList<>();
	
	@FindBy(css = "[ng-click='manageTasks()']")
	WebElement manageTasks;

	private void waitForVisibility (WebElement element)  {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public void pressMeetings() throws InterruptedException {
		
		waitForVisibility(tabs.meetingsTab);
		tabs.meetingsTab.click();
		
		Thread.sleep(1000);
	}


	public void setDateInMeetings() throws InterruptedException {

		actionsmiddlepane.openEntity("Set a Date", "set a date on meetings tab");
		Thread.sleep(2000);
		waitForVisibility(DateButton);
		DateButton.click();
		Thread.sleep(2000);
		waitForVisibility(StartDateButton);
		StartDateButton.click();
		Thread.sleep(2000);
		NextArrow.click();
		StartDate.click();
		Thread.sleep(2000);
		DateButton.click();
		EndDateButton.click();
		NextArrow.click();
		EndDate.click();
		String FirstDay = FirstDate.getText();
		String SecondDay = SecondDate.getText();


		// it take the first numbers from the dates and check if difference is equal to 1
		String[] ArrayOne = FirstDay.split("/");
		int DayOne = Integer.parseInt(ArrayOne[0]);

		String[] ArrayTwo = SecondDay.split("/");
		int DayTwo = Integer.parseInt(ArrayTwo[0]);

		if (DayTwo - DayOne == 1) {

			logger.log(Status.PASS , "Set Two Dates work perfect!");
		}
		else {

			logger.log(Status.FAIL , "Set Two Dates Not working.");
		}

	}

	public void AddLocation() throws InterruptedException {

		String LocationInput = "this input contain the location"; 

		actionsmiddlepane.openEntity("Add location", "test adding location in meeting");
		LocationButton.click();
		Thread.sleep(2000);
		fillLocation.sendKeys(LocationInput);
		String locationContent = fillLocation.getAttribute("value");
		
		Thread.sleep(2000);

		if (locationContent.equals(LocationInput)) {
			logger.log(Status.PASS , "add location work perfectly!");
		}
		else {
			logger.log(Status.FAIL , "add location Not working.");
		}
	}

	public void setDateViaMultipleSelect() throws InterruptedException {
		actionsmiddlepane.openEntity("multiple Select > set a date", "testing seting a date via multiple select");
		waitForVisibility(multipleSelect.pressMultipleChoice);
		multipleSelect.pressMultipleChoice.click();
		waitForVisibility(multipleSelect.pressOnDateMultipleSelect);
		multipleSelect.pressOnDateMultipleSelect.click();;
		waitForVisibility(Deadline);
		Deadline.click();
		StartDateButton.click();
		Thread.sleep(2000);
		NextArrow.click();
		StartDate.click();
		Thread.sleep(2000);
		DateButton.click();
		EndDateButton.click();
		NextArrow.click();
		EndDate.click();
		DateButton.click();
		startHH.sendKeys("12");
		DateButton.click();
		EndHH.sendKeys("13");
		Thread.sleep(1000);
		String firstDateMultipleChoice = FirstDate.getText();
		String secondDateMultipleChoice = SecondDate.getText();
		Thread.sleep(5000);
		waitForVisibility(multipleSelect.updateDate);
		multipleSelect.updateDate.click();
		waitForVisibility(multipleSelect.pressSecondMultipleChoice);
		multipleSelect.pressSecondMultipleChoice.click();
		waitForVisibility(middlepane.pressOnEntity);
		middlepane.pressOnEntity.click();
	
		Thread.sleep(2000);
		
		if (firstDateMultipleChoice.equals(FirstDate.getText()) 
				&& secondDateMultipleChoice.equals(SecondDate.getText())) {
			
			logger.log(Status.PASS , "Set a Date via Multiple Select is working perfect");
		} 
		else {
			logger.log(Status.FAIL, "Set a Date via Multiple Select is working perfect");
		}
	
	}

	public void MeetingFromProjects () throws InterruptedException {

		String ProjectName = "Meeting from Project test";
	

		waitForVisibility(tabs.projectsTab);
		tabs.projectsTab.click();
	
		
		Thread.sleep(2000); 
		actionsmiddlepane.openEntity(ProjectName ,"test the ability to open meetings from projects" + "test the inheritance form project to meeting");

		int numberOfProject  = middlepane.listOfEntities.size();

		actionsrightside.addWatcher();

		Thread.sleep(2000);
		
		tabs.meetingsTab.click();
		
		Thread.sleep(2000);
		
		String SHOWMORE = "SHOW MORE";

		if (numberOfProject > 4) {

			while (ShowMoreButton.getText().equals(SHOWMORE)) {

				Thread.sleep(1000);
				
				ShowMoreButton.click();
			}
		}
		
		// this if is not effective because there are projects I don't have permission for
		/*
		Thread.sleep(2000);
		
		int NumbersOfProjectsOnLeftSide = ProjectsList.size();
		
	
		// Test if project was added to projects list
		if (NumbersOfProjectsOnLeftSide == numberOfProject ) {

			logger.log(Status.PASS , "The project was added");
		}
		else {

			logger.log(Status.FAIL , "The project wasn't add to the projects list");
		}
		*/
		
		for (int i = 0; i < ProjectsList.size(); i++) {

			if (ProjectsList.get(i).getText().equals(ProjectName)) {

				ProjectsList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(1000);
		
		actionsmiddlepane.openEntity("Meetings from " + ProjectName, "this entity related to " + ProjectName);
			
		
		// Test if the project name is display on screen meetings from projects.
		if (EntityTitle.getText().equals(ProjectName)) {

			logger.log(Status.PASS , "The project name  is display");
		}
		else {
			logger.log(Status.FAIL , "The project name  isn't display");
		}

		logger.log(Status.INFO, "inharitance not work need to fix");

		
		// Test if The inheritance from project is working. 
		if (EditorsMembers.size() == 2 )	{

			logger.log(Status.PASS , "The inheritance from project is working!");
		}
		else {

			logger.log(Status.FAIL , "The inheritance from project isn't working");
		}
		
		actionmiddlepane.openEntity("discussions from projects  124354", "dasd");
		
	}
	
	public void getIntoTasksFromMeetings() throws InterruptedException {

		actionsmiddlepane.openEntity("tasksFromMeetings","adsdgt");

		tabsListOnRightSide.get(2).click();

		waitForVisibility(manageTasks);
		manageTasks.click();

		Thread.sleep(2000);

	}

}




