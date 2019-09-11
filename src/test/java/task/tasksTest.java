package task;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import pages.documents.documentsMiddlePane;
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
		documentsMiddlePane documentsmiddlepane;
		
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
		}
		@Test(priority = 1)
		public void MyTasks() throws InterruptedException {
			
			actionsmiddlepane.openEntity("doc1","important");
			
			logger = extent.createTest("My Task using multiple choice");
			
			
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			
			
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			/*
			
			actionsmultipleselect.addDateMultipleChoice();
			
			
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			
			actionsmultipleselect.addWatchersMultipleChoice();
			
			
			actionsmultipleselect.addStatusMultipleChoice();
			
//			Thread.sleep(2000);
//			actionsmiddlepane.sordByStatusAndUnread();
//			
//			Thread.sleep(2000);
//			actionsmiddlepane.sortByTitle();
//			
//			Thread.sleep(2000);
//			documentsmiddlepane.changeStatusOfList();
//			
			
			logger = extent.createTest("My Task template");
			
		
			actionsrightside.deleteEntity();
			
			
			actionsrightside.addAssignee();
		
			actionsrightside.setDate();
			
			
			actionsrightside.addStatus();
			
			
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
		
			tasksrightsideonscreen.SelecttasksOnScreen();
			
		
			actionsrightside.addTags("yaronnn");
			
			actionsrightside.addActivities("sad", "memurmar");
			
			
			//actionsrightside.changePermission();
*/
			
			subTasks.SubTaskEdit();
			
			
			subTasks.TaskTemplate();
			
			//BUGGED
			//logger = extent.createTest("sort middle pane sub tasks");
			//Thread.sleep(2000);
			//subTasks.sortMiddlePane();
			
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
			
			Thread.sleep(2000);
			actionsrightside.addAssignee();
			
			actionsrightside.setDate();
			
			actionsrightside.addStatus();
			
			tasksrightsideonscreen.SelectDiscussionsOnScreen();
			
			tasksrightsideonscreen.SelecttasksOnScreen();
			
			actionsrightside.addTags("yaronnn");
			
			actionsrightside.addActivities("sad", "memurmar");
			
			actionsrightside.addWatcher();
			
			Thread.sleep(2000);
			subTasks.SubTaskEdit();
			
			Thread.sleep(2000);
			subTasks.TaskTemplate();
			
			Thread.sleep(2000);
			subTasks.sortMiddlePane();
		
		}
		
		
		
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




