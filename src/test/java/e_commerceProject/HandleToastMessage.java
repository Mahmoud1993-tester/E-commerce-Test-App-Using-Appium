package e_commerceProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class HandleToastMessage extends BaseTest {

	@Test
	public void ToastMessage() throws InterruptedException {
		        // Select Country 
				driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
				driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();
				driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
				
				String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("text");
				Assert.assertEquals(toastMessage, "Please enter your name");
				Thread.sleep(2000);
	}
}
