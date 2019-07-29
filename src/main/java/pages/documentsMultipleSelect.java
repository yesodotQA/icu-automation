package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

public class documentsMultipleSelect  extends TestBase{

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	
	
	public documentsMultipleSelect(){
		
		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		
		PageFactory.initElements(driver, this);
	 }

	 private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
	public void pressDocument() throws InterruptedException {
		
		waitForVisibility(tabs.documentTabs);
		
		tabs.documentTabs.click();
		
		Thread.sleep(3000);
	}
	
	public void openEntity(String tit , String des) throws InterruptedException {
		
		waitForVisibility(middlepane.pressCreateNewItem);
		
		middlepane.pressCreateNewItem.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(middlepane.enterTitle);
		
		middlepane.enterTitle.sendKeys(tit);
		
		
		waitForVisibility(middlepane.description);
		
		middlepane.description.sendKeys(des);
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
	}
	
	public void deleteEntityMultipleChoice() throws InterruptedException {
		
		int size =middlepane.listOfEntities.size() ;
		
			 Thread.sleep(2000);
			 
			 waitForVisibility(multipleselect.pressMultipleChoice);
			
			multipleselect.pressMultipleChoice.click();
			
		
			waitForVisibility(multipleselect.pressDeleteMultipleChoice);
			
			multipleselect.pressDeleteMultipleChoice.click();
			
			
			waitForVisibility(multipleselect.deleteMultipleChoice);
			
			multipleselect.deleteMultipleChoice.click();
			
			
			Thread.sleep(2000);
			
			int newSize =middlepane.listOfEntities.size();
			
		
			if (size - 1 == newSize) {
				
			
				logger.log(Status.PASS , "delete document using mulitiple choice");
				
			}
			
			else {
				
				logger.log(Status.FAIL , "delete document using mulitiple choice");
			}
		
		 }
	public void addTagsMultipleChoice(String tags) throws InterruptedException {
		 
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.TagsMultipleChoice);
		
		multipleselect.TagsMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.selectTags);
		
		multipleselect.selectTags.sendKeys(tags);
		
		
		waitForVisibility(multipleselect.clickOnNewTAg);
		
		multipleselect.clickOnNewTAg.click();
		
		
		waitForVisibility(multipleselect.updateTags);
		
		multipleselect.updateTags.click();
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String check =therightonthescreen.tagsOnTheScreen.getText();
		
		// checks if the tags have been updated on the side of the screen
		if (check.equals("mission (New)")) {
		
			logger.log(Status.PASS , "add Tags using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Tags using multiple select");
		}
		
	}

//a function that adds date using multiple select 
	public void addDateMultipleChoice() throws InterruptedException {
		
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		
	
		waitForVisibility(multipleselect.pressOnDateMultipleSelect);
		
		multipleselect.pressOnDateMultipleSelect.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressToChooseDate);
		
		multipleselect.pressToChooseDate.click();
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.nextMonth);
		
		multipleselect.nextMonth.click();
		
		
		waitForVisibility(multipleselect.chooseADate);
		
		multipleselect.chooseADate.click();
		
		String nameOfDate = multipleselect.getTextOfDate.getAttribute("value");
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.updateDate);
		
		multipleselect.updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(3000);
		
		String nameOfDateOnScreen =therightonthescreen.dateOnTheScreen.getAttribute("value");
		
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
				
		
			waitForVisibility(multipleselect.pressMultipleChoice);
			
			multipleselect.pressMultipleChoice.click();
			
		
			waitForVisibility(multipleselect.pressAssigneeMultipleChoice);
			
			multipleselect.pressAssigneeMultipleChoice.click();
			
			
			waitForVisibility(multipleselect.selectAssignee);
			
			multipleselect.selectAssignee.click();
			
			Thread.sleep(3000);
			
			String nameOfAssignee = multipleselect.listOfAssignees.get(1).getText();
			
			multipleselect.listOfAssignees.get(1).click();
			
			
			waitForVisibility(multipleselect.updateAssignee);
			
			multipleselect.updateAssignee.click();


			Thread.sleep(2000);
			
			waitForVisibility(multipleselect.pressSecondMultipleChoice);
			
			multipleselect.pressSecondMultipleChoice.click();
			
			
			waitForVisibility(middlepane.pressOnEntity);
			
			middlepane.pressOnEntity.click();
			
			
			Thread.sleep(2000);
			
			String nameOfAssigneeOnScreen= therightonthescreen.assigneeOnTheScreen.getText();
			
			
			if (nameOfAssigneeOnScreen.equals(nameOfAssignee)) {
				
				logger.log(Status.PASS , "add assignee using multiple select");
			}
			
			else {
				
				logger.log(Status.FAIL, "add assignee using multiple select");
			}
			
		}
	
	public void addWatchersMultipleChoice() throws InterruptedException {
		
		
		waitForVisibility(multipleselect.pressMultipleChoice);
		
		multipleselect.pressMultipleChoice.click();
		

		waitForVisibility(multipleselect.pressWatchersMultipleChoice);
		
		multipleselect.pressWatchersMultipleChoice.click();
		
		
		waitForVisibility(multipleselect.addWatchers);
		
		multipleselect.addWatchers.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(multipleselect.selectMembers);
		
		multipleselect.selectMembers.click();
		
		
		waitForVisibility(multipleselect.chooceWatchers);
		
		multipleselect.chooceWatchers.click();
		
		int numberOfWatcherOnMultipleSelect = multipleselect.listOfWatchersMultipleSelect.size();
		
		
		waitForVisibility(multipleselect.updateWatchers);
		
		multipleselect.updateWatchers.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressSecondMultipleChoice);
		
		multipleselect.pressSecondMultipleChoice.click();
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		int numberOfWatchersOnScreen = therightonthescreen.listOfWatchersOnScreen.size() ;

		if (numberOfWatchersOnScreen == numberOfWatcherOnMultipleSelect) {
			
			logger.log(Status.PASS , "add watchers using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add watchers using multiple select");
		}
		
	}
	
	// a function that adds status using multiple select 
		public void addStatusMultipleChoice() throws InterruptedException {
			
			waitForVisibility(multipleselect.pressMultipleChoice);
			
			multipleselect.pressMultipleChoice.click();
			
			
			waitForVisibility(multipleselect.pressStatusMultipleChoice);
			
			multipleselect.pressStatusMultipleChoice.click();
			
			
			Thread.sleep(2000);
			waitForVisibility(multipleselect.selectStatus);
			
			multipleselect.selectStatus.click();
			
			
			Thread.sleep(3000);
			
			String nameOgStatus = multipleselect.listOfStatus.get(1).getText();
		
			multipleselect.listOfStatus.get(1).click();
			
			
			waitForVisibility(multipleselect.updateStatus);
			
			multipleselect.updateStatus.click(); 
			
			
			Thread.sleep(2000);
			waitForVisibility(multipleselect.pressSecondMultipleChoice);
			
			multipleselect.pressSecondMultipleChoice.click();
		
			
			Thread.sleep(2000);
			waitForVisibility(middlepane.pressOnEntity);
			
			middlepane.pressOnEntity.click();
			
			
			Thread.sleep(2000);
			
			String nameOgStatusOnScreen = therightonthescreen.statusOnTheScreen.getText();
			
			if (nameOgStatusOnScreen.equals(nameOgStatus)) {
				
				logger.log(Status.PASS , "add status using multiple select");
			}
			
			else {
				
				logger.log(Status.FAIL, "add status using multiple select");
			}
			
			
		}

	



	
	
		
	
	
	
}
