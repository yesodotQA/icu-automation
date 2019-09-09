package project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.projects.projectsMiddlePane;
import pages.projects.projectsMultipleSelect;
import pages.projects.projectsRightSideOfScreen;
import pages.projects.subprojects;
	public class projectsTest  extends testBase {

		@FindBy(css = "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div > div.entity-details-content.project-details.ng-scope > detail-tabs > div.detail-tabs > div > button:nth-child(3)")
		WebElement tasksfromprojects;
		
		@FindBy(css = "[ng-click='manageTasks()']")
		WebElement managetasks;
		
		
		subprojects subprojects;
		Tabs projectstab;
		projectsMultipleSelect projectsmultipleselect ;
		middlePane middlepane;
		projectsMiddlePane projectsmiddlepane;
		projectsRightSideOfScreen projectsrightsideonscreen;
		actionsRightSide actionsrightside;
		actionsMiddlePane actionsmiddlepane;
		actionsMultipleSelect actionsmultipleselect;
		projectsRightSideOfScreen projectrightside;
		
		@BeforeClass
		public void SetUp() throws InterruptedException, IOException{	
		initialization(); 
		Login();
		
		this.projectsrightsideonscreen = new projectsRightSideOfScreen();
		this.projectstab = new Tabs();
		this.subprojects = new subprojects();
		this.projectsmultipleselect = new projectsMultipleSelect();
		this.middlepane = new middlePane();
		this.projectsmiddlepane = new projectsMiddlePane();
		this.projectsrightsideonscreen = new projectsRightSideOfScreen();
		this.actionsmultipleselect = new actionsMultipleSelect();
		this.actionsmiddlepane = new actionsMiddlePane();
		this.actionsrightside = new actionsRightSide();
		}
		@Test(priority = 1)
		public void Myprojects() throws InterruptedException {
			
			Thread.sleep(2000);
			projectstab.projectsTab.click();
			
			Thread.sleep(2000);
			actionsmiddlepane.openEntity("doc1","important");
			
		/*	logger = extent.createTest("My project using multiple choice");
			
			Thread.sleep(2000);
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			Thread.sleep(2000);
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc2" , "imporant2");
			
			Thread.sleep(2000);
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			
			Thread.sleep(2000);
			actionsmultipleselect.addDateMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addWatchersMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addStatusMultipleChoice();
			
			Thread.sleep(2000);
			logger = extent.createTest("My project template");
			
			Thread.sleep(2000);
			actionsrightside.deleteEntity();
			
			Thread.sleep(2000);
			actionsrightside.addAssignee();
			
			Thread.sleep(2000);
			actionsrightside.setDate();
			
			Thread.sleep(2000);
			actionsrightside.addStatus();
			
			
			Thread.sleep(2000);
			actionsrightside.addTags("yaronnn");
			
			Thread.sleep(2000);
			actionsrightside.addActivities("sad", "memurmar");
			
			Thread.sleep(2000);
			actionsrightside.addWatcher();

			Thread.sleep(2000);
			subprojects.SubProjectEdit();
			
			Thread.sleep(2000);
			subprojects.ProjectTemplate();
			
			subprojects.sortMiddlePane();
	*/}
		
		public void taskFromProject () throws InterruptedException {
			
			Thread.sleep(2000);
			tasksfromprojects.click();
			
			Thread.sleep(2000);
			managetasks.click();
			
			Thread.sleep(2000);
			actionsmiddlepane.openEntity("doc1","important");
			
			logger = extent.createTest("My project using multiple choice");
			
			Thread.sleep(2000);
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			Thread.sleep(2000);
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc2" , "imporant2");
			
			Thread.sleep(2000);
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			
			Thread.sleep(2000);
			actionsmultipleselect.addDateMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addWatchersMultipleChoice();
			
			Thread.sleep(2000);
			actionsmultipleselect.addStatusMultipleChoice();
			
			Thread.sleep(2000);
			logger = extent.createTest("My project template");
			
			Thread.sleep(2000);
			actionsrightside.deleteEntity();
			
			Thread.sleep(2000);
			actionsrightside.addAssignee();
			
			Thread.sleep(2000);
			actionsrightside.setDate();
			
			Thread.sleep(2000);
			actionsrightside.addStatus();
			
			
			Thread.sleep(2000);
			actionsrightside.addTags("yaronnn");
			
			Thread.sleep(2000);
			actionsrightside.addActivities("sad", "memurmar");
			
			Thread.sleep(2000);
			actionsrightside.addWatcher();

			Thread.sleep(2000);
			subprojects.SubProjectEdit();
			
			Thread.sleep(2000);
			subprojects.ProjectTemplate();
			
			subprojects.sortMiddlePane();
		
		}
	
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




