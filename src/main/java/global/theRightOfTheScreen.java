package global;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class theRightOfTheScreen extends TestBase {

	@FindBy(className ="detail-favorite" )
	public	WebElement chooseFavorite;
	
	@FindBy(css = "[tooltip-template='Assignee']")
	public	WebElement assigneeOnTheScreen;
	
	@FindBy(xpath ="//*[@id=\"ui-select-choices-row-49-1\"]/span/span")
	public	WebElement chooseAssigneeOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	public	WebElement dateOnTheScreen;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]")
	public	WebElement chooseDateOnTheScreen;
	
	@FindBy(css = "[list='statuses']")
	public	WebElement pressToChangeStatusOnTheScreen;
	
	@FindBy(css = "[ng-if='$select.open']")
	public List<WebElement>  listOfStatusOnScreen = new ArrayList<>();
	
	@FindBy(className = "dropdown-trigger")
	public	WebElement chooseThreeDotsOnScreen;
	
	@FindBy(css = "[ng-click='item.action()']")
	public	WebElement chooseDelete;
	
	@FindBy (xpath = "//*[@id=\"addTag\"]/span/span/span[2]/span")
	public	WebElement tagsOnTheScreen;

	@FindBy(css = "[ng-blur='minimizeUpdate()']")
	public	WebElement updateActivities;
	
	@FindBy(css = ".save.ng-binding")
	public	WebElement addActivities;
	
	@FindBy(css ="[tooltip-template='Add watcher']")
	public	WebElement pressOnAddWatcherOnTHeScreen;
	
	@FindBy(css = "[autofocus='autofocus']")
	public	WebElement selectMembers;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-87-3\"]/span/span")
	public	WebElement chooseWatchersOnscreen;
	
	@FindBy(className = "delete-wrapper")
	public List<WebElement>  listOfWatchersOnScreen = new ArrayList<>();
	
	 public theRightOfTheScreen  () {
			
		    PageFactory.initElements(driver, this);
		    	
		   }
}
