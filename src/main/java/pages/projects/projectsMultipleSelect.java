package pages.projects;

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


public class projectsMultipleSelect extends testBase {
	
	multipleSelect projectsmultipleselect;	
	middlePane projectsmiddlepane;	
	Tabs projectstab;	
	theRightOfTheScreen template;
	
	@FindBy(className =  "assigned")
	WebElement statusOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
			
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  projectsMultipleSelect() {
		
		this.projectsmultipleselect = new multipleSelect();
		this.projectsmiddlepane = new middlePane();
		this.projectstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	public void pressproject() throws InterruptedException {
		
		waitForVisibility(projectstab.projectsTab);
		
		projectstab.projectsTab.click();
		
		Thread.sleep(3000);
	}
	
	
	// a function that delete entity using multiple select
	public void deleteEntityMultipleChoice() throws InterruptedException {

		int size =projectsmiddlepane.listOfEntities.size() ;
			
		waitForVisibility(projectsmultipleselect.pressMultipleChoice);
			
		projectsmultipleselect.pressMultipleChoice.click();
			
		
		waitForVisibility(projectsmultipleselect.pressDeleteMultipleChoice);
		
		projectsmultipleselect.pressDeleteMultipleChoice.click();
			
			
		waitForVisibility(projectsmultipleselect.deleteMultipleChoice);
			
		projectsmultipleselect.deleteMultipleChoice.click();
			
		
		Thread.sleep(2000);
			
			
		int newSize =projectsmiddlepane.listOfEntities.size();
			
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
			
		projectsmiddlepane.openEntity("doc2", "importent");
			
		waitForVisibility(projectsmultipleselect.pressMultipleChoice);
		
		projectsmultipleselect.pressMultipleChoice.click();
			
			
		waitForVisibility(projectsmultipleselect.TagsMultipleChoice);
			
		projectsmultipleselect.TagsMultipleChoice.click();
			
			
		waitForVisibility(projectsmultipleselect.selectTags);
			
		projectsmultipleselect.selectTags.sendKeys(tags);
			
			
		waitForVisibility(projectsmultipleselect.clickOnNewTAg);
			
		projectsmultipleselect.clickOnNewTAg.click();
			
			
		waitForVisibility(projectsmultipleselect.updateTags);
			
		projectsmultipleselect.updateTags.click();
			
			
		Thread.sleep(2000);
		waitForVisibility(projectsmultipleselect.pressSecondMultipleChoice);
			
		projectsmultipleselect.pressSecondMultipleChoice.click();
			
			
		waitForVisibility(projectsmiddlepane.pressOnEntity);
			
		projectsmiddlepane.pressOnEntity.click();
			
			
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

		waitForVisibility(projectsmultipleselect.pressMultipleChoice);
		
		projectsmultipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(projectsmultipleselect.pressOnDateMultipleSelect);
		
		projectsmultipleselect.pressOnDateMultipleSelect.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(projectsmultipleselect.pressToChooseDate);
		
		projectsmultipleselect.pressToChooseDate.click();
		
		Thread.sleep(2000);
		waitForVisibility(projectsmultipleselect.nextMonth);
		
		projectsmultipleselect.nextMonth.click();
		
		
		waitForVisibility(projectsmultipleselect.chooseADate);
		
		projectsmultipleselect.chooseADate.click();
		
		String nameOfDate = getTextOfDate.getAttribute("value");
		
		
		Thread.sleep(2000);
		waitForVisibility(projectsmultipleselect.updateDate);
		
		projectsmultipleselect.updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(projectsmultipleselect.pressSecondMultipleChoice);
		
		projectsmultipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(projectsmiddlepane.pressOnEntity);
		
		projectsmiddlepane.pressOnEntity.click();
		
		
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
					
			

			waitForVisibility(projectsmultipleselect.pressMultipleChoice);
			
			projectsmultipleselect.pressMultipleChoice.click();
			
		
			waitForVisibility(projectsmultipleselect.pressAssigneeMultipleChoice);
			
			projectsmultipleselect.pressAssigneeMultipleChoice.click();
			
			
			waitForVisibility(projectsmultipleselect.selectAssignee);
			
			projectsmultipleselect.selectAssignee.click();
			
			Thread.sleep(3000);
			
			String nameOfAssignee = projectsmultipleselect.listOfAssignees.get(1).getText();
			
			projectsmultipleselect.listOfAssignees.get(1).click();
			
			
			waitForVisibility(projectsmultipleselect.updateAssignee);
			
			projectsmultipleselect.updateAssignee.click();


			Thread.sleep(2000);
			
			waitForVisibility(projectsmultipleselect.pressSecondMultipleChoice);
			
			projectsmultipleselect.pressSecondMultipleChoice.click();
			
			
			waitForVisibility(projectsmiddlepane.pressOnEntity);
			
			projectsmiddlepane.pressOnEntity.click();
				
				
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
			waitForVisibility(projectsmultipleselect.pressMultipleChoice);
			
			projectsmultipleselect.pressMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.pressWatchersMultipleChoice);
			
			projectsmultipleselect.pressWatchersMultipleChoice.click();
			
			
			waitForVisibility(projectsmultipleselect.addWatchers);
			
			projectsmultipleselect.addWatchers.click();
			
			
			Thread.sleep(2000);
			
			waitForVisibility(projectsmultipleselect.selectMembers);
			
			projectsmultipleselect.selectMembers.click();
			
			Thread.sleep(2000);
			
			projectsmultipleselect.listToChooseWatchers.get(0).click();
			
			int numberOfWatcherOnMultipleSelect = projectsmultipleselect.listOfWatchersMultipleSelect.size();

			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.updateWatchers);
			
			projectsmultipleselect.updateWatchers.click();
			
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.pressSecondMultipleChoice);
			
			projectsmultipleselect.pressSecondMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(projectsmiddlepane.pressOnEntity);
			
			projectsmiddlepane.pressOnEntity.click();
		
			
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
			waitForVisibility(projectsmultipleselect.pressMultipleChoice);
			
			projectsmultipleselect.pressMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.pressStatusMultipleChoice);
			
			projectsmultipleselect.pressStatusMultipleChoice.click();
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.selectStatus);
			
			projectsmultipleselect.selectStatus.click();
			
			
			Thread.sleep(3000);
			
			String nameOfStatus = projectsmultipleselect.listOfStatus.get(1).getText();
			
			projectsmultipleselect.listOfStatus.get(1).click();
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.updateStatus);
			
			projectsmultipleselect.updateStatus.click(); 
			
			Thread.sleep(2000);
			waitForVisibility(projectsmultipleselect.pressSecondMultipleChoice);
			
			projectsmultipleselect.pressSecondMultipleChoice.click();
			
			
			Thread.sleep(2000);
			waitForVisibility(projectsmiddlepane.pressOnEntity);
			
			projectsmiddlepane.pressOnEntity.click();
			
			
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
