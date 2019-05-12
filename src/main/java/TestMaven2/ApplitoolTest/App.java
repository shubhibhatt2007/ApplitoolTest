package TestMaven2.ApplitoolTest;

/**
 * Hello world!
 *
 */



import com.applitools.eyes.images.Eyes;
import com.applitools.eyes.RectangleSize;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class App  {
	public static void main(String[] args) throws IOException {

		Eyes eyes = new Eyes();

		// Initialize the eyes SDK and set your private API key.
		eyes.setApiKey("DGXsidCq1106TT3438fsRXKVEYV14AkdDWi0nj29M2ig4110");

		WebDriver driver = new ChromeDriver();
		BufferedImage img;
		// Initialize the eyes SDK and set your private API key.
		//Eyes eyes = new Eyes();

		// Set the API key from the env variable. Please read the "Important Note"
		// section above.
		//eyes.setApiKey("APPLITOOLS_API_KEY");

		try {


			// Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
			eyes.open("appName","windowName", new RectangleSize(600, 800)); 
			//open(driver, "appName","windowName", new RectangleSize(600, 800));

			// Navigate the browser to the "ACME" demo app
			driver.get("https://demo.applitools.com");
		//eyes.checkWindow( "check window tag");

			img = ImageIO.read(new URL("https://meganvwalker.com/wp-content/uploads/2019/02/upload-file-from-URL-image.png"));///"https://applitools.com/tutorials/applitools.jpg"));
			// Visual checkpoint #1.
			//eyes.checkWindow(image);
			eyes.checkImage(img, "abc");
			//.checkWindow("Login window");

			//🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟  
			//For example, you may want to test errors in the login window after clicking a login button,
			//In that case, you may add the following before you call eyes.close(). 
			//This will create a test with two test steps.
			//driver.click("login");
			//eyes.checkWindow("Login Window Error");

			// End the test.
			eyes.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as
			// aborted.
			eyes.abortIfNotClosed();

			// End main test
			System.exit(0);
		}

	}
}
