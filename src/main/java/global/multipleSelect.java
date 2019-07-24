package global;


import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class multipleSelect extends TestBase {
	
	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement pressMultipleChoice;
	
	@FindBy(css = ".multipleSelected .tick .ng-valid")
	WebElement pressSecondMultipleChoice;
	
	// elements of delete multiple choice
	@FindBy (className =  "delete")
	WebElement pressDeleteMultipleChoice;
	
	@FindBy (className = "action-button")
	WebElement deleteMultipleChoice;
		
	@FindBy(css ="[data-ng-repeat='item in visibleItems']")
	public List<WebElement>  listOfEntities = new ArrayList<>();
	
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
	
	public multipleSelect () {
		
	    PageFactory.initElements(driver, this);
	    	
	   }

	
	
}
