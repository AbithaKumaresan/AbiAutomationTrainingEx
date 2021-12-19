package Own_Pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment1 {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void URL() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Test
	public void Add_Products() {	
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
	}
	@Test (dependsOnMethods = "Add_Products")
	public void Product_Name()
	{
		String Firstproduct = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[1]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+Firstproduct);
		String SecondProduct = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[2]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+SecondProduct);
		String ThirdProduct = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[3]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ThirdProduct);
		String FourthProduct = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[4]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+FourthProduct);
		String FifthProduct = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[5]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+FifthProduct);
	}
	@Test (dependsOnMethods = "Product_Name")
	public void Product_Price()
	{
		String Firstproductprice = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[1]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+Firstproductprice);
		String SecondProductprice = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[2]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+SecondProductprice);
		String ThirdProductprice = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[3]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+ThirdProductprice);
		String FourthProductprice = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[4]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+FourthProductprice);
		String FifthProductprice = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[5]/div[2]/p[2]")).getText();
		System.out.println("Product Name "+FifthProductprice);
		int Firsttprice =Integer.parseInt(Firstproductprice);
		int Secondprice =Integer.parseInt(SecondProductprice);
		int Thirdprice =Integer.parseInt(ThirdProductprice);
		int Fourthprice =Integer.parseInt(FourthProductprice);
		int Fifthprice =Integer.parseInt(FifthProductprice);
		int TotalProductPrice = (Firsttprice+Secondprice+Thirdprice+Fourthprice+Fifthprice);
		System.out.println("Total Product Price "+TotalProductPrice);	
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[2]/button")).click();
		String TotalAmount = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/span[1]")).getText();
		System.out.println("Total Product Price is displayed in Cart Page "+TotalAmount);
		int TotalAmou =Integer.parseInt(TotalAmount);
		Assert.assertEquals(TotalProductPrice, TotalAmou);
	}
	@AfterClass
	public void finish() 
	{
	driver.quit();
	System.out.println("Added Products Successfully");
	} 
}
