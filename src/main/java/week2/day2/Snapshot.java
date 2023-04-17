package week2.day2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Snapshot {
	
	@Test
	public void browser_actions() throws InterruptedException {
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		
		//page.navigate("http://leaftaps.com/opentaps");
		page.navigate("https://amazon.in");
		
		
		page.screenshot(new Page.ScreenshotOptions()
				.setFullPage(true)
				.setPath(Paths.get("snaps/snapshot.png")));
		
//		Locator locator = page.locator("id=username");
//		locator.type("demosalesmanager");
//		page.locator("#password").type("crmsfa");
//		page.locator(".decorativeSubmit").click();
//		page.locator("text=CRM/SFA").click();
//		page.locator("role=link[name='Leads']").click();
//		page.locator("//a[text()='Create Lead']").click();
//		page.type("#createLeadForm_companyName", "TL Industries");
//		page.locator("#createLeadForm_firstName").type("Sooraj");
//		page.locator("#createLeadForm_lastName").type("Krishna");
//		page.screenshot(new Page.ScreenshotOptions()
//				.setFullPage(true)
//				.setPath(Paths.get("snaps/snapshot.png")));
//		page.click(".smallSubmit");
//		
//		Thread.sleep(3000);
//		
//		String textContent = page.locator("#viewLead_firstName_sp").textContent();
//		
//		System.out.println(textContent);
		
		pw.close();
		
	}

}
