package e_commerceProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollToElementAndAddToCart extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException {
		
		// Select Country 
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();
		
		// Name and Continue 
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mahmoud Saber");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Scroll to Element 
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		// Add to Cart steps
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i = 0 ; i < productCount ; i++) {
			
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		Thread.sleep(4000);
	}
}
