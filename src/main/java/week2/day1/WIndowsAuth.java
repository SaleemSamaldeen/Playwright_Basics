package week2.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WIndowsAuth {
	
	@Test
	public void browser_actions() throws InterruptedException {
		
		//Initialise the playwright
		
		//Interface ---> Concrete class (Interface name +Impl)
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setHttpCredentials("admin", "testleaf")
				);
		Page page = context.newPage();
		
		page.navigate("https://leafground.com/auth.xhtml");
		page.click("//span[text()='Basic Auth']");
		
		
		Thread.sleep(10000);
		pw.close();
		
	}

}
