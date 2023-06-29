package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupDriver;
import io.qameta.allure.Description;
import pageobjects.ProductPage;

public class InProductTests extends SetupDriver {
	ProductPage inproduct;

	@Description("Verifying adding quantity plus button")
	@Test
	public void VerifyProductPagePlusButton() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.clickOnQuantityPlus();
	}

	@Description("Verifying substracting quantity minus button")
	@Test
	public void VerifyProductPageMinusButton() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.clickOnQuantityMinus();
	}

	@Description("Verifying selecting size Medium")
	@Test
	public void verifyProductPageSizeMedium() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.sizesSelection(1);
	}

	@Description("Verifying selecting size small")
	@Test
	public void verifyProductPageSizeSmall() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.sizesSelection(0);
	}

	@Description("Verifying selecting size large")
	@Test
	public void verifyProductPageSizeLarge() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.sizesSelection(2);
	}

	@Description("Verifying choosing color")
	@Test
	public void verifyChoosingColor() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		List<WebElement> colors = driver.findElements(inproduct.colors);
		if (colors.size() > 1) {
			inproduct.chooseColor(1);
			Assert.assertTrue(inproduct.checkDisplayPicsLink());
		} else {
			Assert.assertTrue(true);
		}
	}
	@Description("Verifying hovering over thumbnails pics")
	@Test
	public void verifyHoveringOverSmallPics() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.waitElement(inproduct.bigpicture);
		String big_pic_source = driver.findElement(inproduct.bigpicture).getAttribute("src");
		inproduct.waitElement(inproduct.smallpics);
		inproduct.sctolingToElement(inproduct.smallpics);
		List<WebElement> small_pics = driver.findElements(inproduct.smallpics);
		if (small_pics.size() > 1) {
			inproduct.hoverOverPics(1);
			inproduct.sctolingToElement(inproduct.bigpicture);
			String big_pic_source_after_hovering = driver.findElement(inproduct.bigpicture).getAttribute("src");
			Assert.assertNotEquals(big_pic_source, big_pic_source_after_hovering);
		} else {
			Assert.assertTrue(true);;
		}
	}
	@Description("Verifying changing quantity by typing")
	@Test
	public void verifyQuantityTyping() {
		inproduct = new ProductPage();
		inproduct.navigateToAnyProduct();
		inproduct.typeQuantity("5");
		inproduct.clickOnQuantityMinus();
	}
}
