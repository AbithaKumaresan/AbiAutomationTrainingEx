package Own_Pack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Pega_Login_Implicit
{
WebDriver driver;
String projectPath = System.getProperty("user.dir");
@BeforeClass
public void setup() 
{
System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
driver = new ChromeDriver();
}
@Test
public void launch_app() throws Exception 
{

driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
@Test (dependsOnMethods = "launch_app")
public void enter_user() throws Exception 
{
WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
username.sendKeys("tcapron");
}
@Test (dependsOnMethods = "enter_user")
public void enter_pswd() throws Exception 
{
WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
password.sendKeys("Password@123");
}
@Test (dependsOnMethods = "enter_pswd")
public void clicklogin() throws Exception 
{
WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
loginbutton.click();
}
@Test (dependsOnMethods = "clicklogin")
public void get_title() throws Exception 
{
//System.out.println("Page title is : " + driver.getTitle());
String title = driver.getTitle();
if (title.equals("User Portal"))
{
	System.out.println("Valid details");
	}
else
{
	System.out.println("Invalid details");
}
}
@AfterClass
public void finish() 
{
driver.quit();
System.out.println("Test is successful");
} 
}
