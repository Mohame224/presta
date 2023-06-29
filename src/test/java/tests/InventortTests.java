package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupDriver;
import io.qameta.allure.Description;
import pageobjects.Inventory;

public class InventortTests extends SetupDriver{
	@Description("Verifying selecting size Medium from filters")
	@Test
public void chooseFilterMedium() {
	Inventory inv=new Inventory();
	inv.navigate_through_Women();
	inv.chooseSize(1);
	Assert.assertTrue(inv.checkTextInEnabledFilter("Size: M"));
}
	
	@Description("Verifying selecting size small from filters")
	@Test
public void chooseFilterSmall() {
	Inventory inv=new Inventory();
	inv.navigate_through_Women();
	inv.chooseSize(0);
	Assert.assertTrue(inv.checkTextInEnabledFilter("Size: S"));

}
	@Description("Verifying selecting size large from filters")
	@Test
public void chooseFilterLarge() {
	Inventory inv=new Inventory();
	inv.navigate_through_Women();
	inv.chooseSize(2);
	Assert.assertTrue(inv.checkTextInEnabledFilter("Size: L"));

}
	@Description("Verifying choosing first color from filters")
	@Test
public void chooseFilterFirstColor() {
	Inventory inv=new Inventory();
	inv.navigate_through_Women();
	inv.chooseColor(0);

}
	
	@Description("Verifying choosing the last color from filters")
	@Test
public void chooseFilterSecondColor() {
	Inventory inv=new Inventory();
	inv.navigate_through_Women();
	inv.chooseColor(7);

}
	@Description("Verifying changing price slider")
	@Test
	public void changePriceRange() {
		Inventory inv=new Inventory();
		inv.navigate_through_Women();
		inv.moveSlider(60, 99);
	}
}
