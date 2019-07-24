package global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class theRightOfTheScreen {

	@FindBy(className ="detail-favorite" )
	WebElement chooseFavorite;
	
	@FindBy(className = "summary-content")
	WebElement assigneeOnTheScreen;
	
	@FindBy(xpath ="//*[@id=\"ui-select-choices-row-49-1\"]/span/span")
	WebElement chooseAssigneeOnTheScreen;
	
	@FindBy(css = "[ui-date='dueOptions']")
	WebElement dateOnTheScreen;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]")
	WebElement chooseDateOnTheScreen;
	
	@FindBy(css = "[list='statuses']")
	WebElement changeStatusOnTheScreen;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-50-4\"]/span/i")
	WebElement chooseStatusOnTheScreen;
	
	@FindBy(className = "dropdown-trigger")
	WebElement chooseThreeDotsOnScreen;
	
	@FindBy(css = "[ng-click='item.action()']")
	WebElement chooseDelete;
	
	@FindBy(css = "[ng-blur='minimizeUpdate()']")
	WebElement updateActivities;
	
	@FindBy(css = ".save.ng-binding")
	WebElement addActivities;
	
	@FindBy(css ="[tooltip-template='Add watcher']")
	WebElement pressOnAddWatcherOnTHeScreen;
	
	@FindBy(css = "[autofocus='autofocus']")
	WebElement selectMembers;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-87-3\"]/span/span")
	WebElement chooseWatchersOnscreen;
	
}
