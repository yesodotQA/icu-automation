package pages.Search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.css.Counter;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class SearchFunction extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	actionsRightSide    actionsrightside;

	public SearchFunction() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleSelect		 = new multipleSelect();
		this.actionsrightside    = new actionsRightSide();

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "issue in issues")
	List <WebElement> EntitiesFilters = new ArrayList<>();
	
	@FindBy (className = "clear ng-binding")
	List <WebElement> Clearbuttons = new ArrayList<>();

	@FindBy (css = "data-ng-repeat=\"result in results | searchResultsFilter | filteringByUpdated\"")
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
	
	
	
}
	
