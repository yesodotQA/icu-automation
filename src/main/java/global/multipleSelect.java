package global;


import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class multipleSelect extends TestBase {
	
	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	public  WebElement pressMultipleChoice;
	
	@FindBy(css = ".multipleSelected .tick .ng-valid")
	public	WebElement pressSecondMultipleChoice;
	
	// elements of delete multiple choice
	@FindBy (className =  "delete")
	public 	WebElement pressDeleteMultipleChoice;

	@FindBy (className = "action-button")
	public 	WebElement deleteMultipleChoice;
	
	// elements of add tags multiple choice
	@FindBy (className = "tag")
	public	WebElement TagsMultipleChoice;
	
	@FindBy (css = "[style='width: 501px;']")
	public	WebElement selectTags;
	
	@FindBy(className = "ui-select-choices-row-inner")
	public	WebElement clickOnNewTAg;
	
	@FindBy (className = "action-button")
	public	WebElement updateTags;
	
	//elements of add date multiple select
	@FindBy(className = "due")
	public	WebElement pressOnDateMultipleSelect;
	
	@FindBy(className = "hasDatepicker")
	public	WebElement pressToChooseDate;
	
	@FindBy(className = "ui-icon-circle-triangle-e")
	public WebElement nextMonth;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a")
	public	WebElement chooseADate;
	
	@FindBy(css = "[ui-date='dueOptions']")
	public WebElement getTextOfDate;
	
	@FindBy (className = "action-button")
	public	WebElement updateDate;
	
	//elements of add assignee
	@FindBy(className = "assign")
	public	WebElement pressAssigneeMultipleChoice;
	
	@FindBy(xpath = "//*[@id=\"modalBulk\"]/section/tooltip/tip-cont/div/div/div[1]/span/span[1]")
	public	WebElement selectAssignee;
	
	@FindBy(className = "ui-select-choices-row-inner")
	public List<WebElement>  listOfAssignees = new ArrayList<>();
	
	@FindBy(css = "#ui-select-choices-row-31-1 > span > span")
	public WebElement assigneeName;
	
	@FindBy(className = "action-button")
	public	WebElement updateAssignee;
	
	//elements of add watchers
	@FindBy(className = "watchers")
	public	WebElement pressWatchersMultipleChoice;

	@FindBy(className =  "add")
	public	WebElement addWatchers;
	
	@FindBy(css = "[autofocus='autofocus']")
	public	WebElement selectMembers;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-38-0\"]/span")
	public	WebElement chooceWatchers;
	
	@FindBy(css = "[user='member']")
	public List<WebElement> listOfWatchersMultipleSelect = new ArrayList<>();
	
	@FindBy(className = "action-button")
	public	WebElement updateWatchers;
	
	//elements of add watchers
	@FindBy(className = "status")
	public	WebElement pressStatusMultipleChoice;
	
	@FindBy(className = "text-muted")
	public	WebElement selectStatus;

	@FindBy(css ="[ng-if='$select.open']")
	public List<WebElement> listOfStatus = new ArrayList<>();
	
	@FindBy(className = "action-button")
	public	WebElement updateStatus;
	
	

	
	public multipleSelect () {
		
	    PageFactory.initElements(driver, this);
	    	
	   }

	
	
}
