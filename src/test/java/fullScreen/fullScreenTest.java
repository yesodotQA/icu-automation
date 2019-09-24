package fullScreen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.randomActions;
import global.globalElements.middlePane;
import pages.fullScreen.fullScreenFunctions;
import task.tasksTest;

public class fullScreenTest extends testBase {

	fullScreenFunctions fullscreenfunctions;
	tasksTest taskstest;
	actionsMiddlePane actionsmiddlepane;
	randomActions randomactions;
	actionsMultipleSelect actionmultipleselect;
	middlePane middlepane;


	@FindBy (className =  "header-button")
	WebElement FullScreenFirst;

	@FindBy (className =  "hide-menu")
	WebElement FullScreenSecond;

	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{

		this.fullscreenfunctions = new fullScreenFunctions();
		this.taskstest = new tasksTest();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.randomactions = new randomActions();
		this.actionmultipleselect = new actionsMultipleSelect();
		this.middlepane = new middlePane();
		
	}

	@Test(priority = 1)
	public void pressTwiceFullScreen() throws InterruptedException{

	
	fullscreenfunctions.PressOnFullScreen();
		
	
	}	

	@Test (priority = 2)
	public  void myTasks() throws InterruptedException, IOException {
		logger = extent.createTest("my tasks full screen");
		
		taskstest.SetUp();
/*
		taskstest.MyTasksRightSide();
*/
		actionsmiddlepane.openEntity("full screen my tasks", "dasdas");

		
		fullscreenfunctions.moveToElemente();	
		
		actionmultipleselect.deleteEntityMultipleChoice();
		
		actionmultipleselect.addTagsMultipleChoice("david");
	
	}


	@AfterClass
	public void after() {

		extent.flush();
		
		

	}


}
