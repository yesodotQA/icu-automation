package pages.Search;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class SearchmultipleSelect extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	actionsRightSide    actionsrightside;
	actionsMiddlePane   actionmiddlepane;
	public SearchmultipleSelect() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleSelect		 = new multipleSelect();
		this.actionsrightside    = new actionsRightSide();
		this.actionmiddlepane 	 = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "issue in issues")
	List <WebElement> EntitiesFilters = new ArrayList<>();
	
	@FindBy(className ="menu-item")
	List<WebElement> tabsList = new ArrayList<>();
	
	@FindBy(className = "all")
	List<WebElement> settingsList = new ArrayList<>();
	
	@FindBy (css ="[ng-change='search()")
	WebElement searchFields;
	
	@FindBy(className = "name")
	List<WebElement> nameOfEntitiesFound = new ArrayList<>();
	
	@FindBy (className = "clear ng-binding")
	List <WebElement> Clearbuttons = new ArrayList<>();

	@FindBy (css = "[ng-click='rowClicked(result)']")
	List<WebElement> SearchResults = new ArrayList<>();

	@FindBy (css = "ng-repeat=\"field in AllStatus track by $index | orderBy:field\"")
	List<WebElement> AllStatus = new ArrayList<>();
	
	@FindBy (className = "show-more ng-binding" )
	WebElement ShowMore;
	
	@FindBy (css = "placeholder=\"Search\"") 
	WebElement SearchInput;
	
	@FindBy (id = "dp1569329320009")
	WebElement ShowResultsByDate;
	
	@FindBy (css = "class=\"recycle ng-binding\"")
	WebElement ShowDeletedItems;
	

	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
 }
	
	