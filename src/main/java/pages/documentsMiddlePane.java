package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

public class documentsMiddlePane extends TestBase {
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

	public void openEntity(String tit , String des) throws InterruptedException {
		
		waitForVisibility(middlepane.pressCreateNewItem);
		
		middlepane.pressCreateNewItem.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(middlepane.enterTitle);
		
		middlepane.enterTitle.sendKeys(tit);
		
		
		waitForVisibility(middlepane.description);
		
		middlepane.description.sendKeys(des);
		
		
		waitForVisibility(middlepane.pressOnEntity);
		
		middlepane.pressOnEntity.click();
		
		Thread.sleep(3000);
		
	}
	
	public void changeStatusOfList()throws InterruptedException {
		
		int sizeOfList = middlepane.listOfEntities.size();
		
		openEntity("test", "importenet2");
		
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
		
		if (sizeOfList < sizeOfListAfterPressAll) {
			
			logger.log(Status.PASS , "status by all");
		
		}	
		
		else {
			
			logger.log(Status.FAIL , "status by all");
		}
		
	}
	
	public void sortByFavorite() throws InterruptedException {
		
		int sizeOfList = middlepane.listOfEntities.size();
		
		
		waitForVisibility(middlepane.pressOnEntity);
				
		middlepane.pressOnEntity.click();
		
		Thread.sleep(2000);
		
		waitForVisibility(therightonthescreen.chooseFavorite);
		
		therightonthescreen.chooseFavorite.click();
		
		
		Thread.sleep(2000);
		
		waitForVisibility(middlepane.pressOnSortByfavorite);
		
		middlepane.pressOnSortByfavorite.click();
		
		Thread.sleep(2000);
		
		int sizeOfListAfterPressFavorite = middlepane.listOfEntities.size();
		
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
	
	public void pressOnArrow() throws InterruptedException {
		
		openEntity("this is test", "dassad");
		
		openEntity("hello world", "dasdassad");
		
		openEntity("abcd", "dasdassad");
		
		String firstNameOfEntity = listOfnamesOfEntities.get(0).getAttribute("textContent");
		
		String lastNameOfEntity =listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");
				
		
		System.out.println(firstNameOfEntity);
		
		waitForVisibility(middlepane.pressArrow);
		
		middlepane.pressArrow.click();
		
		
		String firstNameAfterPressArrow =listOfnamesOfEntities.get(0).getAttribute("textContent");
		
		String	lastNameAfterPressArrow = listOfnamesOfEntities.get(middlepane.listOfEntities.size() -1).
				getAttribute("textContent");
				
		
		
		Thread.sleep(3000);
	
		if (firstNameOfEntity.equals(lastNameAfterPressArrow) && lastNameOfEntity.equals(firstNameAfterPressArrow)) {
			
			logger.log(Status.PASS , "arrow button");
		} 
		
		else {
			logger.log(Status.FAIL , "arrow button");
		}
	
	}
		
 }	
		
	
