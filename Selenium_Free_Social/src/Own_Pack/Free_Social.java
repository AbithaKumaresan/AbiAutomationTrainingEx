package Own_Pack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Free_Social
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
driver.get("https://freecrm.com/");
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,350)", "");
}
@Test (dependsOnMethods = "launch_app")
public void twitter() throws InterruptedException
{
WebElement Twit = driver.findElement(By.xpath("//a[@href='https://twitter.com/cogmento']"));
Twit.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(3000);
System.out.println("Page title of Tab1: " +driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}

@Test (dependsOnMethods = "twitter")
public void facebook() throws InterruptedException
{
WebElement Face = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/cogmento']"));
Face.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab2: " +driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@Test (dependsOnMethods = "facebook")
public void github() throws InterruptedException
{
WebElement Git = driver.findElement(By.xpath("//a[@href='https://github.com/cogmento']"));
Git.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab3: " +driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@Test (dependsOnMethods = "github")
public void telegram() throws InterruptedException
{
WebElement Tele = driver.findElement(By.xpath("//a[@href='https://t.me/cogmento']"));
Tele.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab4: " +driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@Test (dependsOnMethods = "telegram")
public void medium() throws InterruptedException
{
WebElement Med = driver.findElement(By.xpath("//a[@href='https://medium.com/@cogmento']"));
Med.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab5: " +driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@Test (dependsOnMethods = "medium")
public void linkedin() throws InterruptedException
{
WebElement Linked = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/cogmento']"));
Linked.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab6: " + driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@Test (dependsOnMethods = "linkedin")
public void youtube() throws InterruptedException
{
WebElement YouT = driver.findElement(By.xpath("//a[@href='https://youtu.be/ow44nHQPMJw']"));
YouT.click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(newTb.get(1));
Thread.sleep(2000);
System.out.println("Page title of Tab7: " + driver.getTitle());
driver.close();
driver.switchTo().window(newTb.get(0));
}
@AfterClass
public void finish() 
{
driver.quit();
System.out.println("Test is successful");
}
}
