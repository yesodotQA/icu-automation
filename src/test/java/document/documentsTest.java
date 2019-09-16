
package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;
import pages.documents.tasksFromDocuments;
import pages.tasks.subTasks;
import task.tasksTest;;

public class documentsTest extends testBase {
	
	documentsMultipleSelect documentsmultipleselect ;
	documentsMiddlePane documentsmiddlepane ;
	documentsRightSideOnScreen documentsrhigtsideonscreen ;
	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside ;
	actionsMultipleSelect actionsmultipleselect;
	randomActions randomaction;
	tasksFromDocuments tasksfromdoc;
	tasksTest taskstest;
	subTasks subtasks;


	@BeforeClass
	public void SetUp() throws InterruptedException, IOException {		
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.documentsmultipleselect = new documentsMultipleSelect();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomaction = new randomActions();
		this.tasksfromdoc = new tasksFromDocuments();
		this.taskstest = new tasksTest();
		this.subtasks = new subTasks();
	}
		
		
	@Test( priority = 1)
	public void openDoc() throws InterruptedException {
		logger = extent.createTest("documentt");
		// press document tab
		documentsmultipleselect.pressDocument();
	  
		//open doc  enter title and description
		actionsmiddlepane.openEntity("doc1" , "importenet");
	}
	
	@Test (priority = 2 )
		public void documentsMultipleSelect() throws InterruptedException {
		
		logger = extent.createTest("multiple select");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
	
		actionsmultipleselect.addTagsMultipleChoice("mission");

		actionsmultipleselect.addDateMultipleChoice();
	
		actionsmultipleselect.addAssigneeMultipleChoice();
		
		actionsmultipleselect.addWatchersMultipleChoice();
		
		actionsmultipleselect.addStatusMultipleChoice();
		
	}
	@Test(priority = 3)
	public void documentsMiddlePane() throws InterruptedException {
		
		logger = extent.createTest(" middle pane");
		
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
	
	@Test(priority =4)
	public void documentsRightSide() throws InterruptedException {
		
		logger = extent.createTest("the right side on the screen");
		
		actionsrightside.deleteEntity();
		
		actionsrightside.addAssignee();
		
		actionsrightside.setDate();
		
		actionsrightside.addStatus();
		
		documentsrhigtsideonscreen.SelectFolderOnScreen();
		
		actionsrightside.addTags("www");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
		
		actionsrightside.changePermission();
	}
	
	@Test(priority = 5)
	public void TasksFromDocuments() throws InterruptedException, IOException {
		logger = extent.createTest("tasksFromDocuments");
		
		tasksfromdoc.getIntoTasksFromDocuments();
		
		actionsmiddlepane.openEntity("task1" , "importenet");
		
		taskstest.SetUp();
		
		logger.log(Status.INFO, "multiple choice in taks from doc not work good");
		
		taskstest.allTasksMulitipleChoice();
		
		taskstest.alltasksMiddlePane();
		
		taskstest.alltasksRightSide();
		
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
	
		
	


