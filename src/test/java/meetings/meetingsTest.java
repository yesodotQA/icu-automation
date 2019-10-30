package meetings;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
import pages.tasks.subTasks;
import task.tasksTest;

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
	tasksTest				   tasktest;
	subTasks 				   subtasks;
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
	this.tasktest					= new tasksTest();
	this.subtasks 					= new subTasks();
	}
	
	@Test (priority = 1)
	public void pressMeetings() throws InterruptedException {
		
		meetingsfunctions.pressMeetings();
		
		actionsmiddlepane.openEntity("delete", "dasda");
		
	}

	@Test (priority = 2)
	public void MultipleChoiceFunction () throws InterruptedException {
	
		logger = extent.createTest("Test Multiple Choice ");
		
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
		
		//actionsmiddlepane.sortByFavorite();
		actionsmiddlepane.sortByTitle();
		actionsmiddlepane.sordByStatusAndUnread();
		//actionsmiddlepane.pressOnArrow();
		
	}
	
	@Test (priority = 4)
	public void RightSideFunction () throws InterruptedException {
	
		logger = extent.createTest("Test the Right Side functionality");
		
		actionsrightside.deleteEntity();
		actionsrightside.addAssignee(true);
		meetingsfunctions.setDateInMeetings();
		meetingsfunctions.AddLocation();
		actionsrightside.addStatus();
		actionsrightside.addTags("mission (New)");
		actionsrightside.addActivities("HELLO" , "this is superman");
		
		actionsrightside.changePermission();
	}

	@Test (priority = 5)
	public void  discussionFromProject() throws InterruptedException {
		
		logger = extent.createTest("discussion from projects");
		
		meetingsfunctions.MeetingFromProjects();
		
		MultipleChoiceFunction();
		
		MiddlePaneFunction();
		
		RightSideFunction();
		
	}
	
	@Test (priority = 6)
	public void tasksFromMeetings() throws InterruptedException, IOException {
		logger = extent.createTest("Tasks From meetings");
		meetingsfunctions.pressMeetings();
		meetingsfunctions.getIntoTasksFromMeetings();
		actionsmiddlepane.openEntity("task", "asdjfhf");
		tasktest.SetUp();
		tasktest.allTasksMulitipleChoice();
		tasktest.alltasksMiddlePane();
		tasktest.alltasksRightSide();
		actionsmiddlepane.openEntity("subtasks" , "dasa");
		subtasks.addSubTasks();
		subtasks.deleteSubTasks();
		
		logger.log(Status.INFO, "get into sub tasks not work");
		
	}
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}

