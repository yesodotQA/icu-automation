package pages.tasks;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;
import pages.documents.documentsMiddlePane;


public class subTasks extends testBase{

	multipleSelect tasksmultipleselect;
	tasksMiddlePane tasksmiddlepane;
	Tabs taskstab;
	theRightOfTheScreen template;
	actionsMultipleSelect actionsmultipleselect;
	documentsMiddlePane documentsmiddlepane;
	actionsRightSide actionsrightside;
	



	//parent project and discussion
	public @FindBy(css = "[value='item.project']")
	WebElement selectParentProject;

	public @FindBy(css = "[value='item.discussion']")
	WebElement selectParentMeeting;

	//elements for subtask 
	public @FindBy(css = "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div > div.entity-details-content.task-details.ng-scope > div.sub-items-section > icu-sub-task-list > div.add-sub-entity.sub-entity-title.ng-binding")
	WebElement addSubTask;

	public @FindBy(css = "[placeholder='Create new task']")
	WebElement CreateSubTask;

	public @FindBy(xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-task-list/div[3]/table/tbody/tr[1]/td[2]")
	WebElement nameSubTask;

	public @FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-task-list/div[3]/table/tbody/tr[1]/td[3]/div[2]/div[1]/span")
	WebElement AssigneeSubTask;

	@FindBy(css ="[ng-if='$select.open']")
	public List<WebElement> AssignUserSubTask =  new ArrayList<>();

	public @FindBy(css = "[ng-model='data.task.due']")
	WebElement ClickDueDateSubTask;

	public @FindBy(className = "ui-icon-circle-triangle-e")
	WebElement ClickNextMonth;

	public @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a")
	WebElement ChooseDateSubTask;


	public @FindBy (xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-task-list/div[3]/table/tbody/tr[1]/td[7]")
	WebElement DeleteSubTask;

	public@FindBy(css = ".last")
	WebElement ChooseTaskTemplate;
	
	public@FindBy(css =  "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div > div.entity-details-content.task-details.ng-scope > div.sub-items-section > icu-sub-task-list > div.list-table.sub-entity.scroll > table > tbody > tr:nth-child(1) > td.arrow.ng-scope > div")
	WebElement arrowSubTask;

	//duplicatetask
	public@FindBy(css = "div > div.entity-details-header-bar.ng-scope > detail-menu > div > ul > li:nth-child(1) > a > span")
	WebElement duplicateTask;

	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/detail-tags/div/div[1]/input")
	WebElement selectTags;
	// function for wait
	actionsMiddlePane actionsmiddlepane;
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public subTasks() {

		PageFactory.initElements(driver, this);
		tasksmultipleselect = new multipleSelect();
		tasksmiddlepane = new tasksMiddlePane();
		taskstab = new Tabs();
		template = new theRightOfTheScreen();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.actionsrightside = new actionsRightSide();
	}


	public void  SubTaskEdit() throws InterruptedException {
		
		logger = extent.createTest("create sub tasks and edit it");
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

		AssignUserSubTask.get(1).click();
	
		Thread.sleep(2000);
		ClickDueDateSubTask.click();
		
		Thread.sleep(2000);
		
		ClickNextMonth.click();
		
		Thread.sleep(2000);
		
		ChooseDateSubTask.click();
		
		waitForVisibility(nameSubTask);
		nameSubTask.click();
		
		logger = extent.createTest("delete subtask");
		Thread.sleep(500);
		DeleteSubTask.click();
		
		Thread.sleep(3000);
		waitForVisibility(CreateSubTask);
		CreateSubTask.click();
		
		Thread.sleep(2000);
		nameSubTask.sendKeys("autosubtask2");
		
		Thread.sleep(3000);
		arrowSubTask.click();
		
		Thread.sleep(2000);

	}	

	public void TaskTemplate() throws InterruptedException {
/*		for(int i = 0;i<6;i++) {
			waitForVisibility(tasksmiddlepane.pressCreateNewItem);
			tasksmiddlepane.pressCreateNewItem.click();

			Thread.sleep(3000);
			waitForVisibility(tasksmiddlepane.enterTitle);
			tasksmiddlepane.enterTitle.sendKeys("autotitle"+i);

			Thread.sleep(2000);
			waitForVisibility(tasksmiddlepane.description);
			tasksmiddlepane.description.sendKeys("auto description"+i);
		}
		*/ actionsmiddlepane.openEntity("doc1" , "important");
		
		
		// delete entity using multiple select
		actionsmultipleselect.deleteEntityMultipleChoice();
		
		
		actionsmultipleselect.addTagsMultipleChoice("mission");
		
		
		
		actionsmultipleselect.addDateMultipleChoice();
		
		
		actionsmultipleselect.addAssigneeMultipleChoice();
		
		
		actionsmultipleselect.addWatchersMultipleChoice();
		
		
		actionsmultipleselect.addStatusMultipleChoice();

		
		actionsrightside.addAssignee();
		
		actionsrightside.setDate();
		
		
		actionsrightside.addStatus();

		
		
		actionsrightside.addTags("yaronnn");
		
		
		actionsrightside.addActivities("sad", "memurmar");
		
		
		//actionsrightside.changePermission();

		Thread.sleep(2000);
		
		template.pressOnThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
		waitForVisibility(duplicateTask);
		duplicateTask.click();
		
		actionsrightside.deleteEntity();
	}

	public void sortMiddlePane() throws InterruptedException {
		
		Thread.sleep(2000);
		tasksmiddlepane.changeStatusOfList();
		
		Thread.sleep(2000);
		actionsmiddlepane.sordByStatusAndUnread();
		
		Thread.sleep(2000);
		actionsmiddlepane.sortByTitle();
		
		Thread.sleep(2000);
		documentsmiddlepane.changeStatusOfList();

	}
	
}








