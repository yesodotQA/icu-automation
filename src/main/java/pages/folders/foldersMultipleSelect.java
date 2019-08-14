package pages.folders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.testBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

public class foldersMultipleSelect  extends testBase{
	
	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;	

	
	public foldersMultipleSelect(){
		
		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		PageFactory.initElements(driver, this);
	 }
	
	
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//a function that press on document 
	public void pressFolders() throws InterruptedException {
			
			waitForVisibility(tabs.settingsTab);
			
			tabs.settingsTab.click();
			
			Thread.sleep(3000);
			
	 }
	
		//a function that delete entity using multiple select 
		public void deleteEntityMultipleChoice() throws InterruptedException {
			
			int size =middlepane.listOfEntities.size() ;
			
				 
			 waitForVisibility(multipleselect.pressMultipleChoice);
			
			multipleselect.pressMultipleChoice.click();
			
		
			waitForVisibility(multipleselect.pressDeleteMultipleChoice);
			
			multipleselect.pressDeleteMultipleChoice.click();
			
			
			waitForVisibility(multipleselect.deleteMultipleChoice);
			
			multipleselect.deleteMultipleChoice.click();
			
			
			Thread.sleep(2000);
			
			int newSize =middlepane.listOfEntities.size();
			
			//check if the entity deleted
			if (size - 1 == newSize) {
				
			
				logger.log(Status.PASS , "delete document using mulitiple choice");
				
			}
			
			else {
				
				logger.log(Status.FAIL , "delete document using mulitiple choice");
				
			}
			
		}
		
		//a function that adds tags using multiple select 
		public void addTagsMultipleChoice(String tags) throws InterruptedException {
			 
			middlepane.openEntity("doc2", "importent");
			
			waitForVisibility(multipleselect.pressMultipleChoice);
			
			multipleselect.pressMultipleChoice.click();
			
			Thread.sleep(2000);
			
			waitForVisibility(multipleselect.TagsMultipleChoice);
			
			multipleselect.TagsMultipleChoice.click();
			
			
			waitForVisibility(multipleselect.selectTags);
			
			multipleselect.selectTags.sendKeys(tags);
			
			
			waitForVisibility(multipleselect.clickOnNewTAg);
			
			multipleselect.clickOnNewTAg.click();
			
			
			waitForVisibility(multipleselect.updateTags);
			
			multipleselect.updateTags.click();
			
			Thread.sleep(2000);
			waitForVisibility(multipleselect.pressSecondMultipleChoice);
			
			multipleselect.pressSecondMultipleChoice.click();
			
			
			waitForVisibility(middlepane.pressOnEntity);
			
			middlepane.pressOnEntity.click();
			
			
			Thread.sleep(2000);
			
			String check =therightonthescreen.tagsOnScreenForChecking.getText();
			
			// checks if the tags have been updated on the side of the screen
			if (check.equals("mission (New)")) {
			
				logger.log(Status.PASS , "add Tags using multiple select");
			}
			
			else {
				
				logger.log(Status.FAIL, "add Tags using multiple select");
			}
			
		}
	}
