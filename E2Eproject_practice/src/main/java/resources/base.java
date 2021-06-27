package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializedriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/bhagyashreejethva/Bhagyashree/Bhagyashree Workspace/E2Eproject_practice/src/main/java/resources/data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"/Users/bhagyashreejethva/Bhagyashree/Bhagyashree Desktop/Bhagyashree_Selenium/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String DestFile=System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(SrcFile,new File(DestFile));
		System.out.println(DestFile);
		return DestFile;
		
	}

}
