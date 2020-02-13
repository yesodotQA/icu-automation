package folder;

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
import pages.documents.documentsMiddlePane;
import pages.folders.documentsFromFolder;
import pages.folders.foldersMultipleSelect;
import pages.folders.foldersRightSide;

public class folderTest extends testBase{

	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	foldersMultipleSelect foldermultipleselect;
	foldersRightSide folderrightside;
	documentsMiddlePane documentsmiddlepane;
	randomActions randomactions;
	documentsFromFolder docfromfolder;
	documentsTest documentstest;
	
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	

		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.foldermultipleselect = new foldersMultipleSelect();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.randomactions = new randomActions();
		this.folderrightside = new foldersRightSide();
		this.docfromfolder = new documentsFromFolder();
		this.documentstest = new documentsTest();

	}
	@Test(priority = 0)
	public void goToFolder() throws InterruptedException {

		foldermultipleselect.pressFolders();

	}	

	@Test(priority = 1)
	public void foldersMultipleSelectDelete() throws InterruptedException {

		logger = extent.createTest("folders multiple select delete");

		actionsmiddlepane.openEntity("folder1" , "importenet");

		actionsmultipleselect.deleteEntityMultipleChoice();
		
	}

	@Test(priority = 2)
	public void foldersMultipleSelectAddTags() throws InterruptedException {

		logger = extent.createTest("folders multiple select add tags");

		actionsmultipleselect.addTagsMultipleChoice("mission");
	}

	@Test(priority = 3)
	public void foldersMultipleSelectAddWatchers() throws  InterruptedException {

		logger = extent.createTest("folders multiple select add watchers");

		actionsmultipleselect.addWatchersMultipleChoice(); 

	}

	@Test(priority = 4)
	public void foldersMultipleSelectAddStatus() throws InterruptedException {

		logger = extent.createTest("folders multiple select add status");

		actionsmultipleselect.addStatusMultipleChoice();

	}


	@Test(priority = 5)
	public void foldersChangeStatusList() throws InterruptedException {
		logger = extent.createTest("folders status list");

		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
	}

	@Test(priority = 6)
	public void foldersSortByTitle() throws InterruptedException {

		logger = extent.createTest("folders sort by title");

		// sort the list by title
		actionsmiddlepane.sortByTitle();
	}

	// choose entity and press on favorite 
	//actionsmiddlepane.sortByFavorite();

	// press on arrow to reverse the order of the list
	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 7)
	public void folderStatusAndUnread() throws InterruptedException {

		logger = extent.createTest("folders sort by status and unread");

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();


	}
	
	@Test(priority = 8)
	public void foldersRightSideDelete() throws InterruptedException {

		logger = extent.createTest("folder delete");

		actionsrightside.deleteEntity();
	}

	@Test(priority = 9)
	public void foldersAddStatus() throws InterruptedException {

		logger = extent.createTest("folder add status");

		actionsmiddlepane.openEntity("folderTest", "isr");

		actionsrightside.addStatus();

	}

	@Test(priority = 10)
	public void foldersChooseColors() throws InterruptedException {

		logger = extent.createTest("folder choose color");

		randomactions.chooseColor();
	}
	
	@Test(priority = 11)
	public void foldersSelectOffice() throws InterruptedException {

		logger = extent.createTest("folder select office");

		folderrightside.SelectOfficeOnScreen();
	}

	@Test(priority = 12)
	public void foldersAddTags() throws InterruptedException {

		logger = extent.createTest("folder add tags");

		actionsrightside.addTags("www");
	}

	@Test(priority = 13)
	public void foldersAddActivities() throws InterruptedException {

		logger = extent.createTest("folder add activities");

		actionsrightside.addActivities("hyyyyyy" , "this is superman");			
	}


	@Test(priority = 14)
	public void foldersChangPermissions() throws InterruptedException {

		logger = extent.createTest("folder change permissions");

		actionsrightside.changePermission();

	}

	  @Test(priority = 15)
	  public void  GetIntoDocumentsFromFolder() throws InterruptedException, IOException {
	  
	  logger = extent.createTest("get into documents from folder");
	  
	  docfromfolder.getIntoDocumentsFromFolder();
	  
	}
	  
	  @Test(priority = 16)
	  public void documentsFromFolderMultipleChoiceDelete() throws InterruptedException {
	   
		  logger = extent.createTest("doc from folder multiple choice delete");
		  
		  actionsmiddlepane.openEntity("doc123456789", "ghjydgj");
		  
		  actionsmultipleselect.deleteEntityMultipleChoice();
		   
	  }
	  
	  @Test(priority = 17)
	  public void documentsFromFolderMultipleChoiceAddTags() throws InterruptedException {
	  
		  logger = extent.createTest("documents from folder multiple chouce add tags");
		  
		  actionsmultipleselect.addTagsMultipleChoice("doc");
		  
	  }
	  
	  @Test(priority = 18)
	  public void documentsFromFolderMultipleChoiceAddDate() throws InterruptedException {
		
		  logger = extent.createTest("documents from folder multiple chouce add date");
		  
		  actionsmultipleselect.addDateMultipleChoice();
		  
	  }
	  
	  @Test(priority = 19)
	  public void documentsFromFolderMultipleChoiceAddAssignee() throws InterruptedException {
		
		  logger = extent.createTest("documents from folder multiple chouce add assignee");
		  
		  actionsmultipleselect.addAssigneeMultipleChoice();
			
	  }
	  
	  @Test(priority = 20)
	  public void documentsFromFolderMultipleChoiceAddWatchers() throws InterruptedException {
		
		  logger = extent.createTest("documents from folder multiple choice add watchers");
		   
		  actionsmultipleselect.addWatchersMultipleChoice();
	  }
	  
	  @Test(priority = 21)
	  public void documentsFromFolderMultipleChoiceAddStatus() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder multiple choice add Status");
		  
		  actionsmultipleselect.addStatusMultipleChoice();
	  } 
		
	  @Test(priority = 22)
	  public void documentsFromFolderMiddlePaneStatusList() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder middle pane change status list");
		  
			documentsmiddlepane.changeStatusOfList();
	  } 
	  
	  @Test(priority = 23)
	  public void documentsFromFolderMiddlePaneSortTitle() throws InterruptedException {
		  
			logger = extent.createTest("documents from folder middle pane sort by title");
			
			actionsmiddlepane.sortByTitle();
	  }
	  
	  // choose entity and press on favorite 
	  //actionsmiddlepane.sortByFavorite();


	  // press on arrow to reverse the order of the list
	  //actionsmiddlepane.pressOnArrow();
		
	  @Test(priority = 24)
	  public void documentsFromFolderMiddlePaneStatusAndUnread() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder middle pane sort by status and unread");
			
		  actionsmiddlepane.sordByStatusAndUnread();
	  }
	  
	  @Test(priority = 25)
	  public void documentsFromFolderRightSideDelete() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side delete");
		  
		  actionsrightside.deleteEntity();
	  }
	  
	  @Test(priority = 26)
	  public void documentsFromFolderRightSideAddAsignee() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side add assignee");
		  
		  actionsrightside.addAssignee(true);
	  }
	  
	  @Test(priority = 27)
	  public void documentsFromFolderRightSideSetDate() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side set date");
		  
		  actionsrightside.setDate();
	  }
	  
	  @Test(priority = 28)
	  public void documentsFromFolderRightSideAddStatus() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side add status");
		  
		  actionsrightside.addStatus();
	  }
	  
	  @Test(priority = 29)
	  public void documentsFromFolderRightSideAddTags() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side add tags");
		  
		  actionsrightside.addTags("DocFromFolder");
	  }
	  
	  @Test(priority = 30)
	  public void documentsFromFolderRightSideAddActivities() throws InterruptedException {
		  
		  logger = extent.createTest("documents from folder right side add activities");
		  
		  actionsrightside.addActivities("hyyyyyy" , "this is superman");
	  }
	  
	
	@AfterClass
	public void after() {

		extent.flush();

	}



}

















