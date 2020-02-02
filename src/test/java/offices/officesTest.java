package offices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import base.testBase;
import folder.folderTest;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.offices.officesMultipleSelect;
import pages.offices.officesRightSide;
import pages.documents.documentsMiddlePane;
import pages.offices.foldersFromOffices;

public class officesTest extends testBase {

	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	randomActions randomactions;
	officesMultipleSelect officesmultipleselect;
	officesRightSide officesrightside;
	foldersFromOffices foldersfromoffices;
	folderTest foldertest;
	documentsMiddlePane documentsmiddlepane;
	
	
	@BeforeClass
	public void SetUp() throws InterruptedException, IOException {

		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomactions = new randomActions();
		this.officesmultipleselect = new officesMultipleSelect();
		this.officesrightside = new officesRightSide();
		this.foldersfromoffices = new foldersFromOffices();
		this.foldertest = new folderTest();
		this.documentsmiddlepane = new documentsMiddlePane();
		officesmultipleselect.pressOffices();
		actionsmiddlepane.openEntity("office1", "importent");
	}

	@Test(priority = 1)
	 void deleteMultipleChoice() throws InterruptedException {

		logger = extent.createTest("offices multiple select delete");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}

	@Test(priority = 2)
	public void addWatchersMultipleChoice() throws InterruptedException {

		logger = extent.createTest("offices multiple select add watchers");

		actionsmiddlepane.openEntity("ramat", "sajdkkdhjsd");

		actionsmultipleselect.addWatchersMultipleChoice();

	}

	@Test(priority = 3) 
	public void officesMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest("offices middle pane sort title");

		// sort the list by title

		actionsmiddlepane.sortByTitle();

	}

	// press on arrow to reverse the order of the list //
	// actionsmiddlepane.pressOnArrow();

	// choose entity and press on favorite // //
	//actionsmiddlepane.sortByFavorite();

	@Test(priority = 4) 
	public void officesMiddlePaneSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest("offices middle pane sort status and unread");

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();

	}

	@Test(priority = 5)
	public void officesRightSideDelete() throws InterruptedException {

		logger = extent.createTest("offices right side delete ");

		actionsrightside.deleteEntity();

	}

	@Test(priority = 6) 
	public void chooseColor() throws InterruptedException {

		logger = extent.createTest(" office right side chooose color");

		actionsmiddlepane.openEntity("officeTest", "isr");

		randomactions.chooseColor(); 
		
	}

	@Test(priority = 7) 
	public void officeAddActivities() throws InterruptedException {

		logger = extent.createTest("office right side add activities");

		actionsrightside.addActivities("hyyyyyy", "this is superman");

	}

	@Test(priority = 8) 
	public void  officeAddSignetures() throws InterruptedException {

		logger = extent.createTest("office add signetures");

		officesrightside.signatures("Aviram", "Lieutenant", "Team Leader of QA","Sapir");

	}

	@Test(priority = 9)
	public void OfficechangePermissionsn() throws InterruptedException {

		logger = extent.createTest("office right side change permissions");

		actionsrightside.changePermission();

	}

	@Test(priority = 10) 
	public void inheritance() throws InterruptedException {

		logger = extent.createTest("office inheritance");

		officesrightside.inheritance();

	}

	@Test(priority = 11)

	public void GetIntoFoldersFromOffices() throws InterruptedException, IOException {

		logger = extent.createTest("get into Folder From Office");

		officesmultipleselect.pressOffices();

		actionsmiddlepane.openEntity("folder from offices", "sad");

		foldersfromoffices.getIntoFoldersFromOffices();

	}

	@Test(priority = 12) 
	public void folderFromOfficesMultipleChoiceDelete() throws InterruptedException{

		logger = extent.createTest("folder from office multiple choice delete");		  

		actionsmiddlepane.openEntity("folder1" , "importenet");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}

	@Test(priority = 13) 
	public void folderFromOfficesMultipleChoiceAddTags() throws InterruptedException{

		logger = extent.createTest("folder from office multiple choice add tags");	  

		actionsmultipleselect.addTagsMultipleChoice("kamnar");
		
	}
	
	@Test(priority = 14)
	public void  folderFromOfficesMultipleChoiceAddWatchers()  throws InterruptedException{
		
		logger = extent.createTest("folder from office multiple choice add watchers");	  
	
		actionsmultipleselect.addWatchersMultipleChoice(); 
	}

	@Test(priority = 15)
	public void  folderFromOfficesMultipleChoiceAddStatus()  throws InterruptedException {
		
		logger = extent.createTest("folder from office multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
		
	}
	
	@Test(priority = 16)
	public void  folderFromOfficesChangeStatusList()  throws InterruptedException {
	
		logger = extent.createTest("folders from office status list");

		// change the status of list entities
		documentsmiddlepane.changeStatusOfList();
	}
	
	@Test(priority = 17)
	public void  folderFromOfficesSortByTitle()  throws InterruptedException {
	
		logger = extent.createTest("folders from office sort by title");

		// sort the list by title
		actionsmiddlepane.sortByTitle();
	}
	
	// choose entity and press on favorite 
	//actionsmiddlepane.sortByFavorite();

	// press on arrow to reverse the order of the list
	//actionsmiddlepane.pressOnArrow();
		
	@Test(priority = 18)
	public void  folderFromOfficesStatusAndUnreade()  throws InterruptedException {
		
		logger = extent.createTest("folders from office sort by status and unread");

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();
	}
	
	@Test(priority = 19)
	public void foldersFromOfficeRightSideDelete() throws InterruptedException {
		
		logger = extent.createTest("folder from office right side delete");

		actionsrightside.deleteEntity();
		
	}
	
	@Test(priority = 20)
	public void foldersFromOfficeRightSideAddStatus() throws InterruptedException {
	
		logger = extent.createTest("folder from office right side add status");
		
		actionsmiddlepane.openEntity("folderTest", "isr");

		actionsrightside.addStatus();
		
	}
	
	@Test(priority = 21)
	public void foldersFromOfficeChooseColors() throws InterruptedException {
		
		logger = extent.createTest("folder from office choose color");

		randomactions.chooseColor();
		
	}
	
	@Test(priority = 22)
	public void foldersFromOfficeAddTags() throws InterruptedException {
		
		logger = extent.createTest("folder from offices add tags");

		actionsrightside.addTags("www");
		
	}
	
	@Test(priority = 23)
	public void foldersFromOfficeAddActivities() throws InterruptedException {
	
		logger = extent.createTest("folder from office add activities");

		actionsrightside.addActivities("hyyyyyy" , "this is superman");	
	}
	
	
	@AfterClass
	public void after() {

		extent.flush();

	}

}
