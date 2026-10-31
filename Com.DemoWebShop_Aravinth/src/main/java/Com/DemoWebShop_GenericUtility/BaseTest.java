package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {
	public WebDriver driver;
	static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;

	public FileUtility fileUtility = new FileUtility();

	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriver_Utility webDriverUtility = new WebDriver_Utility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite --- DataBase Connection");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test --- Report Generation");
		spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class --- Launch Browser");

//		String browser = fileUtility.readDataFromPropertyFile("browserName");
//		String url = fileUtility.readDataFromPropertyFile("url");

		String browser = System.getProperty("browserName");
		String url = System.getProperty("baseUrl");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome is Running...");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Edge is Running...");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox is Running...");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Pls Give Correct browser name :" + browser);
		}

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method --- Login to App");

		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginBtn().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("userName"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();

		homePage = new Home_Page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method --- Logout of App");

		homePage.getLogoutBtn().click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After class --- Close Browser");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test --- Report End");
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite --- Database Connection Closed");
	}

}
