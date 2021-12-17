package Own_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Popup {
	public static void main(String[] args) {
		WebDriver driver = null;
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://the-internet.herokuapp.com/digest_auth");
		driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
		}
}
