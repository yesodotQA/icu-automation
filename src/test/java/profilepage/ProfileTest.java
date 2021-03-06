package profilepage;


import base.testBase;
import global.globalElements.middlePane;
import pages.Search.deletedItems;
import pages.profilepage.Profilepage;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;


public class ProfileTest extends testBase {
	Profilepage profilepage;
	

	
	@Test																		
	public void Profiletest () throws InterruptedException, FindFailed, IOException {
		
		logger = extent.createTest("profile test");
		this.profilepage = new Profilepage();
		
		wait.until(ExpectedConditions.visibilityOf(profilepage.avatar));
		profilepage.avatar.click();
		
		wait.until(ExpectedConditions.visibilityOf(profilepage.enterprofile));
		profilepage.enterprofile.click();
		
		Thread.sleep(2000);
		
		profilepage.profilename.sendKeys("12");
		
		Thread.sleep(3000);
		
		profilepage.profileemail.sendKeys("21");
		
		Thread.sleep(3000);
		
		profilepage.changeprofilepic.click();
		
		Thread.sleep(2000);
		logger = extent.createTest("changing profile pic");
		Screen screen = new Screen();
		Pattern desktop= new Pattern ("/home/israel/Desktop/sikulixapi/desktop.png");
		Pattern txt= new Pattern ("/home/israel/Desktop/sikulixapi/txt.png");
		Pattern openbutton= new Pattern ("/home/israel/Desktop/sikulixapi/open.png");
		
		screen.find(desktop);
		Thread.sleep(1500);
		screen.click(desktop);
		Thread.sleep(1500);
		
		screen.find(txt);
		Thread.sleep(1500);
		screen.click(txt);
		
		screen.find(openbutton);
		Thread.sleep(1500);
		screen.click(openbutton);

        
	}
}
	


