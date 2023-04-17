package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnBrowserContext {

	@Test
	public void browser_context() throws InterruptedException {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		BrowserContext context1 = browser.newContext();

		Page page1 = context1.newPage();
		page1.navigate("http://leaftaps.com/opentaps");

		BrowserContext context2 = browser.newContext();

		Page page2 = context2.newPage();
		page2.navigate("https://leafground.com/");

		Locator locator = page1.locator("id=username");
		locator.type("demosalesmanager");
		page1.locator("#password").type("crmsfa");
		page1.locator(".decorativeSubmit").click();
		
		
		page2.type("input#email", "sooraj@testleaf.com");


		Thread.sleep(5000);


	}

}
