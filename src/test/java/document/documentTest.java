package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import global.middlePane;
import pages.documentsMultipleSelect;
import pages.documentsMiddlePane;;

public class documentTest extends TestBase {
	
	documentsMultipleSelect documentsmultipleselect;
	
	documentsMiddlePane documentsmiddlepane;
	middlePane middlepane;
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	documentsmultipleselect = new documentsMultipleSelect();
	documentsmiddlepane = new documentsMiddlePane();
	middlepane = new middlePane();
	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsmultipleselect.pressDocument();
	  
		//open doc  enter title and description
		middlepane.openEntity("doc1" , "importenet");
	}
	
	@Test(priority = 2)
	public void documentsMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("document using multiple choice");
		
		// delete entity using multiple select
		documentsmultipleselect.deleteEntityMultipleChoice();
		
		// add tags using multiple select
		documentsmultipleselect.addTagsMultipleChoice("mission");
		
		//add date using multiple select
		documentsmultipleselect.addDateMultipleChoice();
	
		//add assignee using multiple select
		documentsmultipleselect.addAssigneeMultipleChoice();
		
		//add watchers using multiple select 
		documentsmultipleselect.addWatchersMultipleChoice();
		
		//add status using multiple select
		documentsmultipleselect.addStatusMultipleChoice();
		
	}
	
	
	@Test(priority = 3)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("document mmiddle pane");
		
		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
		
		// choose entity and press on favorite 
		documentsmiddlepane.sortByFavorite();
		
		// press on arrow to reverse the order of the list
		documentsmiddlepane.pressOnArrow();
		
		// sort the list by title
		documentsmiddlepane.sordByTitle();
		
		// press on sort by status and unread
		documentsmiddlepane.sordByStatusAndUnread();
	}
	
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


