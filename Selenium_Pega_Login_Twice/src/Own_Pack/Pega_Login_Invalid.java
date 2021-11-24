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


public class Pega_Login_Invalid
{
WebDriver driver;
String projectPath = System.getProperty("user.dir");
@BeforeClass
public void setup() 
{
System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");

}
/*public void setup() 
{
System.setProperty("webdriver.edge.driver", projectPath+"/Driver/msedgedrivernew.exe");
driver = new EdgeDriver();
}*/
@Test
public void launch_app() throws Exception 
{
	driver = new ChromeDriver();
driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
Thread.sleep(3000);
}
@Test (dependsOnMethods = "launch_app")
public void enter_user() throws Exception 
{
WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
username.sendKeys("tcapron");
Thread.sleep(3000);
}
@Test (dependsOnMethods = "enter_user")
public void enter_pswd() throws Exception 
{
WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
password.sendKeys("Password@12");
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
public void Error_mess() throws Exception 
{
WebElement Error = driver.findElement(By.xpath("//*[@id='error']"));
Thread.sleep(5000);
String Message = Error.getText();
System.out.println("Error Message: " + Message);
}
@AfterClass
public void finish() 
{
driver.quit();
System.out.println("Invalid Credential Test is successful");
} 
}
