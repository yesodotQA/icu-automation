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
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class  SearchMultipleSelect extends testBase {

	Tabs 			  	tabs;
	actionsMiddlePane 	actionsmiddlepane;
	theRightOfTheScreen therightonthescreen;
	multipleSelect   	multipleselect;
	actionsRightSide    actionsrightside;
	actionsMultipleSelect actionmultipleselect;
	middlePane			middlepane;

	String nameOfEntity = "task200";

	@FindBy (css ="[ng-change='search()")
	WebElement searchFields;

	@FindBy(css ="[ng-mouseleave='hideTick(result)']")
	public List<WebElement>  listOfsearch = new ArrayList<>();

	@FindBy(css ="[ng-model='data.result.selected']")
	WebElement pressMultipleSelectSearch;

	@FindBy (id ="addTag")
	WebElement nameOfTagsMultipleChoice;

	@FindBy(css = "[ui-date='dueOptions']")
	WebElement getTextOfDate;

	@FindBy(css = "[activity-type='status']")
	WebElement pressStatusSearch;

	public SearchMultipleSelect() {

		this.tabs 				 = new Tabs();
		this.actionsmiddlepane   = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleselect	 	 = new multipleSelect();
		this.actionsrightside    = new actionsRightSide();
		this.middlepane			 = new middlePane();
		this.actionmultipleselect= new actionsMultipleSelect();
		PageFactory.initElements(driver, this);
	}

	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void getToSearchMultipleSelect() throws InterruptedException {

		waitForVisibility(tabs.tasksTab);

		tabs.tasksTab.click();


		Thread.sleep(1500);

		actionsmiddlepane.openEntity(nameOfEntity, "dsadasd");
	
		Thread.sleep(500);
		
		tabs.searchTab.click();

		Thread.sleep(500);
		
		searchFields.sendKeys(nameOfEntity);

		Thread.sleep(1500);

		if (listOfsearch.size() == 0) {

			logger.log(Status.FAIL, "The task was not found then the test of "
					+ "multiple choice and the right side did not run");
		}
	
	}

	public void deleteMultipleSelectSearch() throws InterruptedException {

		int size =listOfsearch.size() ;

		System.out.println(listOfsearch.size());


		Thread.sleep(1500);

		listOfsearch.get(0).click();


		Thread.sleep(1500);


		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();


		waitForVisibility(multipleselect.pressDeleteMultipleChoice);

		multipleselect.pressDeleteMultipleChoice.click();


		waitForVisibility(multipleselect.deleteMultipleChoice);

		multipleselect.deleteMultipleChoice.click();


		Thread.sleep(1500);

		int newSize =listOfsearch.size();

		System.out.println(listOfsearch.size());

		//check if the entity deleted
		if (size - 1 == newSize) {


			logger.log(Status.PASS , "delete  using mulitiple choice in search");

		}

		else {

			logger.log(Status.FAIL , "delete  using mulitiple choice in search");
		}

		Thread.sleep(1500);
		listOfsearch.get(0).click();

	}

	public void addTagsMultipleSelectSearch(String tags) throws InterruptedException {


		listOfsearch.get(0).click();


		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();

		Thread.sleep(2000);

		waitForVisibility(multipleselect.TagsMultipleChoice);

		multipleselect.TagsMultipleChoice.click();


		waitForVisibility(multipleselect.selectTags);

		multipleselect.selectTags.sendKeys(tags);

		waitForVisibility(multipleselect.clickOnNewTAg);

		multipleselect.clickOnNewTAg.click();


		Thread.sleep(2000);

		String nameOfTagsYouAdded = nameOfTagsMultipleChoice.getAttribute("innerText");


		waitForVisibility(multipleselect.updateTags);

		multipleselect.updateTags.click();

		Thread.sleep(1500);
		listOfsearch.get(0).click();


		Thread.sleep(2000);

		String check =nameOfTagsMultipleChoice.getText();


		// checks if the tags have been updated on the side of the screen
		if (check.equals(nameOfTagsYouAdded)) {

			logger.log(Status.PASS , "add Tags using multiple select search");
		}

		else {

			logger.log(Status.FAIL, "add Tags using multiple select search");
		}

	}

	public void addDateMultipleSelectSearch() throws InterruptedException {

		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();


		waitForVisibility(multipleselect.pressOnDateMultipleSelect);

		multipleselect.pressOnDateMultipleSelect.click();


		Thread.sleep(2000);
		waitForVisibility(multipleselect.pressToChooseDate);

		multipleselect.pressToChooseDate.click();

		Thread.sleep(2000);
		waitForVisibility(multipleselect.nextMonth);

		multipleselect.nextMonth.click();


		waitForVisibility(multipleselect.chooseADate);

		multipleselect.chooseADate.click();



		String nameOfDate = getTextOfDate.getAttribute("value");


		Thread.sleep(2000);
		waitForVisibility(multipleselect.updateDate);

		multipleselect.updateDate.click();

		Thread.sleep(1500);
		listOfsearch.get(0).click();


		Thread.sleep(3000);

		String nameOfDateOnScreen =therightonthescreen.dateOnTheScreen.getAttribute("value");

		System.out.println(nameOfDateOnScreen);
		// checks if the date have been updated on the side of the screen
		if (nameOfDateOnScreen.equals(nameOfDate)) {

			logger.log(Status.PASS , "add Date using multiple select");
		}

		else {

			logger.log(Status.FAIL, "add Date using multiple select");
		}

	}

	public void addAssigneeMultipleChoiceSearch() throws InterruptedException {

		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();


		waitForVisibility(multipleselect.pressAssigneeMultipleChoice);

		multipleselect.pressAssigneeMultipleChoice.click();


		waitForVisibility(multipleselect.selectAssignee);

		multipleselect.selectAssignee.click();

		Thread.sleep(3000);

		String nameOfAssignee = multipleselect.listOfAssignees.get(1).getText();

		multipleselect.listOfAssignees.get(1).click();


		waitForVisibility(multipleselect.updateAssignee);

		multipleselect.updateAssignee.click();


		Thread.sleep(1500);
		listOfsearch.get(0).click();

		Thread.sleep(2000);

		String nameOfAssigneeOnScreen= therightonthescreen.assigneeOnTheScreen.getText();

		// checks if the assignee have been updated on the side of the screen
		if (nameOfAssigneeOnScreen.equals(nameOfAssignee)) {

			logger.log(Status.PASS , "add assignee using multiple select");
		}

		else {

			logger.log(Status.FAIL, "add assignee using multiple select");
		}

	}

	public void addWatchersMultipleChoiceSearch() throws InterruptedException {


		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();


		waitForVisibility(multipleselect.pressWatchersMultipleChoice);

		multipleselect.pressWatchersMultipleChoice.click();

		Thread.sleep(2000);


		waitForVisibility(multipleselect.addWatchers);

		multipleselect.addWatchers.click();


		Thread.sleep(2000);


		waitForVisibility(multipleselect.selectMembers);

		multipleselect.selectMembers.click();


		Thread.sleep(2000);

		multipleselect.listToChooseWatchers.get(0).click();

		Thread.sleep(2000);


		int numberOfWatcherOnMultipleSelect = multipleselect.listOfWatchersMultipleSelect.size();


		waitForVisibility(multipleselect.updateWatchers);

		multipleselect.updateWatchers.click();


		Thread.sleep(1500);
		listOfsearch.get(0).click();


		Thread.sleep(2000);

		int numberOfWatchersOnScreen = therightonthescreen.listOfWatchersIcons.size() ;

		// checks if the watchers have been updated on the side of the screen
		if (numberOfWatchersOnScreen == numberOfWatcherOnMultipleSelect) {

			logger.log(Status.PASS , "add watchers using multiple select");
		}

		else {

			logger.log(Status.FAIL, "add watchers using multiple select");
		}


	}
	public void addStatusMultipleChoiceSearch() throws InterruptedException {

		waitForVisibility(pressMultipleSelectSearch);

		pressMultipleSelectSearch.click();

		Thread.sleep(1500);

		waitForVisibility(pressStatusSearch);

		pressStatusSearch.click();


		Thread.sleep(2000);
		waitForVisibility(multipleselect.selectStatus);

		multipleselect.selectStatus.click();


		Thread.sleep(3000);

		String nameOfStatus = multipleselect.listOfStatus.get(1).getText();

		multipleselect.listOfStatus.get(2).click();


		waitForVisibility(multipleselect.updateStatus);

		multipleselect.updateStatus.click(); 

		Thread.sleep(1500);
		listOfsearch.get(0).click();


		Thread.sleep(2000);

		String nameOfStatusOnScreen =therightonthescreen.pressToChangeStatusOnTheScreen.getText();

		// checks if the status have been updated on the side of the screen
		if (nameOfStatusOnScreen.equals(nameOfStatus)) {

			logger.log(Status.PASS , "add status using multiple select");
		}

		else {

			logger.log(Status.FAIL, "add status using multiple select");
		}



	}

}



