package pageobjects;

import org.openqa.selenium.By;

import base.Loggers;
import base.SetupDriver;
import io.qameta.allure.Step;

public class HomePage extends SetupDriver {
	//best seller link
public By best_sellers=(By.className("blockbestsellers"));
//popular link
public By popular=(By.className("homefeatured"));
//ad next arrow
public By next_ad=(By.className("bx-next"));
//ad previous arrow
public By pre_ad=(By.className("bx-prev"));
//shop btn
public By shop_btn=(By.className("class=\"btn btn-default\""));
//ad_imgs  7 imgs 
public By imgs=(By.className("item-img "));

@Step("navigate to homepage ")
public void navigate() {
	driver.navigate().to(prop.getProperty("url"));
	Loggers.logger.info("navigate to home page");

	
}
}
