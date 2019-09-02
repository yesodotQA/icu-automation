package global.globalElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.testBase;

public class theRightOfTheScreen extends testBase {
	
	@FindBy(className ="detail-favorite" )
	public	WebElement chooseFavorite;
	
	@FindBy(css = "[tooltip-template='Assignee']")
	public	WebElement assigneeOnTheScreen;
	
	@FindBy(className ="ui-select-choices-row")
	public	List<WebElement> listOfAssigneeOnScreen = new ArrayList<>();
	
	@FindBy(css = "[ui-date='dueOptions']")
	public	WebElement dateOnTheScreen;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")
	public	WebElement chooseDateOnTheScreen;
	
	@FindBy(css = "[list='statuses']")
	public	WebElement pressToChangeStatusOnTheScreen;
	
	@FindBy(css = "[ng-if='$select.open']")
	public List<WebElement>  listOfStatusOnScreen = new ArrayList<>();
	
	@FindBy(className = "dropdown-trigger")
	public	WebElement pressOnThreeDotsOnScreen;
	
	@FindBy(css = "[ng-click='item.action()']")
	public	WebElement chooseDelete;
	
	@FindBy(className = "activities-list")
	public WebElement checkIfTheActivitiesUpdate;
	
	@FindBy(xpath = "//*[@id=\"addTag\"]/span/span/span[2]/span")
	public	WebElement tagsOnScreenForChecking;
	
	@FindBy(css = "[role='combobox']")
	public	WebElement enterTagsOnScreen;
	
	@FindBy(css ="[ng-if='$select.open']")
	public List<WebElement> listOfTagsOnScreen =  new ArrayList<>();
	
	@FindBy(css = "[ng-model='activity.description']")
	public	WebElement addActivities;
	
	@FindBy(css = ".save.ng-binding")
	public	WebElement updateActivities;
	
	@FindBy(css ="[tooltip-template='Add watcher']")
	public	WebElement pressOnAddWatcherOnTHeScreen;
	
	@FindBy(css = "[autofocus='autofocus']")
	public	WebElement selectMembers;
	
	@FindBy(css = "[ng-if='$select.open']")
	public List<WebElement>  listOfWatchersOnScreen= new ArrayList<>();
	
	@FindBy(className = "delete-wrapper")
	public List<WebElement>  listOfWatchersIcons = new ArrayList<>();
	
	@FindBy(className = "fa-chevron-down")
	public WebElement openColors;
	
	@FindBy(className = "big-color-box")
	public List<WebElement>  listOfColors = new ArrayList<>();
	
	 public theRightOfTheScreen  () {
			
		    PageFactory.initElements(driver, this);
		    	
		   }
}
