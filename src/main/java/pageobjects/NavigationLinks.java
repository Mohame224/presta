package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Action;
import base.DriverFactory;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class NavigationLinks extends SetupDriver {
	Action ac;

	public NavigationLinks() {
		ac = new Action(DriverFactory.getDriver());
	}

	int num;
	public By womenlink = (By.className("sf-with-ul"));

	// 1 2 3 4 5 6 7 8
	public By womensublinks = (By.xpath("(//ul[@class='submenu-container clearfix first-in-line-xs'])[1]//child::li"));
	public By dresseslink = (By.className("sf-with-ul1"));
	// 1 2 3 4
	public By dressessublinks = (By
			.xpath("(//ul[@class='submenu-container clearfix first-in-line-xs'])[2]//child::li"));

	public By tshirtslink = (By.xpath("(//a[@title='T-shirts'])[2]"));
	public By bloglink = (By.xpath("//a[@title='Blog']"));

	@Step("click women")
	public void clickWomenLink() {
		ac.click(womenlink);
		Loggers.logger.info("click on womens link");

	}

	@Step("click Tshirts")
	public void clickTshirts() {
		ac.click(tshirtslink);
		Loggers.logger.info("click on T-shirts link");

	}

	@Step("click blog link")
	public void clickBlog() {
		ac.click(bloglink);
		Loggers.logger.info("click on blog link");

	}

	@Step("click dresses")
	public void clickDresses() {
		ac.click(dresseslink);
		Loggers.logger.info("click on dresses link");

	}

	@Step("click women sublink")
	public void clickWomenSubLink(int num) {
		ac.moveToElement(womenlink);
		ac.explicitWaitTillElementVisibility(womensublinks, 15);
		List<WebElement> li = DriverFactory.getDriver().findElements(womensublinks);
		int listsize = li.size();
		if (num < listsize) {
			ac.click(li.get(num));
			Loggers.logger.info("click on "+li.get(num).getAccessibleName());

		} else {
			ac.click(li.get(listsize - 1));
			Loggers.logger.info("click on "+li.get(listsize - 1).getAccessibleName());

		}
	}

	@Step("click dresses sublink")
	public void clickDressesSubLink(int num) {

		ac.moveToElement(dresseslink);
		ac.explicitWaitTillElementVisibility(dressessublinks, 15);
		List<WebElement> li = DriverFactory.getDriver().findElements(dressessublinks);
		int listsize = li.size();
		if (num < listsize) {
			ac.click(li.get(num));
			Loggers.logger.info("click on "+li.get(num).getAccessibleName());
		} else {
			ac.click(li.get(listsize - 1));	
			Loggers.logger.info("click on "+li.get(listsize - 1).getAccessibleName());
}

	}
}
