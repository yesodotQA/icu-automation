package global.globalActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;
import pages.documents.documentsMiddlePane;

public class actionsRightSide extends testBase {

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	documentsMiddlePane documentsmiddlepane;
	actionsMiddlePane actionmiddlepane;
	public actionsRightSide() {

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.actionmiddlepane = new actionsMiddlePane();

		PageFactory.initElements(driver, this);
	}
	// WAIT FOR ELEMENT VISBILTY
	private void waitForVisibility (WebElement element)  {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// TEST FUNCTION THAT CHECK DELETE ENTITY
	public void deleteEntity() throws InterruptedException {
		actionmiddlepane.openEntity("delete entity", "1234");
		int size =middlepane.listOfEntities.size() ;

		waitForVisibility(therightonthescreen.pressOnThreeDotsOnScreen);
		therightonthescreen.pressOnThreeDotsOnScreen.click();
		Thread.sleep(2000);

		waitForVisibility(therightonthescreen.chooseDelete);
		therightonthescreen.chooseDelete.click();
		Thread.sleep(2000);
		int newSize =middlepane.listOfEntities.size();

		//check if the entity deleted
		if (size - 1 == newSize) {
			logger.log(Status.PASS , "delete document on screen");
		}
		else {
			logger.log(Status.FAIL , "delete document on screen");
		}
	}

	// TEST FUNCTION THAT ADD ASSIGNEE
	public void addAssignee() throws InterruptedException {

		actionmiddlepane.openEntity("right of screen", "classified");
		int checkSizeOfWatchersBeforeAddAssignee = therightonthescreen.listOfWatchersIcons.size();

		waitForVisibility(therightonthescreen.assigneeOnTheScreen);
		therightonthescreen.assigneeOnTheScreen.click();
		Thread.sleep(3000);

		therightonthescreen.listOfAssigneeOnScreen.get(1).click();
		Thread.sleep(2000);

		int  checkSizeOfWatchersAfterAddAssignee = therightonthescreen.listOfWatchersIcons.size();

		// CHECK IF ASINGEE WAS ADDED
		if(checkSizeOfWatchersBeforeAddAssignee +  1 == checkSizeOfWatchersAfterAddAssignee) {
			logger.log(Status.PASS , "add asignee on screen");
		}
		else {
			logger.log(Status.FAIL , "add asignee on screen");
		}
	}
	
	// TEST FUNCTION THAT SET A DATE
	public void setDate() throws InterruptedException {

		String sizeOfActivtiesList = 
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		int beforeSetDate = Integer.parseInt(sizeOfActivtiesList);

		waitForVisibility(therightonthescreen.dateOnTheScreen);
		therightonthescreen.dateOnTheScreen.click();
		Thread.sleep(2000);

		waitForVisibility(multipleselect.nextMonth);
		multipleselect.nextMonth.click();
		Thread.sleep(2000);

		waitForVisibility(therightonthescreen.chooseDateOnTheScreen);
		therightonthescreen.chooseDateOnTheScreen.click();
		Thread.sleep(2000);

		String sizeOfActivtiesListAfterSet =
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");

		int afterSetDate = Integer.parseInt(sizeOfActivtiesListAfterSet);

		if (beforeSetDate + 1 == afterSetDate) {
			logger.log(Status.PASS , "add date on screen");
		}
		else {
			logger.log(Status.FAIL , "add date on screen");
		}

	}
	
	// 	TEST FUNCTION THAT CHECK ADDED TAGS
	public void addTags(String tags) throws InterruptedException {
		String sizeOfActivtiesList =
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		int switcheStringToInt1 = Integer.parseInt(sizeOfActivtiesList);
		
		waitForVisibility(therightonthescreen.enterTagsOnScreen);
		therightonthescreen.enterTagsOnScreen.click();
		Thread.sleep(1000);
		
		therightonthescreen.enterTagsOnScreen.sendKeys(tags);
		Thread.sleep(1000);
		
		therightonthescreen.listOfTagsOnScreen.get(0).click();
		Thread.sleep(2000);
		
		String sizeOfActivtiesListAfterSet = 
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");
			
		int SwitcheStringToInt2 = Integer.parseInt(sizeOfActivtiesListAfterSet);
			
		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {
			logger.log(Status.PASS , "add tags on screen");
		}
		else {
			logger.log(Status.FAIL , "add tags on screen");
		}
	}
	
	public void addActivities(String act1 , String act2) throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = 
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		waitForVisibility(therightonthescreen.addActivities);
		therightonthescreen.addActivities.sendKeys(act1);
		
		waitForVisibility(therightonthescreen.updateActivities);
		therightonthescreen.updateActivities.click();
	
		Thread.sleep(2000);
			
		waitForVisibility(therightonthescreen.addActivities);
		therightonthescreen.addActivities.sendKeys(act2);
		
		Thread.sleep(2000);
		
		waitForVisibility(therightonthescreen.updateActivities);	
		therightonthescreen.updateActivities.click();
		
		Thread.sleep(2000);
		
		String sizeListOfActivitiesAfterChoosing =
				therightonthescreen.checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		if (switcheStringToInt1 + 2 == SwitcheStringToInt2) {
			logger.log(Status.PASS , "add activities");
			}
		
		else {
			logger.log(Status.FAIL , "add activities");
		}
		
	}
	
	
	

}	