package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Action;
import base.DriverFactory;
import base.FakeData;
import base.Loggers;
import base.SetupDriver;

public class ProductPage extends SetupDriver {

	Action ac;

	public ProductPage() {
		ac = new Action(DriverFactory.getDriver());
	}

	public By sizeselection = (By.id("group_1"));

	public By quantity_field = (By.id("quantity_wanted"));

	public By quantity_plus = (By.xpath("//i[@class='icon-plus']"));

//	public By quantity_plus_popupwindow = (By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']"));
//
//	public By quantity_minus_popupwindow = (By
//			.xpath("//a[@class='btn btn-default button-minus product_quantity_down]"));

	public By quantity_minus = (By.xpath("//i[@class='icon-minus']"));

	public By add_to_cart = (By.className("exclusive"));

	// multiple
	public By colors = (By.xpath("//ul[@id='color_to_pick_list']//child::li"));

	// 1-twitter 2- facebook 3- google plus 4-pinterest
	public By socialbtns = (By.xpath("//p[@class='socialsharing_product list-inline no-print']//child::button"));

	public By sendtofriend = (By.id("send_friend_button"));

	public By printlink = (By.className("print"));
public By dispaly_pics=(By.className("icon-repeat"));
	public By bigpicture = (By.xpath("//img[@id='bigpic']"));

	// multiple
	public By smallpics = (By.xpath("//div[@id='thumbs_list']//li"));

	// chose by index from 0 to 2
	public void sizesSelection(int num) {
		Select dropdown = new Select(DriverFactory.getDriver().findElement(sizeselection));
		dropdown.selectByIndex(num);
	}

	public void chooseColor(int num) {
		ac.explicitWaitTillElementVisibility(colors, 15);
		List<WebElement> li = DriverFactory.getDriver().findElements(colors);
		int listsize = li.size();
		if (num < listsize) {
			ac.click(li.get(num));
			Loggers.logger.info("choose color "+li.get(num).getAccessibleName());
		} else {
			ac.click(li.get(listsize - 1));
			Loggers.logger.info("choose color "+li.get(listsize - 1).getAccessibleName());

		}

		

	}

	public void hoverOverPics(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(smallpics);
		int listsize = li.size();
		if (num < listsize) {
			ac.moveToElement(li.get(num));
		} else {
			ac.moveToElement(li.get(listsize - 1));
		}
		Loggers.logger.info("hover over small pic  ");

	}

	public void clickSmallPics(int num) {
		ac.explicitWaitTillElementVisibility(smallpics, 15);
		List<WebElement> li = DriverFactory.getDriver().findElements(smallpics);
		int listsize = li.size();
		if (num < listsize) {
			ac.click(li.get(num));
		} else {
			ac.click(li.get(listsize - 1));
		}
		Loggers.logger.info("click on small pic ");

	}

	public void clickOnFaceBook() {
		List<WebElement> li = DriverFactory.getDriver().findElements(socialbtns);
		ac.click(li.get(1));
		Loggers.logger.info("click on facebook buton ");

	}

	public void clickOnQuantityPlus() {
//		ac.click(quantity_plus);
		ac.explicitWaitTillElementVisibility(quantity_plus, 15);
		ac.click(quantity_plus);
		Loggers.logger.info("click on add quatitty plus buton ");

	}

	public void clickOnQuantityMinus() {
		ac.explicitWaitTillElementVisibility(quantity_minus, 15);
		ac.click(quantity_minus);
		Loggers.logger.info("click on minus quatitty minus buton ");

	}

//	public void clickOnQuantityPlusPopUpWindow() {
//		ac.click(quantity_plus_popupwindow);
//	}
//
//	public void clickOnQuantityMinusPopUpWindow() {
//		ac.click(quantity_minus_popupwindow);
//	}

	public void typeQuantity(String num) {
		ac.typing(quantity_field, num);
	}

	public void clickOnTwitter() {
		List<WebElement> li = DriverFactory.getDriver().findElements(socialbtns);
		ac.click(li.get(2));
		Loggers.logger.info("click on twiter button ");

	}

	public void clickOnGooglePlus() {
		List<WebElement> li = DriverFactory.getDriver().findElements(socialbtns);
		ac.click(li.get(3));
		Loggers.logger.info("click on google plus button ");

	}

	public void clickOnPinterest() {
		List<WebElement> li = DriverFactory.getDriver().findElements(socialbtns);
		ac.click(li.get(4));
		Loggers.logger.info("click on pinterest button ");

	}

	public void clickOnPrint() {
		ac.click(printlink);
		Loggers.logger.info("click on product print ");

	}

	public void clickOnSendToFriend() {
		ac.click(sendtofriend);
		Loggers.logger.info("click on send to friend link ");

	}

	public void clickOnBigPic() {
		ac.click(bigpicture);
		Loggers.logger.info("click on picture ");

	}

	public void navigateToAnyProduct() {

		LogInPage log = new LogInPage();
		Inventory inv = new Inventory();
		FakeData fker = new FakeData();

		NavigationLinks nl = new NavigationLinks();
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
			reg.selectMonths(2);
			reg.selectYear(2);
//			reg.clickonRecieveOffers();
			reg.acceotNewsLetter();
			reg.clickSubmit();

		}

		nl.clickWomenLink();
		ac.scrollPageToElEment(inv.products);
		ac.moveToElement(inv.products);
		ac.click(inv.morebtn);
		Loggers.logger.info("clicking on first product");
	}

	
	public boolean checkDisplayPicsLink() {
	return 	ac.isDisplayed(dispaly_pics);
	}
	
	
	public void waitElement(By ele) {
		ac.explicitWaitTillElementVisibility(ele, 15);
	}
	
	public void sctolingToElement(By ele) {
		ac.scrollPageToElEment(ele);
	}
}
