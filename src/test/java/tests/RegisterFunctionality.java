package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.FakeData;
import base.SetupDriver;
import io.qameta.allure.Description;
import pageobjects.Headers;
import pageobjects.LogInPage;
import pageobjects.RegisterForm;

public class RegisterFunctionality extends SetupDriver {
	@Description("Verifying valid registration")
	@Test
	public void validRegister() {
		RegisterForm reg = new RegisterForm();
		FakeData fker = new FakeData();
		reg.navigate(fker.fake_email);

		reg.clickOnMRTitle();
		reg.typeFirstName(fker.firstname);
		reg.typeLastName(fker.lastname);
		reg.typeEmail(fker.fake_email);
		reg.typePassword(fker.password);
		reg.selectDays(5);
		reg.selectMonths(5);
		reg.selectYear(5);
		reg.clickSubmit();
		Assert.assertTrue(reg.check_Existence_Of_Success_Message());
	}
	@Description("Verifying registring with existing email address")
	@Test
	public void sameEmailRegister() {
		
		Headers header = new Headers();
		RegisterForm reg = new RegisterForm();
		LogInPage login = new LogInPage();
		FakeData fker = new FakeData();
		reg.navigate(fker.fake_email);
		reg.clickOnMRTitle();
		reg.typeFirstName(fker.firstname);
		reg.typeLastName(fker.lastname);
		reg.typeEmail(fker.fake_email);
		reg.typePassword(fker.password);
		reg.selectDays(5);
		reg.selectMonths(5);
		reg.selectYear(5);
		reg.clickSubmit();
		header.clickLogout();
		login.registeremailtype(fker.fake_email);
		login.clickcreateaccount();
		Assert.assertTrue(reg.check_Existence_Of_Alert_Message());
	}
	@Description("Verifying invalid register")
	@Test
	public void invalidRegister() {

		RegisterForm reg = new RegisterForm();
		FakeData fker = new FakeData();
		reg.navigate(fker.fake_email);
		reg.clickOnMRTitle();
		reg.typeFirstName("1234");
		reg.typeLastName(fker.lastname);
		reg.typeEmail(fker.fake_email);
		reg.typePassword(fker.password);
		reg.selectDays(5);
		reg.selectMonths(5);
		reg.selectYear(5);
		reg.clickSubmit();
		Assert.assertTrue(reg.check_Existence_Of_Alert_Message());

	}

}
