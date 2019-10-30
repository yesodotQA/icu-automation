package Search;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import pages.Search.SearchFunction;
import pages.Search.SearchMultipleSelect;
import pages.Search.deletedItems;

public class searchTest extends testBase {

	deletedItems deleteditems;
	actionsMultipleSelect actionmultipleSelect;
	SearchMultipleSelect searchMulti;
	SearchFunction searchfunction;
	actionsRightSide actionrightside;
	
	
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	

		this.deleteditems = new deletedItems();
		this.actionmultipleSelect = new actionsMultipleSelect();
		this.searchMulti = new SearchMultipleSelect();
		this.searchfunction = new SearchFunction();
		this.actionrightside = new actionsRightSide();
	}

		@Test(priority = 1)
		public void searchEntityAndFilter() throws InterruptedException {
			logger = extent.createTest("search and filter");
	
			searchfunction.searchEntities();
			searchfunction.tabsFilter();
			searchfunction.settingFilter();
			searchfunction.ActiveAndArchivedFilter();	
		}
	
	
			
	@Test (priority = 2)
	public void multipleSelectOnTheEntityFound() throws InterruptedException {
		logger = extent.createTest("search multiple choice");

		searchMulti.getToSearchMultipleSelect();
		searchMulti.addTagsMultipleSelectSearch("www");
		searchMulti.addDateMultipleSelectSearch();
		searchMulti.addAssigneeMultipleChoiceSearch();
		searchMulti.addWatchersMultipleChoiceSearch();
		searchMulti.addStatusMultipleChoiceSearch();	
		searchMulti.deleteMultipleSelectSearch();


	}
	@Test (priority = 3)
	public void	rightSideOnTheEntityFound() throws InterruptedException {
		logger = extent.createTest("search right side");
		actionrightside.addAssignee(false);
		actionrightside.setDate();
		actionrightside.addTags("finish");
		actionrightside.addActivities("finishhh", "aoutomation");
		actionrightside.addWatcher();
	}
	
		@Test (priority =4)
		public void deleteItems() throws InterruptedException {
			logger = extent.createTest("delete items");

			deleteditems.searchDeleteItems();
			deleteditems.unDelete();
		}
	 

	@AfterClass
	public void after() {

		extent.flush();

	}

}
