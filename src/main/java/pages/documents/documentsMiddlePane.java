package pages.documents;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

public class documentsMiddlePane  extends testBase {
	
	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsmiddlepane;
	

	public documentsMiddlePane() {
	
		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();
		actionsmiddlepane = new actionsMiddlePane();
		PageFactory.initElements(driver, this);
	}

	 private void waitForVisibility (WebElement element)  {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
	}

	
	
		
		
	
	
			
 }
	
		

	
		
	
		
	
