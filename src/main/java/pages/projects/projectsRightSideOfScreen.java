package pages.projects;

import java.util.ArrayList;
import java.util.List;

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

public class projectsRightSideOfScreen extends testBase {
	
	multipleSelect projectsmultipleselect;	
	middlePane projectsmiddlepane;	
	Tabs projectstab;	
	theRightOfTheScreen template;
	
	@FindBy (className = "fa-times-circle")
	WebElement deleteOnrightSide;
			
	@FindBy(className = "activities-list")
	WebElement checkIfTheActivitiesUpdate;
	
	@FindBy(xpath =  "/html/body/section/section/div[2]/div[2]/div[2]/div/div[2]"
			+ "/detail-category[1]/div/div[1]/span/span[1]")
	WebElement SelectProjects;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfProjects =  new ArrayList<>();
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[2]/div/"
			+ "div[2]/detail-category[2]/div/div[1]/span/span[1]")
	WebElement SelectDiscussions;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfDiscussions =  new ArrayList<>();
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
			
	
	}
			
	public  projectsRightSideOfScreen() {
		
		this.projectsmultipleselect = new multipleSelect();
		this.projectsmiddlepane = new middlePane();
		this.projectstab = new Tabs();
		this.template = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	}
	
	

	public void addStatusOnScreen() throws InterruptedException {
		
		String sizeListOfActivitiesBeforeChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int switcheStringToInt1 = Integer.parseInt(sizeListOfActivitiesBeforeChoosing);
		
		
		waitForVisibility(template.pressToChangeStatusOnTheScreen);
		
		template.pressToChangeStatusOnTheScreen.click();
		
		
		Thread.sleep(2000);
		
		
		template.listOfStatusOnScreen.get(0).click();
		
		
		Thread.sleep(2000);
		
		String sizeListOfActivitiesAfterChoosing = checkIfTheActivitiesUpdate.getAttribute("childElementCount");
		
		int SwitcheStringToInt2 = Integer.parseInt(sizeListOfActivitiesAfterChoosing);
		
		
		if (switcheStringToInt1 + 1 == SwitcheStringToInt2) {
			
			logger.log(Status.PASS , "add status on screen");
		
		}
		
		else {
			
			logger.log(Status.FAIL , "add status on screen");
		}
	}
	
	
}	
	
	
	
	
