package e_commerceProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FirstTestCase extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException {
		
		// Select Country 
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();
		
		// Name and Continue 
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mahmoud Saber");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(4000);
	}
}
