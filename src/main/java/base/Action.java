package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	Actions ac;
	WebDriver driver;

	// initializing driver by constructor
	public Action(WebDriver driver) {
		this.driver = driver;
		ac = new Actions(driver);
	}

	// explicit wait
	public void explicitWaitTillElementVisibility(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

//	// explicit wait
	public void explicitWaitTillElementVisibility(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(castWebElementToByLocator(ele)));

	}

	// check if element is displayed
	public boolean isDisplayed(By ele) {
		explicitWaitTillElementVisibility(ele, 15);
		if (driver.findElement(ele).isDisplayed()) {
			return true;

		} else {
			return false;
		}

	}

	// click on web element
	public void click(By ele) {
	driver.findElement(ele).click();
	}

	// click on web element
	public void click(WebElement ele) {
		ele.click();
	}

	// type into web element
	public void typing(By ele, String info) {
		explicitWaitTillElementVisibility(ele, 15);
		driver.findElement(ele).clear();
		driver.findElement(ele).sendKeys(info);
	}

	// get url
	public String getCurrentURL() {
		Loggers.logger.info("getting current url");
		return driver.getCurrentUrl();

	}

	public void backNavigate() {
		driver.navigate().back();
		Loggers.logger.info("navigate to last page");

	}

	// check if element is selected
	public boolean isSelected(By ele) {

		if (driver.findElement(ele).isSelected()) {
			return true;

		} else {
			return false;
		}

	}

	// check if element is displayed
	public boolean isEnabled(By ele) {
		// Loggers.logger.info("check existense of element");
		if (driver.findElement(ele).isEnabled()) {
			return true;

		} else {

			return false;
		}
	}

	public void scrollPageToElEment(By ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(ele));
	}

	public void moveToElement(By ele) {
		explicitWaitTillElementVisibility(ele, 15);
		ac.moveToElement(driver.findElement(ele)).perform();
	}

	public void moveToElement(WebElement ele) {
		By element = castWebElementToByLocator(ele);
		explicitWaitTillElementVisibility(element, 15);
		ac.moveToElement(ele).perform();

	}

	private By castWebElementToByLocator(WebElement ele) {
		String locator = ele.toString().split("-> ")[1];
		String locatorType = locator.split(": ")[0];
		String locatorValue = locator.split(": ")[1].substring(0, locator.split(": ")[1].length() - 1);

		// Construct a new By locator using the extracted information
		By byLocator = null;
		switch (locatorType) {
		case "id":
			byLocator = By.id(locatorValue);
			break;
		case "xpath":
			byLocator = By.xpath(locatorValue);
			break;
		case "css selector":
			byLocator = By.cssSelector(locatorValue);
			break;
		// Add cases for other locator types as needed
		}
		return byLocator;
	}

}
