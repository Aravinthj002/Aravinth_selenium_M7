package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernersUtility implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot) BaseTest.sDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotsPath);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
