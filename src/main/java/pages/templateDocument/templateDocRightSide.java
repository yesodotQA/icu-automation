package pages.templateDocument;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;

public class templateDocRightSide extends testBase {
	
	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[2]"
			+ "/div/div[2]/detail-category/div/div[1]/span/span[1]")
	WebElement SelectOffice;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfOffices=  new ArrayList<>();
	
	
	public templateDocRightSide() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void SelectOfficeOnScreen() throws InterruptedException {
		
		if (SelectOffice.getText().equals("Select office")) {

			waitForVisibility(SelectOffice);

			SelectOffice.click();
			
			if (listOfOffices.isEmpty()==false) {
				
				Thread.sleep(3000);

				String nameOfFolder	= listOfOffices.get(0).getText();

				listOfOffices.get(0).click();

				Thread.sleep(2000);

				String nameOfFolderForChecking = SelectOffice.getAttribute("innerText");

				if (nameOfFolder.equals(nameOfFolderForChecking)) {

					logger.log(Status.PASS , "select office on screen");

				}
				
				else {

					logger.log(Status.FAIL , "select office on screen");
				}
			}

		}

	}

}
