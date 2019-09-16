package pages.tasks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalActions.actionsMiddlePane;

public class documentsFromTasks extends testBase {

	actionsMiddlePane actionmiddlepane;
	
	@FindBy (css = ".tab.three ")
	List<WebElement>  tabsListOnRightSide = new ArrayList<>();
	
	@FindBy (css = "[ng-click='manageOfficeDocuments()']")
	WebElement manageDocuments;
	
	public  documentsFromTasks() {

		PageFactory.initElements(driver, this);
		this.actionmiddlepane = new actionsMiddlePane();
	}
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void getIntoDocumentsFromTasks() throws InterruptedException {
		
		actionmiddlepane.openEntity("doc from tasks", "dsasadas");
		
		tabsListOnRightSide.get(2).click();
		
		
		waitForVisibility(manageDocuments);
		
		manageDocuments.click();
		
		Thread.sleep(2000);
		
	}
}

