package task;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import base.testBase;
import document.documentsTest;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsRightSideOnScreen;
import pages.tasks.documentsFromTasks;
import pages.tasks.subTasks;
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksMultipleSelect;
import pages.tasks.tasksRightSideOfScreen;

public class tasksTest  extends testBase {


	subTasks subTasks;
	Tabs tabs;
	tasksMultipleSelect tasksmultipleselect ;
	middlePane middlepane;
	tasksMiddlePane tasksmiddlepane;
	tasksRightSideOfScreen tasksrightsideonscreen;
	actionsRightSide actionsrightside;
	actionsMiddlePane actionsmiddlepane;
	actionsMultipleSelect actionsmultipleselect;
	documentsMiddlePane documentsmiddlepane;
	randomActions randomaction;
	documentsFromTasks documentsfromtasks;
	documentsTest documentstest;
	documentsRightSideOnScreen documentsrightside;

	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	

		this.documentsmiddlepane = new documentsMiddlePane();
		this.subTasks = new subTasks();
		this.tasksmultipleselect = new tasksMultipleSelect();
		this.middlepane = new middlePane();
		this.tasksmiddlepane = new tasksMiddlePane();
		this.tasksrightsideonscreen = new tasksRightSideOfScreen();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.tabs = new Tabs();
		this.randomaction = new randomActions();
		this.documentsfromtasks = new documentsFromTasks();
		this.documentstest = new documentsTest();
		this.documentsrightside = new documentsRightSideOnScreen();
		tasksmultipleselect.pressTask();
		actionsmultipleselect.deleteAllEntities();
		actionsmiddlepane.openEntity("doc1" , "important");
	}

	@Test(priority = 1)
	public void allTasksMultipleChoiceDelete() throws InterruptedException {

		logger = extent.createTest("Task multiple select delete");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}	


	@Test(priority = 2)
	public void allTasksMulitipleChoiceAddTags() throws InterruptedException {

		logger = extent.createTest("tasks multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("mission");
	}

	@Test(priority = 3)
	public void allTasksMulitipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest("tasks multiple choice add date");

		actionsmultipleselect.addDateMultipleChoice();

	}

	@Test(priority = 4)
	public void allTasksMulitipleChoiceAddAssignee() throws InterruptedException {

		logger = extent.createTest("tasks multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 5)
	public void allTasksMulitipleChoiceAddWatchers() throws InterruptedException {

		logger = extent.createTest("tasks multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 6)
	public void allTasksMulitipleChoiceAddStatus() throws InterruptedException {

		logger = extent.createTest("tasks multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();

	}

	@Test(priority = 7)
	public void alltasksMiddlePaneStatusList()throws InterruptedException {

		logger = extent.createTest(" tasks middle pane status list");

		tasksmiddlepane.changeStatusOfList();
	}

	@Test(priority = 8)
	public void alltasksMiddlePaneSortTitle()throws InterruptedException {

		logger = extent.createTest(" tasks sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 9)
	public void alltasksMiddlePaneSortStatusAndUnread()throws InterruptedException {

		logger = extent.createTest("tasks middle pane sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}

	//actionsmiddlepane.pressOnArrow();
	//tasksmiddlepane.sortByFavorite();

	@Test(priority = 10)
	public void alltasksRightSideDelete()throws InterruptedException {

		logger = extent.createTest("tasks right side delete");

		actionsrightside.deleteEntity();

	}

	@Test(priority = 11)
	public void alltasksRightSideAddAssignee()throws InterruptedException {

		logger = extent.createTest("tasks right side add assignee");

		actionsrightside.addAssignee(true);

	}

	@Test(priority = 12)
	public void alltasksRightSideSetDate()throws InterruptedException {

		logger = extent.createTest("tasks right side set date");

		actionsrightside.setDate();
	}

	@Test(priority = 13)
	public void alltasksRightSideAddStatus()throws InterruptedException {

		logger = extent.createTest("tasks right side add status");

		actionsrightside.addStatus();
	}

	@Test(priority = 14)
	public void alltasksSelectDiscussions()throws InterruptedException {

		logger = extent.createTest("tasks right side select discussions");

		tasksrightsideonscreen.SelectDiscussionsOnScreen();
	}

	@Test(priority = 15)
	public void alltasksSelectProjects()throws InterruptedException {

		logger = extent.createTest("tasks right side select projects");

		tasksrightsideonscreen.SelectProjectsOnScreen();
	}

	@Test(priority = 16)
	public void alltasksAddTags()throws InterruptedException {

		logger = extent.createTest("tasks right side add tags");

		actionsrightside.addTags("yaronnn");
	}

	@Test(priority = 17)
	public void alltasksAddActivities()throws InterruptedException {

		logger = extent.createTest("tasks right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}

	@Test(priority = 17)
	public void alltasksChangePermission()throws InterruptedException {

		logger = extent.createTest("tasks right side change permissions");

		actionsrightside.changePermission();		
	}

	@Test(priority = 18)
	public void alltasksDuplicateTasks()throws InterruptedException {

		logger = extent.createTest("tasks right side duplicate tasks");

		tasksrightsideonscreen.duplicateTasks();

	}


	@Test(priority = 19)
	public void deleteSubTasksFromAllTasks()throws InterruptedException {

		logger = extent.createTest("delete sub tasks from all tasks");

		actionsmiddlepane.openEntity("sub tasks", "sfdjh");

		subTasks.addSubTasks();

		subTasks.deleteSubTasks();
	}

	@Test(priority = 20)
	public void creatsSubTasksAllTasksAndEnterIt()throws InterruptedException {

		logger = extent.createTest("create sub tasks from all tasks and enter it");

		subTasks.createSubTasks();

		actionsmiddlepane.openEntity("subtasks22", "rhfjfrjk");
	}

	@Test(priority = 21)
	public void subTasksAllTasksMultipleChoiceDelete()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test(priority = 22)
	public void subTasksAllTasksMultipleChoiceAddTags()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("subTasksAllTAsks");
	}

	@Test(priority = 23)
	public void subTasksAllTasksMultipleChoiceSetDate()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice set date");

		actionsmultipleselect.addTagsMultipleChoice("subTasksAllTAsks");
	}

	@Test(priority = 24)
	public void subTasksAllTasksMultipleChoiceAddAssignee()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 25)
	public void subTasksAllTasksMultipleChoiceAddWatchers()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 26)
	public void subTasksAllTasksMultipleChoiceAddStatus()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 27)
	public void subTasksAllTasksMiddlaPaneStatusList()throws InterruptedException {

		logger = extent.createTest("sub tasks from all taskss middle pane status list");

		tasksmiddlepane.changeStatusOfList();	

	}

	@Test(priority = 28)
	public void subTasksAllTasksMiddlePaneSortTitle()throws InterruptedException {

		logger = extent.createTest("sub tasks from all taskss middle pane sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 29)
	public void subTasksAllTasksMiddlePaneSortStatusAndUnread()throws InterruptedException {

		logger = extent.createTest("sub tasks from all taskss middle pane sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}

	@Test(priority = 30)
	public void subTasksAllTasksRightSideDelete()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks right side delete");

		actionsrightside.deleteEntity();
	}

	@Test(priority = 31)
	public void subTasksAllTasksRightSideAddAssignee()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks right side add assignee");

		actionsrightside.addAssignee(true);
	}

	@Test(priority = 32)
	public void subTasksAllTasksRightSideSetDate()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks right side set date");

		actionsrightside.setDate();
	}

	@Test(priority = 33)
	public void subTasksAllTasksRightSideAddStatus()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks right side add status");

		actionsrightside.addStatus();
	}


	@Test(priority = 34)
	public void subTasksAllTasksRightSideAddTags()throws InterruptedException {

		logger = extent.createTest("sub tasks from all tasks right side add tags");

		actionsrightside.addTags("idf");
	}

	@Test(priority = 35)
	public void subTasksAllTasksRightSideAddActivities()throws InterruptedException {

		logger = extent.createTest(" sub tasks from all tasks right side add activities");


		actionsrightside.addActivities("sad", "memurmar");
	}
	
	@Test(priority = 37)
	public void getIntoMyTasks() throws InterruptedException {

		logger = extent.createTest("get into my tasks");

		tasksmultipleselect.pressMyTask();

		actionsmiddlepane.openEntity("My tasks", "jgj");
	}

	@Test(priority = 38)
	public void myTasksMultipleChoiceDelete() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}


	@Test(priority = 39)
	public void myTasksMultipleChoiceAddTags() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("my tasks");
	}

	@Test(priority = 40)
	public void myTasksMultipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice set date");

		actionsmultipleselect.addDateMultipleChoice();
	}

	@Test(priority = 41)
	public void myTasksMultipleChoiceAddAssignee() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 42)
	public void myTasksMultipleChoiceAddWatchers() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 43)
	public void myTasksMultipleChoiceAddStatus() throws InterruptedException {

		logger = extent.createTest("my tasks multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 44)
	public void  myTasksMiddlePaneStatusList() throws InterruptedException {

		logger = extent.createTest("my tasks middle pane status list");

		tasksmiddlepane.changeStatusOfList();	
	}

	@Test(priority = 45)
	public void  myTasksMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest("my tasks middle pane sort by title");

		actionsmiddlepane.sortByTitle();

	}

	@Test(priority = 46)
	public void  myTasksMiddlePaneSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest("my tasks middle pane sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}

	@Test(priority = 47)
	public void  myTasksRightSideDelete() throws InterruptedException {

		logger = extent.createTest("my tasks right side delete");

		actionsrightside.deleteEntity();
	}

	@Test(priority = 48)
	public void  myTasksRightSideAddAssignee() throws InterruptedException {

		logger = extent.createTest("my tasks right side add assignee");

		actionsrightside.addAssignee(false);
	}

	@Test(priority = 49)
	public void  myTasksRightSideSetDate() throws InterruptedException {

		logger = extent.createTest("my tasks right side set date");

		actionsrightside.setDate();	
	}

	@Test(priority = 50)
	public void  myTasksRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest("my tasks right side add status");

		actionsrightside.addStatus();
	}

	@Test(priority = 51)
	public void  myTasksRightSideAddTags() throws InterruptedException {

		logger = extent.createTest("my tasks right side add tags");

		actionsrightside.addTags("mytasksrightside");
	}

	@Test(priority = 52)
	public void  myTasksRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest("my tasks right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}

	@Test(priority = 53)
	public void myTasksSelectDiscussions()throws InterruptedException {

		logger = extent.createTest("my tasks right side select discussions");

		tasksrightsideonscreen.SelectDiscussionsOnScreen();
	}

	@Test(priority = 54)
	public void myTasksSelectProjects()throws InterruptedException {

		logger = extent.createTest("my tasks right side select projects");

		tasksrightsideonscreen.SelectProjectsOnScreen();
	}

	@Test(priority = 55)
	public void myTasksChangePermission()throws InterruptedException {

		logger = extent.createTest("my tasks right side change permissions");

		actionsrightside.changePermission();			
	}

	@Test(priority = 56)
	public void myTasksDuplicateTasks()throws InterruptedException {

		logger = extent.createTest("my tasks right side duplicate tasks");

		tasksrightsideonscreen.duplicateTasks();
	}

	@Test(priority = 57)
	public void deleteSubTasksMyTasks()throws InterruptedException {
		
		logger = extent.createTest("delete sub tasks from my tasks");
		
		actionsmiddlepane.openEntity("sub tasks", "sfdjh");

		subTasks.addSubTasks();

		subTasks.deleteSubTasks();
	}
	
	@Test(priority = 58)
	public void creatsSubTasksMyTasksAndEnterIt()throws InterruptedException {

		logger = extent.createTest("create sub tasks from my tasks and enter it");

		subTasks.createSubTasks();
		
		actionsmiddlepane.openEntity("subtasks1995", "rhfjfrjk");
	}

	@Test(priority = 59)
	public void subTasksmyTasksMultipleChoiceDelete()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice delete");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test(priority = 60)
	public void subTasksmyTasksMultipleChoiceAddTags()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("subtasksalltasks");
	}

	@Test(priority = 61)
	public void subTasksmyTasksMultipleChoiceSetDate()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice set date");

		actionsmultipleselect.addDateMultipleChoice();
	}

	@Test(priority = 62)
	public void subTasksmyTasksMultipleChoiceAddAssignee()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 63)
	public void subTasksmyTasksMultipleChoiceAddWatchers()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 64)
	public void subTasksmyTasksMultipleChoiceAddStatus()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 65)
	public void subTasksmyTasksMiddlePaneStatusList()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks middle pane status list");

		tasksmiddlepane.changeStatusOfList();		
	}

	@Test(priority = 66)
	public void subTasksmyTasksMiddlePaneSortTitle()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks middle pane sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 67)
	public void subTasksmyTasksMiddlePaneSortStatusAndUnread()throws InterruptedException {

		logger = extent.createTest("sub tasks my tasks middle pane sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}
	
	@Test(priority = 68)
	public void subTasksmyTasksRightSideDelete()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side delete");
		
		actionsrightside.deleteEntity();
	}
	
	@Test(priority = 69)
	public void subTasksmyTasksRightSideAddAssignee()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side add assignee");
		
		actionsrightside.addAssignee(true);
	}
	
	@Test(priority = 70)
	public void subTasksmyTasksRightSideSetDate()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side set date");
		
		actionsrightside.setDate();
	}
	
	@Test(priority = 71)
	public void subTasksmyTasksRightSideAddStatus()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side add status");
		
		actionsrightside.addStatus();	
	}
	
	@Test(priority = 72)
	public void subTasksmyTasksRightSideAddTags()throws InterruptedException {
	
		logger = extent.createTest("sub tasks my tasks right side add tags");
		
		actionsrightside.addTags("mytasksrightside");
	}

	@Test(priority = 73)
	public void subTasksmyTasksRightSideAddActivities()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side add activities");
		
		actionsrightside.addActivities("sad", "memurmar");
	}
	
	@Test(priority = 75)
	public void subTasksmyTasksRightSideDuplicateTasks()throws InterruptedException {
		
		logger = extent.createTest("sub tasks my tasks right side duplicate tasks");
		
		tasksrightsideonscreen.duplicateTasks();
	}
	
	@Test(priority = 76)
	public void getIntoDocumentsFromTasks()throws InterruptedException {
		
		logger = extent.createTest("get into documents from tasks");
		
		documentsfromtasks.getIntoDocumentsFromTasks();
	}
	

	@Test(priority = 77)
	public void documentsFromTasksMultipleChoiceDelete()throws InterruptedException {

		logger = extent.createTest("documents from tasks multiple choice delete");
		
		actionsmiddlepane.openEntity("document from tasks 123456","ahalan");
	
		 actionsmultipleselect.deleteEntityMultipleChoice();
	}
	
	@Test(priority = 78)
	public void documentsFromTasksMultipleChoiceAddTags()throws InterruptedException {

		logger = extent.createTest("documents from tasks multiple choice add tags");
		
		actionsmultipleselect.addTagsMultipleChoice("docFromTasks");
	}
	
	@Test(priority = 79)
	public void documentsFromTasksMultipleChoiceSetDate()throws InterruptedException {
		
		logger = extent.createTest("documents from tasks multiple choice set date");
		
		actionsmultipleselect.addDateMultipleChoice();
	}
	
	@Test(priority = 80)
	public void documentsFromTasksMultipleChoiceAddAsignee()throws InterruptedException {
		
		logger = extent.createTest("documents from tasks multiple choice add assignee");
		
		actionsmultipleselect.addAssigneeMultipleChoice();
	}
	
	@Test(priority = 81)
	public void documentsFromTasksMultipleChoiceAddWatchers()throws InterruptedException {
		
		logger = extent.createTest("documents from tasks multiple choice add watchers");
		
		actionsmultipleselect.addWatchersMultipleChoice();
	}
	
	@Test(priority = 82)
	public void documentsFromTasksMultipleChoiceAddStatus()throws InterruptedException {
	
		logger = extent.createTest("documents from tasks multiple choice add status");
		
		actionsmultipleselect.addStatusMultipleChoice();
	}
	
	@Test(priority = 83)
	public void documentsFromTasksMiddlePaneStatusList()throws InterruptedException {
		
		logger = extent.createTest("documents from tasks middle pane change status list");
		
		documentsmiddlepane.changeStatusOfList();
	}
	
	@Test(priority = 84)
	public void documentsFromTasksMiddlePaneSortTitle()throws InterruptedException {
	
		logger = extent.createTest("documents from tasks middle pane sort by title");
		
		actionsmiddlepane.sortByTitle();
	}
	
	
	@Test(priority = 85)
	public void documentsFromTasksMiddlePaneStatusAndUnread()throws InterruptedException {
	
		logger = extent.createTest("documents from tasks middle pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}
	
	
	@Test(priority = 86)
	public void documentsFromTasksRightSideDelete() throws InterruptedException {
	
		logger = extent.createTest("documents from tasks right side delete");
		
		actionsrightside.deleteEntity();
	}
	
	@Test(priority = 87)
	public void documentsFromTasksRightSideAddAsignee() throws InterruptedException {
		
		logger = extent.createTest("documents from tasks right side add assignee");
		
		actionsrightside.addAssignee(true);
	}
	
	@Test(priority = 88)
	public void documentsFromTasksRightSideSetDate() throws InterruptedException {
		
		logger = extent.createTest("documents from tasks right side set date");
		
		actionsrightside.setDate();
	}
	
	@Test(priority = 89)
	public void documentsFromTasksRightSideAddStatus() throws InterruptedException {
		
		logger = extent.createTest("documents from tasks right side set date");
		
		actionsrightside.addStatus();
	}
	
	@Test(priority = 90)
	public void documentsFromTasksSelectFolder() throws InterruptedException {
		
		logger = extent.createTest("documents from tasks right side select folder");
		
		documentsrightside.SelectFolderOnScreen();
	}
	
	@Test(priority = 91)
	public void documentsFromTasksRightSideAddTags() throws InterruptedException {
		
		logger = extent.createTest("documents from tasks right add tags");
		
		actionsrightside.addTags("www");	
	}
	
	@Test(priority = 92)
	public void documentsFromTasksRightSideAddActivities() throws InterruptedException {
	
		logger = extent.createTest("documents from tasks right add activities");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
	}
	
	
	@AfterClass
	public void after() {

		extent.flush();



	}

}


