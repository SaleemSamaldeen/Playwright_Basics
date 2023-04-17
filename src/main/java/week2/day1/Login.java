package week2.day1;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {
	
	@Test
	public void login() {
		
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps");
		Locator locator = page.locator("id=username");
		locator.type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		
		context.storageState(new BrowserContext.StorageStateOptions()
				.setPath(Paths.get("login_leaftaps.json")));
		
		
		page.close();
		context.close();
		browser.close();
		pw.close();
		
	}

}
