package e_commerceProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		// Start Server Automatically 
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\engab\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build(); 
		
		service.start();
		
		// Setup all options
        UiAutomator2Options options = new UiAutomator2Options();

        // 1. Name of the emulator 
        options.setDeviceName("Saber");
        
        // 2. Setup ChromeDriver
        options.setChromedriverExecutable("D:\\Chrome Driver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        // 3. Platform name 
        options.setPlatformName("Android");

        // 4. Automation engine 
        options.setAutomationName("UIAutomator2");
        
        
		// 5. // Install the app first
        options.setCapability("app", "path/to/generalstore.apk");

        // 5. Full path to APK 
        options.setApp("D:\\eclipse Projects\\E-commerce App\\commerceApp\\src\\test\\java\\resources\\General-Store.apk");

        // 6. Start the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
        service.stop();
	}

}
