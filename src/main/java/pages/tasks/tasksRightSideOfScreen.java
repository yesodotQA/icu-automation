package pages.tasks;

import java.util.ArrayList;
import java.util.List;

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

public class tasksRightSideOfScreen extends testBase {
	
	theRightOfTheScreen rightside;
	multipleSelect tasksmultipleselect;	
	middlePane tasksmiddlepane;	
	Tabs taskstab;	
	theRightOfTheScreen template;
	
	@FindBy (className = "fa-times-circle")
	WebElement deleteOnrightSide;
			
	@FindBy(className = "activities-list")
	WebElement checkIfTheActivitiesUpdate;
	
	@FindBy(xpath =  "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]"
			+ "/detail-category[1]/div/div[1]/span/span[1]")
	WebElement SelectProjects;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfProjects =  new ArrayList<>();
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/"
			+ "div[2]/detail-category[2]/div/div[1]/span/span[1]")
	WebElement SelectDiscussions;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfDiscussions =  new ArrayList<>();
	
	@FindBy(css = "div > div.entity-details-header-bar.ng-scope > detail-menu > div > ul > li:nth-child(1) > a > span")
	WebElement duplicateTask;
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  tasksRightSideOfScreen() {
		this.rightside = new theRightOfTheScreen();
		this.tasksmultipleselect = new multipleSelect();
		this.tasksmiddlepane = new middlePane();
		this.taskstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	public void SelectProjectsOnScreen() throws InterruptedException {
		
		if(SelectProjects.getText().equals("Select a project")){
		
		waitForVisibility(SelectProjects);
		
		SelectProjects.click();
		
		Thread.sleep(2000);
		
		if (listOfProjects.isEmpty()==false) {
			
			Thread.sleep(1000);


			String nameOfProject = listOfProjects.get(0).getText();


			listOfProjects.get(0).click();

			Thread.sleep(2000);


			String nameOfProjectForChecking = SelectProjects.getAttribute("innerText");

			if (nameOfProject.equals(nameOfProjectForChecking)) {

				logger.log(Status.PASS , "select project on screen");

			}
			else {

				logger.log(Status.FAIL , "select project on screen");
			}
		}
	}
 }

	public void SelectDiscussionsOnScreen() throws InterruptedException {
	
		if(SelectDiscussions.getText().equals("Select discussion")){
		
		waitForVisibility(SelectDiscussions);
		
		SelectDiscussions.click();
		
		if (listOfDiscussions.isEmpty()==false) {

			Thread.sleep(3000);


			String nameOfDiscussions = listOfDiscussions.get(0).getText();


			listOfDiscussions.get(0).click();

			Thread.sleep(2000);

			String nameOfDiscussionsForChecking = SelectDiscussions.getAttribute("innerText");

			if (nameOfDiscussions.equals(nameOfDiscussionsForChecking)) {

				logger.log(Status.PASS , "select discussions on screen");

			}
			else {

				logger.log(Status.FAIL , "select doscussions on screen");
			}
		}

	}	

 }
		
	public void duplicateTasks () throws InterruptedException {
		
		int sizeOfEntitiesBeforeDuplicate =  tasksmiddlepane.listOfEntities.size();
		
		waitForVisibility(template.pressOnThreeDotsOnScreen);
		template.pressOnThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
	
		waitForVisibility(duplicateTask);
		duplicateTask.click();
		
		Thread.sleep(2000);
		
		 int sizeOfEntitiesAfterDuplicate = tasksmiddlepane.listOfEntities.size();
		 
		if (sizeOfEntitiesBeforeDuplicate + 1 == sizeOfEntitiesAfterDuplicate) {
			
			logger.log(Status.PASS , "the entity task duplicate ");
		}

		else {

			logger.log(Status.FAIL , "the entity task not duplicate ");
		}	
	}	
 }	




