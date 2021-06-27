package Academy_practice.E2Eproject_practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import pageobjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initializeDriver() throws IOException {
		driver = initializedriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test
	public void basepagenavigation() throws IOException {

		LandingPage lp= new LandingPage(driver);

		Assert.assertEquals(lp.title().getText(), "FEATURED 123COURSES");
		log.info("successfully validated title");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
