
package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;;

public class documentsTest extends testBase {
	
	actionsMultipleSelect actionmultipleselect;
	documentsMultipleSelect documentsmultipleselect;
	documentsMiddlePane documentsmiddlepane;
	middlePane middlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	this.actionmultipleselect = new actionsMultipleSelect();
	this.documentsmultipleselect = new documentsMultipleSelect();
	this.documentsmiddlepane = new documentsMiddlePane();
	this.middlepane = new middlePane();
	this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
	this.actionsmiddlepane = new actionsMiddlePane();
	this.actionsrightside = new actionsRightSide();
	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsmultipleselect.pressDocument();
	  
		//open doc  enter title and description
		actionsmiddlepane.openEntity("doc1" , "importenet");
	}
	
	@Test(priority = 2)
		public void delete() throws InterruptedException {
		
		logger = extent.createTest("delete using multiple choice");
		// delete entity using multiple select
		actionmultipleselect.deleteEntityMultipleChoice();
		}
		
	@Test(priority = 3)
		public void tags() throws InterruptedException {
		
		logger = extent.createTest("tags using multiple choice");
		// add tags using multiple select
		actionmultipleselect.addTagsMultipleChoice("mission");
		}
		
	
	@Test(priority = 4)
		public void date() throws InterruptedException {
		logger = extent.createTest("date using multiple choice");
		//add date using multiple select
		actionmultipleselect.addDateMultipleChoice();
	}
		@Test(priority = 5)
		public void assignee() throws InterruptedException {
		logger = extent.createTest("assignee using multiple choice");
		//add assignee using multiple select
		actionmultipleselect.addAssigneeMultipleChoice();
		}
		@Test(priority = 6)
		public void watchers() throws InterruptedException {
		
		logger = extent.createTest("watchers using multiple choice");
		//add watchers using multiple select 
		actionmultipleselect.addWatchersMultipleChoice();
		}
		
		@Test(priority = 7)
		public void status() throws InterruptedException {
		logger = extent.createTest("status using multiple choice");
		//add status using multiple select
		actionmultipleselect.addStatusMultipleChoice();
		
	}
	
	@Test(priority = 8)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("document middle pane");
		
		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
		
		// choose entity and press on favorite 
		//actionsmiddlepane.sortByFavorite();
		
		// sort the list by title
		actionsmiddlepane.sordByTitle();
		
		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();
		
		// press on arrow to reverse the order of the list
		//actionsmiddlepane.pressOnArrow();
	}
	
	@Test(priority = 9)
	public void documentsRightSideOfScreen() throws InterruptedException {
		
		logger = extent.createTest("document the right side on the screen");
		
		actionsrightside.deleteEntity();
		
		actionsrightside.addAssignee();
		
		actionsrightside.setDate();
		
		documentsrhigtsideonscreen.addStatus();
		
		documentsrhigtsideonscreen.SelectFolderOnScreen();
		
		actionsrightside.addTags("www");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
		
		actionsrightside.addWatcher();
		
	}
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


