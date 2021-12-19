package Own_Pack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private Object cloumn;
	
	@BeforeClass
	public void URL() 
	{
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}
	@Test
	public void Top_Deals()
	{
	driver.findElement(By.linkText("Top Deals")).click();	
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
	String title = driver.getTitle();
	System.out.println("Title Name is: "+title);
	}
	@Test(dependsOnMethods = "Top_Deals")
	public void Top_Deals_Page()
	{
	WebElement search = driver.findElement(By.id("search-field"));
	search.sendKeys("Potato");
	}
	@Test(dependsOnMethods = "Top_Deals_Page")
	public void potato()
	{
	List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-bordered']//tr"));
	String columfirst = "//table[@class='table table-bordered']//tr[";
	String columlast = "]//td";
	String column;
	List<WebElement> tablecolumns;
	for (int i=1;i<tableRows.size();i++)
	{
		column = columfirst+i+columlast;
		tablecolumns=driver.findElements(By.xpath(column));
		
		for (int j=0;j<tablecolumns.size();j++)
		{
			System.out.print(tablecolumns.get(j).getText()+"   ");
		}
		System.out.println();
	}
	}
	@AfterClass
	public void finish() 
	{
	driver.quit();
	System.out.println("Potato search is done Successfull");
	} 
	   
}
