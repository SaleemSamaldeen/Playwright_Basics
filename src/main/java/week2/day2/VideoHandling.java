package week2.day2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Video;
import com.microsoft.playwright.options.LoadState;

public class VideoHandling {
	
	@Test
	public void browser_actions() throws InterruptedException {
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(true));
		
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/createLead/")));
		Page page = context.newPage();
		
		Video video = page.video();
		
		page.navigate("http://leaftaps.com/opentaps");
		
		Locator locator = page.locator("id=username");
		locator.type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		page.locator("role=link[name='Leads']").click();
		page.locator("//a[text()='Create Lead']").click();
		page.type("#createLeadForm_companyName", "TL Industries");
		page.locator("#createLeadForm_firstName").type("Sooraj");
		page.locator("#createLeadForm_lastName").type("Krishna");
		page.click(".smallSubmit");
		
		
		
		Thread.sleep(3000);
		
		String textContent = page.locator("#viewLead_firstName_sp").textContent();
		
		System.out.println(textContent);
		
		page.close();
		video.saveAs(Paths.get("videos/createLead/create_lead_"+System.currentTimeMillis()+".webm"));
		video.delete();
		context.close();
		browser.close();
		pw.close();
		
	}

}
