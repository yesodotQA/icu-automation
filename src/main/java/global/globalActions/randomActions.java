package global.globalActions;

import java.util.Random;

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

		public void chooseColor()  throws InterruptedException{

			waitForVisibility(therightonthescreen.openColors);

			therightonthescreen.openColors.click();

			Thread.sleep(2000);

			Random rand = new Random();

			int randomColors = rand.nextInt(therightonthescreen.listOfColors.size());

			therightonthescreen.listOfColors.get(randomColors).click();

		}
		
		public void enterNameToEntity(String nam) throws InterruptedException{

			waitForVisibility(middlepane.pressOnEntity);
			
			middlepane.pressOnEntity.click();
			
			middlepane.pressOnEntity.sendKeys(nam);
			
			Thread.sleep(2000);
			
			if (middlepane.listOfnamesOfEntities.get(0).getText().equals(middlepane.enterTitle.getText())) {
				
				logger.log(Status.PASS, "enter name to entity from entity row");
			}
			else {
				logger.log(Status.FAIL, "enter name to entity from entity row");
			}
	
		}
		
		


	}
