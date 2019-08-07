package pages;

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
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

public class documentsMiddlePane  extends testBase {
	
	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	
	
	@FindBy(css = "[title='test']")
	 WebElement checkIfArchvedWorks; 
	
	@FindBy(css = "[ng-focus='focusing(item)']")
	public List<WebElement>  listOfnamesOfEntities = new ArrayList<>();
	
	public documentsMiddlePane() {
	
		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		
		PageFactory.initElements(driver, this);
	}

	 private void waitForVisibility (WebElement element)  {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
	}

	// //a function that change the status list to all and archived
	public void changeStatusOfList()throws InterruptedException {
		
		int sizeOfList = middlepane.listOfEntities.size();
		
		middlepane.openEntity("test", "importenet2");
		
		waitForVisibility(therightonthescreen.pressToChangeStatusOnTheScreen);
		
		therightonthescreen.pressToChangeStatusOnTheScreen.click();
		
		
		Thread.sleep(2000);
		
		therightonthescreen.listOfStatusOnScreen.get(4).click();
		

		waitForVisibility(middlepane.sortByStatus);
		
		middlepane.sortByStatus.click();
		
		
		Thread.sleep(2000);
		
		middlepane.listOfStatusOfEntities.get(1).click();
		
		Thread.sleep(2000);
		
		String check = checkIfArchvedWorks.getText();
		
		// check if the entity exists in archived status
		if (check.equals("test")){
			
			logger.log(Status.PASS , "status by archived");
			
		}
		
		else {
			
			logger.log(Status.FAIL ,"status by archived");
		}
		
		
		waitForVisibility(middlepane.sortByStatus);
		
		middlepane.sortByStatus.click();
		
		
		Thread.sleep(1000);
		
		middlepane.listOfStatusOfEntities.get(2).click();
		
		Thread.sleep(2000);
		
		int sizeOfListAfterPressAll = middlepane.listOfEntities.size();
		
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
		
		int sizeOfList = middlepane.listOfEntities.size();
		
		
		waitForVisibility(middlepane.pressOnEntity);
				
		middlepane.pressOnEntity.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(therightonthescreen.chooseFavorite);
		
		therightonthescreen.chooseFavorite.click();
		
		
		Thread.sleep(2000);
		
		middlepane.openEntity("favorite", "dassad");
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(middlepane.pressOnSortByfavorite);
		
		middlepane.pressOnSortByfavorite.click();
		
		Thread.sleep(3000);
		
		int sizeOfListAfterPressFavorite = middlepane.listOfEntities.size();
		
		// check if the list the list is narrowed
		if (sizeOfList > sizeOfListAfterPressFavorite) {
			
			logger.log(Status.PASS , "sort by favorite");
		
		}	
		
		else {
			
			logger.log(Status.FAIL , "sort by favorite");
		}
		
		
		waitForVisibility(middlepane.pressOnSortByfavorite);
		
		middlepane.pressOnSortByfavorite.click();
		
		
		Thread.sleep(3000);
		
	}

	// a function that press on sort by title 
	public void sordByTitle() throws InterruptedException {
			
		middlepane.openEntity("this is test", "dassad");
			
	  	middlepane.openEntity("hello world", "dasdassad");
			
	  	middlepane.openEntity("abcd", "dasdassad");
	  	
	  	int count = 0;
		
		List<String> getStringList=listOfnamesOfEntities.stream().map(WebElement::getText).collect(Collectors.toList());

		Collections.sort(getStringList);
			
		System.out.println(getStringList);
	 

		waitForVisibility(middlepane.pressOnSortButton);
			
		middlepane.pressOnSortButton.click();
			
		Thread.sleep(1000);
		
		middlepane.listOfSorts.get(0).click();
		
		Thread.sleep(2000);
			
		
		waitForVisibility(middlepane.pressArrow);
		
		

	
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
			
		waitForVisibility(middlepane.pressOnSortButton);
			
		middlepane.pressOnSortButton.click();
			
			
		Thread.sleep(1000);
		
		middlepane.listOfSorts.get(1).click();
			
			
		Thread.sleep(2000);

		waitForVisibility(middlepane.pressOnSortButton);
			
		middlepane.pressOnSortButton.click();
			
			
		Thread.sleep(1000);
		
		middlepane.listOfSorts.get(3).click();
			
		logger.log(Status.INFO , "press on sort by status and unread");

			
		waitForVisibility(middlepane.pressOnSortButton);
			
		middlepane.pressOnSortButton.click();
			
			
		Thread.sleep(1000);
			
		middlepane.listOfSorts.get(2).click();
		
		logger.log(Status.INFO , "arrow cannot be checked");
	
	}
		
		
	//a function that press on arrow to reverse the order of the list
	public void pressOnArrow() throws InterruptedException {
		
		String firstNameOfEntity = listOfnamesOfEntities.get(0).getAttribute("textContent");
		
		String lastNameOfEntity =listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");
				
		
		waitForVisibility(middlepane.pressArrow);
		
		middlepane.pressArrow.click();
		
		
		String firstNameAfterPressArrow =listOfnamesOfEntities.get(0).getAttribute("textContent");
		
		String	lastNameAfterPressArrow = listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");
				
		
		
		Thread.sleep(3000);
		
		// checks whether the order of the list is reversed
		if (firstNameOfEntity.equals(lastNameAfterPressArrow) && lastNameOfEntity.equals(firstNameAfterPressArrow)) {
			
			logger.log(Status.PASS , "arrow button");
		} 
		
		else {
			logger.log(Status.FAIL , "arrow button");
		}

		waitForVisibility(middlepane.pressArrow);
		
		middlepane.pressArrow.click();
	
		
		Thread.sleep(3000);
		
		
	}
	
	
			
 }
	
		

	
		
	
		
	
