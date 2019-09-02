package global.globalActions;

import javax.swing.text.AbstractDocument.BranchElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalElements.Tabs;
import global.globalElements.middlePane;
import global.globalElements.multipleSelect;
import global.globalElements.theRightOfTheScreen;

public class randomActions extends testBase{
	
	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionmiddlepane;
	
	
	
	
	public randomActions(){

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		this.actionmiddlepane = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}

	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void enterTagsFromList() throws InterruptedException{
		String ExistingTag = "www (New)";
		
		actionmiddlepane.openEntity("ExistingTags", "fjdkfhkfdjh");
		
		waitForVisibility(therightonthescreen.enterTagsOnScreen);
		
		therightonthescreen.enterTagsOnScreen.click();
		
		Thread.sleep(2000);
		
	
		for (int i = 0; i < therightonthescreen.listOfTagsOnScreen.size()-1; i++) {
			
			if (therightonthescreen.listOfTagsOnScreen.get(i).getText().equals(ExistingTag)) {
				
				therightonthescreen.listOfTagsOnScreen.get(i).click();
				break;
			}
			
	
		
	}

	

}
}
