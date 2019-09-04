
package pages.documents;

import java.util.ArrayList;
import java.util.List;

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

	public class documentsRightSideOnScreen extends testBase {
		
		
		@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div"
				+ "[2]/div/div[2]/detail-category/div/div[1]/span/span[1]")
		WebElement SelectFolder;
		
		@FindBy (css = "[ng-if='$select.open']")
		List<WebElement> listOfFolder=  new ArrayList<>();
	
		public  documentsRightSideOnScreen() {
			PageFactory.initElements(driver, this);
		}
		
		private void waitForVisibility (WebElement element)  {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
	
		public void SelectFolderOnScreen() throws InterruptedException {
			
			waitForVisibility(SelectFolder);
			
			SelectFolder.click();
			
			Thread.sleep(3000);
			
			String nameOfFolder	= listOfFolder.get(0).getText();
			
			listOfFolder.get(0).click();
			
			Thread.sleep(2000);
			
			String nameOfFolderForChecking = SelectFolder.getAttribute("innerText");
			
			if (nameOfFolder.equals(nameOfFolderForChecking)) {
				
				logger.log(Status.PASS , "select folder on screen");
				
			}
			else {
				
				logger.log(Status.FAIL , "select folder on screen");
			}
			
		}
		
	
		
	}
	
