package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

	public class documentsRightSideOnScreen extends TestBase {
	
		Tabs tabs;
		middlePane middlepane;
		multipleSelect multipleselect;
		theRightOfTheScreen therightonthescreen;
		documentsMiddlePane documentsmiddlepane;
		
		
		@FindBy(className = "activities-list")
		WebElement checkIfTheActivitiesUpdate;
	
		public  documentsRightSideOnScreen() {
		
			this.multipleselect = new multipleSelect();
			this.middlepane = new middlePane();
			this.tabs = new Tabs();
			this.therightonthescreen = new theRightOfTheScreen();
			this.documentsmiddlepane = new documentsMiddlePane();
			PageFactory.initElements(driver, this);
	
		}
		
		private void waitForVisibility (WebElement element)  {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		public void deleteEntityOnScreen() throws InterruptedException {
	
			middlepane.openEntity("delete entity", "1234");
			
			
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
		
		public void addAssigneeOnScreen() throws InterruptedException {
			
		
			middlepane.openEntity("right of screen", "classified");
			
			
			int checkSizeOfWatchersBeforeAddAssignee = therightonthescreen.listOfWatchersIcons.size();
			
			
			waitForVisibility(therightonthescreen.assigneeOnTheScreen);
			
			therightonthescreen.assigneeOnTheScreen.click();
			
			
			Thread.sleep(3000);
			
			therightonthescreen.listOfAssigneeOnScreen.get(1).click();
			
			
			Thread.sleep(2000);
			
			
			int  checkSizeOfWatchersAfterAddAssignee = therightonthescreen.listOfWatchersIcons.size();
			
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
			
			
			waitForVisibility(therightonthescreen.dateOnTheScreen);
			
			therightonthescreen.dateOnTheScreen.click();
			
			
			Thread.sleep(2000);
			
			waitForVisibility(multipleselect.nextMonth);
			
			multipleselect.nextMonth.click();
			
			
			Thread.sleep(2000);
			
			waitForVisibility(therightonthescreen.chooseDateOnTheScreen);
			
			therightonthescreen.chooseDateOnTheScreen.click();
			
			
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
			
			
			waitForVisibility(therightonthescreen.pressToChangeStatusOnTheScreen);
			
			therightonthescreen.pressToChangeStatusOnTheScreen.click();
			
			
			Thread.sleep(2000);
			
			
			therightonthescreen.listOfStatusOnScreen.get(0).click();
			
			
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
		
		public void addTagsOnScreen(String tags) throws InterruptedException {
			
			String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
			
			int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
			
			
			waitForVisibility(therightonthescreen.enterTagsOnScreen);
			
			therightonthescreen.enterTagsOnScreen.click();
			
			Thread.sleep(1000);
			
			therightonthescreen.enterTagsOnScreen.sendKeys(tags);
		
			
			Thread.sleep(1000);
			
			therightonthescreen.listOfTagsOnScreen.get(0).click();
			
			
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
			
			int checkSizeOfWatchersBeforeAddWatchers = therightonthescreen.listOfWatchersIcons.size();
			
			waitForVisibility(therightonthescreen.pressOnAddWatcherOnTHeScreen);
			
			therightonthescreen.pressOnAddWatcherOnTHeScreen.click();
			
			
			Thread.sleep(1000);
			
			waitForVisibility(therightonthescreen.selectMembers);
			
			therightonthescreen.selectMembers.click();
			
			
			Thread.sleep(2000);
			
			therightonthescreen.listOfWatchersOnScreen.get(0).click();
			
			Thread.sleep(2000);
			
			int  checkSizeOfWatchersAfterAddWatchers = therightonthescreen.listOfWatchersIcons.size();
			
			if(checkSizeOfWatchersBeforeAddWatchers +  1 ==  checkSizeOfWatchersAfterAddWatchers) {
				
				logger.log(Status.PASS , "add watchers on screen");
			
			}
			
			else {
			
				logger.log(Status.FAIL , "add watchers on screen");
			
			}
				
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
