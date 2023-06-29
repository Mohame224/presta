package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	// define driver
	public static WebDriver driver;
	// define properties var
	public static Properties prop;
	// define the file reader var
	public static FileReader fr;

	// method to start web driver
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeMethod
	public void setuppingDriver(String browser) throws IOException {

		// create the properties instance
		prop = new Properties();
		// create the file reader instance
		fr = new FileReader(
				System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
						+ "resources" + File.separator + "configurations" + File.separator + "config.properties");
		prop.load(fr);
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			Loggers.logger.info("Allow remote origins in chrome");
			options.addArguments("--start-maximized ");
			Loggers.logger.info("Maximize window aptions");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			DriverFactory.setDriver(driver);
			Loggers.logger.info("start chrome browser");
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			DriverFactory.setDriver(driver);
			Loggers.logger.info("start fire fox browser");
		} else if (browser.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			Loggers.logger.info("Allow remote origins in edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			DriverFactory.setDriver(driver);
			Loggers.logger.info("start edge browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closing() {
		DriverFactory.getDriver().quit();
		DriverFactory.unload();
		Loggers.logger.info("stop browser");
	}
}
