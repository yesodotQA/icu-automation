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

public class SearchFunction extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	actionsRightSide    actionsrightside;
	actionsMiddlePane   actionmiddlepane;
	public SearchFunction() {

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
	


	String [] namesOfEntities = {"task" ,"project" , "meetings" ,"documents"};

	String [] namesOfSettings = {"folder" ,"offices" ,"templatedoc"};

	String Entities  = "ENTITIES";
	
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	
	public void  searchEntities()throws InterruptedException{
		
		for (int i = 1; i < tabsList.size()-1; i++) {
			
			logger = extent.createTest(namesOfEntities[i-1] );
			
			Thread.sleep(1000);
			tabsList.get(i).click();

			Thread.sleep(2000);
			actionmiddlepane.openEntity(namesOfEntities[i-1], "dsada");
		}
		
		
		tabs.settingsTab.click();
		
		Thread.sleep(2000);
		
		for (int i = 0; i < settingsList.size(); i++) {

			logger = extent.createTest(namesOfSettings[i]);
			
			Thread.sleep(1000);
			settingsList.get(i).click();

			Thread.sleep(2000);
			actionmiddlepane.openEntity(namesOfSettings[i], "dsada");
		}
		
		waitForVisibility(tabs.searchTab);
		tabs.searchTab.click();
		
		Thread.sleep(2000);
		
		logger = extent.createTest("find  items");
		for (int i = 0; i < 4; i++) {
			
			searchFields.sendKeys(namesOfEntities[i]);
			

			Thread.sleep(2000);

			String nameOfEntities = nameOfEntitiesFound.get(0).getText();
			
			

			if (namesOfEntities[i].equals(nameOfEntities)) {

				logger.log(Status.PASS , "find entity" + " " +  namesOfEntities[i] );
			}

			else {

				logger.log(Status.FAIL , "find  entity" + " " +  namesOfEntities[i] );
			}

			searchFields.clear();
		}
		

		for (int i = 0; i < 3; i++) {

			searchFields.sendKeys(namesOfSettings[i]);

			Thread.sleep(2000);

			String nameOfEntities =nameOfEntitiesFound.get(0).getText();

			if (namesOfSettings[i].equals(nameOfEntities)) {

				logger.log(Status.PASS , "find  entity" + " " + namesOfSettings[i] );
			}

			else {

				logger.log(Status.FAIL , "find  entity" + " " +  namesOfSettings[i] );
			}
			
			searchFields.clear();
		}
	}
	
	public void searchUsingFilter() throws InterruptedException {
		
		for (int i = 1; i < tabsList.size()-1; i++) {
			
			logger = extent.createTest("filter");
			Thread.sleep(1000);
			tabsList.get(i).click();
			
			for (int j = 0; j < 3; j++) {
				
				Thread.sleep(1000);
				actionmiddlepane.openEntity(Entities, "dsada");
			}
		}	

		tabs.settingsTab.click();

		Thread.sleep(2000);

		for (int i = 0; i < settingsList.size(); i++) {
			
				Thread.sleep(1000);
				settingsList.get(i).click();

				for (int j = 0; j < 3; j++) {

					Thread.sleep(1000);
					actionmiddlepane.openEntity(Entities, "dsada");
				}
		}

		waitForVisibility(tabs.searchTab);
		tabs.searchTab.click();

		Thread.sleep(2000);

		searchFields.sendKeys(Entities);
		
		Thread.sleep(2000);
		
		
	


	}

}

	

















	
	


