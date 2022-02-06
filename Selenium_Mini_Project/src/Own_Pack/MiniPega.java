package Own_Pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MiniPega {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		@Parameters("browserName")
		@BeforeClass
		public void setup(String browserName) {
			if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/Driver/msedgedriver.exe");
			driver = new EdgeDriver();
			}
			else if (browserName.equalsIgnoreCase("firefox")) {
				//ProfilesIni settings = new ProfilesIni();
		        //FirefoxProfile profile = settings.getProfile("MyProfile");
		        //FirefoxOptions firefoxOptions = new FirefoxOptions();
		        //firefoxOptions.setProfile(profile);
	            System.setProperty("webdriver.gecko.driver", projectPath+"/Driver/geckodriver.exe");
	            driver = new FirefoxDriver();
			}
		}
		@Test
		public void launch_app() throws Exception 
		{
		driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		@Test (dependsOnMethods = "launch_app")
		public void clicklogin() throws Exception 
		{
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
		username.sendKeys("tcapron");
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("rules@123");
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
		loginbutton.click();
		}
		@Parameters({"firstname","lastname"})
		@Test (dependsOnMethods = "clicklogin")
		public void individuallead(String firstname, String lastname) throws Exception 
		{
		WebElement create = driver.findElement(By.xpath("//a[@class='menu-item-anchor menu-item-expand']/span/span"));
		create.click();
		WebElement individuallead = driver.findElement(By.xpath("//ul[@class='menu menu-format-create-case-menu ']/li[7]/a/span/span"));
		individuallead.click();
		WebElement firstname1 = driver.findElement(By.xpath("//input[@title='Lead first name']"));
		firstname1.sendKeys(firstname);
		WebElement lastname1 = driver.findElement(By.xpath("//input[@title='Lead last name']"));
		lastname1.sendKeys(lastname);
		WebElement btnsubmit = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
		btnsubmit.click();
		}
		@Parameters("phone")
		@Test (dependsOnMethods = "individuallead")
		public void updatelead(String phone) throws Exception 
		{
		WebElement title = driver.findElement(By.xpath("//div[@class=' flex content layout-content-simple_list  content-simple_list  flex-grow-1 height-100-pct']/div[3]/div/div/div[2]/h1"));
		String leadname = title.getText();
		System.out.println("Lead name: "+leadname);
		WebElement btnedit = driver.findElement(By.xpath("(//button[@name='EditAction_pyWorkPage_3'])[2]"));
		btnedit.click();
		WebElement phone1 = driver.findElement(By.xpath("//input[@title='Lead phone number']"));
		phone1.sendKeys(phone);
		WebElement btnupdate = driver.findElement(By.name("pyCaseActionAreaButtons_pyWorkPage_15"));
		btnupdate.click();
		}
		@Parameters({"opponame","date", "amount"})
		@Test (dependsOnMethods = "updatelead")
		public void convertlead(String opponame, String date, String amount) throws Exception 
		{
		WebElement lnkaction = driver.findElement(By.xpath("(//button[@name='CaseActionHeader_pyWorkPage_5'])[2]"));
		lnkaction.click();
		WebElement lnkconvert = driver.findElement(By.xpath("//ul[@class='menu menu-format-standard menu-regular']/li[4]/a/span/span"));
		lnkconvert.click();
		WebElement opponame1 = driver.findElement(By.xpath("(//div[@class='field-item dataValueWrite'])[8]/span/input"));
		opponame1.sendKeys(opponame);
		WebElement amount1 = driver.findElement(By.xpath("(//div[@class='field-item dataValueWrite'])[9]/span/input"));
		amount1.sendKeys(amount);
		WebElement date1 = driver.findElement(By.xpath("(//div[@class='field-item dataValueWrite'])[10]/span/input"));
		date1.sendKeys(date);
		date1.sendKeys(Keys.TAB);
		WebElement btnconvertlead = driver.findElement(By.name("pyCaseActionAreaButtons_pyWorkPage_15"));
		btnconvertlead.click();
		System.out.println("Successfully Converted to Lead");
		}
		@AfterTest
		public void finish() 
		{
		driver.quit();
		}
}
