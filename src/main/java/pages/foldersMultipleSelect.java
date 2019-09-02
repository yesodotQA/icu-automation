package pages;

import org.openqa.selenium.support.PageFactory;

import base.testBase;
import global.Tabs;
import global.middlePane;
import global.multipleSelect;
import global.theRightOfTheScreen;

public class foldersMultipleSelect extends testBase{

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
	
	
	
	
}
