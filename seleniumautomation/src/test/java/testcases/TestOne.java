package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class TestOne extends TestBase{

	@Test
	public static void Login() {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
	}
	@Test
	public void CountItems() {
	driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
	driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	driver.findElement(By.cssSelector("#login-button")).click();
	
	List<WebElement>list=driver.findElements(By.cssSelector("[class=\"inventory_item_name\"]"));
	int itemCount = list.size();
	System.out.println(itemCount);
	}
   @Test
	public void GetTitle() {
	   String title = driver.getTitle();
		System.out.println(title);
	}
}
