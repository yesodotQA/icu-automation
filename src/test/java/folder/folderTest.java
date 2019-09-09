package folder;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import document.documentsTest;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.folders.documentsFromFolder;
import pages.folders.foldersMultipleSelect;
import pages.folders.foldersRightSide;

public class folderTest extends testBase{

	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	foldersMultipleSelect foldermultipleselect;
	foldersRightSide folderrightside;
	documentsMiddlePane documnetsmiddlepane;
	randomActions randomactions;
	documentsFromFolder docfromfolder;
	documentsTest documentstest;
	
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	
		initialization(); 
		Login();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.foldermultipleselect = new foldersMultipleSelect();
		this.documnetsmiddlepane = new documentsMiddlePane();
		this.randomactions = new randomActions();
		this.folderrightside = new foldersRightSide();
		this.docfromfolder = new documentsFromFolder();
		this.documentstest = new documentsTest();
		
	}
	
	@Test(priority = 1)
	public void openfolder() throws InterruptedException {
		
		foldermultipleselect.pressFolders();
		
		actionsmiddlepane.openEntity("folder1" , "importenet");
	}
	/*
	@Test(priority = 2)
	
	public void foldersMultipleSelect() throws InterruptedException {
		
		logger = extent.createTest("folders multiple select");

		actionsmultipleselect.deleteEntityMultipleChoice();

		actionsmultipleselect.addTagsMultipleChoice("mission");
		
		actionsmultipleselect.addWatchersMultipleChoice();

		actionsmultipleselect.addStatusMultipleChoice();

	}
	
	@Test(priority = 3)
	public void foldersMiddlePane() throws InterruptedException {
		logger = extent.createTest("folders middle pane");

		randomactions.enterNameToEntity("hyyyyyyyyy");
	
		// change the status of list entities
		documnetsmiddlepane.changeStatusOfList();

		// choose entity and press on favorite 
		//actionsmiddlepane.sortByFavorite();

		// sort the list by title
		actionsmiddlepane.sortByTitle();

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();

		// press on arrow to reverse the order of the list
		//actionsmiddlepane.pressOnArrow();
	}
	
	@Test(priority = 2)
	public void foldersRightSide() throws InterruptedException {
		
		logger = extent.createTest("folder right side");
		
		actionsrightside.deleteEntity();
		
		actionsmiddlepane.openEntity("folderTest", "isr");
		
		actionsrightside.addStatus();
		
		randomactions.chooseColor();
		
		folderrightside.SelectOfficeOnScreen();
		
		actionsrightside.addTags("www");

		actionsrightside.addActivities("hyyyyyy" , "this is superman");

		actionsrightside.changePermission();
		
		
	}
	*/
	@Test(priority = 3)
	public void documentsFromFolder() throws InterruptedException {
		
		logger = extent.createTest("documents from folder");
		
		docfromfolder.getIntoDocumentsFromFolder();
		
		actionsmiddlepane.openEntity("doc1" , "importenet");
		
		documentstest.documentsMultipleSelect();
		
		documentstest.documentsMiddlePane();
		
		documentstest.documentsRightSide();
		
		
	}
		
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	