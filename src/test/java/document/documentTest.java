package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.documentObjects;

public class documentTest extends TestBase {
	
	documentObjects documentsobjects;
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	documentsobjects = new documentObjects();

	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsobjects.pressDocument();
	  
		//open doc  enter title and description
		documentsobjects.openEntity("doc1" , "importenet");
	}
	
	@Test(priority = 2)
	public void documentsMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("document using multiple choice");
		
		// delete entity using multiple select
		documentsobjects.deleteEntityMultipleChoice();
		
		//open doc  enter title and description
		documentsobjects.openEntity("doc2" , "importenet2");
		
		documentsobjects.addTagsMultipleChoice("mission");
		
		documentsobjects.addDateMultipleChoice();
		
		documentsobjects.addAssigneeMultipleChoice();
		
		documentsobjects.addWatchersMultipleChoice();
		
		documentsobjects.addStatusMultipleChoice();
		
	}
	
	@Test(priority = 3)
	public void documentsActivivties() throws InterruptedException {
		
		logger = extent.createTest("document activities");
		
		documentsobjects.addActivities("this is a test");
		
	}
	
	@Test(priority = 4)
	public void documentsDetailsOnScreen() throws InterruptedException {
		
		logger = extent.createTest("document details on th screen");
		
		documentsobjects.ChangeDetailsOnTheScreen("importent");
		
	}
	
	
	
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


