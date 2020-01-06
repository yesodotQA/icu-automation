package project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
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
import pages.tasks.tasksMiddlePane;
import pages.tasks.tasksRightSideOfScreen;
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
	tasksMiddlePane tasksmiddlepane;
	tasksRightSideOfScreen tasksrightside;

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
		this.tasksmiddlepane = new tasksMiddlePane();
		this.tasksrightside = new tasksRightSideOfScreen();
		projectsmultipleselect.pressproject();
		actionsmiddlepane.openEntity("doc1","important");
	}

	@Test(priority = 1)
	public void ProjectDeleteMultipleChoice() throws InterruptedException {

		logger = extent.createTest("projects delete multiple choice");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test(priority = 2)
	public void projectAddTagsMultipleSelect() throws InterruptedException {

		logger = extent.createTest(" projects multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("mission");
	}

	@Test(priority = 3)
	public void projectSetDateMultipleChice() throws InterruptedException {

		logger = extent.createTest(" projects multiple choice add date");

		actionsmultipleselect.addDateMultipleChoice();
	}

	@Test(priority = 4)
	public void projectAddAsigneeMultipleChice() throws InterruptedException {

		logger = extent.createTest(" projects multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 5)
	public void projectAddWatchersMultipleChice() throws InterruptedException {

		logger = extent.createTest(" projects multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();

	}

	@Test(priority = 6)
	public void projectAddStatusMultipleChice() throws InterruptedException {

		logger = extent.createTest(" projects multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();

	}

	@Test(priority = 7)
	public void projectsMiddlePaneStatsuList() throws InterruptedException {

		logger = extent.createTest(" projects middle pane change status list");

		documentsmiddlepane.changeStatusOfList();

	}

	//tasksmiddlepane.sortByFavorite();

	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 8)
	public void projectsMiddleSortTitle() throws InterruptedException {

		logger = extent.createTest(" projects middle pane sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 9)
	public void projectsMiddleSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest(" projects middle pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();

	}


	@Test(priority = 10)
	public void projectRightSideDlete() throws InterruptedException {

		logger = extent.createTest("project right side delete");

		actionsrightside.deleteEntity();

	}

	@Test(priority = 11)
	public void projectRightAddAssignee() throws InterruptedException {

		logger = extent.createTest("project right side add assignee");

		actionsrightside.addAssignee(true);

	}

	@Test(priority = 12)
	public void projectRightSetDate() throws InterruptedException {

		logger = extent.createTest("project right side set date");

		actionsrightside.setDate();

	}

	@Test(priority = 13)
	public void projectRightAddStatus() throws InterruptedException {

		logger = extent.createTest("project right side add status");

		actionsrightside.addStatus();

	}

	@Test(priority = 14)
	public void projectRightChooseColor() throws InterruptedException {

		logger = extent.createTest("project choose color");

		randomaction.chooseColor();

	}

	@Test(priority = 15)
	public void projectRightAddTags() throws InterruptedException {

		logger = extent.createTest("project right side add tags");

		actionsrightside.addTags("yaronnn");

	}

	@Test(priority = 16)
	public void projectRightAddActivities() throws InterruptedException {

		logger = extent.createTest("project right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}

	@Test(priority = 17)
	public void projectRightChangePermission() throws InterruptedException {

		logger = extent.createTest("project right side change permission");

		actionsrightside.changePermission();

	}

	@Test(priority = 18)
	public void deleteSubProjects() throws InterruptedException {

		logger = extent.createTest("delete sub projects");

		actionsmiddlepane.openEntity("sub pro", "sfdjh");

		subprojects.addSubProjects();

		subprojects.deleteSubProject();

	}

	@Test(priority = 19)
	public void creatsSubProjectsAndEnterIt() throws InterruptedException {

		logger = extent.createTest("create and enter it sub projects");

		subprojects.createSubProjects();

		actionsmiddlepane.openEntity("subpro22", "rhfjfrjk");

	}

	@Test(priority = 20) 
	public void subProjectsMultipleChoiceDelete() throws	InterruptedException {

		logger = extent.createTest("sub project multiple choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test(priority = 21) 
	public void subProjectMultipleChoiceAddTags() throws InterruptedException {

		logger = extent.createTest("sub project multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("proj");

	}

	@Test(priority = 22) 
	public void subProjectMultipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest("sub project multiple choice set a date");

		actionsmultipleselect.addDateMultipleChoice();

	}

	@Test(priority = 23)
	public void subProjectMultipleChoiceAddAssigne() throws InterruptedException { 

		logger = extent.createTest("sub project multiple choice add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 24)
	public void subProjectMultipleChoiceAddWatchers() throws InterruptedException { 

		logger = extent.createTest("sub project multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();

	}

	@Test(priority = 25)
	public void subProjectMultipleChoiceAddStatus() throws InterruptedException { 

		logger = extent.createTest("sub project multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 26)
	public void subProjectMiddlePanStatusList() throws InterruptedException {

		logger = extent.createTest("sub project middle pane change status list");

		documentsmiddlepane.changeStatusOfList();

	}

	@Test(priority = 27)
	public void subProjectMiddlePanSortTitle() throws InterruptedException {

		logger = extent.createTest("sub project middle pane sort by title");

		actionsmiddlepane.sortByTitle();

	}	

	//actionsmiddlepane.sortByFavorite();

	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 28)
	public void subProjectMiddlePanSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest("sub project pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();

	}

	@Test(priority = 29)
	public void subProjectRightSideDelete() throws InterruptedException {

		logger = extent.createTest("sub project right side delele");

		actionsrightside.deleteEntity();

	}

	@Test(priority = 30)
	public void subProjectRightSideAddAsignee() throws InterruptedException {

		logger = extent.createTest("sub project right side add assignee");

		actionsrightside.addAssignee(true);

	}

	@Test(priority = 31)
	public void subProjectRightSideSetDate() throws InterruptedException {

		logger = extent.createTest("sub project right side set date");

		actionsrightside.setDate();

	}

	@Test(priority = 32)
	public void subProjectRightAddStatus() throws InterruptedException {

		logger = extent.createTest("sub project right side add status");

		actionsrightside.addStatus();

	}

	@Test(priority = 33)
	public void subProjectRightChooseColor() throws InterruptedException {

		logger = extent.createTest("sub project right side choose color");

		randomaction.chooseColor();

	}

	@Test(priority = 34)
	public void subProjectRightAddTags() throws InterruptedException {

		logger = extent.createTest("sub project right side add tags");

		actionsrightside.addTags("yaronnn");

	}

	@Test(priority = 35)
	public void subProjectRightAddAcivities() throws InterruptedException {

		logger = extent.createTest("sub project right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}	

	@Test(priority = 36)
	public void subProjectRightChangePermission() throws InterruptedException {

		logger = extent.createTest("sub project right side change permission");

		actionsrightside.changePermission(); 

	}

	@Test(priority = 37)
	public void getIntoProjectFromDiscussion() throws InterruptedException {

		logger = extent.createTest("get into project from discussions");

		projectfromdiscussions.getIntoProjectFromDiscussions();

	}

	@Test(priority = 38)
	public void projectFromDiscussionMultipleChoiceDelete () throws InterruptedException {

		logger = extent.createTest(" projects from discussion multiple choice delete");

		actionsmultipleselect.deleteEntityMultipleChoice();

	}

	@Test(priority = 39)
	public void projectFromDiscussionMultipleChoiceAddTags () throws InterruptedException {

		logger = extent.createTest(" projects from discussion multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("proj");

	}

	@Test(priority = 40)
	public void projectFromDiscussionMultipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest(" projects from discussion multiple choice set date");

		actionsmultipleselect.addDateMultipleChoice();
	}

	@Test(priority = 41)
	public void projectFromDiscussionMultipleChoiceAddAssignee() throws InterruptedException {

		logger = extent.createTest("projects from discussion multiple choice Add assignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 42)
	public void projectFromDiscussionMultipleChoiceAddWatchers() throws InterruptedException {

		logger = extent.createTest("projects from discussion multiple choice Add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 43)
	public void projectFromDiscussionMultipleChoiceAddStatus() throws InterruptedException {

		logger = extent.createTest("projects from discussion multiple choice Add watchers");

		actionsmultipleselect.addStatusMultipleChoice();
	}	

	@Test(priority = 44)
	public void  projectFromDiscussionMiddlePaneStatusList() throws InterruptedException {

		logger = extent.createTest(" projects from discussions middle pane status list");

		documentsmiddlepane.changeStatusOfList();	
	}



	@Test(priority = 45)
	public void projectFromDiscussionMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest("projects from discussion middle pane sort by title");

		actionsmiddlepane.sortByTitle();
	}

	//actionsmiddlepane.sortByFavorite();

	//actionsmiddlepane.pressOnArrow();

	@Test(priority = 46)
	public void projectFromDiscussionMiddlePaneSortStatusAndUnread() throws InterruptedException {	

		logger = extent.createTest("projects from discussion middle pane sort by status and unread");

		actionsmiddlepane.sordByStatusAndUnread();

	}

	@Test(priority = 47)
	public void projectFromDiscussionRightSideDelete() throws InterruptedException {

		logger = extent.createTest("projects from discussion right side delele");

		actionsrightside.deleteEntity();

	}

	@Test(priority = 48)
	public void projectFromDiscussionRightSideAddAssignee() throws InterruptedException {	

		logger = extent.createTest("projects from discussion right side add assignee");

		actionsrightside.addAssignee(true);
	}

	@Test(priority = 49)
	public void projectFromDiscussionRightSideSetDate() throws InterruptedException {	

		logger = extent.createTest("projects from discussion right side set date");

		actionsrightside.setDate();
	}

	@Test(priority = 50)
	public void projectFromDiscussionRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest("projects from discussion right side add status");

		actionsrightside.addStatus();
	}

	@Test(priority = 51)
	public void projectFromDiscussionRightSideAddTags() throws InterruptedException {

		logger = extent.createTest("projects from discussion right side add tags");

		actionsrightside.addTags("projFromDiscus");
	}

	@Test(priority = 52)
	public void projectFromDiscussionRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest("projects from discussion right side add activities");

		actionsrightside.addActivities("HELLO" , "this is superman");
	}


	@Test(priority = 53)
	public void projectFromDiscussionRightSideChangePermission() throws InterruptedException {

		logger = extent.createTest("meetings right side change permission");

		actionsrightside.changePermission();

	}

	@Test(priority = 54)
	public void getIntoTasksFromProjects() throws InterruptedException {

		logger = extent.createTest("get into tasks from projects");

		projectsmultipleselect.pressproject();

		tasksfromprojects.getIntoTasksFromProjects();
	}

	@Test(priority = 55)
	public void tasksFromProjectsMultipleChoiceDelete() throws InterruptedException {

		logger = extent.createTest("tasks from projects multiple choice delete");

		actionsmiddlepane.openEntity("tasksfromrpoj" , "ghjydgj");

		actionsmultipleselect.deleteEntityMultipleChoice();
	}

	@Test(priority = 56)
	public void tasksFromProjectsMultipleChoiceAddTags() throws InterruptedException {

		logger = extent.createTest("tasks from projects multiple choice add tags");

		actionsmultipleselect.addTagsMultipleChoice("tasksfromproj");
	}	


	@Test(priority = 57)
	public void tasksFromProjectsMultipleChoiceSetDate() throws InterruptedException {

		logger = extent.createTest("tasks from projects multiple choice set date");

		actionsmultipleselect.addDateMultipleChoice();

	}

	@Test(priority = 58)
	public void tasksFromProjectsMultipleChoiceAddAsignee() throws InterruptedException {

		logger = extent.createTest("tasks from Projects multiple choice add asignee");

		actionsmultipleselect.addAssigneeMultipleChoice();
	}

	@Test(priority = 59)
	public void tasksFromMProjectsMultipleChoiceAddWatchers() throws InterruptedException {

		logger = extent.createTest("tasks from projects multiple choice add watchers");

		actionsmultipleselect.addWatchersMultipleChoice();
	}

	@Test(priority = 60)
	public void tasksFromMProjectsMultipleChoiceAddStatus() throws InterruptedException {

		logger = extent.createTest("tasks from projects multiple choice add status");

		actionsmultipleselect.addStatusMultipleChoice();
	}

	@Test(priority = 61)
	public void tasksFromMProjectsMiddlePaneStatusList() throws InterruptedException {

		logger = extent.createTest(" tasks from projects middle pane status list");

		tasksmiddlepane.changeStatusOfList();	
	}


	@Test(priority = 62)
	public void tasksFromMProjectsMiddlePaneSortTitle() throws InterruptedException {

		logger = extent.createTest(" tasks from projects sort by title");

		actionsmiddlepane.sortByTitle();
	}

	@Test(priority = 63)
	public void tasksFromMProjectsMiddlePaneSortStatusAndUnread() throws InterruptedException {

		logger = extent.createTest(" tasks from projects sort status and unread");

		actionsmiddlepane.sordByStatusAndUnread();
	}

	@Test(priority = 64)
	public void tasksFromMProjectsRightSideDelete() throws InterruptedException {

		logger = extent.createTest(" tasks from projects right side delete");

		actionsrightside.deleteEntity();
	}

	@Test(priority = 65)
	public void tasksFromMProjectsRightSideAddAssignee() throws InterruptedException {

		logger = extent.createTest(" tasks from projects right side add assignee");

		actionsrightside.addAssignee(true);
	}

	@Test(priority = 66)
	public void tasksFromMeetingsRightSideSetDate() throws InterruptedException {

		logger = extent.createTest(" tasks from meetings right side set date");

		actionsrightside.setDate();
	}

	@Test(priority = 67)
	public void tasksFromProjectsRightSideAddStatus() throws InterruptedException {

		logger = extent.createTest(" tasks from projects right side add status");

		actionsrightside.addStatus();
	}

	@Test(priority = 68)
	public void tasksFromProjectsRightSideAddTags() throws InterruptedException {

		logger = extent.createTest(" tasks from projects right side add tags");

		actionsrightside.addTags("tasksFromprojr");
	}


	@Test(priority = 69)
	public void tasksFromProjectsRightSideAddActivities() throws InterruptedException {

		logger = extent.createTest(" tasks from projects right side add activities");

		actionsrightside.addActivities("sad", "memurmar");
	}

	@Test(priority = 70)
	public void tasksFromProjectsRightSideChangePermission() throws InterruptedException {

		logger = extent.createTest("tasks from projects right side change permissions");

		actionsrightside.changePermission();		
	}

	@Test(priority = 71)
	public void tasksFromProjectsRightSideDuplicateTasks() throws InterruptedException {

		logger = extent.createTest("tasks from projetcs right side duplicate tasks");

		tasksrightside.duplicateTasks();
	}

	@AfterClass
	public void after() {

		extent.flush();

	}
}
