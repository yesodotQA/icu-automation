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

public class deletedItems extends testBase {

	Tabs tabs;
	actionsMiddlePane 	actionsmiddlepane;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsMiddlePane;
	actionsRightSide    actionsrightside;
	actionsMiddlePane actionmiddlepane;
	actionsMultipleSelect actionmultipleselect;

	@FindBy (className = "recycle")
	WebElement showDeletedItems;

	@FindBy (css ="[ng-change='search()")
	WebElement searchFields;

	@FindBy(className ="menu-item")
	List<WebElement> tabsList = new ArrayList<>();

	@FindBy(className = "all")
	List<WebElement> settingsList = new ArrayList<>();

	@FindBy(className = "name")
	List<WebElement> nameOfEntitiesFound = new ArrayList<>();

	@FindBy(css = ".fa.fa-2x.fa-times-circle")
	WebElement unDelete;

	@FindBy(css ="[ng-mouseleave='hideTick(result)']")
	List<WebElement> listOfDeletedEntities = new ArrayList<>();

	String [] namesOfEntities = {"deletetask" ,"deleteproject" , "deletemeetings" ,"deletedocuments"};

	String [] namesOfSettings = {"deletefolder" ,"deleteoffices" ,"deletetemplatedoc"};

	public deletedItems() {

		PageFactory.initElements(driver, this);
		this.tabs = new Tabs();
		this.actionsmiddlepane  = new actionsMiddlePane();
		this.therightonthescreen = new theRightOfTheScreen();
		this.multipleselect	= new multipleSelect();
		this.actionsrightside  = new actionsRightSide();
		this.actionmiddlepane = new actionsMiddlePane();
		this.actionmultipleselect = new actionsMultipleSelect();
		this.middlepane = new middlePane();
	}


	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}


	public void searchDeleteItems() throws InterruptedException {

		waitForVisibility(tabs.tasksTab);
		tabs.tasksTab.click();



		for (int i = 1; i < tabsList.size()-1; i++) {

			logger = extent.createTest(namesOfEntities[i-1] );

			Thread.sleep(2000);
			tabsList.get(i).click();

			Thread.sleep(2000);
			actionmiddlepane.openEntity(namesOfEntities[i-1], "dsada");

			actionmultipleselect.deleteEntityMultipleChoice();

		}

		Thread.sleep(2000);
		tabs.settingsTab.click();

		Thread.sleep(2000);

		for (int i = 0; i < settingsList.size(); i++) {

			logger = extent.createTest(namesOfSettings[i]);

			Thread.sleep(2000);
			settingsList.get(i).click();

			Thread.sleep(2000);
			actionmiddlepane.openEntity(namesOfSettings[i], "dsada");

			actionmultipleselect.deleteEntityMultipleChoice();
		}


		waitForVisibility(tabs.searchTab);
		tabs.searchTab.click();

		waitForVisibility(showDeletedItems);
		showDeletedItems.click();

		Thread.sleep(2000);


		logger = extent.createTest("find delete items");
		for (int i = 0; i < 4; i++) {

			searchFields.clear();
			searchFields.sendKeys(namesOfEntities[i]);

			Thread.sleep(2000);

			String nameOfDeletedEntities = nameOfEntitiesFound.get(0).getText();


			if (namesOfEntities[i].equals(nameOfDeletedEntities)) {

				logger.log(Status.PASS , "find delete entity" + " " +  namesOfEntities[i] );
			}

			else {

				logger.log(Status.FAIL , "find delete entity" + " " +  namesOfEntities[i] );
			}

		}

		for (int i = 0; i < 3; i++) {

			searchFields.clear();
			searchFields.sendKeys(namesOfSettings[i]);

			Thread.sleep(2000);

			String nameOfDeletedEntities =nameOfEntitiesFound.get(0).getText();


			if (namesOfSettings[i].equals(nameOfDeletedEntities)) {

				logger.log(Status.PASS , "find delete entity" + " " + namesOfSettings[i] );
			}

			else {

				logger.log(Status.FAIL , "find delete entity" + " " +  namesOfSettings[i] );
			}
		}
	}

	public void unDelete() throws InterruptedException {

		for (int i = 1; i < 5; i++) {


			searchFields.clear();
			searchFields.sendKeys(namesOfEntities[i-1]);


			Thread.sleep(3000);

			listOfDeletedEntities.get(0).click();

			waitForVisibility(therightonthescreen.pressOnThreeDotsOnScreen);
			therightonthescreen.pressOnThreeDotsOnScreen.click();

			Thread.sleep(2000);

			waitForVisibility(unDelete);
			unDelete.click();

			Thread.sleep(2000);

			tabsList.get(i).click();

			Thread.sleep(2000);

			String nameOfUnDeleteEntities = middlepane.listOfnamesOfEntities.get(0).getText();
	

				if (nameOfUnDeleteEntities.equals(namesOfEntities[i-1])) {
					
					logger.log(Status.PASS , "un delete entity" + " " + namesOfEntities[i-1] );
				}
			
			else {
				logger.log(Status.FAIL, "un delete entity" + " " + namesOfEntities[i-1]);
			}

			waitForVisibility(tabs.searchTab);
			tabs.searchTab.click();

			waitForVisibility(showDeletedItems);
			showDeletedItems.click();

			Thread.sleep(3000);

		}

		for (int j = 0; j < 3; j++) {


			searchFields.clear();
			searchFields.sendKeys(namesOfSettings[j]);

			Thread.sleep(2000);

			listOfDeletedEntities.get(0).click();

			waitForVisibility(therightonthescreen.pressOnThreeDotsOnScreen);
			therightonthescreen.pressOnThreeDotsOnScreen.click();

			Thread.sleep(2000);

			waitForVisibility(unDelete);
			unDelete.click();

			Thread.sleep(2000);

			tabs.settingsTab.click();

			Thread.sleep(2000);

			settingsList.get(j).click();

			Thread.sleep(2000);
			
			String nameOfUnDeleteEntities = middlepane.listOfnamesOfEntities.get(0).getText();


			if (nameOfUnDeleteEntities.equals(namesOfSettings[j])) {


				logger.log(Status.PASS , "un delete entity" + " " + namesOfSettings[j] );
			}
			else {
				logger.log(Status.FAIL, "un delete entity" + " " + namesOfSettings[j]);
			}

			waitForVisibility(tabs.searchTab);
			tabs.searchTab.click();

			waitForVisibility(showDeletedItems);
			showDeletedItems.click();

			Thread.sleep(3000);

		}

	}
}











