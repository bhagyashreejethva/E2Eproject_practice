package Academy_practice.E2Eproject_practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;


import pageobjects.LandingPage;
import resources.base;

public class ValidateNavBar extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest

	public void initializeDriver() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basepagenavigation() throws IOException {

		LandingPage lp= new LandingPage(driver);

		AssertJUnit.assertTrue(lp.getNavbar().isDisplayed());
		log.info("successfully displayed navbar");

	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
