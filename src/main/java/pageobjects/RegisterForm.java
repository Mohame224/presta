package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class RegisterForm extends SetupDriver {

	Action ac;

	public RegisterForm() {
		ac = new Action(DriverFactory.getDriver());
	}

	public By mr = (By.id("uniform-id_gender1"));

	public By mrs = (By.id("id_gender2"));

	public By firstname = (By.id("customer_firstname"));

	public By lastname = (By.id("customer_lastname"));

	public By email = (By.id("email"));

	public By password = (By.id("passwd"));

	public By days = (By.id("days"));

	public By months = (By.id("months"));

	public By years = (By.id("years"));

	public By newsletter = (By.id("uniform-newsletter"));

	public By recieveoffers = (By.id("uniform-optin"));

	public By submit = (By.id("submitAccount"));
	
	public By alert_message = (By.xpath("//div[@class='alert alert-danger']"));
	public By success_message =(By.xpath("//p[@class='alert alert-success']"));

	@Step("click on submit buton")
	public void clickSubmit() {
		ac.click(submit);
		Loggers.logger.info("click on submit button");

	}
	@Step("click on MR checkbox")
	public void clickOnMRTitle() {
		ac.click(mr);
		Loggers.logger.info("click on Mr title");


	}
	@Step("click on MRS checkbox")
	public void clickOnMRSTitle() {
		ac.click(mrs);
		Loggers.logger.info("click on MRS title");


	}
	@Step("Acceot news letter")
	public void acceotNewsLetter() {
	ac.click(newsletter);
	Loggers.logger.info("click on accept news letter check box");


	}
	@Step("clcik on recieve offers checkbox")
	public void clickonRecieveOffers() {
	ac.click(recieveoffers);
	Loggers.logger.info("click on recieve offers check box");


	}
	@Step("type first name")
	public void typeFirstName(String fname) {		
		ac.typing(firstname, fname);
		Loggers.logger.info("type first name: "+fname);

	}
	@Step("type last name")
	public void typeLastName(String lname) {
		ac.typing(lastname, lname);
		Loggers.logger.info("type last name: "+lname);

	}
	@Step("type Email")
	public void typeEmail(String email) {
		ac.typing(this.email, email);
		Loggers.logger.info("type email: "+email);

	}
	@Step("type password")
	public void typePassword(String pass) {
		ac.typing(password, pass);
		Loggers.logger.info("type password: "+pass);

	}
	@Step("select day")
	public void selectDays(int num) {
	//use arguments from 1 to 31
		Select select=new Select(DriverFactory.getDriver().findElement(days));
		select.selectByIndex(num);
		Loggers.logger.info("select day from drop down list: ");

		
	}
	@Step("select months")
	public void selectMonths(int num) {
		Select select=new Select(DriverFactory.getDriver().findElement(months));
		//use arguments from 1 to 12
		select.selectByIndex(num);
		Loggers.logger.info("select month from drop down list: ");

		
	}
	
	@Step("select year")
	public void selectYear(int num) {
		Select select=new Select(DriverFactory.getDriver().findElement(years));
		//use arguments from 1 to 80
		select.selectByIndex(num);
		Loggers.logger.info("select year from drop down list: ");

	}
	
	@Step("verify the alert message")
	public boolean check_Existence_Of_Alert_Message() {
		return ac.isDisplayed(alert_message);
	}
	
	@Step("verify the success message")
	public boolean check_Existence_Of_Success_Message() {
		return ac.isDisplayed(success_message);
	}
	
	public void navigate(String email) {
		DriverFactory.getDriver().navigate().to(prop.getProperty("url"));
		Headers header=new Headers();
		header.clickLogIn();
		LogInPage login=new LogInPage();
		login.registeremailtype(email);
		login.clickcreateaccount();
		
	}
}
