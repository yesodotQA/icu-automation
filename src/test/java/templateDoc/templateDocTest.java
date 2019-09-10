package templateDoc;

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
		initialization(); 
		Login();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomactions = new randomActions();
		this.templatedocsmultipleselect = new templateDocMultipleSelect();
		this.templatedocrightside = new templateDocRightSide();
	}
	

	@Test(priority = 1)
	public void openTemplateDOC() throws InterruptedException {
		
		templatedocsmultipleselect.pressTemplateDoc();
		
		actionsmiddlepane.openEntity("template1" , "importenet");
	
	}

	@Test(priority = 2)
	public void templateDocMultipleSelect() throws InterruptedException {
		
		logger = extent.createTest("template doc multiple select");

		actionsmultipleselect.deleteEntityMultipleChoice();
		
	}
	
	@Test(priority = 3)
	public void templateDocMiddlePane() throws InterruptedException {
		
		logger = extent.createTest("template doc middle pane");
		
		actionsmiddlepane.openEntity("ramt", "dasdsa");
		
		randomactions.enterNameToEntity("hyyyyyyyyy");
		
		// sort the list by title
		actionsmiddlepane.sortByTitle();

		// press on sort by status and unread
		actionsmiddlepane.sordByStatusAndUnread();

		// press on arrow to reverse the order of the list
		//actionsmiddlepane.pressOnArrow();
		
	}
	
	@Test(priority = 4)
	public void templateDocRightSide() throws InterruptedException {
		
		logger = extent.createTest("template document the right side on the screen");
		
		actionsrightside.deleteEntity();

		actionsmiddlepane.openEntity("templateDocsTest", "isr");
		
		templatedocrightside.SelectOfficeOnScreen();
		
		actionsrightside.addActivities("hyyyyyy" , "this is superman");
		
		
		
	}
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
	
  }
