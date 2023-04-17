package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleHover {
	
	@Test
	public void handleHover() throws InterruptedException {
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setSlowMo(2000)
				.setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.geeksforgeeks.org/");
		
		page.locator("//span[text()='Tutorials']").hover();
		
		page.locator("(//span[text()='Algorithms'])[1]").hover();
		
		page.locator("//span[text()='Analysis of Algorithms']").hover();
		
		page.locator("(//a[text()='Solving Recurrences'])[1]").click();
		
		Thread.sleep(5000);
		
	}

}
