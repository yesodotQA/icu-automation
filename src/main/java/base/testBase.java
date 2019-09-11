package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> 0f0b0af4918a6d14a9854704845a7f63ee9cec4b
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
<<<<<<< HEAD
=======
import org.testng.annotations.BeforeSuite;

>>>>>>> 0f0b0af4918a6d14a9854704845a7f63ee9cec4b

public class testBase {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	public static WebDriverWait wait;
	public static Properties prop;

	public static void initialization() throws IOException  {

		prop = new Properties();
		FileInputStream ip = new FileInputStream("./configs/properties");
		prop.load(ip);

		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));

		driver 		 = new ChromeDriver();
		wait 		 = new WebDriverWait(driver, 30);
		extent 		 = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		extent.attachReporter(htmlReporter);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to(prop.getProperty("url"));

	}


	public static void Login() throws InterruptedException {


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/div/form/div[2]/input")));

		driver.findElement(By.xpath("/html/body/section/section/div/form/div[2]/input")).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath("/html/body/section/section/div/form/div[3]/input")).sendKeys(prop.getProperty("password"));

		driver.findElement(By.className("btn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/button")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button")).click();

		Thread.sleep(2000);

	}
<<<<<<< HEAD
	
=======
>>>>>>> 0f0b0af4918a6d14a9854704845a7f63ee9cec4b
}


class beforeWeStart extends testBase {
	@BeforeSuite
	public void SetUp() throws InterruptedException, IOException {
		initialization();
		Login();

	}


<<<<<<< HEAD
=======
}
>>>>>>> 0f0b0af4918a6d14a9854704845a7f63ee9cec4b



