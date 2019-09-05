package pages.meetings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.theRightOfTheScreen;

public class MeetingsFunctions extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;

	public MeetingsFunctions() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();

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
	@FindBy (css = "[ng-model='item.location']")
	WebElement LocationButton;
	
	private void waitForVisibility (WebElement element)  {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void setDateInMeetings() throws InterruptedException {
		
		tabs.meetingsTab.click();
		Thread.sleep(2000);
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
		
		tabs.meetingsTab.click();
		actionsmiddlepane.openEntity("Add location", "test adding location in meeting");
		LocationButton.click();
		Thread.sleep(1000);
		LocationButton.sendKeys(LocationInput);
		
		
		
		
		
	}
}

