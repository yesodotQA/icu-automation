import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import pages.documents.documentsMiddlePane;
import pages.documents.documentsMultipleSelect;
import pages.documents.documentsRightSideOnScreen;

public class tests {

	documentsMultipleSelect documentsmultipleselect;
	documentsMiddlePane documentsmiddlepane;
	documentsRightSideOnScreen documentsrhigtsideonscreen;
	actionsMiddlePane actionsmiddlepane;
	actionsRightSide actionsrightside;
	actionsMultipleSelect actionsmultipleselect;
	randomActions randomaction;
	
	
	
	@BeforeClass
	public void tests1() throws InterruptedException, IOException{
		
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.documentsmultipleselect = new documentsMultipleSelect();
		this.documentsmiddlepane = new documentsMiddlePane();
		this.documentsrhigtsideonscreen = new documentsRightSideOnScreen();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		this.randomaction = new randomActions();
		
	}
	
	@Test(priority = 2)
	public void documentsMultipleSelect() throws InterruptedException {
	
	
	actionsmultipleselect.deleteEntityMultipleChoice();

	actionsmultipleselect.addTagsMultipleChoice("mission");

	actionsmultipleselect.addDateMultipleChoice();

	actionsmultipleselect.addAssigneeMultipleChoice();
	
	actionsmultipleselect.addWatchersMultipleChoice();
	
	actionsmultipleselect.addStatusMultipleChoice();
	
}
	
	
	
}
