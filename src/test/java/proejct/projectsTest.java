package proejct;

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
		
	    @FindBy(xpath = "/html/body/section/section/div[1]/header/div[1]/div/span")
	    public WebElement Myprojects;
		subprojects subprojects;
		Tabs tabs;
		projectsMultipleSelect projectsmultipleselect ;
		middlePane middlepane;
		projectsMiddlePane projectsmiddlepane;
		projectsRightSideOfScreen projectsrightsideonscreen;
		actionsRightSide actionsrightside;
		actionsMiddlePane actionsmiddlepane;
		actionsMultipleSelect actionsmultipleselect;
		
		@BeforeClass
		public void SetUp() throws InterruptedException, IOException{	
		initialization(); 
		Login();
	    
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
			subprojects.SubprojectEdit();
			
			Thread.sleep(2000);
			subprojects.projectTemplate();
		}
		@Test(priority = 2)
		public void openDoc() throws InterruptedException {
		
			// press project tab
			projectsmultipleselect.pressproject();
			
			//open doc  enter title and description
			actionsmiddlepane.openEntity("doc1" , "important");
		}	

		@Test(priority = 3)
		public void projectsMulitipleChoice() throws InterruptedException {
		
			logger = extent.createTest("project using multiple choice");
			
			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();
			
			actionsmultipleselect.addTagsMultipleChoice("mission");
			
			actionsmultipleselect.addDateMultipleChoice();
			
			actionsmultipleselect.addAssigneeMultipleChoice();
			
			actionsmultipleselect.addWatchersMultipleChoice();
			
			actionsmultipleselect.addStatusMultipleChoice();
			
		}
	
		@Test(priority = 4)
		public void projectsMiddlePane()throws InterruptedException {
			logger = extent.createTest("project using middle pane");
			
			projectsmiddlepane.changeStatusOfList();
			
			//projectsmiddlepane.sortByFavorite();
			
			actionsmiddlepane.sortByTitle();
			
			actionsmiddlepane.sordByStatusAndUnread();
			
			//actionsmiddlepane.pressOnArrow();
		}
		
		@Test(priority = 5)
		public void projectsRightSideOnScreen()throws InterruptedException {
			
			logger = extent.createTest("project using right side on screen");
			
			actionsrightside.deleteEntity();
			
			actionsrightside.addAssignee();
			
			actionsrightside.setDate();
			
			actionsrightside.addStatus();
			

			
			actionsrightside.addTags("yaronnn");
			
			actionsrightside.addActivities("sad", "memurmar");
			
			actionsrightside.addWatcher();
		
		}
		
		
		
		@Test(priority = 6)
		public void Subproject()throws InterruptedException{
			logger = extent.createTest("project template");
			
		//	subprojects.SubprojectEdit();
			
		//	subprojects.projectTemplate();
		}
		
		
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




