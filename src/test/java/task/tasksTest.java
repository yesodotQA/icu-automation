package task;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksMultipleSelect;
import pages.tasks.tasksRightSideOfScreen;
import pages.tasks.subTasks;
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
		
		@BeforeClass
		public void SetUp() throws InterruptedException{	
		initialization(); 
		Login();
		
		this.subTasks = new subTasks();
		this.tasksmultipleselect = new tasksMultipleSelect();
		this.middlepane = new middlePane();
		this.tasksmiddlepane = new tasksMiddlePane();
		this.tasksrightsideonscreen = new tasksRightSideOfScreen();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		}
		
		@Test(priority = 1)
		public void openDoc() throws InterruptedException {
		
			// press Task tab
			tasksmultipleselect.pressTask();
		  
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc1" , "important");
		}
		
		@Test(priority = 2)
		public void TasksMulitipleChoice() throws InterruptedException {
		
			logger = extent.createTest("Task using multiple choice");
			
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			actionsmultipleselect.addDateMultipleChoice();
			
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			actionsmultipleselect.addWatchersMultipleChoice();
			
			actionsmultipleselect.addStatusMultipleChoice();
			
		}
		
		@Test(priority = 3)
		public void tasksMiddlePane()throws InterruptedException {
			logger = extent.createTest("Task using middle pane");
			
			tasksmiddlepane.changeStatusOfList();
			
			//tasksmiddlepane.sortByFavorite();
			
			actionsmiddlepane.sortByTitle();
			
			actionsmiddlepane.sordByStatusAndUnread();
			
			//actionsmiddlepane.pressOnArrow();
		}
		
		@Test(priority = 4)
		public void tasksRightSideOnScreen()throws InterruptedException {
			
			logger = extent.createTest("Task using right side on screen");
			
			actionsrightside.deleteEntity();
			
			actionsrightside.addAssignee();
			
			actionsrightside.setDate();
			
			tasksrightsideonscreen.addStatusOnScreen();
			
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
			tasksrightsideonscreen.SelectProjectsOnScreen();
			
			actionsrightside.addTags("yaronnn");
			
			actionsrightside.addActivities("sad", "memurmar");
			
			actionsrightside.addWatcher();
		
		}
		
		
		
		@Test(priority = 5)
		public void TasksTemplate()throws InterruptedException{
			logger = extent.createTest("Task template");
			
			
			subTasks.SubTaskEdit();
			
			subTasks.TaskTemplate();
		}
		/*
		public void MyTasks() throws InterruptedException {
			tabs.MyTasks.click();
			
			Thread.sleep(2000);
			tasksmiddlepane.openEntity("doc1" , "important");
			
			logger = extent.createTest("My Task using multiple choice");
			
			// delete entity using multiple select
			taskspage.deleteEntityMultipleChoice();
			
			//open doc  enter title and description
			taskspage.openEntity("doc2" , "imporant2");
			
			taskspage.addTagsMultipleChoice("mission");
			
			taskspage.addDateMultipleChoice();
			
			taskspage.addAssigneeMultipleChoice();
			
			taskspage.addWatchersMultipleChoice();
			
			taskspage.addStatusMultipleChoice();
			
			logger = extent.createTest("My Task template");
			
			taskspage.TaskTemplate();
			
			taskspage.SubTask();
		}
		
		*/
		
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




