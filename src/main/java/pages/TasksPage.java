package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.multipleSelect;
import global.middlePane;
import global.Tabs;
import global.theRightOfTheScreen;

public class TasksPage extends testBase{
	
	multipleSelect tasksmultipleselect;
	
	middlePane tasksmiddlepane;
	
	Tabs taskstab;
	
	theRightOfTheScreen template;
	
	
	@FindBy(className =  "Assigned")
	WebElement statusOnTheScreen;
	
	@FindBy (xpath = "//*[@id=\"addTag\"]/span/span/span[2]/span")
	WebElement tagsOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	 WebElement getTextOfDate;
	
	//parent project and discussion
	public @FindBy(css = "[value='item.project']")
	WebElement selectParentProject;
	
	public @FindBy(css = "[value='item.discussion']")
	WebElement selectParentMeeting;
	
	//elements for subtask 
	public @FindBy(className = ".add-sub-entity")
	WebElement addSubTask;
	
	public @FindBy(css = "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div >"
	+ " div.entity-details-content.task-details.ng-scope > div.sub-items-section > icu-sub-task-list > div.list-table.sub-entity.scroll "
	+ "> table > tbody > tr > td.name.ng-pristine.ng-untouched.ng-valid")
	WebElement CreateSubTask;

	public @FindBy(xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[2]")
	WebElement nameSubTask;

	public @FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-task-list/div[3]/table/tbody/tr[1]/td[3]/div[2]/div[1]/span")
	WebElement AssigneeSubTask;

	public @FindBy(xpath = "//*[@id=\"ui-select-choices-row-95-1\"]/span")
	WebElement AssignUserSubTask;

	public @FindBy(id = "#dp1564059419917")
	WebElement ClickDueDateSubTask;

	public @FindBy(className = ".ui-datepicker-next")
	WebElement ClickNextMonth;

	public @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]")
	WebElement ChooseDateSubTask;

	public @FindBy (className = ".row-arrow")
	WebElement ArrowSubTask;

	public @FindBy (xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-task-list/div[3]/table/tbody/tr[1]/td[7]")
	WebElement DeleteSubTask;

	public @FindBy(className = ".fa-chevron-down")
	WebElement OpenTaskTemplates;
	
	public@FindBy(css = ".last")
	WebElement ChooseTaskTemplate;
	
	//duplicatetask
	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[1]/detail-menu/div/ul/li[1]/a")
	WebElement duplicateTask;
	
	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/detail-tags/div/div[1]/input")
	WebElement selectTags;
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
	public  TasksPage() {
		
	 	PageFactory.initElements(driver, this);
		tasksmultipleselect = new multipleSelect();
		tasksmiddlepane = new middlePane();
		taskstab = new Tabs();
	}
	
	
	// a function that press on Task tab
	public void pressTask() throws InterruptedException {
		
		waitForVisibility(taskstab.tasksTab);
		
		taskstab.tasksTab.click();
		
		Thread.sleep(3000);
	}
	
	// a function that opens a new entity and adds a title and description
	public void openEntity(String tit , String des) throws InterruptedException {
		
		waitForVisibility(tasksmiddlepane.pressCreateNewItem);
		
		tasksmiddlepane.pressCreateNewItem.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(tasksmiddlepane.enterTitle);
		

		tasksmiddlepane.enterTitle.sendKeys(tit);
		
		
		waitForVisibility(tasksmiddlepane.description);
		
		tasksmiddlepane.description.sendKeys(des);
		
		waitForVisibility(tasksmiddlepane.pressOnEntity);
		
		tasksmiddlepane.pressOnEntity.click();
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
		
		String check =tagsOnTheScreen.getText();
		
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
		/*
		String nameOfDateOnScreen =template.dateOnTheScreen.getAttribute("value");
		
		// checks if the date have been updated on the side of the screen
		if (nameOfDateOnScreen.equals(nameOfDate)) {
		
			logger.log(Status.PASS , "add Date using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Date using multiple select");
		}
		*/
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
		
		
		waitForVisibility(tasksmultipleselect.chooceWatchers);
		
		tasksmultipleselect.chooceWatchers.click();
		
		
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
	public void  SubTask() throws InterruptedException {
		Thread.sleep(2000);
		addSubTask.click();
		
		Thread.sleep(2000);
		waitForVisibility(CreateSubTask);
		
		CreateSubTask.click();
		Thread.sleep(2000);
		waitForVisibility(nameSubTask);
		nameSubTask.sendKeys("autosubtask");
		
		Thread.sleep(1500);
		
		AssigneeSubTask.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(AssignUserSubTask);
		AssignUserSubTask.click();
		
		OpenTaskTemplates.click();
		
		Thread.sleep(2000);
		waitForVisibility(ChooseTaskTemplate);
		ChooseTaskTemplate.click();
		
		Thread.sleep(1000);
		waitForVisibility(DeleteSubTask);
		DeleteSubTask.click();
		
		Thread.sleep(2000);
		ArrowSubTask.click();
	}	
	/*
	public void TaskTemplate() throws InterruptedException {
		for(int i = 0;i<6;i++) {
		waitForVisibility(tasksmiddlepane.pressCreateNewItem);
		tasksmiddlepane.pressCreateNewItem.click();
		
		Thread.sleep(3000);
		waitForVisibility(template.enterTitle);
		template.enterTitle.sendKeys("autotitle"+i);
		
		Thread.sleep(2000);
		waitForVisibility(template.description);
		template.description.sendKeys("auto description"+i);
	}
		
		Thread.sleep(2000);
		template.chooseFavorite.click();
		
		Thread.sleep(2500);
		waitForVisibility(template.assigneeOnTheScreen);
		
		
		Thread.sleep(2000);
		template.dateOnTheScreen.click();
		
		Thread.sleep(3000);
		waitForVisibility(tasksmultipleselect.nextMonth);
		tasksmultipleselect.nextMonth.click();
		
		Thread.sleep(2000);
		waitForVisibility(template.chooseDateOnTheScreen);
		
		Thread.sleep(2000);
		selectTags.click();
		
		Thread.sleep(2000);
		selectTags.sendKeys("new tag test");
		
		Thread.sleep(1500);
		selectTags.submit();
		
		template.pressOnAddWatcherOnTHeScreen.click();
		
		Thread.sleep(2000);
		template.selectMembers.click();
		Thread.sleep(2000);
		template.chooseWatchersOnscreen.click();
		
		waitForVisibility(template.chooseThreeDotsOnScreen);
		template.chooseThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
		waitForVisibility(duplicateTask);
		duplicateTask.click();
		
		Thread.sleep(2000);
		template.chooseThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
		template.chooseDelete.click();
	}
	
public void sortMiddlePane() throws InterruptedException {
	Thread.sleep(2000);
	tasksmiddlepane.pressOnSortByStar.click();
	
	Thread.sleep(2000);
	tasksmiddlepane.chooceToSortByArchived.click();
	
	Thread.sleep(2000);
	tasksmiddlepane.chooceToSortByAll.click();
	
	for(int j=0;j<2;j++) {
	Thread.sleep(2000);
	tasksmiddlepane.prssarrow.click();
	}
	
	Thread.sleep(3000);
	tasksmiddlepane.pressOnSortButton.click();
	
	Thread.sleep(2000);
	waitForVisibility(tasksmiddlepane.pressOnStatus);
	tasksmiddlepane.pressOnStatus.click();
	
	Thread.sleep(2000);
	waitForVisibility(tasksmiddlepane.pressOnUnread);
	tasksmiddlepane.pressOnUnread.click();
	
	Thread.sleep(2000);
	waitForVisibility(tasksmiddlepane.pressSortByTitle);
	tasksmiddlepane.pressSortByTitle.click();
	
	

}
*/
}

	
		
	

	

	
