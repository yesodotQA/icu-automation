package global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class middlePane extends TestBase {

	@FindBy(css = "[ng-model='newItem']")
	WebElement pressCreateNewItem;
	
	@FindBy(className = "item-title")
	WebElement enterTitle;
	
	@FindBy(css = "[ng-model='item.description']")
	WebElement description;
	
	@FindBy(css = ".sortByStar .favorites")
	WebElement pressOnSortByStar;
	
	@FindBy(className = "active-status")
	WebElement sortByStatus;
	
	@FindBy(xpath ="//*[@id=\"ui-select-choices-row-45-2\"]")
	WebElement chooceToSortByAll;
	
	@FindBy(xpath =  "//*[@id=\"ui-select-choices-row-51-1\"]/span")
	WebElement chooceToSortByArchived;
	
	@FindBy(className = "button-left-part")
	WebElement prssarrow;
	
	@FindBy(className =  "button-right-part")
	WebElement pressOnSortButton;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-0\"]/span/span")
	WebElement pressSortByTitle;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-1\"]/span/span")
	WebElement pressOnStatus;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-3\"]/span/span")
	WebElement pressOnUnread;
	
	
	 public middlePane () {
			
		    PageFactory.initElements(driver, this);
		    	
		   }

	
	
	
}
