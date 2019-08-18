package folders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;
import pages.folders.foldersMultipleSelect;

public class foldrsTest extends testBase {

		foldersMultipleSelect foldersmultipleselect;
		
		middlePane middlepane;
		
	@BeforeClass
	public void SetUp() throws InterruptedException {	
		initialization(); 
		Login();
		foldersmultipleselect = new foldersMultipleSelect();
		middlepane = new middlePane();
		
	}
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
	foldersmultipleselect.pressFolders();
  
	//open doc  enter title and description
	middlepane.openEntity("doc1" , "importenet");
	
	}
	
	@Test(priority = 2)
	public void folderssMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("folders using multiple choice");
		
		// delete entity using multiple select
		foldersmultipleselect.deleteEntityMultipleChoice();
		
		// add tags using multiple select
		foldersmultipleselect.addTagsMultipleChoice("mission");

		
	}

	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
	
}