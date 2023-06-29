package pageobjects;

import org.openqa.selenium.By;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class FooterLinks extends SetupDriver {
	Action ac;

	public FooterLinks() {
		ac = new Action(		DriverFactory.getDriver());
	}

	public By homelink = (By.className(""));

	public By womencategorylink = (By.className(""));

	public By termslink = (By.className(""));

	public By ourstoreslink = (By.className(""));

	public By aboutuslink = (By.className(""));

	public By myorderslink = (By.className(""));

	public By mycreditslipslink = (By.className(""));

	public By myaddresseslink = (By.className(""));

	public By mypersonalinfolink = (By.className(""));

	public By facebooklink = (By.className(""));

	public By instagramlink = (By.className(""));

	public By feedslink = (By.className(""));

	public By newsleterlink = (By.className(""));

	public By emaillink = (By.className(""));

	public By websitelink = (By.className(""));

	@Step("click on home page link")
	public void clickHomeLink() {

		ac.click(homelink);
	}

	@Step("click on about us  link")
	public void clickAboutUsLink() {
		ac.click(aboutuslink);
		Loggers.logger.info("click about us link");

	}

	@Step("click on women link")
	public void clickWomenLink() {
		ac.click(womencategorylink);
		Loggers.logger.info("click on women link");

	}

	@Step("click on orders link")

	public void clickOrdersLink() {
		ac.click(myorderslink);
		Loggers.logger.info("click my orders link");

	}

	@Step("click on credit lips link")
	public void clickCreditLipsLink() {
		ac.click(mycreditslipslink);
		Loggers.logger.info("click my credit lips");

	}

	@Step("click on terms and conditions link")
	public void clickTermsLink() {
		ac.click(termslink);
		Loggers.logger.info("click terms and conditions");

	}

	@Step("click on addresses link")
	public void clickAddressesLink() {
		ac.click(myaddresseslink);
		Loggers.logger.info("click my addresses ");

	}

	@Step("click on our stores link")
	public void clickOurStoresLink() {
		ac.click(ourstoreslink);
		Loggers.logger.info("click our stores");

	}

	@Step("click on email ")
	public void clickEmailLink() {
		ac.click(emaillink);
		Loggers.logger.info("click the company email");

	}

	@Step("click on the actual website link")
	public void clickWebSiteLink() {
		ac.click(websitelink);
		Loggers.logger.info("click website link");

	}

	@Step("click on news letter link")
	public void clickNewsLetterLink() {
		ac.click(newsleterlink);
		Loggers.logger.info("click News letter");

	}

	@Step("click on personal info link")
	public void clickPersoalInfoLink() {
		ac.click(mypersonalinfolink);
		Loggers.logger.info("click personal info link");

	}

	@Step("click on facebook link")
	public void clickFacebookLink() {
		ac.click(facebooklink);
		Loggers.logger.info("click facebook  link");

	}

	@Step("click on instagram link")
	public void clickInstagramLink() {
		ac.click(instagramlink);
		Loggers.logger.info("click instagram link");

	}

	@Step("click on feed link")
	public void clickFeedsLink() {
		ac.click(feedslink);
		Loggers.logger.info("click feeds link");

	}

}
