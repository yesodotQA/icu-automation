package pages;

import java.awt.Dimension;
import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class documentObjects extends TestBase {
	
	private static final String String = null;

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
	/*
	@FindAll({
		
		@FindBy(css ="[data-ng-repeat='item in visibleItems']")
	})
	
	public List<WebElement>  listOfEntities;
	*/
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
		
	@FindBy(css ="[alt='yaron']")
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
	
	//elements of add watchers
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
	

	// function for wait
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
	public documentObjects() {
		
	 	PageFactory.initElements(driver, this);
	}
	
	
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
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressDeleteMultipleChoice);
		
		pressDeleteMultipleChoice.click();
		
		
		waitForVisibility(deleteMultipleChoice);
		
		deleteMultipleChoice.click();
		
	
		Thread.sleep(2000);
		
		
		logger.log(Status.PASS , "delete document using mulitiple choice");
			
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
	
	 
	
		
	
}
	

	
