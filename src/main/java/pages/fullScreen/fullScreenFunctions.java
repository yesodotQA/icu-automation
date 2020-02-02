
package pages.fullScreen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;
import global.globalActions.actionsMultipleSelect;
import global.globalElements.middlePane;

public class fullScreenFunctions  extends testBase{
	
	  actionsMultipleSelect actionsmultipleselect;
	  middlePane middlepane;
	
	  
	@FindBy (className =  "header-button")
	WebElement FullScreenFirst;
	
	@FindBy (className =  "hide-menu")
	WebElement FullScreenSecond;
	
	
	public  fullScreenFunctions() {
		
		PageFactory.initElements(driver, this);
		this.middlepane = new middlePane();
		this.actionsmultipleselect = new actionsMultipleSelect();
		
	}
	
	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void PressOnFullScreen() throws InterruptedException {

	
			waitForVisibility(FullScreenFirst);
			
			FullScreenFirst.click();
			
			Thread.sleep(1000);
			
			waitForVisibility(FullScreenSecond);
			
			FullScreenSecond.click();
				
	}
/*
	public static  void click (int x, int y) throws AWTException{
 	Robot robot = new Robot ();
     robot.mouseMove(x, y);
     robot.delay(5);
     robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
     robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
	}
*/
	public void moveToElemente() {
    
		action.moveToElement(FullScreenFirst).click().build().perform();
		
		action.moveToElement(middlepane.pressOnEntity).build().perform();
 }
	
	

}

