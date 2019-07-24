package pages;



import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import base.TestBase;

public class documentObjects extends TestBase {
	
	// elements of opening an entity
	@FindBy (xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[5]/div/div[2]/span")
	WebElement pressButtonDocument;
	
	@FindBy(css = "[ng-model='newItem']")
	WebElement pressCreateNewItem;
	
	@FindBy(className = "item-title")
	WebElement enterTitle;
	
	@FindBy(css = "[ng-model='item.description']")
	WebElement description;
	
	// elements of multiple choice
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[3]")
	WebElement pressOnEntity;

	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement pressMultipleChoice;
	
	@FindBy(css = ".multipleSelected .tick .ng-valid")
	WebElement pressSecondMultipleChoice;
	
	// elements of delete multiple choice
	@FindBy (className =  "delete")
	WebElement pressDeleteMultipleChoice;
	
	@FindBy (className = "action-button")
	WebElement deleteMultipleChoice;
	
	@FindBy(css= "[ng-click='onClickRow($event, item)']")
	public List <WebElement> webElements = new ArrayList<>(); ;
	
	// elements of add tags multiple choice
	@FindBy (className = "tag")
	WebElement TagsMultipleChoice;
	
	@FindBy (css = "[style='width: 501px;']")
	WebElement selectTags;
	
	@FindBy(className = "ui-select-choices-row-inner")
	WebElement clickOnNewTAg;
	
	@FindBy (className = "action-button")
	WebElement updateTags;
	
	@FindBy (xpath = "//*[@id=\"addTag\"]/span/span/span[2]/span")
	WebElement tagsOnTheScreen;
	
	//elements of add date multiple select
	@FindBy(className = "due")
	WebElement pressOnDateMultipleSelect;
	
	@FindBy(className = "hasDatepicker")
	WebElement pressToChooseDate;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")
	WebElement chooseADate;
	
	@FindBy (className = "action-button")
	WebElement updateDate;
	
	@FindBy(css = "[ui-date='dueOptions']")
	WebElement dateOnTheScreen;
	
	//elements of add assignee
	@FindBy(className = "assign")
	WebElement pressAssigneeMultipleChoice;
	
	@FindBy(xpath = "//*[@id=\"modalBulk\"]/section/tooltip/tip-cont/div/div/div[1]/span")
	WebElement selectAssignee;
		
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-31-1\"]/span/div/div")
	WebElement pressOnAssignee;
	
	@FindBy(className = "action-button")
	WebElement updateAssignee;
	
	@FindBy(className = "summary-content")
	WebElement assigneeOnTheScreen;
	
	//elements of add watchers
	@FindBy(className = "watchers")
	WebElement pressWatchersMultipleChoice;

	@FindBy(className =  "add")
	WebElement addWatchers;
	
	@FindBy(css = "[autofocus='autofocus']")
	WebElement selectMembers;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-38-0\"]/span")
	WebElement chooceWatchers;
	
	@FindBy(className = "action-button")
	WebElement updateWatchers;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/icu-members-footer/div/div[1]/div[2]/div/div[1]/div/img")
	WebElement WatchersOnTheScreen;
	
	//elements of add status
	@FindBy(className = "status")
	WebElement pressStatusMultipleChoice;
	
	@FindBy(className = "text-muted")
	WebElement selectStatus;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-44-4\"]")
	WebElement chooceStatus;
	
	@FindBy(className = "action-button")
	WebElement updateStatus;
	
	@FindBy(className = "active-status")
	WebElement sortByStatus;
	
	@FindBy(xpath ="//*[@id=\"ui-select-choices-row-45-2\"]")
	WebElement chooceToSortByAll;
	
	@FindBy(className = "waiting-approval")
	WebElement statusOnTheScreen;
	
	//elements of activities
	@FindBy(css = "[ng-blur='minimizeUpdate()']")
	WebElement updateActivities;
	
	@FindBy(css = ".save.ng-binding")
	WebElement addActivities;
	
	//elements of assignee on screen
	@FindBy(xpath ="//*[@id=\"ui-select-choices-row-49-1\"]/span/span")
	WebElement chooseAssigneeOnTheScreen;
	
	// elements of date on screen
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]")
	WebElement chooseDateOnTheScreen;
	
	//elements of status on screen
	@FindBy(css = "[list='statuses']")
	WebElement changeStatusOnTheScreen;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-50-4\"]/span/i")
	WebElement chooseStatusOnTheScreen;
	
	//elements of delete on screen
	@FindBy(className = "dropdown-trigger")
	WebElement chooseThreeDotsOnScreen;
	
	@FindBy(css = "[ng-click='item.action()']")
	WebElement chooseDelete;
	
	@FindBy(className ="detail-favorite" )
	WebElement chooseFavorite;
	
	@FindBy(css =".sortByStar .favorites")
	WebElement chooseSortByFavorite;
	
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/*	
	public documentObjects() {
		
	 	PageFactory.initElements(driver, this);
	}
	*/
	
	// a function that press on document tab
	public void pressDocument() throws InterruptedException {
		
		waitForVisibility(pressButtonDocument);
		
		pressButtonDocument.click();
		
		Thread.sleep(3000);
		
		
	}
	
	// a function that opens a new entity and adds a title and description
	public void openEntity(String tit , String des) throws InterruptedException {
		
		waitForVisibility(pressCreateNewItem);
		
		pressCreateNewItem.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(enterTitle);
		
		enterTitle.sendKeys(tit);
		
		
		waitForVisibility(description);
		
		description.sendKeys(des);
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
	
	}
	
	// a function that delete entity using multiple select
	public void deleteEntityMultipleChoice() throws InterruptedException {
		
		int size = webElements.size();
		
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressDeleteMultipleChoice);
		
		pressDeleteMultipleChoice.click();
		
		
		waitForVisibility(deleteMultipleChoice);
		
		deleteMultipleChoice.click();
		
	
		Thread.sleep(2000);
		
		int newSize = webElements.size();
		
	
		if (size - 1 == newSize) {
			
		
			logger.log(Status.PASS , "delete document using mulitiple choice");
			
		}
		
		else {
			
			logger.log(Status.FAIL , "delete document using mulitiple choice");
		}
		
			
		}
	
	// a function that adds tags using multiple select 
	public void addTagsMultipleChoice(String tags) throws InterruptedException {
		 
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
		
		waitForVisibility(TagsMultipleChoice);
		
		TagsMultipleChoice.click();
		
		
		waitForVisibility(selectTags);
		
		selectTags.sendKeys(tags);
		
		
		waitForVisibility(clickOnNewTAg);
		
		clickOnNewTAg.click();
		
		
		waitForVisibility(updateTags);
		
		updateTags.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
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
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressOnDateMultipleSelect);
		
		pressOnDateMultipleSelect.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(pressToChooseDate);
		
		pressToChooseDate.click();
		
		
		waitForVisibility(chooseADate);
		
		chooseADate.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(updateDate);
		
		updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(3000);
		
		String check =dateOnTheScreen.getAttribute("value");
		
		// checks if the date have been updated on the side of the screen
		if (check.equals("27/07/2019")) {
		
			logger.log(Status.PASS , "add Date using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Date using multiple select");
		}
		
		}
	
	// a function that adds assignee using multiple select 
	public void addAssigneeMultipleChoice() throws InterruptedException {
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressAssigneeMultipleChoice);
		
		pressAssigneeMultipleChoice.click();
		
		
		waitForVisibility(selectAssignee);
		
		selectAssignee.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(pressOnAssignee);
		
		pressOnAssignee.click();
		
		
		waitForVisibility(updateAssignee);
		
		updateAssignee.click();
		

		Thread.sleep(1000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String check =assigneeOnTheScreen.getText();
		
		if (check.equals("yaron")) {
			
			logger.log(Status.PASS , "add assignee using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add assignee using multiple select");
		}
		
	}
	
	// a function that adds watchers using multiple select 
	public void addWatchersMultipleChoice() throws InterruptedException {
		
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		

		waitForVisibility(pressWatchersMultipleChoice);
		
		pressWatchersMultipleChoice.click();
		
		
		waitForVisibility(updateWatchers);
		
		updateWatchers.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		boolean check =WatchersOnTheScreen.isDisplayed();
		
		if (check == true) {
			
			logger.log(Status.PASS , "add watchers using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add watchers using multiple select");
		}
		
	}
	
	// a function that adds status using multiple select 
	public void addStatusMultipleChoice() throws InterruptedException {
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
		
		waitForVisibility(pressStatusMultipleChoice);
		
		pressStatusMultipleChoice.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(selectStatus);
		
		selectStatus.click();
		
		
		Thread.sleep(3000);
		waitForVisibility(chooceStatus);
		
		chooceStatus.click();
		
		
		waitForVisibility(updateStatus);
		
		updateStatus.click(); 
		
		
		Thread.sleep(2000);
		waitForVisibility(sortByStatus);
		
		sortByStatus.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(sortByStatus);
		
		chooceToSortByAll.click();
	
		
		Thread.sleep(2000);
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String check = statusOnTheScreen.getText();
		
		if (check.equals("waiting approval")) {
			
			logger.log(Status.PASS , "add status using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add status using multiple select");
		}
		
		
	}
	
	// a function that checks whether the activity is updated
	public void addActivities(String upd) throws InterruptedException {
		
		waitForVisibility(updateActivities);

		updateActivities.sendKeys(upd);
		
		
		waitForVisibility(addActivities);
		
		addActivities.click();
		
		logger.log(Status.PASS , "add update to activities");
		
	}
	
	public void ChangeDetailsOnTheScreen(String tag)throws InterruptedException {
		
		waitForVisibility(assigneeOnTheScreen);
			
		assigneeOnTheScreen.click();
			
			
		waitForVisibility(chooseAssigneeOnTheScreen);
			
		chooseAssigneeOnTheScreen.click();
			
		logger.log(Status.PASS , "add assignee to entity");
			
			
		waitForVisibility(dateOnTheScreen);
				
		dateOnTheScreen.click();
				
		
		waitForVisibility(chooseDateOnTheScreen);
				
		chooseDateOnTheScreen.click();
				
		logger.log(Status.PASS , "add date to entity");
		
		
		waitForVisibility(changeStatusOnTheScreen);
		
		changeStatusOnTheScreen.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(chooseStatusOnTheScreen);
	
		chooseStatusOnTheScreen.click();
		
		logger.log(Status.PASS , "add status to entity");
		
		
		waitForVisibility(chooseThreeDotsOnScreen);
		
		chooseThreeDotsOnScreen.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(chooseDelete);
		
		chooseDelete.click();
		
		logger.log(Status.PASS , " delete the entity");
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		waitForVisibility(chooseFavorite);
		
		chooseFavorite.click();
		
		
		 Thread.sleep(2000);
		 waitForVisibility(chooseSortByFavorite);
		
		 chooseSortByFavorite.click();
		
		 Thread.sleep(2000);
		 
		 logger.log(Status.PASS , " sort By Favorite");
		 
		 
		/*
		waitForVisibility(tagsOnTheScreen);
		
		tagsOnTheScreen.click();
		
		tagsOnTheScreen.sendKeys(tag);
	*/
	}

	
	
		
	}
	
	
		
	

	

	
