package pageobjects;

import org.openqa.selenium.By;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class ForgetLoginPage extends SetupDriver{
	Action ac;
	public ForgetLoginPage() {
		ac=new Action(DriverFactory.getDriver());
	}
public By email=(By.id("email"));

public By retrieve=(By.className("btn btn-default button button-medium"));

@Step("click on retrieve password ")
public void clickRetrive() {
  ac.click(retrieve);
	Loggers.logger.info("click retrieve ");

}

@Step("type Email ")
public void typeEmail(String email) {
	 ac.typing(this.email, email);
		Loggers.logger.info("type Email: "+email);
}


public void navigate() {
	HomePage homep=new HomePage();
	homep.navigate();
	Headers headers=new Headers();
	headers.clickLogIn();
	LogInPage login=new LogInPage();
	login.clickforgetpassword();
}
}
