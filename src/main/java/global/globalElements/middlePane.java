package global.globalElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.testBase;

public class middlePane extends testBase {
	
	@FindBy(css = "[ng-model='newItem']")
	public WebElement pressCreateNewItem;
	
	@FindBy(className = "item-title")
	public WebElement enterTitle;
	
	@FindBy(css = "[ng-model='item.description']")
	public WebElement description;
	
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[3]")
	public	WebElement pressOnEntity;
	
	@FindBy(css ="[ng-include='unifiedRowTpl']")
	public List<WebElement>  listOfEntities = new ArrayList<>();
	
	@FindBy(css = ".sortByStar .favorites")
	public	WebElement pressOnSortByfavorite;
	
	@FindBy(className = "active-status")
	public WebElement sortByStatus;
	
	@FindBy(css = "[ng-if='$select.open']")
	public List<WebElement>  listOfStatusOfEntities = new ArrayList<>();
	
	@FindBy(className = "button-left-part")
	public	WebElement pressArrow;
	
	@FindBy(className =  "button-right-part")
	public	WebElement pressOnSortButton;
	
	@FindBy(className = "ui-select-choices-row")
	public List<WebElement>  listOfSorts = new ArrayList<>();
	
	
	 public middlePane () {
			
		    PageFactory.initElements(driver, this);
		    	
		   }
	 
	 private void waitForVisibility (WebElement element)  {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
	}
	//a function that open new entity and give title and description
	 public void openEntity(String tit , String des) throws InterruptedException {
			
			waitForVisibility(pressCreateNewItem);
			
			pressCreateNewItem.click();
			
			
			Thread.sleep(2000);
			
			waitForVisibility(enterTitle);
			
			enterTitle.sendKeys(tit);
			
			
			Thread.sleep(3000);
			
			waitForVisibility(description);
			
			description.sendKeys(des);
			
		
			Thread.sleep(3000);
			
			waitForVisibility(pressOnEntity);
			
			pressOnEntity.click();
			
			Thread.sleep(3000);
			
		}
	
	
	
}
