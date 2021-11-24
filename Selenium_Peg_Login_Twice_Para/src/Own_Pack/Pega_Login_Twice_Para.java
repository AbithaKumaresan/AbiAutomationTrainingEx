package Own_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Pega_Login_Twice_Para
{
WebDriver driver;
String projectPath = System.getProperty("user.dir");
@BeforeClass
public void setup() 
{
System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
driver = new ChromeDriver();
}
/*public void setup() 
{
System.setProperty("webdriver.edge.driver", projectPath+"/Driver/msedgedrivernew.exe");
driver = new EdgeDriver();
}*/
@Test
public void launch_app() throws Exception 
{
	
driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
Thread.sleep(3000);
}
@Parameters ("Userna")
@Test (dependsOnMethods = "launch_app")
public void enter_user(String Userna) throws Exception 
{
WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
username.sendKeys(Userna);
Thread.sleep(3000);
}
@Parameters ("Passw")
@Test (dependsOnMethods = "enter_user")
public void enter_pswd(String Passw) throws Exception 
{
WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
password.sendKeys(Passw);
Thread.sleep(3000);
}
@Test (dependsOnMethods = "enter_pswd")
public void clicklogin() throws Exception 
{
WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
loginbutton.click();
Thread.sleep(3000);
}
@Test (dependsOnMethods = "clicklogin")
public void get_title() throws Exception 
{
String title = driver.getTitle();
if (title.equals("User Portal"))
{
	System.out.println("Valid details");
	System.out.println("Page title is : " + driver.getTitle());
	}
else
{
	WebElement Error = driver.findElement(By.xpath("//*[@id='error']"));
	Thread.sleep(8000);
	String Message = Error.getText();
	System.out.println("Error Message: " + Message);
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
