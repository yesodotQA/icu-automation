package pages;

import java.util.ArrayList;
import java.util.List;

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

public class tasksRightSideOfScreen extends testBase {
	
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
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  tasksRightSideOfScreen() {
		
		this.tasksmultipleselect = new multipleSelect();
		this.tasksmiddlepane = new middlePane();
		this.taskstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	public void deleteEntityOnScreen() throws InterruptedException {
		
		tasksmiddlepane.openEntity("delete entity", "1234");
		
		
		int size =tasksmiddlepane.listOfEntities.size() ;
		
		
		waitForVisibility(template.pressOnThreeDotsOnScreen);
		
		template.pressOnThreeDotsOnScreen.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(deleteOnrightSide);
		
		deleteOnrightSide.click();
		
		
		Thread.sleep(2000);
		
		int newSize =tasksmiddlepane.listOfEntities.size();
		
	//check if the entity deleted
		if (size - 1 == newSize) {
			
		
			logger.log(Status.PASS , "delete document on screen");
			
		}
		
		else {
			
			logger.log(Status.FAIL , "delete document on screen");
		}
	}
	
	public void addAssigneeOnScreen() throws InterruptedException {
		
		
		tasksmiddlepane.openEntity("right of screen", "classified");
		
		
		int checkSizeOfWatchersBeforeAddAssignee =template.listOfWatchersIcons.size();
		
		
		waitForVisibility(template.assigneeOnTheScreen);
		
		template.assigneeOnTheScreen.click();
		
		
		Thread.sleep(3000);
		
		template.listOfAssigneeOnScreen.get(1).click();
		
		
		Thread.sleep(2000);
		
		
		int  checkSizeOfWatchersAfterAddAssignee =template.listOfWatchersIcons.size();
		
		if(checkSizeOfWatchersBeforeAddAssignee +  1 == checkSizeOfWatchersAfterAddAssignee) {
			
			logger.log(Status.PASS , "add asignee on screen");
		
		}
		
		else {
		
			logger.log(Status.FAIL , "add asignee on screen");
		
		}
			
	}
	
	public void addDateOnScreen() throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		
		waitForVisibility(template.dateOnTheScreen);
		
		template.dateOnTheScreen.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(tasksmultipleselect.nextMonth);
		
		tasksmultipleselect.nextMonth.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(template.chooseDateOnTheScreen);
		
		template.chooseDateOnTheScreen.click();
		
		
		Thread.sleep(2000);

		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		
		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {
			
			logger.log(Status.PASS , "add date on screen");
		
		}
		
		else {
			
			logger.log(Status.FAIL , "add date on screen");
		}
		
	}
	

	public void addStatusOnScreen() throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		
		waitForVisibility(template.pressToChangeStatusOnTheScreen);
		
		template.pressToChangeStatusOnTheScreen.click();
		
		
		Thread.sleep(2000);
		
		
		template.listOfStatusOnScreen.get(0).click();
		
		
		Thread.sleep(2000);
		
		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		
		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {
			
			logger.log(Status.PASS , "add status on screen");
		
		}
		
		else {
			
			logger.log(Status.FAIL , "add status on screen");
		}
	}
	
	public void SelectProjectsOnScreen() throws InterruptedException {
		
		waitForVisibility(SelectProjects);
		
		SelectProjects.click();
		
		
		Thread.sleep(3000);
		
		
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
	
	public void SelectDiscussionsOnScreen() throws InterruptedException {
	
		waitForVisibility(SelectDiscussions);
		
		SelectDiscussions.click();
		
		
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
	
	public void addTagsOnScreen(String tags) throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		
		waitForVisibility(template.enterTagsOnScreen);
		
		template.enterTagsOnScreen.click();
		
		Thread.sleep(1000);
		
		template.enterTagsOnScreen.sendKeys(tags);
	
		
		Thread.sleep(1000);
		
		template.listOfTagsOnScreen.get(0).click();
		
		
		Thread.sleep(2000);
		
		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		
		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {
			
			logger.log(Status.PASS , "add tags on screen");
		
		}
		
		else {
			
			logger.log(Status.FAIL , "add tags on screen");
		}
	}
	
	public void addActivities(String act1 , String act2) throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		
		waitForVisibility(template.addActivities);
	
		template.addActivities.sendKeys(act1);
		
		Thread.sleep(2000);
		
		waitForVisibility(template.updateActivities);
		
		template.updateActivities.click();
		

		Thread.sleep(2000);
		
		
		waitForVisibility(template.addActivities);
		
		
		template.addActivities.sendKeys(act2);
		
		
		Thread.sleep(2000);
		
		
		waitForVisibility(template.updateActivities);
		
		template.updateActivities.click();
		
		
		Thread.sleep(2000);
		
		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		
		if (switcheStringToInt1 + 2 == SwitcheStringToInt2) {
			
			logger.log(Status.PASS , "add activities");
		
		}
		
		else {
			
			logger.log(Status.FAIL , "add activities");
		}
		
	}
	
	public void addWatcherOnScreen() throws InterruptedException {
		
		int checkSizeOfWatchersBeforeAddWatchers = template.listOfWatchersIcons.size();
		
		waitForVisibility(template.pressOnAddWatcherOnTHeScreen);
		
		template.pressOnAddWatcherOnTHeScreen.click();
		
		
		Thread.sleep(1000);
		
		waitForVisibility(template.selectMembers);
		
		template.selectMembers.click();
		
		
		Thread.sleep(2000);
		
		template.listOfWatchersOnScreen.get(1).click();
		
		Thread.sleep(2000);
		
		int  checkSizeOfWatchersAfterAddWatchers = template.listOfWatchersIcons.size();
		
		if(checkSizeOfWatchersBeforeAddWatchers +  1 ==  checkSizeOfWatchersAfterAddWatchers) {
			
			logger.log(Status.PASS , "add watchers on screen");
		
		}
		
		else {
		
			logger.log(Status.FAIL , "add watchers on screen");
		
		}
		
	}

}	
	
	
	
	
