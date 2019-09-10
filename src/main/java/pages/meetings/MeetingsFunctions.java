package pages.meetings;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.css.Counter;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class MeetingsFunctions extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	
	public MeetingsFunctions() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleSelect		 = new multipleSelect();
		
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
	@FindBy (css = "[ng-change=\"onChange(item)\"]")
	List<WebElement> ListOfEntities = new ArrayList<>();
	
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
		String locationContent = LocationButton.getAttribute("value");


		if (locationContent.equals(LocationInput)) {
			logger.log(Status.PASS , "add location work perfectly!");
		}
		else {
			logger.log(Status.FAIL , "add location Not working.");
		}
	}

	public void setDateViaMultipleSelect() throws InterruptedException {
		
		tabs.meetingsTab.click();
		actionsmiddlepane.openEntity("multiple Select > set a date", "testing seting a date via multiple select");
		actionsmiddlepane.openEntity("multiple Select > set a date", "testing seting a date via multiple select");
		waitForVisibility(multipleSelect.pressMultipleChoice);
		multipleSelect.pressMultipleChoice.click();
		waitForVisibility(SelectAll);
		SelectAll.click();
		SetDateButtonViaMS.click();
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
		Thread.sleep(5000);
		waitForVisibility(multipleSelect.updateDate);
		multipleSelect.updateDate.click();
		Thread.sleep(2000);
		SelectAll.click();
		
		Thread.sleep(3000);
		int i;
		int Counter = 0;
		
		for (i = 0; i < ListOfEntities.size(); i++) {
			
			ListOfEntities.get(i).click();
			String FirstDay = FirstDate.getText();
			String SecondDay = SecondDate.getText();
			
			String[] ArrayOne = FirstDay.split("/");
			int DayOne = Integer.parseInt(ArrayOne[0]);

			String[] ArrayTwo = SecondDay.split("/");
			int DayTwo = Integer.parseInt(ArrayTwo[0]);
			
			if(DayTwo - DayOne == 1) {
				int counter = i;
			}
			else {
				break;
			}
		}
		
		if (Counter == (ListOfEntities.size()-1)) {
			
			logger.log(Status.PASS , "Set a Date via Multiple Select is working perfect");
			
		}
		else {
			logger.log(Status.FAIL , "Set a Date via Multiple Select isn't working");
		}
		
	}

}


