package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class Testtwo extends TestBase{
	@DataProvider(name = "Login")
	public Object[][] dataset() {
		return new Object[][] { { "standard_user", "secret_sauce" },
			                    { "locked_out_user", "secret_sauce" },
				                { "problem_user", "secret_sauce" },
				                { "performance_glitch_user", "secret_sauce" }};
	}
	@Test(dataProvider="Login")
	public static void Login(String username,String password) {
		
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys(username);
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.cssSelector(loc.getProperty("loginButton"))).click();
	}
	
	@Test
	public void CountItems() {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(loc.getProperty("loginButton"))).click();
	
	List<WebElement>list=driver.findElements(By.cssSelector(loc.getProperty("items")));
	int itemCount = list.size();
	System.out.println(itemCount);
	}
	
 @Test
	public void GetTitle() {
	    driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(loc.getProperty("loginButton"))).click();
		
	    String title = driver.getTitle();
	       System.out.println(title);
 }
}

		