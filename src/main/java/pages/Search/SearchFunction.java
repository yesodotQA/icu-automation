package pages.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;


public class SearchFunction extends testBase {
	deletedItems        deleteditems;
	Tabs 			  	tabs;
	middlePane 			middlepane;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleSelect;
	actionsRightSide    actionsrightside;

	public SearchFunction() {

		this.deleteditems        = new deletedItems();
		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleSelect		 = new multipleSelect();
		this.actionsrightside    = new actionsRightSide();
		this.middlepane 		 = new middlePane();

		PageFactory.initElements(driver, this);
	}

	String[] EntitiesTitle = {"task", "project", "meetings",  "doc","folder","office","file"};
	String[] EntitiesTags  = {"0", "AAA", "BBB", "CCC", "DDD"};
	String[] EntitiesSettingsTag = {"EEE", "FFF", "GGG"};
	String Description     = "related to Search";

	int counter			   = 0;
	int statusIndex        = 1;
	int ResultsNumber = 0;
	int toInt = 0;
	String stringResult;

	@FindBy (className = "menu-item")
	List <WebElement> TabsList = new ArrayList<WebElement>();

	@FindBy (css = ".issue .ng-scope")
	List <WebElement> EntitiesFilters = new ArrayList<>();

	@FindBy (className = "all")
	List <WebElement> settingsList = new ArrayList<>();

	@FindBy (className = "all-status")
	List <WebElement> AllStatus = new ArrayList<>();

	@FindBy (className =  "detail-status")
	WebElement statusBox;

	@FindBy (className = "clear ng-binding")
	List <WebElement> Clearbuttons = new ArrayList<>();

	@FindBy (css = "data-ng-repeat=\"result in results | searchResultsFilter | filteringByUpdated\"")
	List<WebElement> SearchResults = new ArrayList<>();

	@FindBy (className = "show-more" )
	WebElement ShowMore;

	@FindBy (css = "[placeholder='Search']")
	WebElement SearchInput;

	@FindBy (id = "dp1569329320009")
	WebElement ShowResultsByDate;

	@FindBy (css = "class=\"recycle ng-binding\"")
	WebElement ShowDeletedItems;

	@FindBy (css = "[class='status ng-binding']")
	List<WebElement> StatusFilter = new ArrayList<WebElement>();

	@FindBy (css = "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div > div > h1")
	WebElement ResultsFound;

	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> possibleStatus = new ArrayList<>();

	@FindBy (css ="[value='item.status']")
	WebElement statusName;

	@FindBy (css = ".entity-details .ng-binding.ng-scope")
	WebElement AmountOfResults; 

	@FindBy(css ="[ng-mouseleave='hideTick(result)']")
	public List<WebElement>  listOfsearch = new ArrayList<>();

	private void waitForVisibility (WebElement element)  {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void splitFilter(String task, int change) { 

		String[] array = task.split(" ");

		char letter = array[1].charAt(1);

		change = Character.getNumericValue(letter);

		this.toInt = change;

	}

	public void splitNumberOfResults(String text, int intNumber) {

		text= AmountOfResults.getText();

		String[] ArraySplit = text.split(" ");

		intNumber = Integer.parseInt(ArraySplit[0]);

		this.ResultsNumber = intNumber;		
	}

	public void changeStatus () throws InterruptedException  {

		Random rand = new Random();


		waitForVisibility(statusBox);
		statusBox.click();
		Thread.sleep(1500);

		possibleStatus.get(rand.nextInt(possibleStatus.size())).click();

	}


	public void tabsFilter () throws InterruptedException {

		for (int i = 1; i < TabsList.size()-1 ; i++) {


			TabsList.get(i).click();

			Thread.sleep(1500);

			waitForVisibility(middlepane.pressCreateNewItem);

			actionsmiddlepane.openEntity(EntitiesTitle[counter], Description);

			counter++;

		}



		tabs.searchTab.click();

		for (int i = 0; i <= 3; i++) {

			waitForVisibility(SearchInput);
			SearchInput.sendKeys(EntitiesTitle[i]);


			Thread.sleep(2000);

			String tasksFilter =  EntitiesFilters.get(i).getText();

			splitFilter(tasksFilter,toInt);


			Thread.sleep(1500);


			EntitiesFilters.get(i).click();

			Thread.sleep(1500);

			splitNumberOfResults(stringResult,ResultsNumber);

			int listSearch = listOfsearch.size();


			if (toInt == ResultsNumber && listSearch == toInt && listSearch == ResultsNumber) {

				logger.log(Status.PASS, "filter by" + " " + EntitiesTitle[i]);
			}
			else {
				logger.log(Status.FAIL, "filter by" + " " + EntitiesTitle[i] + "not working");
			}


			SearchInput.clear();

			Thread.sleep(1500);

		}
	}

	public void settingFilter() throws InterruptedException {
		
		
		tabs.settingsTab.click();
		
		Thread.sleep(1500);
		for (int index = 0; index < settingsList.size()-1; index++) {

			settingsList.get(index).click();
			
			Thread.sleep(3000);
			actionsmiddlepane.openEntity(EntitiesTitle[counter], Description);

			counter++;

			Thread.sleep(1500);
		}

		tabs.searchTab.click();

		for (int i = 3; i < 6 ; i++) {

			SearchInput.sendKeys(EntitiesTitle[i+1]);


			Thread.sleep(2000);

			String tasksFilter =  EntitiesFilters.get(i+1).getText();

			splitFilter(tasksFilter,toInt);


			Thread.sleep(1500);


			EntitiesFilters.get(i+1).click();

			Thread.sleep(1500);

			splitNumberOfResults(stringResult,ResultsNumber);

			int listSearch = listOfsearch.size();


			if (toInt == ResultsNumber && listSearch == toInt && listSearch == ResultsNumber) {

				logger.log(Status.PASS, "filter by" + " " + EntitiesTitle[i]);
			}
			else {
				logger.log(Status.FAIL, "filter by" + " " + EntitiesTitle[i] + "not working");
			}

			SearchInput.clear();

			Thread.sleep(1500);
		}
	}

	public void ActiveAndArchivedFilter () throws InterruptedException {

		final int RUNNIG_NUMBER = 3;
		int	counterActive = 0;
		int	counterArchive = 0;
		String FilterTitle = "check status filtered";

		String[] Active = {"New","Assigned","In progress","Review" };
		String[] Archive = {"Rejected","Done"};
		int i = 0;


		waitForVisibility(tabs.tasksTab);
		tabs.tasksTab.click();

		while ( i < RUNNIG_NUMBER ) {

			Thread.sleep(1500);
			waitForVisibility(middlepane.pressCreateNewItem);
			actionsmiddlepane.openEntity(FilterTitle , "no need");
			changeStatus();

			Thread.sleep(1500);

			for (int j = 0; j < Active.length; j++) {

				if (Active[j].equals(statusName.getText())) {
					counterActive++;
					System.out.println(statusName.getText());
				}
			}

			Thread.sleep(1500);

			for (int g = 0; g < Archive.length; g++) {

				if (Archive[g].equals(statusName.getText())) {
					counterArchive++;
					System.out.println(statusName.getText());
				}
			}

			i++;
		}
		tabs.searchTab.click();
		Thread.sleep(1500);

		WebElement activeButton = StatusFilter.get(0);
		WebElement archiveButton = StatusFilter.get(1);

		SearchInput.sendKeys(FilterTitle);

		Thread.sleep(1500);
		String amount = AmountOfResults.getText();
		String[] ArraySplit = amount.split(" ");
		ResultsNumber = Integer.parseInt(ArraySplit[0]);

		if (ResultsNumber == RUNNIG_NUMBER) {

			logger.log(Status.PASS , "open all Entities successfully!");
		}
		
		else {

			logger.log(Status.FAIL , "Faile d on open all entities.");
		}	

		Thread.sleep(1500);
		activeButton.click();
		amount = AmountOfResults.getText();
		ArraySplit = amount.split(" ");
		ResultsNumber = Integer.parseInt(ArraySplit[0]);

		if (ResultsNumber == counterActive) {

			logger.log(Status.PASS , "Active filter work good!");
		}
		else {

			logger.log(Status.FAIL , "active filter not working :( ");
		}

		Thread.sleep(1500);
		archiveButton.click();
		amount = AmountOfResults.getText();
		ArraySplit = amount.split(" ");
		ResultsNumber = Integer.parseInt(ArraySplit[0]);


		if (ResultsNumber == counterArchive) {

			logger.log(Status.PASS , "Archive filter work good!");
		}
		else {

			logger.log(Status.FAIL , "Archive filter not working :( ");
		}

	}

	public void searchEntities() throws InterruptedException {

		String TagSearch = "searchtag";

		String[] SearchTest = { "Entity", "Entity1", "Entity 2"};

		int[]resultsfound  = {3,1,2};

		waitForVisibility(tabs.tasksTab);
		tabs.tasksTab.click();
		Thread.sleep(1500);

		for(int j = 0;j<3; j++) {
			actionsmiddlepane.openEntity(SearchTest[j], "kalamari");
			if (j == 0) {
				actionsrightside.addTags(TagSearch);
			}
		}

		SearchInput.sendKeys("Ent");

		Thread.sleep(1500);
		String amount = AmountOfResults.getText();

		String[] ArraySplit = amount.split(" ");

		ResultsNumber = Integer.parseInt(ArraySplit[0]);


		Thread.sleep(1500);
		if(	ResultsNumber == resultsfound[0]) 
			logger.log(Status.PASS,"succssed to search with 3 letters");

		else
			logger.log(Status.FAIL,"failed to search 3 letters");

		Thread.sleep(1500);
		SearchInput.clear();
		SearchInput.sendKeys(SearchTest[1]);
		Thread.sleep(1500);

		amount = AmountOfResults.getText();

		ArraySplit = amount.split(" ");

		ResultsNumber = Integer.parseInt(ArraySplit[0]);

		Thread.sleep(1500);

		if(ResultsNumber == listOfsearch.size()) 

			logger.log(Status.PASS,"connected numbers & letters passed");

		else
			logger.log(Status.FAIL,"failed to search connected letters");


		Thread.sleep(1500);
		SearchInput.clear();
		SearchInput.sendKeys(SearchTest[2]);

		Thread.sleep(1500);
		amount = AmountOfResults.getText();

		ArraySplit = amount.split(" ");

		ResultsNumber = Integer.parseInt(ArraySplit[0]);


		if(ResultsNumber == listOfsearch.size()) 
			logger.log(Status.PASS,"regular numbers & letters passed");

		else
			logger.log(Status.FAIL,"failed to search regular letters and numbers ");


		Thread.sleep(1500);
		SearchInput.clear();
		SearchInput.sendKeys(TagSearch);

		Thread.sleep(1500);

		amount = AmountOfResults.getText();

		ArraySplit = amount.split(" ");

		ResultsNumber = Integer.parseInt(ArraySplit[0]);

		if(ResultsNumber == listOfsearch.size()) 
			logger.log(Status.PASS,"search by tag passed");

		else
			logger.log(Status.FAIL,"failed to search by tag ");


		Thread.sleep(1500);
		SearchInput.clear();
		SearchInput.sendKeys("Kalamari");
		Thread.sleep(1500);

		amount = AmountOfResults.getText();

		ArraySplit = amount.split(" ");

		ResultsNumber = Integer.parseInt(ArraySplit[0]);


		if(ResultsNumber == listOfsearch.size()) 
			logger.log(Status.PASS,"search by description passed");

		else
			logger.log(Status.FAIL,"failed to search by description ");

	}

}



