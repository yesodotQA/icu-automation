package folders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;
import pages.folders.foldersMultipleSelect;

public class foldrsTest extends testBase {

		foldersMultipleSelect foldersmultipleselect;
		middlePane middlepane;
		actionsMultipleSelect actionsmultipleselect;
		actionsMiddlePane actionsmiddlepane;
		
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException {	
		initialization(); 
		Login();
		this.foldersmultipleselect = new foldersMultipleSelect();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
	}
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
	foldersmultipleselect.pressFolders();
  
	//open doc  enter title and description
	actionsmiddlepane.openEntity("doc1" , "importenet");
	
	}
	
	@Test(priority = 2)
	public void folderssMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("folders using multiple choice");
		
		// delete entity using multiple select
		actionsmultipleselect.deleteEntityMultipleChoice();
		
		// add tags using multiple select
		actionsmultipleselect.addTagsMultipleChoice("mission");

		
	}

	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
	
}