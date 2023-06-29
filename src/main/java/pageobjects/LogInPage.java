package pageobjects;

import org.openqa.selenium.By;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

//import io.qameta.allure.Step;
public class LogInPage extends SetupDriver {
	Action ac;
	
	public LogInPage( ){
	 ac=new Action(DriverFactory.getDriver());
	}	

	// login email
	public By loginemail = (By.id("email"));

	public By loginpassword = (By.id("passwd"));

	public By registeremail = (By.id("email_create"));

	public By loginbtn = (By.id("SubmitLogin"));

	public By createaccountbtn = (By.id("SubmitCreate"));

	public By forgetpassword = (By.xpath("//a[text()='Forgot your password?']"));
	
	public By alert_message = (By.xpath("//div[@class='alert alert-danger']"));
	public By success_message =(By.xpath("//p[@class='alert alert-success']"));

	@Step("type Email in login form")
	public void loginemailtype(String email) {
		
		ac.typing(loginemail, email);
		Loggers.logger.info("typing email in the login form:"+email);
	}

	@Step("type email in registraion form")
	public void registeremailtype(String email) {
		ac.typing(registeremail, email);
		Loggers.logger.info("typing email in the registration form: "+email);

	}
	
	@Step("Type password in login form ")
	public void loginpasswordtype(String pass) {
		ac.typing(loginpassword, pass);
		Loggers.logger.info("typing password in the login form: "+pass);


	}

	@Step("click login button")
	public void loginclick() {
		Loggers.logger.info("click the login buton");

		ac.click(loginbtn);

	}
	@Step("click create  account")
	public void clickcreateaccount() {
		Loggers.logger.info("click on create account link");

		ac.click(createaccountbtn);

	}
	@Step("click forget password")
	public void clickforgetpassword() {
		Loggers.logger.info("click on forget password link");
		ac.click(forgetpassword);

	}
	
	@Step("verify the alert message")
	public boolean check_Existence_Of_Alert_Message() {
		return ac.isDisplayed(alert_message);
	}
	
	@Step("verify the success message")
	public boolean check_Existence_Of_Success_Message() {
		return ac.isDisplayed(success_message);
	}

	public void navigate() {
		DriverFactory.getDriver().navigate().to(prop.getProperty("url"));
		Headers headers = new Headers();
		headers.clickLogIn();

	}


}
