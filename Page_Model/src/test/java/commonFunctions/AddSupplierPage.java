package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddSupplierPage {
public WebDriver driver;
public AddSupplierPage(WebDriver driver)
{
	this.driver = driver;
}
//define Repository
@FindBy(linkText =  "Suppliers")
WebElement ObjSupplierLink;
@FindBy(xpath ="//a[@data-original-title='Add']")
WebElement ObjAddIconBtn;
@FindBy(name ="x_Supplier_Number")
WebElement ObjSupplierNumber;
@FindBy(name="x_Supplier_Name")
WebElement ObjSupplierName;
@FindBy(name="x_Address")
WebElement ObjAddress;
@FindBy (name="x_City")
WebElement ObjCity;
@FindBy(name="x_Country")
WebElement ObjCountry;
@FindBy (name="x_Contact_Person")
WebElement ObjContactPerson;
@FindBy (name ="x_Phone_Number")
WebElement ObjPhoneNumber;
@FindBy (name="x__Email")
WebElement ObjEmail;
@FindBy (name="x_Mobile_Number")
WebElement ObjMobileNumber;
@FindBy (name="x_Notes")
WebElement ObjNotes;
@FindBy (name="btnAction")
WebElement ObjAddBtn;
@FindBy (xpath ="//button[normalize-space()='OK!']")
WebElement ObjConfirmOkBtn;
@FindBy (xpath ="//button[@class='ajs-button btn btn-primary']")
WebElement ObjAlertOkBtn;
@FindBy( xpath ="//button[@data-toggle='button']")
WebElement ObjSearchPanel;
@FindBy (xpath ="//input[@id='psearch']")
WebElement ObjSearchTextBox;
@FindBy (xpath ="//button[@id='btnsubmit']")
WebElement ObjSearchBtn;
@FindBy (xpath ="//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")
WebElement WebTable;
// Method for supplier
public boolean add_Supplier(String SupplierName, String Address, String City, String Country, String ContactPerson, 
		String PhoneNumber, String Email,String MobileNumber, String Notes)throws Throwable
{
	this.ObjSupplierLink.click();
	Thread.sleep(1000);
	this.ObjAddIconBtn.click();
	Thread.sleep(1000);
	String Exp_data = this.ObjSupplierNumber.getAttribute("value");
	this.ObjSupplierName.sendKeys(SupplierName);
	this.ObjAddress.sendKeys(Address);
	this.ObjCity.sendKeys(City);
	this.ObjCountry.sendKeys(Country);
	this.ObjContactPerson.sendKeys(ContactPerson);
	this.ObjPhoneNumber.sendKeys(PhoneNumber);
	this.ObjEmail.sendKeys(Email);
	this.ObjMobileNumber.sendKeys(MobileNumber);
	this.ObjNotes.sendKeys(Notes);
	this.ObjAddBtn.click();
	Thread.sleep(1000);
	this.ObjConfirmOkBtn.click();
	Thread.sleep(1000);
	this.ObjAlertOkBtn.click();
	// click search panel if search text box not displayed 
	if(!this.ObjSearchTextBox.isDisplayed())
			this.ObjSearchPanel.click();
			
	this.ObjSearchTextBox.clear();
	this.ObjSearchTextBox.sendKeys(Exp_data);
	this.ObjSearchBtn.click();
	Thread.sleep(1000);
	String Act_data = this.WebTable.getText();
	if(Exp_data.equalsIgnoreCase(Act_data))
	{
		Reporter.log("Add Supplier success:  "+Exp_data +"   "+ Act_data,true);
		return true;
	}
	else
	{
		Reporter.log("Add Supplier Failed : "+ Exp_data +"   "+ Act_data,true);
		return false;
	}
}




}
