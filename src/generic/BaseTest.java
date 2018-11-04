package generic;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class open Firefox browser
 * Open application URl
 * Set Implict wait
 * Close the application after every class
 * @author user
 *
 */

public class BaseTest implements IAutoConstant {

	public WebDriver driver;

	static {
		System.setProperty(GEkCO_KEY, GEkCO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);

	}

	@BeforeClass
	public void openApplication() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		
		

		String ito = Lib.getPropertyValue("ITO");
		int timePeriod = Integer.parseInt(ito);

		driver.manage().timeouts().implicitlyWait(timePeriod, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}

}
