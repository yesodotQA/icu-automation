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
import global.globalActions.actionsMiddlePane;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;


public class projectsMiddlePane extends testBase {
	
	multipleSelect projectsmultipleselect;	
	middlePane projectsmiddlepane;	
	Tabs projectstab;	
	theRightOfTheScreen template;
	actionsMiddlePane actionsmiddlepane;
	
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
		this.actionsmiddlepane = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}

	// //a function that change the status list to all and archived
	public void changeStatusOfList()throws InterruptedException {
		
		int sizeOfList = projectsmiddlepane.listOfEntities.size();
		
		actionsmiddlepane.openEntity("test", "importenet2");
		
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

	
}
