package pages.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

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
	
	
	// a function that delete entity using multiple select
	public void deleteEntityMultipleChoice() throws InterruptedException {

		int size =tasksmiddlepane.listOfEntities.size() ;
			
		waitForVisibility(tasksmultipleselect.pressMultipleChoice);
			
		tasksmultipleselect.pressMultipleChoice.click();
			
		
		waitForVisibility(tasksmultipleselect.pressDeleteMultipleChoice);
		
		tasksmultipleselect.pressDeleteMultipleChoice.click();
			
			
		waitForVisibility(tasksmultipleselect.deleteMultipleChoice);
			
		tasksmultipleselect.deleteMultipleChoice.click();
			
		
		Thread.sleep(2000);
			
			
		int newSize =tasksmiddlepane.listOfEntities.size();
			
		//check if the entity deleted
		if (size - 1 == newSize) {
					
				
			logger.log(Status.PASS , "delete document using mulitiple choice");
					
			}
				
			else {
					
			logger.log(Status.FAIL , "delete document using mulitiple choice");
			}
			
				
		}
		
		// a function that adds tags using multiple select 
	public void addTagsMultipleChoice(String tags) throws InterruptedException {
			
		tasksmiddlepane.openEntity("doc2", "importent");
			
		waitForVisibility(tasksmultipleselect.pressMultipleChoice);
		
		tasksmultipleselect.pressMultipleChoice.click();
			
			
		waitForVisibility(tasksmultipleselect.TagsMultipleChoice);
			
		tasksmultipleselect.TagsMultipleChoice.click();
			
			
		waitForVisibility(tasksmultipleselect.selectTags);
			
		tasksmultipleselect.selectTags.sendKeys(tags);
			
			
		waitForVisibility(tasksmultipleselect.clickOnNewTAg);
			
		tasksmultipleselect.clickOnNewTAg.click();
			
			
		waitForVisibility(tasksmultipleselect.updateTags);
			
		tasksmultipleselect.updateTags.click();
			
			
		Thread.sleep(2000);
		waitForVisibility(tasksmultipleselect.pressSecondMultipleChoice);
			
		tasksmultipleselect.pressSecondMultipleChoice.click();
			
			
		waitForVisibility(tasksmiddlepane.pressOnEntity);
			
		tasksmiddlepane.pressOnEntity.click();
			
			
		Thread.sleep(2000);
			
		String check =template.tagsOnScreenForChecking.getText();
		
			// checks if the tags have been updated on the side of the screen
			if (check.equals("mission (New)")) {
			
				logger.log(Status.PASS , "add Tags using multiple select");
			}
			
			else {
				
				logger.log(Status.FAIL, "add Tags using multiple select");
			}
			
		}
		
		// a function that adds date using multiple select 
	public void addDateMultipleChoice() throws InterruptedException {

		waitForVisibility(tasksmultipleselect.pressMultipleChoice);
		
		tasksmultipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(tasksmultipleselect.pressOnDateMultipleSelect);
		
		tasksmultipleselect.pressOnDateMultipleSelect.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(tasksmultipleselect.pressToChooseDate);
		
		tasksmultipleselect.pressToChooseDate.click();
		
		Thread.sleep(2000);
		waitForVisibility(tasksmultipleselect.nextMonth);
		
		tasksmultipleselect.nextMonth.click();
		
		
		waitForVisibility(tasksmultipleselect.chooseADate);
		
		tasksmultipleselect.chooseADate.click();
		
		String nameOfDate = getTextOfDate.getAttribute("value");
		
		
		Thread.sleep(2000);
		waitForVisibility(tasksmultipleselect.updateDate);
		
		tasksmultipleselect.updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(tasksmultipleselect.pressSecondMultipleChoice);
		
		tasksmultipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(tasksmiddlepane.pressOnEntity);
		
		tasksmiddlepane.pressOnEntity.click();
		
		
		Thread.sleep(3000);
		
		String nameOfDateOnScreen =template.dateOnTheScreen.getAttribute("value");
		
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
					
			

			waitForVisibility(tasksmultipleselect.pressMultipleChoice);
			
			tasksmultipleselect.pressMultipleChoice.click();
			
		
			waitForVisibility(tasksmultipleselect.pressAssigneeMultipleChoice);
			
			tasksmultipleselect.pressAssigneeMultipleChoice.click();
			
			
			waitForVisibility(tasksmultipleselect.selectAssignee);
			
			tasksmultipleselect.selectAssignee.click();
			
			Thread.sleep(3000);
			
			String nameOfAssignee = tasksmultipleselect.listOfAssignees.get(1).getText();
			
			tasksmultipleselect.listOfAssignees.get(1).click();
			
			
			waitForVisibility(tasksmultipleselect.updateAssignee);
			
			tasksmultipleselect.updateAssignee.click();


			Thread.sleep(2000);
			
			waitForVisibility(tasksmultipleselect.pressSecondMultipleChoice);
			
			tasksmultipleselect.pressSecondMultipleChoice.click();
			
			
			waitForVisibility(tasksmiddlepane.pressOnEntity);
			
			tasksmiddlepane.pressOnEntity.click();
				
				
				Thread.sleep(2000);
				
				String nameOfAssigneeOnScreen= template.assigneeOnTheScreen.getText();
				// checks if the assignee have been updated on the side of the screen
				if (nameOfAssigneeOnScreen.equals(nameOfAssignee)) {
					
					logger.log(Status.PASS , "add assignee using multiple select");
				}
				
				else {
					
					logger.log(Status.FAIL, "add assignee using multiple select");
				}
				
			}
		// a function that adds watchers using multiple select 
		public void addWatchersMultipleChoice() throws InterruptedException {
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressMultipleChoice);
			
			tasksmultipleselect.pressMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressWatchersMultipleChoice);
			
			tasksmultipleselect.pressWatchersMultipleChoice.click();
			
			
			waitForVisibility(tasksmultipleselect.addWatchers);
			
			tasksmultipleselect.addWatchers.click();
			
			
			Thread.sleep(2000);
			
			waitForVisibility(tasksmultipleselect.selectMembers);
			
			tasksmultipleselect.selectMembers.click();
			
			Thread.sleep(2000);
			
			tasksmultipleselect.listToChooseWatchers.get(0).click();
			
			int numberOfWatcherOnMultipleSelect = tasksmultipleselect.listOfWatchersMultipleSelect.size();

			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.updateWatchers);
			
			tasksmultipleselect.updateWatchers.click();
			
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressSecondMultipleChoice);
			
			tasksmultipleselect.pressSecondMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(tasksmiddlepane.pressOnEntity);
			
			tasksmiddlepane.pressOnEntity.click();
		
			
			Thread.sleep(2000);
			
			int numberOfWatchersOnScreen = template.listOfWatchersIcons.size() ;

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
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressMultipleChoice);
			
			tasksmultipleselect.pressMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressStatusMultipleChoice);
			
			tasksmultipleselect.pressStatusMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.selectStatus);
			
			tasksmultipleselect.selectStatus.click();
			
			
			Thread.sleep(3000);
			
			String nameOfStatus = tasksmultipleselect.listOfStatus.get(1).getText();
			
			tasksmultipleselect.listOfStatus.get(1).click();
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.updateStatus);
			
			tasksmultipleselect.updateStatus.click(); 
			
			Thread.sleep(2000);
			waitForVisibility(tasksmultipleselect.pressSecondMultipleChoice);
			
			tasksmultipleselect.pressSecondMultipleChoice.click();
			
			
			Thread.sleep(2000);
			waitForVisibility(tasksmiddlepane.pressOnEntity);
			
			tasksmiddlepane.pressOnEntity.click();
			
			
			Thread.sleep(2000);
	
			String nameOfStatusOnScreen = statusOnTheScreen.getText();
			
			// checks if the status have been updated on the side of the screen
			if (nameOfStatusOnScreen.equals(nameOfStatus)) {
				
				logger.log(Status.PASS , "add status using multiple select");
			}
			
			else {
				
				logger.log(Status.FAIL, "add status using multiple select");
			}
	
		}
	
}
