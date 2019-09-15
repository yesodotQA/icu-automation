package pages.projects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
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
	WebElement addSubProject;

	public @FindBy(css = "[placeholder='Create new project']")
	WebElement CreateSubProject;

	public @FindBy(xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[2]")
	WebElement nameSubProject;

	public @FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[3]/div[2]/div[1]/span")
	WebElement AssigneeProject;

	@FindBy(css ="[ng-if='$select.open']")
	public List<WebElement> AssignUserSubProject =  new ArrayList<>();

	public @FindBy(css = "[ng-model='data.project.due']")
	WebElement ClickDueDateSubProject;

	public @FindBy(className = "ui-icon-circle-triangle-e")
	WebElement ClickNextMonth;

	public @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a")
	WebElement ChooseDateSubProject;


	public @FindBy (xpath ="/html/body/section/section/div[2]/div[2]/div[2]"
			+ "/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[7]")
	WebElement DeleteSubProject;
	
	@FindBy(css = "[ng-mouseleave='deleteShowDlt(task)']")
	public List<WebElement>listOfSubProjects=  new ArrayList<>();

	public@FindBy(css = ".last")
	WebElement ChooseTaskTemplate;
	
	public@FindBy(xpath =  "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[6]")
	WebElement arrowSubProjects;

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
	
	public void addSubProjects() throws InterruptedException {
		
		waitForVisibility(addSubProject);
		addSubProject.click();
	
		Thread.sleep(1000);
	}


	public void deleteSubProject() throws InterruptedException {
		
		logger = extent.createTest("create sub projects and edit it");
		
		waitForVisibility(CreateSubProject);
		CreateSubProject.click();
		
		Thread.sleep(2000);
		
		int numberOfSubProjectsBefore = listOfSubProjects.size();
		
		
		waitForVisibility(nameSubProject);
		nameSubProject.sendKeys("autosubtask");

		Thread.sleep(1500);

		AssigneeProject.click();

		Thread.sleep(2000);

		AssignUserSubProject.get(1).click();
	
		Thread.sleep(2000);
		ClickDueDateSubProject.click();
		
		Thread.sleep(2000);
		
		ClickNextMonth.click();
		
		Thread.sleep(2000);
		
		ChooseDateSubProject.click();
		
		Thread.sleep(500);
		DeleteSubProject.click();
	
		Thread.sleep(2000);
		
		int numberOfSubProjectsAfter =listOfSubProjects.size();		
		
		if (numberOfSubProjectsBefore -1 == numberOfSubProjectsAfter) {

			logger.log(Status.PASS, "delete sub projects");
		}
		else {

			logger.log(Status.FAIL, "delete sub  projects");
		}

	}	

	public void createSubProjects() throws InterruptedException {

		waitForVisibility(CreateSubProject);
		CreateSubProject.click();

		Thread.sleep(2000);

		waitForVisibility(nameSubProject);
		nameSubProject.sendKeys("autosubtask");

		Thread.sleep(2000);

		waitForVisibility(arrowSubProjects);
		arrowSubProjects.click();

		Thread.sleep(2000);

	}
}






