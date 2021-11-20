package Projec1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Day1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", projectPath+"/Driver/msedgedrivernew.exe");
		driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			ProfilesIni settings = new ProfilesIni();
	        FirefoxProfile profile = settings.getProfile("MyProfile");
	        FirefoxOptions firefoxOptions = new FirefoxOptions();
	        firefoxOptions.setProfile(profile);
            System.setProperty("webdriver.gecko.driver", projectPath+"/Driver/geckodriver.exe");
            driver = new FirefoxDriver(firefoxOptions);
		}
	}
	@Test
	public void testgoo() throws Exception {
	driver.get("https://google.com");
	Thread.sleep(10000);
	}
	@Test
	public void testyah() throws Exception {
	driver.get("https://yahoo.com");
	Thread.sleep(10000);
	}
	@AfterTest
	public void finish() {
	driver.quit();
	System.out.println("Test is successful");
	}
}
