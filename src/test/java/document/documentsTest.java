package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksRightSideOfScreen;
import task.tasksTest;

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
	tasksMiddlePane tasksmiddlepane;
	tasksRightSideOfScreen tasksrightside;
	
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
		this.tasksrightside = new tasksRightSideOfScreen();
		this.tasksmiddlepane = new tasksMiddlePane();
		documentsmultipleselect.pressDocument();
		actionsmiddlepane.openEntity("doc1" , "importenet");
	}
		
	
	@Test( priority = 1)
	public void documentDeleteMultipleChoice() throws InterruptedException {
	
		
		logger = extent.createTest("documents multiple select delete");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
		
	}
	
	@Test (priority = 2 )
	public void documentsMultipleSelectAddTags() throws InterruptedException {
		
		logger = extent.createTest("doc multiple select add tags");
		
		actionsmultipleselect.addTagsMultipleChoice("mission");
	}
	
	@Test (priority = 3 )
	public void documentsMultipleSelectAddDate() throws InterruptedException {
		
		logger = extent.createTest("doc multiple select add date");
		
		actionsmultipleselect.addDateMultipleChoice();
		
	}
	
	@Test (priority = 4 )
	public void documentsMultipleSelectAddAsignee() throws InterruptedException {
		
		logger = extent.createTest("doc multiple select add assignee");
		
		actionsmultipleselect.addAssigneeMultipleChoice();
		
	}
	
	@Test (priority = 5 )
	public void documentsMultipleSelectAddWatchers() throws InterruptedException {
		
		logger = extent.createTest("doc multiple select add watchers");
		
		actionsmultipleselect.addWatchersMultipleChoice();
	}
	
	
	@Test (priority = 6 )
	public void documentsMultipleSelectAddStatus() throws InterruptedException {
		
		logger = extent.createTest("doc multiple select add status");
		
		actionsmultipleselect.addStatusMultipleChoice();
		
	}
	

	@Test (priority = 7 )
	public void documentsMiddlePaneStatusList() throws InterruptedException {
		
		logger = extent.createTest("doc middle pane change status list");

		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
		
	}

	// choose entity and press on favorite 
	//actionsmiddlepane.sortByFavorite();
	
	
	// press on arrow to reverse the order of the list
	//actionsmiddlepane.pressOnArrow();
	
	@Test(priority = 8)
	public void documentsMiddlePaneSortTitle() throws InterruptedException {
		
		logger = extent.createTest("doc middle pane sort by title");
		
		// sort the list by title
		actionsmiddlepane.sortByTitle();
	}
	
	@Test(priority = 9)
	public void documentsMiddlePaneStatusAndUnread() throws InterruptedException {
		
		logger = extent.createTest("doc middle pane sort by status and unread");
		
		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();
		
	}
	
	
	@Test(priority = 10)
	public void documentsRightSideDelete() throws InterruptedException {
		
		logger = extent.createTest("doc right side delete");
		
		actionsrightside.deleteEntity();
	}
	
	@Test(priority = 11)
	public void documentsRightSideAddAsignee() throws InterruptedException {
		
		logger = extent.createTest("doc right side add assignee");
		
		actionsrightside.addAssignee(true);
		
		logger.log(Status.INFO, "bug in documents When you open entity add asignee field should be empty");
		
	}
	
	@Test(priority = 12)
	public void documentsRightSideSetDate() throws InterruptedException {
		
		logger = extent.createTest("doc right side set date");
		
		actionsrightside.setDate();
	
	}
	
	@Test(priority = 13)
	public void documentsRightSideAddStatus() throws InterruptedException {
	
		logger = extent.createTest("doc right side add status");
		
		actionsrightside.addStatus();
	
	}
	
	@Test(priority = 14)
	public void documentsSelectFolder() throws InterruptedException {
		
		logger = extent.createTest("doc right side select folder");
		
		documentsrhigtsideonscreen.SelectFolderOnScreen();
	}
	
	@Test(priority = 15)
	public void documentsAddTags() throws InterruptedException {
		
		logger = extent.createTest("doc right side add tags");
		
		actionsrightside.addTags("www");
		
	}
	
	@Test(priority = 16)
	public void documentsAddActivities() throws InterruptedException {
		
		logger = extent.createTest("doc right side add activities");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
	}
	
	@Test(priority = 17)
	public void documentsChangePremission() throws InterruptedException {
		
		logger = extent.createTest("doc right side change permissions");
		
		actionsrightside.changePermission();
	}
	
	@Test(priority = 18)
	public void GetIntoTasksFromDocuments() throws InterruptedException {
		
		  logger = extent.createTest("get into tasks from documents");
		  
		  tasksfromdoc.getIntoTasksFromDocuments();
	}
	
	@Test(priority = 19)
	public void tasksFromDocumentsMultipleChoiceDelete() throws InterruptedException {
		
		logger = extent.createTest("tasks from documents multiple choice delete");
		
		 actionsmiddlepane.openEntity("tasks123456789", "ghjydgj");
		  
		  actionsmultipleselect.deleteEntityMultipleChoice();
		
	}
	
	@Test(priority = 20)
	public void tasksFromDocumentsMultipleChoiceAddTags() throws InterruptedException {
		
		logger = extent.createTest("tasks from documents multiple choice add tags");
		
		actionsmultipleselect.addTagsMultipleChoice("mission8040");
	}
	
	@Test(priority = 21)
	public void tasksFromDocumentsMultipleChoiceSetDate() throws InterruptedException {
		
		logger = extent.createTest("tasks from documents multiple choice set date");
		
		actionsmultipleselect.addDateMultipleChoice();
	}
		
	@Test(priority = 22)
	public void tasksFromDocumentsMultipleChoiceAddAsignee() throws InterruptedException {
		
		logger = extent.createTest("tasks from documents multiple choice add asignee");
	
		actionsmultipleselect.addAssigneeMultipleChoice();
	}
	
	@Test(priority = 23)
	public void tasksFromDocumentsMultipleChoiceAddWatchers() throws InterruptedException {
	
		logger = extent.createTest("tasks from documents multiple choice add watchers");
		
		actionsmultipleselect.addWatchersMultipleChoice();
	}
	
	@Test(priority = 24)
	public void tasksFromDocumentsMultipleChoiceAddStatus() throws InterruptedException {
	
		logger = extent.createTest("tasks from documents multiple choice add statsus");
		
		actionsmultipleselect.addStatusMultipleChoice();
	}
	
	@Test(priority = 25)
	public void tasksFromDocumentsMiddlePaneStatusList() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents middle pane status list");
		
		tasksmiddlepane.changeStatusOfList();	
	}
	
	@Test(priority = 26)
	public void tasksFromDocumentsMiddlePaneSortTitle() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents sort by title");
	
		actionsmiddlepane.sortByTitle();
	}
	
	@Test(priority = 27)
	public void tasksFromDocumentsMiddlePaneSortStatusAndUnread() throws InterruptedException {
	
		logger = extent.createTest(" tasks from documents sort status and unread");
		
		actionsmiddlepane.sordByStatusAndUnread();
	}
	
	//actionsmiddlepane.pressOnArrow();
	//tasksmiddlepane.sortByFavorite();
	
	@Test(priority = 28)
	public void tasksFromDocumentsRightSideDelete() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents right side delete");
		
		actionsrightside.deleteEntity();
	}
	
	@Test(priority = 29)
	public void tasksFromDocumentsRightSideAddAssignee() throws InterruptedException {
	
		logger = extent.createTest(" tasks from documents right side add assignee");
		
		actionsrightside.addAssignee(true);
	}
	
	@Test(priority = 30)
	public void tasksFromDocumentsRightSideSetDate() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents right side set date");

		actionsrightside.setDate();
	}
	
	@Test(priority = 31)
	public void tasksFromDocumentsRightSideAddStatus() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents right side add status");
		
		actionsrightside.addStatus();
	}
	
	@Test(priority = 32)
	public void tasksFromDocumentsRightSideAddTags() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents right side add tags");
	
		actionsrightside.addTags("tasksFromFolder");
	}
	
	@Test(priority = 33)
	public void tasksFromDocumentsRightSideAddActivities() throws InterruptedException {
		
		logger = extent.createTest(" tasks from documents right side add activities");
		
		actionsrightside.addActivities("sad", "memurmar");
	}
	
	@Test(priority = 34)
	public void tasksFromDocumentsRightSideDuplicateTasks() throws InterruptedException {
		
		logger = extent.createTest("tasks from documents right side duplicate tasks");
		
		tasksrightside.duplicateTasks();
	}
	

	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
