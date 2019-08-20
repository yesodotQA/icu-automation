package pages.documents;

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
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class documentsMiddlePane  extends testBase {

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsmiddlepane;


	public documentsMiddlePane() {

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		actionsmiddlepane = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}

	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	//a function that change the status list to all and archived
	public void changeStatusOfList()throws InterruptedException {

		int sizeOfList = middlepane.listOfEntities.size();

		actionsmiddlepane.openEntity("test", "importenet2");

		waitForVisibility(therightonthescreen.pressToChangeStatusOnTheScreen);

		therightonthescreen.pressToChangeStatusOnTheScreen.click();


		Thread.sleep(2000);

		therightonthescreen.listOfStatusOnScreen.get(4).click();


		waitForVisibility(middlepane.sortByStatus);

		middlepane.sortByStatus.click();


		Thread.sleep(2000);

		middlepane.listOfStatusOfEntities.get(1).click();

		Thread.sleep(2000);

		String check = middlepane.checkIfArchvedWorks.getText();

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

}


