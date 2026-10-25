package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	public void webPageScroonShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(FrameWorkConstants.screenshotsPath);
		FileHandler.copy(temp, desc);
	}

	public void selectByVisibleText(WebElement dropdownElement, String text) {
		Select sel = new Select(dropdownElement);
		sel.selectByVisibleText(text);
	}

	public void javascriptScrollTillElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javascriptpopupAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

}
