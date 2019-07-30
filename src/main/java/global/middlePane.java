package global;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class middlePane extends TestBase {

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
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-0\"]/span/span")
	public WebElement pressSortByTitle;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-1\"]/span/span")
	public	WebElement pressOnStatus;
	
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-52-3\"]/span/span")
	public	WebElement pressOnUnread;
	
	
	 public middlePane () {
			
		    PageFactory.initElements(driver, this);
		    	
		   }

	
	
	
}
