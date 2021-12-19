package Own_Pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment2 {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void URL() 
	{
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}
	@Test
	public void Add_Products() throws InterruptedException {	
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button")).click();
		String button = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button")).click();
		String button1 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button1);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button")).click();
		String button2 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button2);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button")).click();
		String button3 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button3);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button")).click();
		String button4 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button4);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[6]/div[3]/button")).click();
		String button5 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[6]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button5);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[7]/div[3]/button")).click();
		String button6 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[7]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button6);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[8]/div[3]/button")).click();
		String button7 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[8]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button7);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[9]/div[3]/button")).click();
		String button8 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[9]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button8);
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[10]/div[3]/button")).click();
		String button9 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[10]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button9);
		Thread.sleep(4000);
	}
	@Test(dependsOnMethods = "Add_Products")
	public void Validatebuttonname()
	{
		String button = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button);
		String button1 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button1);
		String button2 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button2);
		String button3 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button3);
		String button4 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button4);
		String button5 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[6]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button5);
		String button6 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[7]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button6);
		String button7 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[8]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button7);
		String button8 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[9]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button8);
		String button9 = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[10]/div[3]/button")).getText();
		System.out.println("Button Name is displayed: " +button9);
	}
	@AfterClass
	public void finish() 
	{
	driver.quit();
	System.out.println("Validated button name change Successfully");
	} 
}
