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
import pages.tasks.subTasks;
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksRightSideOfScreen;
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
	tasksMiddlePane 		  tasksmiddlepane;
	tasksRightSideOfScreen	   tasksrightside;
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
		this.tasksmiddlepane			= new tasksMiddlePane();  
		this.tasksrightside				= new tasksRightSideOfScreen();
		meetingsfunctions.pressMeetings();
		actionsmiddlepane.openEntity("delete", "dasda");

	}

	@Test (priority = 1)
	public void meetingsDeleteMultipleChocie() throws InterruptedException {

		logger = extent.createTest("meetings multiple Choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}

	@Test (priority = 2)
	public void meetingsAddTagsMultipleChoiceFunction () throws InterruptedException {

		logger = extent.createTest("meetings multiple Choice tags ");

		actionsmultipleselect.addTagsMultipleChoice("Meetings ASAP");
	}

	@Test(priority = 3)
	public void meetingsSetDateMultipleChoiceFunction () throws InterruptedException {

		logger = extent.createTest("meetings multiple Choice set date");

		meetingsfunctions.setDateViaMultipleSelect();
	}

	@Test(priority = 4)
	public void meetingsAddAsigneeMultipleChoice() throws InterruptedException {

		logger = extent.createTest("meetings multiple Choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 5)
	public void meetingsAddWatcherMultipleChoioce()throws InterruptedException {

		logger = extent.createTest("meetings multiple Choice add Watchers");

		actionsmultipleselect.addWatchersMultipleChoice();

	}

	@Test(priority = 6)
	public void meetingsAddStatusMultipoleChoice()throws InterruptedException{

		logger = extent.createTest("meetings multiple choice add status");

		meetingsmultipleselect.addStatusMultipleChoiceMeetings();

	}



	@Test (priority = 7)
	public void meetingsMiddlePaneSortTitle () throws InterruptedException {

		logger = extent.createTest("meetings middle pane sort by title");

		actionsmiddlepane.sortByTitle();

	}
	//actionsmiddlepane.sortByFavorite();

	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 8)
	public void meetingsMiddlePaneSortStatusAndUnread ()throws InterruptedException {

		logger = extent.createTest("meetings middle pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();

	}

	@Test(priority = 9)
	public void meetingsRightSideDelete() throws InterruptedException{

		logger = extent.createTest("meetings right side delele");

		actionsrightside.deleteEntity();

	}

	@Test (priority = 10)
	public void meetingsRightSideAddAssignee () throws InterruptedException {

		logger = extent.createTest("meetings right side add assignee");

		actionsrightside.addAssignee(true);

	}

	@Test (priority = 11)
	public void meetingsRightSideSetDate () throws InterruptedException {

		logger = extent.createTest("meetings right side set date");

		meetingsfunctions.setDateInMeetings();

	}

	@Test (priority = 12)
	public void meetingsRightSideAddLocation () throws InterruptedException {

		logger = extent.createTest("meetings right side add location");

		meetingsfunctions.AddLocation();

	}

	@Test (priority = 13)
	public void meetingsRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest("meetings right side add status");

		actionsrightside.addStatus();

	}

	@Test (priority = 14)
	public void meetingsRightSideAddTags() throws InterruptedException {

		logger = extent.createTest("meetings right side add tags");

		actionsrightside.addTags("mission (New)");

	}

	@Test (priority = 15)
	public void meetingsRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest("meetings right side add activities");

		actionsrightside.addActivities("HELLO" , "this is superman");

	}

	@Test(priority = 16)
	public void meetingsRightSideChangePermission() throws InterruptedException {

		logger = extent.createTest("meetings right side change permission");

		actionsrightside.changePermission();
	}

	@Test(priority = 17)
	public void GetIntoTasksFromMeetings() throws InterruptedException {

		logger = extent.createTest("get into tasks from meetings");

		meetingsfunctions.getIntoTasksFromMeetings();
	}

	@Test(priority = 18)
	public void tasksFromMeetingsMultipleChoiceDelete() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice delete");

		actionsmiddlepane.openEntity("meet123456789", "ghjydgj");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}

	@Test(priority = 19)
	public void tasksFromMeetingsMultipleChoiceAddTags() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("missionimpossible");
	}

	@Test(priority = 20)
	public void tasksFromMeetingsMultipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice set date");

		actionsmultipleselect.addDateMultipleChoice();
	}

	@Test(priority = 21)
	public void tasksFromMeetingsMultipleChoiceAddAsignee() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice add asignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 22)
	public void tasksFromMeetingsMultipleChoiceAddWatchers() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 23)
	public void tasksFromMeetingsMultipleChoiceAddStatus() throws InterruptedException {

		logger = extent.createTest("tasks from meetings multiple choice add statsus");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 24)
	public void tasksFromMeetingsMiddlePaneStatusList() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings middle pane status list");

		tasksmiddlepane.changeStatusOfList();	
	}

	@Test(priority = 25)
	public void tasksFromMeetingsMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 26)
	public void tasksFromMeetingsMiddlePaneSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}

	//actionsmiddlepane.pressOnArrow();
	//tasksmiddlepane.sortByFavorite();

	@Test(priority = 27)
	public void tasksFromMeetingsRightSideDelete() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side delete");

		actionsrightside.deleteEntity();
	}

	@Test(priority = 28)
	public void tasksFromMeetingsRightSideAddAssignee() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side add assignee");

		actionsrightside.addAssignee(true);
	}

	@Test(priority = 29)
	public void tasksFromMeetingsRightSideSetDate() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side set date");

		actionsrightside.setDate();
	}

	@Test(priority = 30)
	public void tasksFromMeetingsRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side add status");

		actionsrightside.addStatus();
	}

	@Test(priority = 31)
	public void tasksFromMeetingsRightSideAddTags() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side add tags");

		actionsrightside.addTags("tasksFromFolder");
	}

	@Test(priority = 32)
	public void tasksFromMeetingsRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}

	@Test(priority = 33)
	public void tasksFromMeetingsRightSideDuplicateTasks() throws InterruptedException {

		logger = extent.createTest("tasks from meetings right side duplicate tasks");

		tasksrightside.duplicateTasks();
	}

	@Test (priority = 34) 
	public void getIntoDiscussionFromProject() throws InterruptedException {

		logger = extent.createTest("get into discussion from projects");

		meetingsfunctions.MeetingFromProjects();

	}

	@Test (priority = 35) 
	public void discussionsFromProjectMultipleChoiceDelete() throws InterruptedException {

		logger = extent.createTest(" discussion from projects multiple choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test (priority = 36)
	public void discussionsFromProjectsMultipleChoiceAddTags () throws InterruptedException {

		logger = extent.createTest(" discussion from projects multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("Meetings ASAP");
	}

	@Test(priority = 37)
	public void discussionsFromProjectsMultipleChoiceSetDate () throws InterruptedException {

		logger = extent.createTest("discussion from projects multiple choice set date");

		meetingsfunctions.setDateViaMultipleSelect();
	}

	@Test(priority = 38)
	public void discussionsFromProjectsMultipleChoiceAddAsignee() throws InterruptedException {

		logger = extent.createTest("discussion from projects multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 39)
	public void  discussionsFromProjectsMultipleChoiceAddwatcher()throws InterruptedException {

		logger = extent.createTest("discussion from projects multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();

	}

	@Test(priority = 40)
	public void discussionsFromProjectsMultipleChoiceAddStatsus()throws InterruptedException{

		logger = extent.createTest("discussion from projects multiple choice add status");

		meetingsmultipleselect.addStatusMultipleChoiceMeetings();

	}

	@Test (priority = 41)
	public void discussionsFromProjectsMiddlePaneSortTitle () throws InterruptedException {

		logger = extent.createTest("discussion from projects middle pane sort by title");

		actionsmiddlepane.sortByTitle();

	}

	//actionsmiddlepane.sortByFavorite();

	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 42)
	public void discussionsFromProjectsMiddlePaneSortStatusAndUnread ()throws InterruptedException {

		logger = extent.createTest("discussion from projects middle pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();

	}

	@Test(priority = 43)
	public void discussionsFromProjectsRightSideDelete() throws InterruptedException{

		logger = extent.createTest("discussion from projects right side delele");

		actionsrightside.deleteEntity();

	}

	@Test (priority = 44)
	public void discussionsFromProjectsRightSideAddAssignee () throws InterruptedException {

		logger = extent.createTest("discussion from projects right side add assignee");

		actionsrightside.addAssignee(true);

	}

	@Test (priority = 45)
	public void discussionsFromProjectsRightSideSetDate () throws InterruptedException {

		logger = extent.createTest("discussion from projects right side set date");

		meetingsfunctions.setDateInMeetings();

	}

	@Test (priority = 46)
	public void discussionsFromProjectsRightSideAddLocation () throws InterruptedException {

		logger = extent.createTest("discussion from projects right side add location");

		meetingsfunctions.AddLocation();

	}

	@Test (priority = 47)
	public void discussionsFromProjectsRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest("discussion from projects right side add status");

		actionsrightside.addStatus();

	}

	@Test (priority = 48)
	public void discussionsFromProjectsRightSideAddTags() throws InterruptedException {

		logger = extent.createTest("discussion from projects right side add tags");

		actionsrightside.addTags("gregory");

	}

	@Test (priority = 49)
	public void discussionsFromProjectsRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest("discussion from projects right side add activities");

		actionsrightside.addActivities("HELLO" , "this is superman");

	}

	@AfterClass
	public void after() {

		extent.flush();

	}

}

