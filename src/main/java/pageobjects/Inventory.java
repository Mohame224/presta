package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Action;
import base.DriverFactory;
import base.FakeData;
import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class Inventory extends SetupDriver {
	Action ac;

	public Inventory() {
		ac = new Action(DriverFactory.getDriver());
	}

	public By enabled_filters = (By.id("enabled_filters"));
	public By enabled_filters_contents = (By.xpath("//div[@id='enabled_filters']//child::li"));
	// multiple
	public By products = (By.xpath("//ul[@class='product_list grid row']//child::div[@class='left-block']"));
	// multiple
	public By eyebtn = (By.xpath("//ul[@class='product_list grid row']//i[@class='icon-eye-open']"));
	// multiple
	public By viewmore = (By.xpath("//span[text()='Quick view']"));

	// multiple
	public By morebtn = (By.xpath("//span[text()='More']"));
	// multiple
	public By subcategories = (By.xpath("//ul[@class='clearfix']//child::li"));
	// multiple
	public By comparebtn = (By.className("add_to_compare"));

	public By categoriesblockleft = (By.id("categories_block_left"));
	// if categoriesblockleft exists the this variable should exist too
	public By leftblockcategoriessublinks = (By.xpath("//div[@id='categories_block_left']//child::li"));
	// if categoriesblockleft exists the this variable should exist too
	public By left_block_categories_Plus_btns = (By
			.xpath("//div[@id='categories_block_left']//child::span[@class='grower CLOSE']"));
//multiple filters
//	public By left_side_filters=(By.className("layered_filter"));

	public By left_side_filters_categories = (By.xpath("//ul[@id='ul_layered_category_0']//child::input"));

	public By left_side_filter_size = (By.xpath("//ul[@id='ul_layered_id_attribute_group_1']//child::input"));

	public By left_side_filters_color = (By.xpath("//ul[@id='ul_layered_id_attribute_group_3']//child::input"));

	public By left_side_filters_properties = (By.xpath("//ul[@id='ul_layered_id_feature_7']//child::input"));

	public By left_side_filters_composition = (By.xpath("//ul[@id='ul_layered_id_feature_5']//child::input"));

	public By left_side_filters_style = (By.xpath("//ul[@id='ul_layered_id_feature_6']//child::input"));

	public By left_side_filters_availability = (By.xpath("//ul[@id='ul_layered_quantity_0']//child::input"));

	public By left_side_filters_condition = (By.xpath("//ul[@id='ul_layered_condition_0']//child::input"));

	public By left_side_filters_low_price_slider = (By
			.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));

	public By left_side_filters_high_price_slider = (By
			.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]"));

	@Step("choose category  ")
	public void chooseCategory(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_categories);
		ac.scrollPageToElEment(left_side_filters_categories);
		Loggers.logger.info("scrolling to element");

//		ac.click(li.get(num));
		li.get(num).click();
		Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
	}

	@Step("choose availability filter ")
	public void chooseAvailability(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_availability);
		ac.scrollPageToElEment(left_side_filters_availability);
		Loggers.logger.info("scrolling to element"+li.get(num).getAccessibleName());
//		ac.click(li.get(num));
		li.get(num).click();
		Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
	}

	@Step("choose condition filter ")

	public void chooseCondition(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_condition);
		ac.scrollPageToElEment(left_side_filters_condition);
		Loggers.logger.info("scrolling to element"+li.get(num).getAccessibleName());

//		ac.click(li.get(num));
		li.get(num).click();
		Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
	}

	@Step("choose style filter ")

	public void chooseStyle(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_style);
		ac.scrollPageToElEment(left_side_filters_style);
		
		Loggers.logger.info("scrolling to element"+li.get(num).getAccessibleName());

//		ac.click(li.get(num));
		li.get(num).click();
		Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
	}

	@Step("choose color filter ")
	public void chooseColor(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_color);
		int nnn=li.size();
		if(num<nnn) {
			ac.scrollPageToElEment(left_side_filters_color);
			Loggers.logger.info("scrolling to element"+li.get(num).getAccessibleName());
			ac.click(li.get(num));
			Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
		}
		else {
			ac.scrollPageToElEment(left_side_filters_color);
			Loggers.logger.info("scrolling to element"+li.get(nnn-1).getAccessibleName());
			ac.click(li.get(nnn-1));
			Loggers.logger.info("click on element " + li.get(nnn-1).getAccessibleName());
		}

	}

	@Step("choose size filter ")
	public void chooseSize(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filter_size);
			ac.scrollPageToElEment(left_side_filter_size);
			Loggers.logger.info("scrolling to "+li.get(num).getAccessibleName());
			ac.click(li.get(num));
			Loggers.logger.info("clicking to "+li.get(num).getAccessibleName());


		}


	@Step("check enabled filters text")
	public boolean checkTextInEnabledFilter(String text) {
		ac.explicitWaitTillElementVisibility(enabled_filters_contents, 15);
		List<WebElement> li = DriverFactory.getDriver().findElements(enabled_filters_contents);

		for (WebElement element : li) {
			if (element.getText().contains(text)) {
				Loggers.logger.info("enabled filters contains: "+text);

				return true;
			}
		}
		return false;
	}

	@Step("choose composition filter ")
	public void chooseComposition(int num) {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_composition);
		ac.scrollPageToElEment(left_side_filters_composition);
		Loggers.logger.info("scrolling to element"+li.get(num).getAccessibleName());

//		ac.click(li.get(num));
		li.get(num).click();
		Loggers.logger.info("click on element " + li.get(num).getAccessibleName());
	}

	@Step("Move price slider ")
	public void moveSlider(int low, int high) {
		if (low < high) {
			int lower_slider_width = DriverFactory.getDriver().findElement(left_side_filters_low_price_slider).getSize().getWidth();
			moveSlider(DriverFactory.getDriver().findElement(left_side_filters_low_price_slider), 0, low, lower_slider_width);
			Loggers.logger.info("Move lower slider to " + low);

			int higher_slider_width = DriverFactory.getDriver().findElement(left_side_filters_high_price_slider).getSize().getWidth();
			moveSlider(DriverFactory.getDriver().findElement(left_side_filters_high_price_slider), 0, high, higher_slider_width);
			Loggers.logger.info("Move higher slider to " + high);

		} else {
			Assert.assertTrue(false);
		}
	}

	private static void moveSlider(WebElement slider, int xOffsetStart, int xOffsetEnd, int sliderWidth) {
		Actions action = new Actions(DriverFactory.getDriver());
		int xOffset = (int) (sliderWidth * ((double) xOffsetEnd - (double) xOffsetStart) / 100);
		action.dragAndDropBy(slider, xOffsetStart * sliderWidth / 100, 0).dragAndDropBy(slider, xOffset, 0).perform();
	}

	@Step("check existence of all products ")
	public void checkAllProducts() {
		List<WebElement> li = DriverFactory.getDriver().findElements(left_side_filters_color);
		int listsize = li.size();
		for (int i = 0; i < listsize; i++) {
			ac.click(li.get(i));
			ac.backNavigate();
		}
	}

	public void logging() {
		LogInPage log = new LogInPage();
		FakeData fker = new FakeData();
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
			reg.typePassword(fker.password);
			reg.selectDays(5);
			reg.selectMonths(5);
			reg.selectYear(5);
			reg.clickSubmit();
	
		}
	}

	public void navigate_through_dresses_link() {
		NavigationLinks nl = new NavigationLinks();
		logging();
		nl.clickDresses();
	}

	public void navigate_through_Tshirts_link() {
		NavigationLinks nl = new NavigationLinks();
		logging();
		nl.clickTshirts();
	}

	public void navigate_through_Women() {
		NavigationLinks nl = new NavigationLinks();
		logging();
		nl.clickWomenLink();
	}

	public void navigate_through_searchbar() {

		Headers headse = new Headers();
		logging();
		headse.typeOnSearchField("dress");
		headse.clickSarch();
	}
}
