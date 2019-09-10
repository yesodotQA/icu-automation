package offices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import base.testBase;
import folder.folderTest;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.offices.officesMultipleSelect;
import pages.offices.officesRightSide;
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

	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	
		
		this.actionsmultipleselect = new actionsMultipleSelect();		
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomactions = new randomActions();
		this.officesmultipleselect = new officesMultipleSelect();
		this.officesrightside = new officesRightSide();
		this.foldersfromoffices = new foldersFromOffices();
		this.foldertest = new folderTest(); 
	}
	
	@Test(priority = 1)
	public void openOffice() throws InterruptedException {
		
		officesmultipleselect.pressOffices();
		
		//open doc  enter title and description
		actionsmiddlepane.openEntity("office1" , "importenet");
		
	}
	
	@Test(priority = 2)
	public void officesMultipleSelect() throws InterruptedException {
		
		logger = extent.createTest("offices multiple select");
		
		actionsmultipleselect.deleteEntityMultipleChoice();
		
		actionsmiddlepane.openEntity("ramat", "sajdkkdhjsd");
		
		actionsmultipleselect.addWatchersMultipleChoice();
	}
	
	@Test(priority = 3)
	public void officesMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("offices middle pane");
		
		randomactions.enterNameToEntity("hyyyyyyyyy");
		
		// choose entity and press on favorite 
		//actionsmiddlepane.sortByFavorite();
		
		// sort the list by title
		actionsmiddlepane.sortByTitle();
		
		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();
		
		// press on arrow to reverse the order of the list
		//actionsmiddlepane.pressOnArrow();
	}
	
	@Test(priority = 4)
	public void officesRightSide() throws InterruptedException {
		
		logger = extent.createTest("offices the right side on the screen");

		actionsrightside.deleteEntity();

		actionsmiddlepane.openEntity("folderTest", "isr");

		randomactions.chooseColor();

		actionsrightside.addActivities("hyyyyyy" , "this is superman");

		officesrightside.signatures("Aviram", "Lieutenant", "Team Leader of QA", "Sapir");

		actionsrightside.changePermission();

		officesrightside.inheritance();
		
	}
	
	@Test(priority = 5)
	
	public void foldersFromOffices() throws InterruptedException, IOException {
		
		logger = extent.createTest("start test folders from offices");
		
		officesmultipleselect.pressOffices();
		
		actionsmiddlepane.openEntity("folder from offices" , "sad");
		
		foldersfromoffices.getIntoFoldersFromOffices();
		
		actionsmiddlepane.openEntity("folder1" , "importenet");
		
		foldertest.SetUp();
		
	
		foldertest.foldersMultipleSelect();
		
		foldertest.foldersMiddlePane();
		
		foldertest.foldersRightSide();
		
		
	}

	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
	
	
	}
