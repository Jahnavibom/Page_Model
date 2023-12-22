package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {

	@FindBy(xpath ="//li[@id='mi_logout']//a[@href='logout.php'][normalize-space()='Logout']")
	WebElement ObjLogOut;
	//method for logout
	public void logOutApp()
	
	{
		ObjLogOut.click();
	}
}
