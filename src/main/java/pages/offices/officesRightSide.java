package pages.offices;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;

public class officesRightSide extends testBase {
	

	@FindBy(xpath = "/html/body/section/section"
			+ "/div[2]/div[2]/div[2]/div/div[2]/detail-tabs/div[1]/div/button[4]")
	WebElement pressSignaturesTab;
	
	@FindBy (css = "[placeholder='Full name']")
	WebElement fullNameField;
	
	@FindBy (css = "[placeholder='Rank']")
	WebElement rankField;
	
	@FindBy (css = "[placeholder='Role']")
	WebElement roleField;

	@FindBy (css = "[placeholder='Unit']")
	WebElement unitField;
	
	@FindBy (className = "addSignature")
	WebElement pressOnAddSignature;
	
	@FindBy(className = "signature-table")
	WebElement signatureTable;
	
	public officesRightSide() {
		PageFactory.initElements(driver, this);
	}
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void signatures(String nam , String rank , String role , String unit) throws InterruptedException {
		
		waitForVisibility(pressSignaturesTab);
		
		pressSignaturesTab.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(fullNameField);
		
		fullNameField.sendKeys(nam);
		
		rankField.sendKeys(rank);
		
		roleField.sendKeys(role);
		
		unitField.sendKeys(unit);
		
		pressOnAddSignature.click();
		
		
		Thread.sleep(2000);
		
		String atributteOfSignatureAfter = signatureTable.getAttribute("childElementCount");
		
		int afterSetSignature = Integer.parseInt(atributteOfSignatureAfter);
		
		if (afterSetSignature == 1) {
			logger.log(Status.PASS, "adding signatures");
			System.out.println("sad");
		}
		
		else {
			logger.log(Status.FAIL, "adding signatures");
		}
		
		
		
		
	}
}
