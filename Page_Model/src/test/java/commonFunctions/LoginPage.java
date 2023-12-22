package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//define repository for login
	@FindBy(xpath ="//button[@id='btnreset']")
	WebElement ObjResetBtn;
	@FindBy(xpath ="//input[@id='username']")
	WebElement ObjUser;
	@FindBy(xpath ="//input[@id='password']")
	WebElement ObjPass;
	@FindBy(xpath ="//button[@id='btnsubmit']")
	WebElement ObjLoginBtn;
	// method for login
	public void adminLogin(String username, String password)
	{
		ObjResetBtn.click();
		ObjUser.sendKeys(username);
		ObjPass.sendKeys(password);
		ObjLoginBtn.click();
		
	}
	
}
