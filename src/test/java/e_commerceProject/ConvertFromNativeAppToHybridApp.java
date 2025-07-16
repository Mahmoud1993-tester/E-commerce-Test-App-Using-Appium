package e_commerceProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ConvertFromNativeAppToHybridApp extends BaseTest {

	@Test
	public void HybridApp() throws InterruptedException {
		
		// Select Country 
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
		
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
		
		// Wait until Add to Cart Page Loaded 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"))
		, "text", "Cart"));
		
		// Assertion of Add to Cart Element 
		String addToCartElement = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(addToCartElement, "Jordan 6 Rings");
		
		// Check box Selection
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		
		// Click App browser Button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		// Hybrid App Browser
		Set<String> contexts = driver.getContextHandles();
		for (String contextName: contexts) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("PayPal");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		Thread.sleep(3000);
		
	}
}
