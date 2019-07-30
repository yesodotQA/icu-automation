package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.documentsMultipleSelect;
import pages.documentsMiddlePane;;

public class documentTest extends TestBase {
	
	documentsMultipleSelect documentsmultipleselect;
	
	documentsMiddlePane documentsmiddlepane;
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	documentsmultipleselect = new documentsMultipleSelect();
	documentsmiddlepane = new documentsMiddlePane();
	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsmultipleselect.pressDocument();
	  
		//open doc  enter title and description
		documentsmiddlepane.openEntity("doc1" , "importenet");
	}
	
	@Test(priority = 2)
	public void documentsMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("document using multiple choice");
		
		// delete entity using multiple select
		documentsmultipleselect.deleteEntityMultipleChoice();
		
		documentsmultipleselect.addTagsMultipleChoice("mission");
		
		documentsmultipleselect.addDateMultipleChoice();
	
		documentsmultipleselect.addAssigneeMultipleChoice();
		
		documentsmultipleselect.addWatchersMultipleChoice();
		
		documentsmultipleselect.addStatusMultipleChoice();
		
	}
	
	
	@Test(priority = 3)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("document mmiddle pane");
		
		
		documentsmiddlepane.changeStatusOfList();
		
		documentsmiddlepane.sortByFavorite();
		
		documentsmiddlepane.pressOnArrow();
	}
	
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


