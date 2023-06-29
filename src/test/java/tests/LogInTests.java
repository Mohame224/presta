package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.FakeData;
import base.SetupDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.Headers;
import pageobjects.LogInPage;
import pageobjects.RegisterForm;
import util.GetExcelData;
import util.GetJsonFileInvalidData;

public class LogInTests extends SetupDriver {
	@Description("verify login with valid credintials")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("verify logging functionality")
	@Test
	public void sucessfulLogIn() throws InterruptedException {
		LogInPage log = new LogInPage();
		FakeData fker = new FakeData();
		Headers headse = new Headers();
		log.navigate();
		log.loginemailtype(fker.fake_email);
		log.loginpasswordtype(fker.fake_password);
		log.loginclick();
		if (log.check_Existence_Of_Alert_Message() == true) {
			RegisterForm reg = new RegisterForm();
			log.registeremailtype(fker.fake_email);
			log.clickcreateaccount();
			reg.clickOnMRTitle();
			reg.typeFirstName(fker.firstname);
			reg.typeLastName(fker.lastname);
			reg.typeEmail(fker.fake_email);
			reg.typePassword(fker.fake_password);
			reg.selectDays(5);
			reg.selectMonths(4);
			reg.selectYear(2);
//			reg.clickonRecieveOffers();
//			reg.acceotNewsLetter();
			reg.clickSubmit();
			log.check_Existence_Of_Success_Message();
			headse.clickLogout();
			log.loginemailtype(fker.fake_email);
			log.loginpasswordtype(fker.fake_password);
			log.loginclick();
		}
	}

	@Description("verify login with invalid credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("verify logging functionality")
	@Test(testName = "login scenario ", dataProvider = "invalidData")
	public void verifyLoggingWithInvalidCredentials(String username, String password) {
		LogInPage log = new LogInPage();
		log.navigate();
		log.loginemailtype(username);
		log.loginpasswordtype(password);
		log.loginclick();
		Assert.assertTrue(log.check_Existence_Of_Alert_Message());
	}

	@DataProvider
	public Object[][] invalidData() {
		return new Object[][] { { "hela", "hello" }, { "", "hello" }, { "hela", "" }, { "", "" } };
	}
	
	
	
	
	
	@Description("verify login with invalid credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("verify logging functionality")
	@Test(testName = "login scenario ", dataProvider = "getInvalidLoginsData")
	public void verifyLoggingWithInvalidCredentialsFromExcel(String username, String password) {
		LogInPage log = new LogInPage();
		log.navigate();
		log.loginemailtype(username);
		log.loginpasswordtype(password);
		log.loginclick();
		Assert.assertTrue(log.check_Existence_Of_Alert_Message());
	}
	@DataProvider
	public Object[][] getInvalidLoginsData() throws  IOException, InvalidFormatException {
		GetExcelData gd= new GetExcelData ();
	    Object[][] data = gd.read_excel_sheet1(); // assuming you have defined the read_excel_sheet1 method
	    
	    return data;
	}
	
	
	
	
	@Description("verify login with invalid credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("verify logging functionality")
	@Test(testName = "login scenario ", dataProvider = "invalid_JSON_file")
	public void verifyLoggingWithInvalidCredentialsFromJSON(String data) {
		String users[]=data.split(",");
		LogInPage log = new LogInPage();
		log.navigate();
		log.loginemailtype(users[0].replace("\"", ""));
		log.loginpasswordtype(users[1].replace("\"", ""));
		log.loginclick();
		Assert.assertTrue(log.check_Existence_Of_Alert_Message());
	}
	
	@DataProvider
	public String[] invalid_JSON_file() throws IOException{
		GetJsonFileInvalidData data=new GetJsonFileInvalidData();
		return data.invalid_JSON_file();		
	}
}
