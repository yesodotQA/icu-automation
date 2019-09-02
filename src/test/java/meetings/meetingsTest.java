package meetings;

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

public class meetingsTest extends testBase {

	documentsMultipleSelect    documentsmultipleselect;
	documentsMiddlePane        documentsmiddlepane;
	middlePane                 middlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane          actionsmiddlepane;
	actionsRightSide           actionsrightside;
	actionsMultipleSelect      actionsmultipleselect;
	Tabs 					   tabs;

	@BeforeClass
	
	public void SetUp() throws InterruptedException{	
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
	
	tabs.meetingsTab.click();
	
	}
	
	@Test
	public void temp() throws InterruptedException {
	
		Thread.sleep(2000);
		actionsmiddlepane.openEntity("Permissions","Check the Permissions changeable");
		actionsrightside.changePermission();
	}
	
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
	
	
}
