package pages.projects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;


public class subprojects extends testBase{
	
	multipleSelect projectsmultipleselect;
	
	middlePane projectsmiddlepane;
	
	Tabs projectstab;
	
	theRightOfTheScreen template;
	
	
	//parent project and discussion
	public @FindBy(css = "[value='item.project']")
	WebElement selectParentProject;
	
	public @FindBy(css = "[value='item.discussion']")
	WebElement selectParentMeeting;
	
	//elements for subproject 
	public @FindBy(className = ".add-sub-entity")
	WebElement addSubproject;
	
	public @FindBy(css = "body > section > section > div.icu-data.ng-scope > div.panes-wrapper.ng-scope > div.detailspane.animate-hide.ng-isolate-scope > div >"
	+ " div.entity-details-content.project-details.ng-scope > div.sub-items-section > icu-sub-project-list > div.list-table.sub-entity.scroll "
	+ "> table > tbody > tr > td.name.ng-pristine.ng-untouched.ng-valid")
	WebElement CreateSubproject;

	public @FindBy(xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[3]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[2]")
	WebElement nameSubproject;

	public @FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[3]/div[2]/div[1]/span")
	WebElement AssigneeSubproject;

	public @FindBy(xpath = "//*[@id=\"ui-select-choices-row-95-1\"]/span")
	WebElement AssignUserSubproject;

	public @FindBy(id = "#dp1564059419917")
	WebElement ClickDueDateSubproject;

	public @FindBy(className = ".ui-datepicker-next")
	WebElement ClickNextMonth;

	public @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]")
	WebElement ChooseDateSubproject;

	public @FindBy (className = ".row-arrow")
	WebElement ArrowSubproject;

	public @FindBy (xpath ="/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/div[4]/icu-sub-project-list/div[3]/table/tbody/tr[1]/td[7]")
	WebElement DeleteSubproject;

	public @FindBy(className = ".fa-chevron-down")
	WebElement OpenprojectTemplates;
	
	public@FindBy(css = ".last")
	WebElement ChooseprojectTemplate;
	
	//duplicateproject
	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[1]/detail-menu/div/ul/li[1]/a")
	WebElement duplicateproject;
	
	public@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]/detail-tags/div/div[1]/input")
	WebElement selectTags;
	
	// function for wait
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
	public subprojects() {

	 	PageFactory.initElements(driver, this);
		projectsmultipleselect = new multipleSelect();
		projectsmiddlepane = new middlePane();
		projectstab = new Tabs();
		template = new theRightOfTheScreen();
	}
	
	
	public void  Subproject() throws InterruptedException {
		logger = extent.createTest("create sub tasks and edit it");
		Thread.sleep(2000);
		addSubproject.click();
		
		Thread.sleep(2000);
		waitForVisibility(CreateSubproject);
		
		CreateSubproject.click();
		Thread.sleep(2000);
		waitForVisibility(nameSubproject);
		nameSubproject.sendKeys("autosubproject");
		
		Thread.sleep(1500);
		
		AssigneeSubproject.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(AssignUserSubproject);
		AssignUserSubproject.click();
		
		OpenprojectTemplates.click();
		
		Thread.sleep(2000);
		waitForVisibility(ChooseprojectTemplate);
		ChooseprojectTemplate.click();
		
		logger = extent.createTest("delete subtask");
		Thread.sleep(1000);
		waitForVisibility(DeleteSubproject);
		DeleteSubproject.click();

	}	

	public void projectTemplate() throws InterruptedException {
		for(int i = 0;i<6;i++) {
		waitForVisibility(projectsmiddlepane.pressCreateNewItem);
		projectsmiddlepane.pressCreateNewItem.click();
		
		Thread.sleep(3000);
		waitForVisibility(projectsmiddlepane.enterTitle);
		projectsmiddlepane.enterTitle.sendKeys("autotitle"+i);
		
		Thread.sleep(2000);
		waitForVisibility(projectsmiddlepane.description);
		projectsmiddlepane.description.sendKeys("auto description"+i);
	}
		
		Thread.sleep(2000);
		template.chooseFavorite.click();
		
		Thread.sleep(2500);
		waitForVisibility(template.assigneeOnTheScreen);
		
		
		Thread.sleep(2000);
		template.dateOnTheScreen.click();
		
		Thread.sleep(3000);
		waitForVisibility(projectsmultipleselect.nextMonth);
		projectsmultipleselect.nextMonth.click();
		
		Thread.sleep(2000);
		waitForVisibility(template.chooseDateOnTheScreen);
		
		Thread.sleep(2000);
		selectTags.click();
		
		Thread.sleep(2000);
		selectTags.sendKeys("new tag test");
		
		Thread.sleep(1500);
		selectTags.submit();
		
		template.pressOnAddWatcherOnTHeScreen.click();
		
		Thread.sleep(2000);
		template.selectMembers.click();
		Thread.sleep(2000);
		template.pressOnThreeDotsOnScreen.click();
		
		waitForVisibility(template.pressOnThreeDotsOnScreen);
		template.pressOnThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
		waitForVisibility(duplicateproject);
		duplicateproject.click();
		
		Thread.sleep(2000);
		template.pressOnThreeDotsOnScreen.click();
		
		Thread.sleep(2000);
		template.chooseDelete.click();
	}
	
public void sortMiddlePane() throws InterruptedException {
	Thread.sleep(2000);
	projectsmiddlepane.pressOnSortByfavorite.click();
	/*	Thread.sleep(2000);
	projectsmiddlepane..click();
	
	Thread.sleep(2000);
	projectsmiddlepane.chooceToSortByAll.click();
	
	for(int j=0;j<2;j++) {
	Thread.sleep(2000);
	projectsmiddlepane.pressArrow.click();
	}
	
	Thread.sleep(3000);
	projectsmiddlepane.pressOnSortButton.click();
	
	Thread.sleep(2000);
	waitForVisibility(projectsmiddlepane.pressOnStatus);
	projectsmiddlepane.pressOnStatus.click();
	
	Thread.sleep(2000);
	waitForVisibility(projectsmiddlepane.pressOnUnread);
	projectsmiddlepane.pressOnUnread.click();
	
	Thread.sleep(2000);
	waitForVisibility(projectsmiddlepane.pressSortByTitle);
	projectsmiddlepane.pressSortByTitle.click();
	*/
	

}

}

	
		
	

	

	
