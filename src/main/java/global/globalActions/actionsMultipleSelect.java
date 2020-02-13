package global.globalActions;

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
import javassist.bytecode.stackmap.BasicBlock.Catch;
import pages.offices.officesMultipleSelect;

public class actionsMultipleSelect extends testBase {

	Tabs tabs;
	middlePane middlepane;
	multipleSelect multipleselect;
	theRightOfTheScreen therightonthescreen;
	actionsMiddlePane actionsMiddlePane;

	@FindBy (className =  "header-button")
	WebElement FullScreenFirst;

	@FindBy(css = "[ui-date='dueOptions']")
	WebElement getTextOfDate;

	@FindBy (css =".ui-select-match-item .ng-binding.ng-scope")
	WebElement nameOfTagsMultipleChoice;

	@FindBy (className = "cancel")
	WebElement cancelButton;

	@FindBy(className = "modal-content")
	WebElement windowOfMultipleChoice;

	public actionsMultipleSelect(){

		this.multipleselect = new multipleSelect();
		this.middlepane = new middlePane();
		this.actionsMiddlePane = new actionsMiddlePane();
		this.tabs = new Tabs();
		this.therightonthescreen = new theRightOfTheScreen();

		PageFactory.initElements(driver, this);
	}

	private void waitForVisibility (WebElement element)  {

		wait.until(ExpectedConditions.visibilityOf(element));	

	}

	//a function that delete entity using multiple select 
	public void deleteEntityMultipleChoice() throws InterruptedException {
		
		int size =middlepane.listOfEntities.size();

		System.out.println(middlepane.listOfEntities.size());


		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();

		try {

			waitForVisibility(multipleselect.pressDeleteMultipleChoice);

			multipleselect.pressDeleteMultipleChoice.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into delete multiple chioce succeeded");

				try {

					waitForVisibility(multipleselect.deleteMultipleChoice);

					multipleselect.deleteMultipleChoice.click();

					Thread.sleep(3000);

					if (windowOfMultipleChoice.isDisplayed()) {

						logger.log(Status.FAIL, "delete button not work need to check elastic");

						cancelButton.click();

						Thread.sleep(2000);
						waitForVisibility(multipleselect.pressSecondMultipleChoice);

						multipleselect.pressSecondMultipleChoice.click();

					}

				} catch (Exception e) {

					logger.log(Status.PASS, "delete button work");

				} finally {

					Thread.sleep(2000);

					int newSize =middlepane.listOfEntities.size();

					System.out.println(middlepane.listOfEntities.size());

					//check if the entity deleted
					if (size - 1 == newSize) {


						logger.log(Status.PASS , "delete  using mulitiple choice");

					}

					else {

						logger.log(Status.FAIL , "delete  using mulitiple choice");
					}
				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into delete multiple chioce faild");

			Thread.sleep(2000);
			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();
		} 
	}

	//a function that adds tags using multiple select 
	public void addTagsMultipleChoice(String tags) throws InterruptedException {

		String nameOfTagsYouAdded = "";

		actionsMiddlePane.openEntity("military", "importent");

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();

		Thread.sleep(2000);

		try {

			waitForVisibility(multipleselect.TagsMultipleChoice);

			multipleselect.TagsMultipleChoice.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into tags multiple choice");

				try {

					waitForVisibility(multipleselect.selectTags);

					multipleselect.selectTags.sendKeys(tags);

					waitForVisibility(multipleselect.clickOnNewTAg);

					multipleselect.clickOnNewTAg.click();

					Thread.sleep(2000);

					nameOfTagsYouAdded = nameOfTagsMultipleChoice.getAttribute("innerText");

					waitForVisibility(multipleselect.updateTags);

					multipleselect.updateTags.click();

					Thread.sleep(3000);

					if (windowOfMultipleChoice.isDisplayed()) {

						logger.log(Status.FAIL, "update button not work");

						Thread.sleep(2000);

						cancelButton.click();

						Thread.sleep(2000);
						waitForVisibility(multipleselect.pressSecondMultipleChoice);

						multipleselect.pressSecondMultipleChoice.click();

						waitForVisibility(middlepane.pressOnEntity);

						middlepane.pressOnEntity.click();

					}

				} catch (Exception e) {

					logger.log(Status.PASS, "update button work");

					Thread.sleep(2000);

					waitForVisibility(multipleselect.pressSecondMultipleChoice);

					multipleselect.pressSecondMultipleChoice.click();


					waitForVisibility(middlepane.pressOnEntity);

					middlepane.pressOnEntity.click();

				} finally {

					Thread.sleep(2000);

					String check =therightonthescreen.tagsOnScreenForChecking.getText();

					System.out.println(check);
					System.out.println(nameOfTagsYouAdded);
					// checks if the tags have been updated on the side of the screen
					if (check.equals(nameOfTagsYouAdded)) {

						logger.log(Status.PASS , "add Tags using multiple select");
					}

					else {

						logger.log(Status.FAIL, "add Tags using multiple select");
					}

				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into tags multiple chioce faild");

			Thread.sleep(2000);

			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();

			waitForVisibility(middlepane.pressOnEntity);

			middlepane.pressOnEntity.click();

		}
	}

	//a function that adds date using multiple select 
	public void addDateMultipleChoice() throws InterruptedException {

		String nameOfDate ="";

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();

		try {

			waitForVisibility(multipleselect.pressOnDateMultipleSelect);

			multipleselect.pressOnDateMultipleSelect.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into date multiple choice");

				try {

					Thread.sleep(2000);
					waitForVisibility(multipleselect.pressToChooseDate);

					multipleselect.pressToChooseDate.click();

					Thread.sleep(2000);
					waitForVisibility(multipleselect.nextMonth);

					multipleselect.nextMonth.click();


					waitForVisibility(multipleselect.chooseADate);

					multipleselect.chooseADate.click();

					nameOfDate = getTextOfDate.getAttribute("value");


					Thread.sleep(2000);
					waitForVisibility(multipleselect.updateDate);

					multipleselect.updateDate.click();

					Thread.sleep(2000);

					if (windowOfMultipleChoice.isDisplayed()) {

						logger.log(Status.FAIL, "update button not work");

						Thread.sleep(2000);

						cancelButton.click();

						Thread.sleep(2000);
						waitForVisibility(multipleselect.pressSecondMultipleChoice);

						multipleselect.pressSecondMultipleChoice.click();

						waitForVisibility(middlepane.pressOnEntity);

						middlepane.pressOnEntity.click();

					}

				} catch (Exception e) {

					logger.log(Status.PASS, "update button work");


					Thread.sleep(2000);

					waitForVisibility(multipleselect.pressSecondMultipleChoice);

					multipleselect.pressSecondMultipleChoice.click();


					waitForVisibility(middlepane.pressOnEntity);

					middlepane.pressOnEntity.click();

				}finally {

					Thread.sleep(2000);


					String nameOfDateOnScreen =therightonthescreen.dateOnTheScreen.getAttribute("value");

					// checks if the date have been updated on the side of the screen
					if (nameOfDateOnScreen.equals(nameOfDate)) {

						logger.log(Status.PASS , "add Date using multiple select");
					}

					else {

						logger.log(Status.FAIL, "add Date using multiple select");
					}

				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into date multiple chioce faild");

			Thread.sleep(2000);

			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();

			waitForVisibility(middlepane.pressOnEntity);

			middlepane.pressOnEntity.click();

		}
	}

	// a function that adds assignee using multiple select 
	public void addAssigneeMultipleChoice() throws InterruptedException {

		String nameOfAssignee = "";

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();

		try {

			waitForVisibility(multipleselect.pressAssigneeMultipleChoice);

			multipleselect.pressAssigneeMultipleChoice.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into assignee multiple choice");

				try {

					waitForVisibility(multipleselect.selectAssignee);

					multipleselect.selectAssignee.click();


					Thread.sleep(2000);

					nameOfAssignee = multipleselect.listOfAssignees.get(1).getText();

					multipleselect.listOfAssignees.get(1).click();

					waitForVisibility(multipleselect.updateAssignee);

					multipleselect.updateAssignee.click();

					Thread.sleep(2000);

					if (windowOfMultipleChoice.isDisplayed()) {

						cancelButton.click();

						Thread.sleep(2000);
						waitForVisibility(multipleselect.pressSecondMultipleChoice);

						multipleselect.pressSecondMultipleChoice.click();

						waitForVisibility(middlepane.pressOnEntity);

						middlepane.pressOnEntity.click();


					}	

				} catch (Exception e) {

					logger.log(Status.PASS, "update button work");


					Thread.sleep(2000);

					waitForVisibility(multipleselect.pressSecondMultipleChoice);

					multipleselect.pressSecondMultipleChoice.click();


					waitForVisibility(middlepane.pressOnEntity);

					middlepane.pressOnEntity.click();

				} finally {

					Thread.sleep(2000);

					String nameOfAssigneeOnScreen= therightonthescreen.assigneeOnTheScreen.getText();

					// checks if the assignee have been updated on the side of the screen
					if (nameOfAssigneeOnScreen.equals(nameOfAssignee)) {

						logger.log(Status.PASS , "add assignee using multiple select");
					}

					else {

						logger.log(Status.FAIL, "add assignee using multiple select");
					}

				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into assignee multiple chioce faild");

			Thread.sleep(2000);

			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();

			waitForVisibility(middlepane.pressOnEntity);

			middlepane.pressOnEntity.click();
		}


	}

	public void addWatchersMultipleChoice() throws InterruptedException {

		int numberOfWatcherOnMultipleSelect = 0;

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();


		try {

			waitForVisibility(multipleselect.pressWatchersMultipleChoice);

			multipleselect.pressWatchersMultipleChoice.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into watchers multiple choice");

				try {

					if (multipleselect.addWatchers.isDisplayed()) {

						waitForVisibility(multipleselect.addWatchers);

						multipleselect.addWatchers.click();

						Thread.sleep(2000);

						waitForVisibility(multipleselect.selectMembers);

						multipleselect.selectMembers.click();

						Thread.sleep(2000);

						multipleselect.listToChooseWatchers.get(0).click();

						numberOfWatcherOnMultipleSelect = multipleselect.listOfWatchersMultipleSelect.size();

						try {

							waitForVisibility(multipleselect.updateWatchers);

							multipleselect.updateWatchers.click();

							Thread.sleep(2000);

							if (windowOfMultipleChoice.isDisplayed()) {

								logger.log(Status.FAIL, "update button not work");

								Thread.sleep(2000);

								cancelButton.click();

								Thread.sleep(2000);
								waitForVisibility(multipleselect.pressSecondMultipleChoice);

								multipleselect.pressSecondMultipleChoice.click();

								waitForVisibility(middlepane.pressOnEntity);

								middlepane.pressOnEntity.click();
							}

						} catch (Exception e) {

							logger.log(Status.PASS, "update button work");

						}

					}

				} catch (Exception e) {

					Thread.sleep(2000);

					cancelButton.click();
					
					Thread.sleep(2000);

					waitForVisibility(multipleselect.pressSecondMultipleChoice);

					multipleselect.pressSecondMultipleChoice.click();

					waitForVisibility(middlepane.pressOnEntity);

					middlepane.pressOnEntity.click();


				} finally {

					Thread.sleep(2000);

					int numberOfWatchersOnScreen = therightonthescreen.listOfWatchersIcons.size() ;

					// checks if the watchers have been updated on the side of the screen
					if (numberOfWatchersOnScreen == numberOfWatcherOnMultipleSelect) {

						logger.log(Status.PASS , "add watchers using multiple select");
					}

					else {

						logger.log(Status.FAIL, "add watchers using multiple select");
					}
				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into watchers multiple chioce faild");

			Thread.sleep(2000);

			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();

			waitForVisibility(middlepane.pressOnEntity);

			middlepane.pressOnEntity.click();
		}

	}

	// a function that adds status using multiple select 
	public void addStatusMultipleChoice() throws InterruptedException {

		String nameOfStatus = "";

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();

		try {

			waitForVisibility(multipleselect.pressStatusMultipleChoice);

			multipleselect.pressStatusMultipleChoice.click();

			if (windowOfMultipleChoice.isDisplayed()) {

				logger.log(Status.PASS, "get into status multiple choice");
			}
			try {

				waitForVisibility(multipleselect.selectStatus);

				multipleselect.selectStatus.click();

				nameOfStatus = multipleselect.listOfStatus.get(1).getText();

				multipleselect.listOfStatus.get(1).click();

				waitForVisibility(multipleselect.updateStatus);

				multipleselect.updateStatus.click(); 

				Thread.sleep(2000);

				if (windowOfMultipleChoice.isDisplayed()) {

					logger.log(Status.FAIL, "update button not work");

					cancelButton.click();

					Thread.sleep(2000);
					waitForVisibility(multipleselect.pressSecondMultipleChoice);

					multipleselect.pressSecondMultipleChoice.click();

					waitForVisibility(middlepane.pressOnEntity);

					middlepane.pressOnEntity.click();
				}

			} catch (Exception e) {

				logger.log(Status.PASS, "update button work");

				waitForVisibility(multipleselect.pressSecondMultipleChoice);

				multipleselect.pressSecondMultipleChoice.click();


				waitForVisibility(middlepane.pressOnEntity);

				middlepane.pressOnEntity.click();

			} finally {

				Thread.sleep(2000);

				String nameOfStatusOnScreen =therightonthescreen.pressToChangeStatusOnTheScreen.getText();

				// checks if the status have been updated on the side of the screen
				if (nameOfStatusOnScreen.equals(nameOfStatus)) {

					logger.log(Status.PASS , "add status using multiple select");
				}

				else {

					logger.log(Status.FAIL, "add status using multiple select");
				}
			}

		} catch (Exception e) {

			logger.log(Status.FAIL, "get into status multiple chioce faild");

			Thread.sleep(2000);

			waitForVisibility(multipleselect.pressSecondMultipleChoice);

			multipleselect.pressSecondMultipleChoice.click();

			waitForVisibility(middlepane.pressOnEntity);

			middlepane.pressOnEntity.click();

		}

	}

	public void deleteAllEntities()  throws InterruptedException {

		waitForVisibility(middlepane.pressOnEntity);

		middlepane.pressOnEntity.click();

		waitForVisibility(multipleselect.pressMultipleChoice);

		multipleselect.pressMultipleChoice.click();


		waitForVisibility(multipleselect.multipleChoiceAllEntities);

		multipleselect.multipleChoiceAllEntities.click();


		try {

			waitForVisibility(multipleselect.pressDeleteMultipleChoice);

			multipleselect.pressDeleteMultipleChoice.click();

			Thread.sleep(2000);

			if (windowOfMultipleChoice.isDisplayed()) {

				try {

					waitForVisibility(multipleselect.deleteMultipleChoice);

					multipleselect.deleteMultipleChoice.click();

					Thread.sleep(3000);

					if (windowOfMultipleChoice.isDisplayed()) {

						cancelButton.click();

						waitForVisibility(multipleselect.multipleChoiceAllEntities);

						multipleselect.multipleChoiceAllEntities.click();

						Thread.sleep(2000);

						middlepane.pressOnEntity.click();

					}

				} catch (Exception e) {


				}

			}
		} catch (Exception e) {
			waitForVisibility(multipleselect.multipleChoiceAllEntities);

			multipleselect.multipleChoiceAllEntities.click();

			Thread.sleep(2000);

			middlepane.pressOnEntity.click();

		}

	}
}

