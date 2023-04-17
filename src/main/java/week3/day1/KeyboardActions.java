package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyboardActions {
	
	
	@Test
	public void keyboard_actions(){
		
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("http://leaftaps.com/opentaps");
		
		Locator locator = page.locator("#username");
		locator.type("demosalesmanager");
		
		page.keyboard().press("Tab");
		
		String attribute = page.locator("*:focus").getAttribute("id");
		
		System.out.println(attribute);
		
	}

}
