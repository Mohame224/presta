package pageobjects;

import org.openqa.selenium.By;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class Headers extends SetupDriver{
	
	Action ac;
	public Headers() {
		ac=new Action(DriverFactory.getDriver());
	}


public By login=(By.className("login"));
public By logout=(By.className("logout"));
public By contactus=(By.id("contact-link"));
public By shoopingcart=(By.xpath("(//div[@class='shopping_cart']//child::a)[1]"));
public By searchfield=(By.id("search_query_top"));
public By searchbtn=(By.id("btn btn-default button-search"));

@Step("click on login link")
public void clickLogIn() {
	ac.click(login);
	Loggers.logger.info("click login");

}
@Step("click logout ")
public void clickLogout() {
	ac.click(logout);
	Loggers.logger.info("click logout");

}

@Step("click search button ")
public void clickSarch() {
	ac.click(searchbtn);
	Loggers.logger.info("click search button");

}
@Step("click on shopping cart ")
public void clickShoppingCart() {
	ac.click(shoopingcart);
	Loggers.logger.info("click on shopping cart");
}

@Step("click contact us ")
public void clickContactUs() {
	ac.click(contactus);
	Loggers.logger.info("click contact us");

}


@Step("type in the search field ")
public void typeOnSearchField(String sear) {
	ac.typing(searchfield, sear);
	Loggers.logger.info("type text in search field: "+sear);

}
}
