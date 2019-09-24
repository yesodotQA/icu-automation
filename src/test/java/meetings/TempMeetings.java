package meetings;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

public class TempMeetings extends testBase {

	documentsMultipleSelect    documentsmultipleselect;
	documentsMiddlePane        documentsmiddlepane;
	middlePane                 middlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane          actionsmiddlepane;
	actionsRightSide           actionsrightside;
	actionsMultipleSelect      actionsmultipleselect;
	Tabs 					   tabs;
	MeetingsFunctions		   meetingsfunctions;
	meetingsTest			   meetingstest;
	@BeforeClass
	
	public void SetUp() throws InterruptedException, IOException {	
	
	this.tabs                       = new Tabs();
	this.actionsmultipleselect      = new actionsMultipleSelect();
	this.documentsmultipleselect    = new documentsMultipleSelect();
	this.documentsmiddlepane        = new documentsMiddlePane();
	this.middlepane                 = new middlePane();
	this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
	this.actionsmiddlepane          = new actionsMiddlePane();
	this.actionsrightside           = new actionsRightSide();
	this.meetingsfunctions			= new MeetingsFunctions();
	this.meetingstest				= new meetingsTest();
	PageFactory.initElements(driver, this);

	
	
	tabs.meetingsTab.click();
	
	}
	
	@Test (priority = 1)
	public void MultipleChoiceFunction () throws InterruptedException, IOException {
	
		logger = extent.createTest("set a date in meetings");
		
		meetingsfunctions.MeetingFromProjects();
		
		meetingstest.SetUp();
		
		meetingstest.MultipleChoiceFunction();
		
		meetingstest.MiddlePaneFunction();
		
		meetingstest.RightSideFunction();
		
	}
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}
