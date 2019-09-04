package task;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
		
	    @FindBy(xpath = "/html/body/section/section/div[1]/header/div[1]/div/span")
	    public WebElement MyTasks;
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
		public void SetUp() throws InterruptedException, IOException{	
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
		public void MyTasks() throws InterruptedException {
			Thread.sleep(2000);
			actionsmiddlepane.openEntity("doc1","important");
			
			logger = extent.createTest("My Task using multiple choice");
			
			Thread.sleep(2000);
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			Thread.sleep(2000);
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc2" , "imporant2");
			
			Thread.sleep(2000);
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			
			Thread.sleep(2000);
			actionsmultipleselect.addDateMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addWatchersMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addStatusMultipleChoice();
			
			Thread.sleep(2000);
			logger = extent.createTest("My Task template");
			
			Thread.sleep(2000);
			actionsrightside.deleteEntity();
			
			Thread.sleep(2000);
			actionsrightside.addAssignee();
			
			Thread.sleep(2000);
			actionsrightside.setDate();
			
			Thread.sleep(2000);
			actionsrightside.addStatus();
			
			Thread.sleep(2000);		
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
			Thread.sleep(2000);
			tasksrightsideonscreen.SelecttasksOnScreen();
			
			Thread.sleep(2000);
			actionsrightside.addTags("yaronnn");
			
			Thread.sleep(2000);
			actionsrightside.addActivities("sad", "memurmar");
			
			Thread.sleep(2000);
			actionsrightside.addWatcher();

			Thread.sleep(2000);
			subTasks.SubTaskEdit();
			
			Thread.sleep(2000);
			subTasks.TaskTemplate();
		}
		@Test(priority = 2)
		public void openDoc() throws InterruptedException {
		
			// press Task tab
			tasksmultipleselect.pressTask();
			
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc1" , "important");
		}	

		@Test(priority = 3)
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
	
		@Test(priority = 4)
		public void tasksMiddlePane()throws InterruptedException {
			logger = extent.createTest("Task using middle pane");
			
			tasksmiddlepane.changeStatusOfList();
			
			//tasksmiddlepane.sortByFavorite();
			
			actionsmiddlepane.sortByTitle();
			
			actionsmiddlepane.sordByStatusAndUnread();
			
			//actionsmiddlepane.pressOnArrow();
		}
		
		@Test(priority = 5)
		public void tasksRightSideOnScreen()throws InterruptedException {
			
			logger = extent.createTest("Task using right side on screen");
			
			actionsrightside.deleteEntity();
			
			actionsrightside.addAssignee();
			
			actionsrightside.setDate();
			
			actionsrightside.addStatus();
			
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
			tasksrightsideonscreen.SelecttasksOnScreen();
			
			actionsrightside.addTags("yaronnn");
			
			actionsrightside.addActivities("sad", "memurmar");
			
			actionsrightside.addWatcher();
		
		}
		
		
		
		@Test(priority = 6)
		public void SubTask()throws InterruptedException{
			logger = extent.createTest("Task template");
			
		//	subTasks.SubTaskEdit();
			
		//	subTasks.TaskTemplate();
		}
		
		
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




