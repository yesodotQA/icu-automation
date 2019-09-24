package pages.meetings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class meetingsMultipleSelect extends testBase {

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsMiddlePane;


	public meetingsMultipleSelect(){

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.actionsMiddlePane = new actionsMiddlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();

		PageFactory.initElements(driver, this);
	}
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void addStatusMultipleChoiceMeetings() throws InterruptedException {
		
	waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.pressStatusMultipleChoice);
		
		multipleselect.pressStatusMultipleChoice.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.selectStatus);
		
		multipleselect.selectStatus.click();
		
		
		Thread.sleep(3000);
		
		
		String nameOfStatus = multipleselect.listOfStatus.get(1).getText();
		
		multipleselect.listOfStatus.get(1).click();
		
		
		waitForVisibility(multipleselect.updateStatus);
		
		multipleselect.updateStatus.click(); 
		
		
		waitForVisibility(middlepane.sortByStatus);

		 middlepane.sortByStatus.click();


		 Thread.sleep(1000);

		 middlepane.listOfStatusOfEntities.get(2).click();

		 Thread.sleep(2000);
		 waitForVisibility(middlepane.pressOnEntity);

		 middlepane.pressOnEntity.click();
		 

		 Thread.sleep(2000);

		 String nameOfStatusOnScreen =therightonthescreen.pressToChangeStatusOnTheScreen.getText();

		 // checks if the status have been updated on the side of the screen
		 if (nameOfStatusOnScreen.equals(nameOfStatus)) {

			 logger.log(Status.PASS , "add status using multiple select");
		 }

		 else {

			 logger.log(Status.FAIL, "add status using multiple select");
		 }

		 waitForVisibility(middlepane.sortByStatus);

		 middlepane.sortByStatus.click();

		 
		 Thread.sleep(1000);

		 middlepane.listOfStatusOfEntities.get(0).click();

		 Thread.sleep(2000);
		 waitForVisibility(middlepane.pressOnEntity);

		 middlepane.pressOnEntity.click();

	}



}
