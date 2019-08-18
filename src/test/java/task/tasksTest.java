package task;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksMultipleSelect;
import pages.tasks.tasksRightSideOfScreen;

	public class tasksTest  extends testBase {
		
		Tabs tabs;
		tasksMultipleSelect tasksmultipleselect ;
		middlePane middlepane;
		tasksMiddlePane tasksmiddlepane;
		tasksRightSideOfScreen tasksrightsideonscreen;
		
		@BeforeClass
		public void SetUp() throws InterruptedException{	
		initialization(); 
		Login();
		tasksmultipleselect = new tasksMultipleSelect();
		middlepane = new middlePane();
		tasksmiddlepane = new tasksMiddlePane();
		tasksrightsideonscreen = new tasksRightSideOfScreen();
		}
		
		@Test(priority = 1)
		public void openDoc() throws InterruptedException {
		
			// press Task tab
			tasksmultipleselect.pressTask();
		  
			//open doc  enter title and description
			middlepane.openEntity("doc1" , "important");
		}
		
		@Test(priority = 2)
		public void TasksMulitipleChoice() throws InterruptedException {
		
			logger = extent.createTest("Task using multiple choice");
			
			// delete entity using multiple select
			 tasksmultipleselect.deleteEntityMultipleChoice();
			
			 tasksmultipleselect.addTagsMultipleChoice("mission");
			
			 tasksmultipleselect.addDateMultipleChoice();
			
			 tasksmultipleselect.addAssigneeMultipleChoice();
			
			 tasksmultipleselect.addWatchersMultipleChoice();
			
			 tasksmultipleselect.addStatusMultipleChoice();
			
		}
		
		@Test(priority = 3)
		public void tasksMiddlePane()throws InterruptedException {
			logger = extent.createTest("Task using middle pane");
			
			tasksmiddlepane.changeStatusOfList();
			
			//tasksmiddlepane.sortByFavorite();
			
			tasksmiddlepane.sortByTitle();
			
			tasksmiddlepane.sordByStatusAndUnread();
			
			//tasksmiddlepane.pressOnArrow();
		}
		
		@Test(priority = 4)
		public void tasksRightSideOnScreen()throws InterruptedException {
			
			logger = extent.createTest("Task using right side on screen");
			
			tasksrightsideonscreen.deleteEntityOnScreen();
			
			tasksrightsideonscreen.addAssigneeOnScreen();
			
			tasksrightsideonscreen.addDateOnScreen();
			
			tasksrightsideonscreen.addStatusOnScreen();
			
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
			tasksrightsideonscreen.SelectProjectsOnScreen();
			
			tasksrightsideonscreen.addTagsOnScreen("yaronnn");
			
			tasksrightsideonscreen.addActivities("sad", "memurmar");
			
			tasksrightsideonscreen.addWatcherOnScreen();
		
		}
		
		
		/*
		@Test(priority = 3)
		public void TasksTemplate()throws InterruptedException{
			logger = extent.createTest("Task template");
			
			taskspage.TaskTemplate();
			
			taskspage.SubTask();
		}
		
		public void MyTasks() throws InterruptedException {
			tabs.MyTasks.click();
			
			Thread.sleep(2000);
			taskspage.openEntity("doc1" , "important");
			
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
		
			
		




