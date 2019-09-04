package folder;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.documents.documentsMiddlePane;
import pages.folders.foldersMultipleSelect;

public class folderTest extends testBase{

	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	foldersMultipleSelect foldermultipleselect;
	documentsMiddlePane documnetsmiddlepane;
	randomActions random;
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	
		initialization(); 
		Login();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.foldermultipleselect = new foldersMultipleSelect();
		this.documnetsmiddlepane = new documentsMiddlePane();
		this.random = new randomActions();
	}
	
	@Test(priority = 1)
	public void openfolder() throws InterruptedException {
		
		foldermultipleselect.pressFolders();
		
		actionsmiddlepane.openEntity("folder1" , "importenet");
	}
	
	@Test(priority = 2)
	public void folderssMultipleSelect() throws InterruptedException {
		logger = extent.createTest("folders select");

		actionsmultipleselect.deleteEntityMultipleChoice();

		actionsmultipleselect.addTagsMultipleChoice("mission");
		
		actionsmultipleselect.addWatchersMultipleChoice();

		actionsmultipleselect.addStatusMultipleChoice();

	}
	
	@Test(priority = 3)
	public void foldersMiddlePane() throws InterruptedException {
		logger = extent.createTest("folders middle pane");

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
	
	@Test(priority = 4)
	public void foldersRightSide() throws InterruptedException {
		
	}
	
	
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	