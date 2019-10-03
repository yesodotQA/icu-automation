package Search;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.testBase;
import pages.Search.deletedItems;

public class searchTest extends testBase {
	
	deletedItems deleteditems;

	@BeforeClass
	public void SetUp() throws InterruptedException, IOException{	

		this.deleteditems = new deletedItems();

	}
	
	@Test (priority = 1)
	public void testDeletedItems() throws InterruptedException {
		logger = extent.createTest("search");
		deleteditems.searchDeleteItems();
		deleteditems.unDelete();
	}
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
