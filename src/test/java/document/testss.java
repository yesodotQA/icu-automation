package document;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;

public class testss extends testBase {
	
	documentsMultipleSelect documentsmultipleselect;
	documentsMiddlePane documentsmiddlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	randomActions randomaction;

	public testss() throws InterruptedException
	{
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.documentsmultipleselect = new documentsMultipleSelect();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomaction = new randomActions();
	}
	
	 
	@Test (groups = {"doc"}, priority = 1)
		public void documentsMultipleSelect() throws InterruptedException {
		
		logger = extent.createTest("document multiple select");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
	
		actionsmultipleselect.addTagsMultipleChoice("mission");

		actionsmultipleselect.addDateMultipleChoice();
	
		actionsmultipleselect.addAssigneeMultipleChoice();
		
		actionsmultipleselect.addWatchersMultipleChoice();
		
		actionsmultipleselect.addStatusMultipleChoice();
		
	}
	@Test(groups = {"doc"}, priority = 2)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("document middle pane");
		
		randomaction.enterNameToEntity("hyyyyyyyyy");
		
		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
		
		// choose entity and press on favorite 
		//actionsmiddlepane.sortByFavorite();
		
		// sort the list by title
		actionsmiddlepane.sortByTitle();
		
		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();
		
		// press on arrow to reverse the order of the list
		//actionsmiddlepane.pressOnArrow();
	}
	
	@Test(groups = {"doc"}, priority = 3)
	public void documentsRightSide() throws InterruptedException {
		
		logger = extent.createTest("document the right side on the screen");
		
		actionsrightside.deleteEntity();
		
		actionsrightside.addAssignee();
		
		actionsrightside.setDate();
		
		actionsrightside.addStatus();
		
		documentsrhigtsideonscreen.SelectFolderOnScreen();
		
		actionsrightside.addTags("www");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
		
		actionsrightside.changePermission();
	}
	
}
