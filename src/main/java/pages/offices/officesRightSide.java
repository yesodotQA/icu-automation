package pages.offices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.ls.LSInput;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.globalActions.actionsMiddlePane;
import global.globalActions.actionsRightSide;
import global.globalElements.Tabs;
import pages.folders.foldersRightSide;

public class officesRightSide extends testBase {
	
	actionsMiddlePane actionmiddlepane;
	actionsRightSide actionrightside;
	Tabs tabs;
	foldersRightSide folderrightside;
	
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
	
	@FindBy(css ="[user='member']")
	List<WebElement>  memberList = new ArrayList<>();
	
	@FindBy(className = "dropdown-item")
	List<WebElement> permissionsList= new ArrayList<>();
	
	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[2]"
			+ "/div/div[2]/detail-category/div/div[1]/span/span[1]")
	WebElement SelectOffice;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfOffices=  new ArrayList<>();
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div"
			+ "[2]/div/div[2]/detail-category/div/div[1]/span/span[1]")
	WebElement SelectFolder;
	
	@FindBy (css = "[ng-if='$select.open']")
	List<WebElement> listOfFolder=  new ArrayList<>();
	
	public officesRightSide() {
		this.folderrightside = new foldersRightSide();
		this.tabs = new Tabs();
		this.actionrightside = new actionsRightSide();
		this.actionmiddlepane = new actionsMiddlePane();		
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
	
	public void inheritance()  throws InterruptedException {
		
		actionmiddlepane.openEntity("inheritance", "mjhgjf");
		
		actionrightside.addWatcher();
		
		
		Thread.sleep(2000);
		
		memberList.get(1).click();
	
		Thread.sleep(2000);
		
		
		String Editor    = "Set as Editor";
		
		String Commenter = "Set as commenter";

		// Set as editor 
		for(int i = 0; i <= permissionsList.size(); i++) {

			if (permissionsList.get(i).getText().equals(Editor)){

				permissionsList.get(i).click();
				break;
			}

		}
		
		Thread.sleep(2000);
		
		waitForVisibility(tabs.foldersTab);
		
		tabs.foldersTab.click();
		
		Thread.sleep(2000);
		
		actionmiddlepane.openEntity("inheritance2", "dsaasd");
		
		int sizeOfMemberInFolder = memberList.size();
		
		waitForVisibility(SelectOffice);
		
		SelectOffice.click();
		
		Thread.sleep(2000);
		
		String Office = "inheritance";
		
		for (int i = 0; i < listOfOffices.size();i++) {
			
			if (listOfOffices.get(i).getText().equals(Office)) {
				
				listOfOffices.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		int sizeOfMembersAfterInFolder =memberList.size();
		
		if (sizeOfMemberInFolder + 1 == sizeOfMembersAfterInFolder) {
			
			logger.log(Status.PASS , "inheritance from office to folder");
		}
		
		else {

			logger.log(Status.FAIL, "inheritance from office to folder");
		}
		
		
		waitForVisibility(tabs.documentTab);
		
		tabs.documentTab.click();
		
		Thread.sleep(2000);
		
		actionmiddlepane.openEntity("inheritance4", "adsasd");
		
		int sizeOfMemberInDoc = memberList.size();
		
		waitForVisibility(SelectFolder);
		
		SelectFolder.click();
		
		String Folder = "inheritance2";
		
		for (int i = 0; i < listOfFolder.size();i++) {

			if (listOfOffices.get(i).getText().equals(Folder)) {

				listOfOffices.get(i).click();
				break;
			}
		}

		int	sizeOfMemberAfterInDoc = memberList.size();
		
		if (sizeOfMemberInDoc + 1 == sizeOfMemberAfterInDoc) {
			
			logger.log(Status.PASS , "inheritance from folder to documents");
		}
		
		else {

			logger.log(Status.FAIL, "inheritance from folder to documents");
		}
		
	}


}
	
	
	
	
	

