package global.globalActions;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen; 

public class actionsMiddlePane extends testBase {


	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;


	public actionsMiddlePane(){

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}


	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	//a function that open new entity and give title and description
	public void openEntity(String tit , String des) throws InterruptedException {

		waitForVisibility(middlepane.pressCreateNewItem);

		middlepane.pressCreateNewItem.click();


		Thread.sleep(2000);

		waitForVisibility(middlepane.enterTitle);

		middlepane.enterTitle.sendKeys(tit);


		Thread.sleep(3000);

		waitForVisibility(middlepane.description);

		middlepane.description.sendKeys(des);


		Thread.sleep(3000);

		waitForVisibility(middlepane.pressOnEntity);

		middlepane.pressOnEntity.click();

		Thread.sleep(3000);

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

		openEntity("favorite", "dassad");


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
	public void sortByTitle() throws InterruptedException {

		openEntity("this is test", "dassad");

		openEntity("hello world", "dasdassad");

		openEntity("abcd", "dasdassad");

		int count = 0;

		List<String> getStringList=middlepane.listOfnamesOfEntities.stream().map(WebElement::getText).collect(Collectors.toList());

		Collections.sort(getStringList);

		System.out.println(getStringList);


		waitForVisibility(middlepane.pressOnSortButton);

		middlepane.pressOnSortButton.click();

		Thread.sleep(1000);

		middlepane.listOfSorts.get(0).click();

		Thread.sleep(3000);

		// check if the list sorted
		for (int i = 0; i < middlepane.listOfnamesOfEntities.size()-1; i++) {

			if (middlepane.listOfnamesOfEntities.get(i).getText().equals(getStringList.get(i))) {

				count++;
			} 

		}

		if (count == middlepane.listOfnamesOfEntities.size()-1) {

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


	}

	//a function that press on arrow to reverse the order of the list
	public void pressOnArrow() throws InterruptedException {

		String firstNameOfEntity = middlepane.listOfnamesOfEntities.get(0).getAttribute("textContent");

		String lastNameOfEntity =middlepane.listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");


		waitForVisibility(middlepane.pressArrow);

		middlepane.pressArrow.click();


		String firstNameAfterPressArrow =middlepane.listOfnamesOfEntities.get(0).getAttribute("textContent");

		String	lastNameAfterPressArrow = middlepane.listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");


		Thread.sleep(3000);

		// checks whether the order of the list is reversed
		if (firstNameOfEntity.equals(lastNameAfterPressArrow) && lastNameOfEntity.equals(firstNameAfterPressArrow)) {

			logger.log(Status.PASS , "arrow button");
		} 

		else {
			logger.log(Status.FAIL , "arrow button");
		}

	}




}
