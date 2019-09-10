package meetings;

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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;
import pages.meetings.MeetingsFunctions;

public class meetingsTest extends testBase {

	documentsMultipleSelect    documentsmultipleselect;
	documentsMiddlePane        documentsmiddlepane;
	middlePane                 middlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane          actionsmiddlepane;
	actionsRightSide           actionsrightside;
	actionsMultipleSelect      actionsmultipleselect;
	Tabs 					   tabs;
	MeetingsFunctions		   meetingsfunctions;

	@BeforeClass
	
	public void SetUp() throws InterruptedException, IOException{	
	initialization(); 
	Login();
	
	this.tabs                       = new Tabs();
	this.actionsmultipleselect      = new actionsMultipleSelect();
	this.documentsmultipleselect    = new documentsMultipleSelect();
	this.documentsmiddlepane        = new documentsMiddlePane();
	this.middlepane                 = new middlePane();
	this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
	this.actionsmiddlepane          = new actionsMiddlePane();
	this.actionsrightside           = new actionsRightSide();
	this.meetingsfunctions			= new MeetingsFunctions();
	
	tabs.meetingsTab.click();
	
	}
	
	@Test (priority = 1)
	public void MultipleChoiceFunction () throws InterruptedException {
	
		logger = extent.createTest("Test Multiple Choice in Meetings");
		
		actionsmultipleselect.addAssigneeMultipleChoice();
		actionsmultipleselect.addDateMultipleChoice();
		actionsmultipleselect.addStatusMultipleChoice();
		actionsmultipleselect.addTagsMultipleChoice("Meetings ASAP");
		actionsmultipleselect.addWatchersMultipleChoice();
		actionsmultipleselect.deleteEntityMultipleChoice();
	}
	
	@Test (priority = 2)
	public void MiddlePaneFunction () throws InterruptedException {
		
		logger = extent.createTest("Test the Middle Pane Functionality");
		
		actionsmiddlepane.openEntity("Title Test", "Open Entity Perfectly!!!");
		//actionsmiddlepane.sortByFavorite();
		actionsmiddlepane.sortByTitle();
		actionsmiddlepane.sordByStatusAndUnread();
		//actionsmiddlepane.pressOnArrow();
		
	}
	
	@Test (priority = 3)
	public void RightSideFunction () throws InterruptedException {
		logger = extent.createTest("Test the Right Side functionality");
				
		
		
	}
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}
