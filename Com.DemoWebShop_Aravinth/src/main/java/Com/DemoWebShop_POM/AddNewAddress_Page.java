package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress_Page {

	public AddNewAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Address_FirstName")
	private WebElement firstnameTextField;

	@FindBy(id = "Address_LastName")
	private WebElement lastnameTextField;

	@FindBy(id = "Address_Email")
	private WebElement emailTextField;

	@FindBy(id = "Address_CountryId")
	private WebElement countryDropdown;

	@FindBy(id = "Address_City")
	private WebElement cityTextField;

	@FindBy(id = "Address_Address1")
	private WebElement addressTextField;

	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipcodeTextField;

	@FindBy(id = "Address_PhoneNumber")
	private WebElement phonenoTextField;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getZipcodeTextField() {
		return zipcodeTextField;
	}

	public WebElement getPhonenoTextField() {
		return phonenoTextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
