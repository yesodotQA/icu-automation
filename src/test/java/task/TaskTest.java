package tests;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import Base.testBase;
import global.Tabs;
import pages.TasksPage;


	public class TaskTest  extends testBase {
		
		Tabs tabs;
		TasksPage taskspage;
			
		@BeforeClass
		public void SetUp() throws InterruptedException{	
		initialization(); 
		Login();
		taskspage = new TasksPage();
		

		}
		
		@Test(priority = 1)
		public void openDoc() throws InterruptedException {
		
			// press Task tab
			taskspage.pressTask();
		  
			//open doc  enter title and description
			taskspage.openEntity("doc1" , "important");
		}
		
		@Test(priority = 2)
		public void TasksMulitipleChoice() throws InterruptedException {
		
			logger = extent.createTest("Task using multiple choice");
			
			// delete entity using multiple select
			taskspage.deleteEntityMultipleChoice();
			
			//open doc  enter title and description
			taskspage.openEntity("doc2" , "imporant2");
			
			taskspage.addTagsMultipleChoice("mission");
			
			taskspage.addDateMultipleChoice();
			
			taskspage.addAssigneeMultipleChoice();
			
			taskspage.addWatchersMultipleChoice();
			
			taskspage.addStatusMultipleChoice();
			
		}
		
		@Test(priority = 3)
		public void TasksTemplate()throws InterruptedException{
			logger = extent.createTest("Task template");
			
			taskspage.TaskTemplate();
			
			taskspage.SubTask();
		}
		
		public void MyTasks() throws InterruptedException {
			tabs.MyTasks.click();
			
			Thread.sleep(2000);
			taskspage.openEntity("doc1" , "important");
			
			logger = extent.createTest("My Task using multiple choice");
			
			// delete entity using multiple select
			taskspage.deleteEntityMultipleChoice();
			
			//open doc  enter title and description
			taskspage.openEntity("doc2" , "imporant2");
			
			taskspage.addTagsMultipleChoice("mission");
			
			taskspage.addDateMultipleChoice();
			
			taskspage.addAssigneeMultipleChoice();
			
			taskspage.addWatchersMultipleChoice();
			
			taskspage.addStatusMultipleChoice();
			
			logger = extent.createTest("My Task template");
			
			taskspage.TaskTemplate();
			
			taskspage.SubTask();
		}
		
		
		
		
		@AfterClass
		public void after() {
			
			extent.flush();
			
		}
			
	}
		
			
		




