package pages.projects;


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


public class subprojects extends testBase{

	multipleSelect projectsmultipleselect;
	projectsMiddlePane projectsmiddlepane;
	Tabs projectstab;
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
	public @FindBy(css = "body > section > section "
			+ "> div.icu-data.ng-scope > div.panes-wrapper.ng-scope "
			+ "> div.detailspane.animate-hide.ng-isolate-scope > div "
			+ "> div.entity-details-content.project-details.ng-scope "
			+ "> div.sub-items-section > icu-sub-project-list"
			+ " > div.add-sub-entity.sub-entity-title.ng-binding")
	WebElement addSubTask;

	public @FindBy(css = "[placeholder='Create new project']")
	WebElement CreateSubTask;

	public @FindBy(xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[2]")
	WebElement nameSubTask;

	public @FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[3]/div[2]/div[1]/span")
	WebElement AssigneeSubTask;

	@FindBy(css ="[ng-if='$select.open']")
	public List<WebElement> AssignUserSubTask =  new ArrayList<>();

	public @FindBy(css = "[ng-model='data.project.due']")
	WebElement ClickDueDateSubTask;

	public @FindBy(className = "ui-icon-circle-triangle-e")
	WebElement ClickNextMonth;

	public @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a")
	WebElement ChooseDateSubTask;


	public @FindBy (xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[7]/img")
	WebElement DeleteSubTask;

	public@FindBy(css = ".last")
	WebElement ChooseTaskTemplate;
	
	public@FindBy(xpath =  "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[6]")
	WebElement arrowSubTask;

	//duplicatetask
	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[1]/detail-menu/div/ul/li[1]/a")
	WebElement duplicateTask;

	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/detail-tags/div/div[1]/input")
	WebElement selectTags;
	// function for wait
	actionsMiddlePane actionsmiddlepane;
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public subprojects() {

		PageFactory.initElements(driver, this);
		projectsmultipleselect = new multipleSelect();
		projectsmiddlepane = new projectsMiddlePane();
		projectstab = new Tabs();
		template = new theRightOfTheScreen();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.actionsrightside = new actionsRightSide();
	}


	public void  SubProjectEdit() throws InterruptedException {
		
		logger = extent.createTest("create sub projects and edit it");
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
		
		//logger = extent.createTest("delete subtask");
		Thread.sleep(500);
	//	DeleteSubTask.click();
		
	//	Thread.sleep(3000);
		//waitForVisibility(CreateSubTask);
	//	CreateSubTask.click();
		
		Thread.sleep(2000);
		//nameSubTask.sendKeys("autosubtask2");
		
		//Thread.sleep(3000);
		arrowSubTask.click();

	}	

	public void ProjectTemplate() throws InterruptedException {
/*		for(int i = 0;i<6;i++) {
			waitForVisibility(projectsmiddlepane.pressCreateNewItem);
			projectsmiddlepane.pressCreateNewItem.click();

			Thread.sleep(3000);
			waitForVisibility(projectsmiddlepane.enterTitle);
			projectsmiddlepane.enterTitle.sendKeys("autotitle"+i);

			Thread.sleep(2000);
			waitForVisibility(projectsmiddlepane.description);
			projectsmiddlepane.description.sendKeys("auto description"+i);
		}
		*/ actionsmiddlepane.openEntity("proj1" , "important");
		
		Thread.sleep(2000);
		// delete entity using multiple select
		actionsmultipleselect.deleteEntityMultipleChoice();
		
		Thread.sleep(2000);
		actionsmultipleselect.addTagsMultipleChoice("mission");
		
		
		Thread.sleep(2000);
		actionsmultipleselect.addDateMultipleChoice();
		
		Thread.sleep(2000);
		actionsmultipleselect.addAssigneeMultipleChoice();
		
		Thread.sleep(2000);
		actionsmultipleselect.addWatchersMultipleChoice();
		
		Thread.sleep(2000);
		actionsmultipleselect.addStatusMultipleChoice();
		
		Thread.sleep(2000);
		actionsmiddlepane.openEntity("sub3" , "sub task right side");

		// BUG SO SKIPPED
		/*Thread.sleep(2000);
		actionsrightside.addAssignee();
		
		Thread.sleep(2000);
		actionsrightside.setDate();
	*/
		Thread.sleep(2000);
		actionsrightside.addStatus();

		
		Thread.sleep(2000);
		actionsrightside.addTags("yaronnn");
		
		Thread.sleep(2000);
		actionsrightside.addActivities("sad", "memurmar");
		
		Thread.sleep(2000);
		actionsrightside.changePermission();
		
		Thread.sleep(2000);
		actionsrightside.deleteEntity();
	}

	public void sortMiddlePane() throws InterruptedException {
	/*	
		BUGGED DO NOT TOUCH
		
		Thread.sleep(2000);
		projectsmiddlepane.changeStatusOfList();
		
		Thread.sleep(2000);
		actionsmiddlepane.sordByStatusAndUnread();
		
		Thread.sleep(2000);
		actionsmiddlepane.sortByTitle();
		
		Thread.sleep(2000);
		documentsmiddlepane.changeStatusOfList();
*/
	}
	
}








