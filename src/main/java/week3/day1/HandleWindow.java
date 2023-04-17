package week3.day1;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class HandleWindow {

	
	@Test
	public void handle_window() throws InterruptedException {
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions(
				).setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.navigate("https://leafground.com/window.xhtml");
		
//		page.click("//h5[text()='Click and Confirm new Window Opens']/following::span[1]");
//		
//		Page childPage = context.waitForPage(() -> {
//			page.locator("//span[text()='Resolution Center']").isVisible();
//		});
		
		//childPage.type("#email", "sooraj@testleaf.com");
		
		page.click("//h5[text()='Find the number of opened tabs']/following::span[1]");
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		List<Page> pages = page.context().pages();
		
		//Page parentPage = pages.get(0);
		
		Page webTablePage = null;
		for (Page window : pages) {
			if(window.title().equals("Web Table")) {
				webTablePage = window;
			}
		}
		
		
		webTablePage.type("//input[@placeholder='Search']", "Chavez");
		
		Thread.sleep(5000);
		
	}
}
