package global.globalActions;

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

public class actionsMultipleSelect extends testBase {

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsMiddlePane;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	public actionsMultipleSelect(){
		
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

	//a function that delete entity using multiple select 
	public void deleteEntityMultipleChoice() throws InterruptedException {
		
		int size =middlepane.listOfEntities.size() ;
		
		 
		 waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(multipleselect.pressDeleteMultipleChoice);
		
		multipleselect.pressDeleteMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.deleteMultipleChoice);
		
		multipleselect.deleteMultipleChoice.click();
		
		
		Thread.sleep(3000);
		
		int newSize =middlepane.listOfEntities.size();
		
		//check if the entity deleted
		if (size - 1 == newSize) {
			
		
			logger.log(Status.PASS , "delete document using mulitiple choice");
			
		}
		
		else {
			
			logger.log(Status.FAIL , "delete document using mulitiple choice");
		}
	
	}
		
	//a function that adds tags using multiple select 
	public void addTagsMultipleChoice(String tags) throws InterruptedException {
			 
		actionsMiddlePane.openEntity("doc2", "importent");
		
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.TagsMultipleChoice);
		
		multipleselect.TagsMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.selectTags);
		
		multipleselect.selectTags.sendKeys(tags);
		
		
		waitForVisibility(multipleselect.clickOnNewTAg);
		
		multipleselect.clickOnNewTAg.click();
		
		
		waitForVisibility(multipleselect.updateTags);
		
		multipleselect.updateTags.click();
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String check =therightonthescreen.tagsOnScreenForChecking.getText();
		
		// checks if the tags have been updated on the side of the screen
		if (check.equals("mission (New)")) {
		
			logger.log(Status.PASS , "add Tags using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Tags using multiple select");
		}
		
	}
	
	//a function that adds date using multiple select 
	public void addDateMultipleChoice() throws InterruptedException {
			
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(multipleselect.pressOnDateMultipleSelect);
		
		multipleselect.pressOnDateMultipleSelect.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressToChooseDate);
		
		multipleselect.pressToChooseDate.click();
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.nextMonth);
		
		multipleselect.nextMonth.click();
		
		
		waitForVisibility(multipleselect.chooseADate);
		
		multipleselect.chooseADate.click();
		
		String nameOfDate = getTextOfDate.getAttribute("value");
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.updateDate);
		
		multipleselect.updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(3000);
		
		String nameOfDateOnScreen =therightonthescreen.dateOnTheScreen.getAttribute("value");
		
		// checks if the date have been updated on the side of the screen
		if (nameOfDateOnScreen.equals(nameOfDate)) {
		
			logger.log(Status.PASS , "add Date using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Date using multiple select");
		}
		
	}
	
	// a function that adds assignee using multiple select 
	public void addAssigneeMultipleChoice() throws InterruptedException {
					
			
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(multipleselect.pressAssigneeMultipleChoice);
		
		multipleselect.pressAssigneeMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.selectAssignee);
		
		multipleselect.selectAssignee.click();
		
		Thread.sleep(3000);
		
		String nameOfAssignee = multipleselect.listOfAssignees.get(1).getText();
		
		multipleselect.listOfAssignees.get(1).click();
		
		
		waitForVisibility(multipleselect.updateAssignee);
		
		multipleselect.updateAssignee.click();


		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String nameOfAssigneeOnScreen= therightonthescreen.assigneeOnTheScreen.getText();
		
		// checks if the assignee have been updated on the side of the screen
		if (nameOfAssigneeOnScreen.equals(nameOfAssignee)) {
			
			logger.log(Status.PASS , "add assignee using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add assignee using multiple select");
		}
		
	}
	
	public void addWatchersMultipleChoice() throws InterruptedException {
		
		
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		

		waitForVisibility(multipleselect.pressWatchersMultipleChoice);
		
		multipleselect.pressWatchersMultipleChoice.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.addWatchers);
		
		multipleselect.addWatchers.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.selectMembers);
		
		multipleselect.selectMembers.click();
		
		Thread.sleep(2000);
		
		multipleselect.listToChooseWatchers.get(0).click();
		
		Thread.sleep(2000);
		
		int numberOfWatcherOnMultipleSelect = multipleselect.listOfWatchersMultipleSelect.size();
		
		
		waitForVisibility(multipleselect.updateWatchers);
		
		multipleselect.updateWatchers.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		int numberOfWatchersOnScreen = therightonthescreen.listOfWatchersIcons.size() ;

		// checks if the watchers have been updated on the side of the screen
		if (numberOfWatchersOnScreen == numberOfWatcherOnMultipleSelect) {
			
			logger.log(Status.PASS , "add watchers using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add watchers using multiple select");
		}
		
	}
	
	// a function that adds status using multiple select 
	public void addStatusMultipleChoice() throws InterruptedException {
			
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
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
	
		
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
		
		
	}
		

}
