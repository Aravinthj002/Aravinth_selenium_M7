package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC_002_verify_user_is_able_to_delete_address_or_not_Test extends BaseTest {
	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		System.out.println("Delete Address Test Script");

		webDriverUtility.javascriptScrollTillElement(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();

		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getDeleteAddressBtn().get(0).click();

		webDriverUtility.javascriptpopupAccept(driver);

		Thread.sleep(3000);
		driver.navigate().refresh();
		

		Thread.sleep(3000);
		webDriverUtility.webPageScroonShot(driver);

	}

}
