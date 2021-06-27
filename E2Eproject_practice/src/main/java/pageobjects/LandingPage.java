package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signIn =	By.cssSelector("a[href*='sign_in']");
	By emailId = By.id("user_email");
	By password = By.id("user_password");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");



	public LandingPage(WebDriver driver) {
		this.driver =  driver;
	}


	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		LoginPage lop = new LoginPage(driver);
		return lop;
	}

	public WebElement emailId() {
		return driver.findElement(emailId);
	}
	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement title() {
		return driver.findElement(title);
	}
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}


}
