package week2.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Amazon {

	@Test
	public void amazon() {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		Page page = browser.newPage();
		
		page.navigate("https://amazon.in");
		
		page.type("//input[@type='text']", "Books");
		
		page.click("#nav-search-submit-button");
		
		Locator firstResult = page.locator("((//div[@data-component-type=\"s-search-result\"])[1]//following::a/span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]");

		System.out.println(firstResult.innerText());
		
		firstResult.click();
		
		
	}

}
