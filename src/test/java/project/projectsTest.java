package project;

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

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsMultipleSelect;
import global.globalActions.actionsRightSide;
import global.globalActions.randomActions;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import pages.documents.documentsMiddlePane;
import pages.projects.projectsFromDiscussions;
import pages.projects.projectsMiddlePane;
import pages.projects.projectsMultipleSelect;
import pages.projects.projectsRightSideOfScreen;
import pages.projects.subprojects;
import pages.projects.tasksFromProjects;
import pages.tasks.subTasks;
import task.tasksTest;
	public class projectsTest  extends testBase {
	
		
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
		documentsMiddlePane documentsmiddlepane;
		randomActions randomaction;
		projectsFromDiscussions projectfromdiscussions;
		tasksTest taskstest;
		tasksFromProjects tasksfromprojects;
		subTasks subtasks;
		
		@BeforeClass
		public void SetUp() throws InterruptedException, IOException{	
		
		this.documentsmiddlepane = new documentsMiddlePane();
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
		this.randomaction = new randomActions();
		this.projectfromdiscussions = new projectsFromDiscussions();
		this.taskstest = new tasksTest();
		this.tasksfromprojects = new tasksFromProjects();
		this.subtasks = new subTasks();
		
		}
		
		@Test(priority = 1)
		public void openProject() throws InterruptedException {
			logger = extent.createTest("project");
			
			projectsmultipleselect.pressproject();
			
			actionsmiddlepane.openEntity("doc1","important");
		}
		
		@Test(priority = 2)
		public void projectsMultipleSelect() throws InterruptedException {

			logger = extent.createTest("multiple choice");

			// delete entity using multiple select
			actionsmultipleselect.deleteEntityMultipleChoice();

			actionsmultipleselect.addTagsMultipleChoice("mission");

			actionsmultipleselect.addDateMultipleChoice();

			actionsmultipleselect.addAssigneeMultipleChoice();

			actionsmultipleselect.addWatchersMultipleChoice();

			actionsmultipleselect.addStatusMultipleChoice();

		}

			
		@Test(priority = 3)
		public void projectsMiddlePane() throws InterruptedException {
			logger = extent.createTest("middle pane");
			
			randomaction.enterNameToEntity("hyyyyyyyyy");
			
			documentsmiddlepane.changeStatusOfList();
			
			//tasksmiddlepane.sortByFavorite();
			
			actionsmiddlepane.sortByTitle();

			actionsmiddlepane.sordByStatusAndUnread();
			
			//actionsmiddlepane.pressOnArrow();
		}
		
		@Test(priority = 4)
		public void projectRightSide() throws InterruptedException {
		
			logger = extent.createTest("right side");

			actionsrightside.deleteEntity();

			actionsrightside.addAssignee(true);

			actionsrightside.setDate();

			actionsrightside.addStatus();

			randomaction.chooseColor();

			actionsrightside.addTags("yaronnn");

			actionsrightside.addActivities("sad", "memurmar");

			actionsrightside.changePermission();

		}
			
		@Test(priority = 5)
		public void subProjectMultipleSelect() throws InterruptedException {
		
			logger = extent.createTest("sub projects");
			
			actionsmiddlepane.openEntity("sub pro", "sfdjh");
			
			subprojects.addSubProjects();
			
			//subprojects.deleteSubProject();
			
			subprojects.createSubProjects();
			
			logger.log(Status.INFO, "delete sub projects not work");
			
			actionsmiddlepane.openEntity("subpro22", "rhfjfrjk");
			
			projectsMultipleSelect();
			
			
			
		}
		@Test(priority = 6)
		public void subProjectMiddlePane() throws InterruptedException {
			
			projectsMiddlePane();
		}
		
		@Test(priority = 7)
		public void subProjectsRightSide() throws InterruptedException {
			logger = extent.createTest("right Side");
			
			logger.log(Status.INFO, "add assignee and date  not work");
			
			actionsrightside.deleteEntity();
			
			actionsmiddlepane.openEntity("subbpro","important");
			
			actionsrightside.addAssignee(true);
			
			actionsrightside.addStatus();
				
			randomaction.chooseColor();

			actionsrightside.addTags("yaronnn");

			actionsrightside.addActivities("sad", "memurmar");

			actionsrightside.changePermission();
		}
	
		@Test(priority = 8)
		public void projectFromDiscussion() throws InterruptedException{
			logger = extent.createTest("project from discussions");
			
			projectfromdiscussions.getIntoProjectFromDiscussions();
			
			projectsMultipleSelect();
			
			projectsMiddlePane();
			
			projectRightSide();
			
			subProjectMultipleSelect();
		
			subProjectsRightSide();
			
		}
		
		@Test(priority = 9)
		public void TasksFromProjects()throws InterruptedException, IOException {
			logger = extent.createTest("Tasks From Project");
			
			projectsmultipleselect.pressproject();
			
			tasksfromprojects.getIntoTasksFromProjects();
			
			actionsmiddlepane.openEntity("task", "asdjfhf");
			
			logger.log(Status.INFO, "multiple choice in taks from project not work good");
			
			taskstest.SetUp();
			
			taskstest.allTasksMulitipleChoice();

			taskstest.alltasksMiddlePane();
			
			taskstest.alltasksRightSide();
			
			actionsmiddlepane.openEntity("subtasks" , "dasa");
			
			subtasks.addSubTasks();
			
			subtasks.deleteSubTasks();
			
			logger.log(Status.INFO, "get into sub tasks not work");
		
		}

		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
