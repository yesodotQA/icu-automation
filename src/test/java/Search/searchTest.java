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
	public void searchEntities() throws InterruptedException {
		logger = extent.createTest("search ecnities");

		searchfunction.searchEntities();
	}

	@Test(priority = 2)
	public void tabsFilter() throws InterruptedException {

		logger = extent.createTest("search ecnities By tab filtering");

		searchfunction.tabsFilter();

		searchfunction.settingFilter();

	}

	@Test(priority = 3)
	public void activeAndArchivedFilter() throws InterruptedException {

		logger = extent.createTest("search ecnities By active and archive filtering");

		searchfunction.ActiveAndArchivedFilter();	
	}

	@Test (priority = 4)
	public void multipleSelectOnTheEntityFoundAddTags() throws InterruptedException {
		logger = extent.createTest("search multiple choice add tags");

		searchMulti.getToSearchMultipleSelect();

		searchMulti.addTagsMultipleSelectSearch("www");
	}

	@Test (priority = 5)
	public void multipleSelectOnTheEntityFoundAddDate() throws InterruptedException {

		logger = extent.createTest("search multiple choice add date");

		searchMulti.addDateMultipleSelectSearch();
	}

	
	@Test (priority = 6)
	public void multipleSelectOnTheEntityFoundAddAssignee() throws InterruptedException {

		logger = extent.createTest("search multiple choice add assignee");

		searchMulti.addAssigneeMultipleChoiceSearch();	
	}

	@Test (priority = 7)
	public void multipleSelectOnTheEntityFoundAddWatchers() throws InterruptedException {

		logger = extent.createTest("search multiple choice add watchers");

		searchMulti.addWatchersMultipleChoiceSearch();
	}

	@Test (priority = 8)
	public void multipleSelectOnTheEntityFoundAddStatus() throws InterruptedException {

		logger = extent.createTest("search multiple choice add status");

		searchMulti.addStatusMultipleChoiceSearch();
	}

	@Test (priority = 9)
	public void multipleSelectOnTheEntityFoundDelete() throws InterruptedException {

		logger = extent.createTest("search multiple choice delete");

		searchMulti.deleteMultipleSelectSearch();

	}
	
	@Test (priority = 10)
	public void	rightSideOnTheEntityFoundAddAssignee() throws InterruptedException {
		
		logger = extent.createTest("search right side add assignee");
	
		actionrightside.addAssignee(false);
	}
	
	@Test (priority = 11)
	public void	rightSideOnTheEntityFoundSetDate() throws InterruptedException {
	
		logger = extent.createTest("search right side set date");
		
		actionrightside.setDate();
	}
	
	@Test (priority = 12)
	public void	rightSideOnTheEntityFoundAddTags() throws InterruptedException {
	
		logger = extent.createTest("search right side add tags");
		
		actionrightside.addTags("finish");
	}

	@Test (priority = 13)
	public void	rightSideOnTheEntityFoundAddActivities() throws InterruptedException {
	
		logger = extent.createTest("search right side add activities");
		
		actionrightside.addActivities("finishhh", "aoutomation");
	}
	
	@Test (priority = 14)
	public void	rightSideOnTheEntityFoundAddWatchers() throws InterruptedException {
		
		logger = extent.createTest("search right side add watchers");
	
		actionrightside.addWatcher();
	}
	
	@Test (priority = 15)
	public void searchDeleteItems() throws InterruptedException {
		
		logger = extent.createTest("search delete items");

		deleteditems.searchDeleteItems();
	}	
		
	@Test (priority = 16)
	public void deleteItems() throws InterruptedException {
		logger = extent.createTest("undelete items");

		deleteditems.unDelete();
	}


	@AfterClass
	public void after() {

		extent.flush();

	}

}
