package meetings;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;


import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;
import pages.meetings.MeetingsFunctions;
import pages.meetings.meetingsMultipleSelect;

public class meetingsTest extends testBase {

	documentsMultipleSelect    documentsmultipleselect;
	documentsMiddlePane        documentsmiddlepane;
	middlePane                 middlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane          actionsmiddlepane;
	actionsRightSide           actionsrightside;
	actionsMultipleSelect      actionsmultipleselect;
	Tabs 					   tabs;
	MeetingsFunctions		   meetingsfunctions;
	meetingsMultipleSelect	   meetingsmultipleselect;

	@BeforeClass

	public void SetUp() throws InterruptedException, IOException{	
	
	this.tabs                       = new Tabs();
	this.actionsmultipleselect      = new actionsMultipleSelect();
	this.documentsmultipleselect    = new documentsMultipleSelect();
	this.documentsmiddlepane        = new documentsMiddlePane();
	this.middlepane                 = new middlePane();
	this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
	this.actionsmiddlepane          = new actionsMiddlePane();
	this.actionsrightside           = new actionsRightSide();
	this.meetingsfunctions			= new MeetingsFunctions();
	this.meetingsmultipleselect		= new meetingsMultipleSelect();
	
	}
	
	@Test (priority = 1)
	public void pressMeetings() throws InterruptedException {
		
		meetingsfunctions.pressMeetings();
		
		actionsmiddlepane.openEntity("delete", "dasda");
		
	}

	@Test (priority = 2)
	public void MultipleChoiceFunction () throws InterruptedException {
	
		logger = extent.createTest("Test Multiple Choice in Meetings");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
		actionsmultipleselect.addTagsMultipleChoice("Meetings ASAP");
		meetingsfunctions.setDateViaMultipleSelect();
		actionsmultipleselect.addAssigneeMultipleChoice();
		actionsmultipleselect.addWatchersMultipleChoice();
		
		meetingsmultipleselect.addStatusMultipleChoiceMeetings();
				
	}
	
	@Test (priority = 3)
	public void MiddlePaneFunction () throws InterruptedException {
		
		logger = extent.createTest("Test the Middle Pane Functionality");
		
		actionsmiddlepane.openEntity("Title Test", "Open Entity Perfectly!!!");
		//actionsmiddlepane.sortByFavorite();
		actionsmiddlepane.sortByTitle();
		actionsmiddlepane.sordByStatusAndUnread();
		//actionsmiddlepane.pressOnArrow();
		
	}
	
	@Test (priority = 4)
	public void RightSideFunction () throws InterruptedException {
	
		logger = extent.createTest("Test the Right Side functionality");
		
		actionsrightside.deleteEntity();
		actionsrightside.addAssignee();
		meetingsfunctions.setDateInMeetings();
		actionsrightside.addStatus();
		actionsrightside.addTags("ASAP");
		actionsrightside.addActivities("HELLO" , "this is superman");
		actionsrightside.changePermission();
	}

	@Test (priority = 2)
	public void  discussionFromProject() throws InterruptedException {
		
		meetingsfunctions.MeetingFromProjects();
		
		MultipleChoiceFunction();
		
		MiddlePaneFunction();
		
		RightSideFunction();
		
	}
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}

