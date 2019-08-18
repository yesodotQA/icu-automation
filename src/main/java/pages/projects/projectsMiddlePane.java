package pages.projects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;


public class projectsMiddlePane extends testBase {
	
	multipleSelect projectsmultipleselect;	
	middlePane projectsmiddlepane;	
	Tabs projectstab;	
	theRightOfTheScreen template;
	
	@FindBy(css = "[title='test']")
	 WebElement checkIfArchvedWorks;
	
	@FindBy(css = "[ng-focus='focusing(item)']")
	public List<WebElement>  listOfnamesOfEntities = new ArrayList<>();
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  projectsMiddlePane() {
		
		this.projectsmultipleselect = new multipleSelect();
		this.projectsmiddlepane = new middlePane();
		this.projectstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}

	// //a function that change the status list to all and archived
	public void changeStatusOfList()throws InterruptedException {
		
		int sizeOfList = projectsmiddlepane.listOfEntities.size();
		
		projectsmiddlepane.openEntity("test", "importenet2");
		
		waitForVisibility(template.pressToChangeStatusOnTheScreen);
		
		template.pressToChangeStatusOnTheScreen.click();
		
		
		Thread.sleep(2000);
		
		template.listOfStatusOnScreen.get(4).click();
		

		waitForVisibility(projectsmiddlepane.sortByStatus);
		
		projectsmiddlepane.sortByStatus.click();
		
		
		Thread.sleep(2000);
		
		projectsmiddlepane.listOfStatusOfEntities.get(1).click();
		
		Thread.sleep(2000);
		
		String check = checkIfArchvedWorks.getText();
		
		// check if the entity exists in archived status
		if (check.equals("test")){
			
			logger.log(Status.PASS , "status by archived");
			
		}
		
		else {
			
			logger.log(Status.FAIL ,"status by archived");
		}
		
		
		waitForVisibility(projectsmiddlepane.sortByStatus);
		
		projectsmiddlepane.sortByStatus.click();
		
		
		Thread.sleep(1000);
		
		projectsmiddlepane.listOfStatusOfEntities.get(2).click();
		
		Thread.sleep(2000);
		
		int sizeOfListAfterPressAll = projectsmiddlepane.listOfEntities.size();
		
		//check if the list is growing when i press on all status
		if (sizeOfList < sizeOfListAfterPressAll) {
			
			logger.log(Status.PASS , "status by all");
		
		}	
		
		else {
			
			logger.log(Status.FAIL , "status by all");
		}
		
	}

	// a function that selects a favorite entity
	public void sortByFavorite() throws InterruptedException {
		
		int sizeOfList = projectsmiddlepane.listOfEntities.size();
		
		
		waitForVisibility(projectsmiddlepane.pressOnEntity);
				
		projectsmiddlepane.pressOnEntity.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(template.chooseFavorite);
		
		template.chooseFavorite.click();
		
		
		Thread.sleep(2000);
		
		projectsmiddlepane.openEntity("favorite", "dassad");
		
		
		waitForVisibility(projectsmiddlepane.pressOnEntity);
		
		projectsmiddlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(projectsmiddlepane.pressOnSortByfavorite);
		
		projectsmiddlepane.pressOnSortByfavorite.click();
		
		Thread.sleep(3000);
		
		int sizeOfListAfterPressFavorite = projectsmiddlepane.listOfEntities.size();
		
		// check if the list the list is narrowed
		if (sizeOfList > sizeOfListAfterPressFavorite) {
			
			logger.log(Status.PASS , "sort by favorite");
		
		}	
		
		else {
			
			logger.log(Status.FAIL , "sort by favorite");
		}
		
		
		waitForVisibility(projectsmiddlepane.pressOnSortByfavorite);
		
		projectsmiddlepane.pressOnSortByfavorite.click();
		
		
		Thread.sleep(3000);
		
	}
	

	// a function that press on sort by title 
	public void sortByTitle() throws InterruptedException {
			
		projectsmiddlepane.openEntity("this is test", "dassad");
			
		projectsmiddlepane.openEntity("hello world", "dasdassad");
			
		projectsmiddlepane.openEntity("abcd", "dasdassad");
	  	
	  	int count = 0;
		
		List<String> getStringList=listOfnamesOfEntities.stream().map(WebElement::getText).collect(Collectors.toList());

		Collections.sort(getStringList);
			
		System.out.println(getStringList);
	 

		waitForVisibility(projectsmiddlepane.pressOnSortButton);
			
		projectsmiddlepane.pressOnSortButton.click();
			
		Thread.sleep(1000);
		
		projectsmiddlepane.listOfSorts.get(0).click();
		
		Thread.sleep(2000);
		
	
		// check if the list sorted
		
		for (int i = 0; i < listOfnamesOfEntities.size()-1; i++) {
					
			if (listOfnamesOfEntities.get(i).getText().equals(getStringList.get(i))) {
					
				count++;
			} 
				
		}
				
		if (count == listOfnamesOfEntities.size()-1) {
				
			logger.log(Status.INFO , "sort by title  unable to check the arrow needs to be fixed");
			} 
			
		else {
			
			logger.log(Status.INFO , "sort by title unable to check the arrow needs to be fixed");
			}		
	}
	
	// a function that press on sort by unread and status
		public void sordByStatusAndUnread() throws InterruptedException {
				
			waitForVisibility(projectsmiddlepane.pressOnSortButton);
				
			projectsmiddlepane.pressOnSortButton.click();
				
				
			Thread.sleep(1000);
			
			projectsmiddlepane.listOfSorts.get(1).click();
				
				
			Thread.sleep(2000);

			waitForVisibility(projectsmiddlepane.pressOnSortButton);
				
			projectsmiddlepane.pressOnSortButton.click();
				
				
			Thread.sleep(1000);
			
			projectsmiddlepane.listOfSorts.get(3).click();
				
			logger.log(Status.INFO , "press on sort by status and unread");

				
			waitForVisibility(projectsmiddlepane.pressOnSortButton);
				
			projectsmiddlepane.pressOnSortButton.click();
				
				
			Thread.sleep(1000);
				
			projectsmiddlepane.listOfSorts.get(2).click();
			
			Thread.sleep(1000);

			logger.log(Status.INFO , "arrow cannot be checked");
			
		}
	
		//a function that press on arrow to reverse the order of the list
		public void pressOnArrow() throws InterruptedException {
			
			String firstNameOfEntity = listOfnamesOfEntities.get(0).getAttribute("textContent");
			
			String lastNameOfEntity =listOfnamesOfEntities.get(projectsmiddlepane.listOfEntities.size() -1).
					getAttribute("textContent");
					
			
			waitForVisibility(projectsmiddlepane.pressArrow);
			
			projectsmiddlepane.pressArrow.click();
			
			
			String firstNameAfterPressArrow =listOfnamesOfEntities.get(0).getAttribute("textContent");
			
			String	lastNameAfterPressArrow = listOfnamesOfEntities.get(projectsmiddlepane.listOfEntities.size() -1).
					getAttribute("textContent");
					
			
			
			Thread.sleep(3000);
			
			// checks whether the order of the list is reversed
			if (firstNameOfEntity.equals(lastNameAfterPressArrow) && lastNameOfEntity.equals(firstNameAfterPressArrow)) {
				
				logger.log(Status.PASS , "arrow button");
			} 
			
			else {
				logger.log(Status.FAIL , "arrow button");
			}

			waitForVisibility(projectsmiddlepane.pressArrow);
			
			projectsmiddlepane.pressArrow.click();
		
			
			Thread.sleep(3000);
			
			
		}
		
	
}
