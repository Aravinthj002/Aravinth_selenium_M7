package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Books_Page;
import Com.DemoWebShop_POM.CheckOut_Page;
import Com.DemoWebShop_POM.ShoppingCart_Page;

public class TC_003_verify_user_is_able_to_place_order_or_not_Test extends BaseTest {

	@Test
	public void placeOrder() throws IOException, InterruptedException {
		System.out.println("Place Order");

		homePage.getSearchTextField().sendKeys(fileUtility.readDataFromPropertyFile("productName"));
		homePage.getSearchBtn().click(); 

		Thread.sleep(2000);
		Books_Page bookPage = new Books_Page(driver);
		webDriverUtility.javascriptClick(driver, bookPage.getAddToCartBtn());

		Thread.sleep(2000);
		homePage.getShoopingCartBtn().click();

		ShoppingCart_Page cartPage = new ShoppingCart_Page(driver);
		cartPage.getCheckOutRadioBox().click();
		cartPage.getCheckOutBtn().click();

		CheckOut_Page checkOutPage = new CheckOut_Page(driver);
		checkOutPage.getContinueBtns().get(0).click();
		checkOutPage.getContinueBtns().get(1).click();
		checkOutPage.getContinueBtns().get(2).click();
		checkOutPage.getContinueBtns().get(3).click();
		checkOutPage.getContinueBtns().get(4).click();

		checkOutPage.getConfirmBtn().click();

		Thread.sleep(2000);
		webDriverUtility.webPageScroonShot(driver);
	}

}
