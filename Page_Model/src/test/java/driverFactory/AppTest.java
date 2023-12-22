package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.AddSupplierPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {
	String inputpath = "./FileInput/SupplierData.xlsx";
	String outputpath = "./FileOutput/PomResults.xlsx";
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void startTest() throws Throwable
	{
		//define path for html reports
		report = new ExtentReports("./target/Reports/Supplier.html");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		// count no of rows in supplier sheet
		int rc = xl.rowCount("Supplier");
		Reporter.log("No of rows in supplier sheet: "+ rc,true);
		// iterate all rows in supplier sheet
		for(int i=1; i<=rc; i++)
		{
			logger= report.startTest("Validate Supplier");
			logger.assignAuthor("Janu");
			// read all cells from supplier sheet
			String SupplierName = xl.getCellData("Supplier", i, 0);
			String Address = xl.getCellData("Supplier", i, 1);
			String City = xl.getCellData("Supplier", i, 2);
			String Country = xl.getCellData("Supplier", i, 3);
			String ContactPerson = xl.getCellData("Supplier", i, 4);
			String PhoneNumber = xl.getCellData("Supplier", i, 5);
			String Email = xl.getCellData("Supplier", i, 6);
			String MobileNumber = xl.getCellData("Supplier", i, 7);
			String Notes = xl.getCellData("Supplier", i, 8);
			logger.log(LogStatus.INFO,"ExcelData"+ SupplierName+"......."+ Address+"......."+City+"......"+
			Country+".........."+ContactPerson+"......"+ PhoneNumber+"........"+ Email+"........."+ MobileNumber+"......"+Notes);
			
			AddSupplierPage addsup = PageFactory.initElements(driver, AddSupplierPage.class);
			boolean res = addsup.add_Supplier(SupplierName, Address, City, Country, ContactPerson, PhoneNumber, Email, MobileNumber, Notes);
			if (res)
			{
				logger.log(LogStatus.PASS, "Supplier number Matching");
				xl.setCellData("Supplier", i, 9, "pass", outputpath);
			}
			else
			{
				logger.log(LogStatus.FAIL, "Supplier number not Matching");
				xl.setCellData("Supplier", i, 9, "Fail", outputpath);
			}
			report.endTest(logger);
			report.flush();
		}
	}
	
		
	}


