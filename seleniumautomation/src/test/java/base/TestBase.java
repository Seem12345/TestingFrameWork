package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties property = new Properties();
	public static Properties loc = new Properties();
	
	@BeforeMethod
	public void SetUp() throws IOException {
		if(driver == null){
			//System.out.println(System.getProperty("user.dir"));
			System.out.println(property.getProperty("browser"));
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
			property.load(inputStream);
			FileInputStream inputStream1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\locators.properties");
			loc.load(inputStream1);
		}
		if(property.getProperty("browser").equals("chrome")) {
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(property.getProperty("baseUrl"));
			System.out.println("baseUrl");
		}
		
		else if(property.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		   	driver.get(property.getProperty("baseUrl"));
		}
	}
	@AfterMethod
	public void TearDown() {
		driver.close();	
	}
}
