package global.globalActions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
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
import pages.documents.documentsMiddlePane;

public class actionsRightSide extends testBase {

	Tabs                 tabs;
	middlePane           middlepane;
	multipleSelect       multipleselect;
	theRightOfTheScreen  therightonthescreen;
	documentsMiddlePane  documentsmiddlepane;
	actionsMiddlePane    actionmiddlepane;

	@FindBy(className = "activities-list")
	WebElement checkIfTheActivitiesUpdate;

	@FindBy(css = ".description.ng-binding")
	List<WebElement> listOfDescriptionInActivities=  new ArrayList<>();

	public actionsRightSide() {

		this.multipleselect      = new multipleSelect();
		this.middlepane          = new middlePane();
		this.tabs                = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.actionmiddlepane    = new actionsMiddlePane();

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
	public void addAssignee(boolean openEntity) throws InterruptedException {
		Thread.sleep(1500);

		actionmiddlepane.openEntity("right of screen", "classified");

		if (openEntity ==true ) {

			int checkSizeOfWatchersBeforeAddAssignee = therightonthescreen.listOfWatchersIcons.size();

			waitForVisibility(therightonthescreen.assigneeOnTheScreen);
			therightonthescreen.assigneeOnTheScreen.click();
			Thread.sleep(3000);

			therightonthescreen.listOfAssigneeOnScreen.get(2).click();
			Thread.sleep(3000);

			int  checkSizeOfWatchersAfterAddAssignee = therightonthescreen.listOfWatchersIcons.size();

			// CHECK IF ASINGEE WAS ADDED
			if(checkSizeOfWatchersBeforeAddAssignee +  1 == checkSizeOfWatchersAfterAddAssignee) {
				logger.log(Status.PASS , "add asignee on screen");
			}
			else {
				logger.log(Status.FAIL , "add asignee on screen");
			}

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
			logger.log(Status.PASS , "add activity in activities");
		}
		else {
			logger.log(Status.FAIL , "add activity in activities");
		}

		String Description = listOfDescriptionInActivities.get(0).getText();

		String collect = "";

		for (int i = 10; i > 0 ; i--) {

			collect +=	Description.charAt(Description.length()-i);
		}

		String Date =therightonthescreen.dateOnTheScreen.getAttribute("value");

		if (Date.equals(collect)) {

			logger.log(Status.PASS , "Add a correct description");			
		}
		else {
			logger.log(Status.FAIL , "the description is not correct");
		}

	}

	public void addStatus() throws InterruptedException {

		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");

		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);


		waitForVisibility(therightonthescreen.pressToChangeStatusOnTheScreen);

		therightonthescreen.pressToChangeStatusOnTheScreen.click();


		Thread.sleep(2000);


		therightonthescreen.listOfStatusOnScreen.get(1).click();


		Thread.sleep(2000);

		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");

		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);


		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {

			logger.log(Status.PASS , "add status on screen");

		}

		else {

			logger.log(Status.FAIL , "add status on screen");
		}

		String Description = listOfDescriptionInActivities.get(0).getText();

		int status = therightonthescreen.pressToChangeStatusOnTheScreen.getText().length();

		String collect = "";

		for (int i = status; i > 0 ; i--) {

			collect +=Description.charAt(Description.length()-i);  
		}
		System.out.println(collect);

		String statusName = therightonthescreen.pressToChangeStatusOnTheScreen.getText();

		System.out.println(statusName);

		if (collect.equals(statusName)) {

			logger.log(Status.PASS , "Add a correct description");			
		}
		else {
			logger.log(Status.FAIL , "the description is not correct");
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

		String Description = listOfDescriptionInActivities.get(0).getText();

		int tagSize = therightonthescreen.tagsOnScreenForChecking.getText().length();

		System.out.println(tagSize);

		String collect = "";

		for (int i = tagSize; i > 0 ; i--) {

			collect +=Description.charAt(Description.length()-i);  
		}

		String tagName = therightonthescreen.tagsOnScreenForChecking.getText();

		System.out.println(tagName + " " + collect);

		if (tagName.equals(collect)) {

			logger.log(Status.PASS , "Add a correct description");			
		}
		else {
			logger.log(Status.FAIL , "the description is not correct");
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
	public void addWatcher() throws InterruptedException {

		int checkSizeOfWatchersBeforeAddWatchers = therightonthescreen.listOfWatchersIcons.size();

		waitForVisibility(therightonthescreen.pressOnAddWatcherOnTHeScreen);
		therightonthescreen.pressOnAddWatcherOnTHeScreen.click();

		Thread.sleep(1000);

		waitForVisibility(therightonthescreen.selectMembers);
		therightonthescreen.selectMembers.click();

		Thread.sleep(2000);
		therightonthescreen.listOfWatchersOnScreen.get(1).click();

		Thread.sleep(2000);

		List<WebElement> memberList = driver.findElements(By.cssSelector("[user='member']"));
		memberList.get(1).click();

		Thread.sleep(2000);
		List<WebElement> permissionsList = driver.findElements(By.className("dropdown-item"));


		String Editor    = "Set as Editor";

		// Set as editor 
		for(int i = 0; i <= permissionsList.size(); i++) {

			if (permissionsList.get(i).getText().equals(Editor)){

				permissionsList.get(i).click();
				break;
			}
		}

		int  checkSizeOfWatchersAfterAddWatchers = therightonthescreen.listOfWatchersIcons.size();

		if(checkSizeOfWatchersBeforeAddWatchers +  1 ==  checkSizeOfWatchersAfterAddWatchers) {
			logger.log(Status.PASS , "add watchers on screen");
		}

		else {
			logger.log(Status.FAIL , "add watchers on screen");

		}


	}

	public void changePermission() throws InterruptedException {

		int i = 0;
		int count = 0;
		while(count < 3) {
			waitForVisibility(therightonthescreen.pressOnAddWatcherOnTHeScreen);
			therightonthescreen.pressOnAddWatcherOnTHeScreen.click();
			Thread.sleep(2000);

			waitForVisibility(therightonthescreen.selectMembers);
			therightonthescreen.selectMembers.click();
			Thread.sleep(2000);

			therightonthescreen.listOfWatchersOnScreen.get(i).click();
			Thread.sleep(2000);

			count++;
		}


		List<WebElement> memberList = driver.findElements(By.cssSelector("[user='member']"));
		memberList.get(1).click();

		Thread.sleep(2000);
		List<WebElement> permissionsList = driver.findElements(By.className("dropdown-item"));

		String Editor    = "Set as Editor";
		String Commenter = "Set as commenter";


		// Set as editor 
		for(int j = 0; j <= permissionsList.size(); j++) {

			if (permissionsList.get(j).getText().equals(Editor)){

				permissionsList.get(j).click();
				break;
			}
		}

		Thread.sleep(2000);
		List<WebElement> EditorMembers = driver.findElements(By.cssSelector(".avatar.editor"));

		if (EditorMembers.size() == 2) {
			logger.log(Status.PASS , "change permission to Editor");
		}
		else {

			logger.log(Status.FAIL, "change permission to Editor");
		}

		// set as commenter
		memberList.get(2).click();

		for(int j = 0; j <= permissionsList.size(); j++) {

			if (permissionsList.get(j).getText().equals(Commenter)) {

				permissionsList.get(j).click();
				break;
			}
		}
		try {
			
			WebElement commenterMember = driver.findElement(By.className("commenter"));

			Thread.sleep(2000);

			if (commenterMember.isDisplayed()) {
				logger.log(Status.PASS , "change permission to commenter");
			}
		
		} catch (Exception e) {
			
			logger.log(Status.FAIL, "change permission to commenter");
		}

		try {
			
			WebElement viewerMember = driver.findElement(By.className("viewer"));

			Thread.sleep(2000);

			if (viewerMember.isDisplayed()) {

				logger.log(Status.PASS , "The defaults permmision is viewer");
			}
	
		} catch (Exception e) {
			
			logger.log(Status.FAIL, "The defaults permmision is viewer");
		}

	}


}



