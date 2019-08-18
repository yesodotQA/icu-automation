package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.testBase;
import global.globalActions.actionsMultipleSelect;
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
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	this.actionmultipleselect = new actionsMultipleSelect();
	this.documentsmultipleselect = new documentsMultipleSelect();
	this.documentsmiddlepane = new documentsMiddlePane();
	this.middlepane = new middlePane();
	this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
	
	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsmultipleselect.pressDocument();
	  
		//open doc  enter title and description
		middlepane.openEntity("doc1" , "importenet");
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
	
	
	@Test(priority = 3)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("document mmiddle pane");
		
		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
		
		// choose entity and press on favorite 
		//documentsmiddlepane.sortByFavorite();
		
		// sort the list by title
		documentsmiddlepane.sordByTitle();
		
		// press on sort by status and unread
		documentsmiddlepane.sordByStatusAndUnread();
		
		// press on arrow to reverse the order of the list
		// documentsmiddlepane.pressOnArrow();
	}
	
	@Test(priority = 4)
	public void documentsRightSideOfScreen() throws InterruptedException {
		
		logger = extent.createTest("document the right side on the screen");
		
		documentsrhigtsideonscreen.deleteEntityOnScreen();
		
		documentsrhigtsideonscreen.addAssigneeOnScreen();
		
		documentsrhigtsideonscreen.addDateOnScreen();
		
		documentsrhigtsideonscreen.addStatusOnScreen();
		
		documentsrhigtsideonscreen.SelectFolderOnScreen();
		
		documentsrhigtsideonscreen.addTagsOnScreen("www");
		
		documentsrhigtsideonscreen.addActivities("hyyyyyy" , "this is superman");
		
		documentsrhigtsideonscreen.addWatcherOnScreen();
		
	}
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


