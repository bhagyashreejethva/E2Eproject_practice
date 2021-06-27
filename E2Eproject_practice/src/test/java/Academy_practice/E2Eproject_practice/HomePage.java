package Academy_practice.E2Eproject_practice;

import org.testng.annotations.Test;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initializeDriver() throws IOException {
		driver = initializedriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test(dataProvider = "getData")

	public void basepagenavigation(String uname, String pass) throws IOException {

		driver.get(prop.getProperty("url"));

		LandingPage lp= new LandingPage(driver);
		LoginPage lop =lp.getLogin();
		lop.getEmail().sendKeys(uname);
		lop.getPassword().sendKeys(pass);
		lop.getLogin().click();
	}

	@DataProvider

	public Object[][] getData() {
		Object [][] data = new Object[1][2];

		data[0][0] = "abc@gmail.com";
		data[0][1] = "abc@123";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
