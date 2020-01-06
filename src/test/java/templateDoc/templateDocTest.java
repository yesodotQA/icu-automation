package templateDoc;

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

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.templateDocument.templateDocMultipleSelect;
import pages.templateDocument.templateDocRightSide;

public class templateDocTest extends testBase{

	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	randomActions randomactions;
	templateDocMultipleSelect templatedocsmultipleselect;
	templateDocRightSide templatedocrightside;


	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	

		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomactions = new randomActions();
		this.templatedocsmultipleselect = new templateDocMultipleSelect();
		this.templatedocrightside = new templateDocRightSide();
		templatedocsmultipleselect.pressTemplateDoc();
		actionsmiddlepane.openEntity("template1" , "importenet");

	}


	@Test(priority = 1)
	public void openTemplateDOC() throws InterruptedException {

		logger = extent.createTest("template doc delete multiple select");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}
	

	@Test(priority = 2) 
	public void templateDocMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest("template documents middle pane sort title");

		// sort the list by title 

		actionsmiddlepane.sortByTitle(); 

	}
	
	// press on arrow to reverse the order of the list
	//actionsmiddlepane.pressOnArrow();

	// choose entity and press on favorite //
	//actionsmiddlepane.sortByFavorite();
	
	
	@Test(priority = 3)
	public void templateDocMiddlePaneSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest("template doc middle pane ort status and unread");

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();

		
	}

	@Test(priority = 4)
	public void templateDocRightSideDelete() throws InterruptedException {

		logger = extent.createTest("template document the right side Delete");

		actionsrightside.deleteEntity();
	}
	
	@Test(priority = 5)
	public void templateDocSelectOffice() throws InterruptedException {
	
		logger = extent.createTest("template document the right side select office");

		actionsmiddlepane.openEntity("templateDocsTest", "isr");

		templatedocrightside.SelectOfficeOnScreen();
		
	}
	
	@Test(priority = 6)
	public void templateDocAddActivities() throws InterruptedException {
		
		logger = extent.createTest("template document the right side add activities");
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");

	}

	@AfterClass
	public void after() {

		extent.flush();

	}

}
