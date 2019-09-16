package task;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.testBase;
import document.documentsTest;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
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
	}

	@Test(priority = 1)
	public void openTask() throws InterruptedException {
		logger = extent.createTest("all Task ");
		// press Task tab
		tasksmultipleselect.pressTask();

		//open doc  enter title and description
		actionsmiddlepane.openEntity("doc1" , "important");
	}	
	
	@Test(priority = 2)
	public void allTasksMulitipleChoice() throws InterruptedException {
		
		
		logger = extent.createTest("multiple choice");

		// delete entity using multiple select
		actionsmultipleselect.deleteEntityMultipleChoice();

		actionsmultipleselect.addTagsMultipleChoice("mission");

		actionsmultipleselect.addDateMultipleChoice();

		actionsmultipleselect.addAssigneeMultipleChoice();

		actionsmultipleselect.addWatchersMultipleChoice();

		actionsmultipleselect.addStatusMultipleChoice();

	}
	
	@Test(priority = 3)
	public void alltasksMiddlePane()throws InterruptedException {
		logger = extent.createTest(" middle pane");
		
		randomaction.enterNameToEntity("hyyyyyyyyy");
		
		tasksmiddlepane.changeStatusOfList();

		//tasksmiddlepane.sortByFavorite();

		actionsmiddlepane.sortByTitle();

		actionsmiddlepane.sordByStatusAndUnread();

		//actionsmiddlepane.pressOnArrow();
	}

	@Test(priority = 4)
	public void alltasksRightSide()throws InterruptedException {

		logger = extent.createTest("right side on screen");

		actionsrightside.deleteEntity();

		actionsrightside.addAssignee();

		actionsrightside.setDate();

		actionsrightside.addStatus();

		tasksrightsideonscreen.SelectDiscussionsOnScreen();

		tasksrightsideonscreen.SelectProjectsOnScreen();

		actionsrightside.addTags("yaronnn");

		actionsrightside.addActivities("sad", "memurmar");

		actionsrightside.changePermission();		

		tasksrightsideonscreen.duplicateTasks();
		
		
	}
	
	@Test(priority = 5)
	public void allTaksSubTasksMultipleChoice()throws InterruptedException {
		
		logger = extent.createTest("sub tasks from all tasks");
		
		actionsmiddlepane.openEntity("sub tasks", "sfdjh");
		
		subTasks.addSubTasks();
		
		subTasks.deleteSubTasks();
		
		subTasks.createSubTasks();
		
		actionsmiddlepane.openEntity("subtasks22", "rhfjfrjk");
		
		allTasksMulitipleChoice();
		
		logger.log(Status.INFO, "middle pane not work");
		
	}

	@Test(priority = 6)
	public void allTaksSubTasksRightSide()throws InterruptedException {
		
		logger = extent.createTest("right side");
		
		actionsrightside.deleteEntity();

		actionsrightside.addAssignee();

		actionsrightside.setDate();

		actionsrightside.addStatus();
		
		actionsrightside.addTags("yaronnn");

		actionsrightside.addActivities("sad", "memurmar");

		actionsrightside.changePermission();		

		tasksrightsideonscreen.duplicateTasks();
		
	}
	
	
	@Test(priority = 7 )
	public void MyTasksMultipleSelect() throws InterruptedException {
		
		tasksmultipleselect.pressMyTask();
		
		logger = extent.createTest("my tasks");
	
		actionsmiddlepane.openEntity("My tasks", "jgj");
		
		allTasksMulitipleChoice();
		
		logger.log(Status.INFO, "middle pane not work");
	
		//			Thread.sleep(2000);
		//			actionsmiddlepane.sordByStatusAndUnread();
		//			
		//			Thread.sleep(2000);
		//			actionsmiddlepane.sortByTitle();
		//			
		//			Thread.sleep(2000);
		//			documentsmiddlepane.changeStatusOfList();
		//			
	}

	@Test(priority = 8)
	public void MyTasksRightSide() throws InterruptedException {
	
		logger = extent.createTest("right Side");

		actionsrightside.deleteEntity();

		actionsrightside.addAssignee();

		actionsrightside.setDate();

		actionsrightside.addStatus();

		tasksrightsideonscreen.SelectDiscussionsOnScreen();

		tasksrightsideonscreen.SelectProjectsOnScreen();

		actionsrightside.addTags("yaronnn");

		actionsrightside.addActivities("sad", "memurmar");
		
		tasksrightsideonscreen.duplicateTasks();
		
		logger.log(Status.INFO, "Permission not work in my tasks");
		
		//actionsrightside.changePermission();		

	}
	
	@Test(priority = 9)
	public void MyTasksSubTasksMultipleChoice() throws InterruptedException {

		logger = extent.createTest("sub Tasks from MyTasks ");
		
		actionsmiddlepane.openEntity("haaushh", "sfdjh");

		subTasks.addSubTasks();
		
		subTasks.deleteSubTasks();

		subTasks.createSubTasks();
		
		actionsmiddlepane.openEntity("subtasks22", "rhfjfrjk");
		
		allTasksMulitipleChoice();

		logger.log(Status.INFO, "middle pane not work");
	}


	@Test(priority = 10)
	public void MyTasksSubTasksRightSide() throws InterruptedException {

		allTaksSubTasksRightSide();
		

	}
	
	@Test(priority = 11)
	public void documentsFromTasks() throws InterruptedException, IOException {
		
		logger = extent.createTest("documents from tasks");
		
		documentsfromtasks.getIntoDocumentsFromTasks();
	
		actionsmiddlepane.openEntity("document 123456","ahalan");
		
		documentstest.SetUp();
		
		documentstest.documentsMultipleSelect();
		
		documentstest.documentsMiddlePane();
		
		documentstest.documentsRightSide();
	}

	@AfterClass
	public void after() {

		extent.flush();
		
		

	}

}


