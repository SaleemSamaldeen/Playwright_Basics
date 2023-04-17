package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom {

	@Test
	public void shadow_dom_handling() {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		Page page = browser.newPage();
		
		page.setDefaultTimeout(60000);
		page.setDefaultNavigationTimeout(60000);

		page.navigate("https://dev143892.service-now.com");
		
		page.type("#user_name", "aes.creator");
		
		page.type("#user_password", "unU8B7w%KO-l");
		
		page.click("#sysverb_login");
		
		page.click("text=Add a table");
		
		page.type(".sn-aes-search-input","Sooraj here");
		
		

	}

}
